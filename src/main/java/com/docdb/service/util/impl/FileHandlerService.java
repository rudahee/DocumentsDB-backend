package com.docdb.service.util.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.zip.DataFormatException;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.docdb.service.common.FileConstants;

@Service
public class FileHandlerService {
	
	@Autowired
	private PackageHandlerService phService;
	
	public Blob getBlobFromFile(String path, String extension) throws IOException, SerialException, SQLException, DataFormatException {
		
		
		byte[] data = Files.readAllBytes(Path.of(path)); 
		
		// Only if data is text we need uncompress data
		if (FileConstants.TEXT_EXTENSION.stream().anyMatch(ext -> ext.equals(extension.toUpperCase()))) {
			data = phService.unpackageTextFile(data);
		}
		
		Blob blob = new SerialBlob(data);
		
		return blob;
	}
	
	
	public Blob createBlobForProfileImage(MultipartFile mpf) {
		
		Blob blob = null;
		try {
			if (!mpf.isEmpty() && mpf.getSize() < FileConstants.MAX_IMAGE_USER_SIZE) {
				if (FileConstants.IMAGE_USER_TYPES.contains(mpf.getContentType())) {
					blob = new SerialBlob(mpf.getInputStream().readAllBytes());
				}
			}
			return blob;
		} catch (Exception e) {
			return null;
		}
	}
	
	public Blob createBlobForPdfOrImageNonTiff(MultipartFile mpf) {
		// the pdfs or the images that are not tiff are saved in the database, 
		// therefore we are only going to convert the multiparfile into a blob
		
		Blob blob = null;
		try {
			if (!mpf.isEmpty()) {
				blob = new SerialBlob(mpf.getInputStream().readAllBytes());
			}
			
			return blob;
		
		} catch (Exception e) {
			return null;
		}
	}
	
	public File createTiffInFileSystem(MultipartFile mpf) throws IOException {
		
		// We need to write TIFF in filesystem in temporal file to package it.
		File tmpFile = new File(FileConstants.TMP_ROUTE, mpf.getOriginalFilename());
		tmpFile.createNewFile(); 
		
		OutputStream os = new FileOutputStream(tmpFile);
		
		os.write(mpf.getBytes());
		
		os.close();
		
		return tmpFile;
	}
	
	public void createPackagedTextInFileSystem(byte[] data, String path, String filename) throws IOException {
		// Save file in file system
		
		File file = new File(path + "/" + filename);
		
		file.createNewFile();
				
		OutputStream os = new FileOutputStream(file);
		os.write(data);
		os.close();
	}

	public void createNonTextNonTiffNonImageNonPdfFileInFileSystem(byte[] data, String path, String filename) throws IOException {
		// Save file in file system
		
		File file = new File(path + "/" + filename);
		
		file.createNewFile();
		
		OutputStream os = new FileOutputStream(file);
		os.write(data);
		os.close();
	}
	
	public String createDir(String user, String note) throws IOException {
		// We need create dir for user and note if not exists
		
		Path path = Paths.get(FileConstants.LOCAL_ROUTE + user + "/" + note + "/");
		
		if (Files.notExists(path)) {
			Files.createDirectories(path);
		} 
		
		return FileConstants.LOCAL_ROUTE + user + "/" + note + "/";
	}
}
