package com.docdb.service.util.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.docdb.service.common.FileConstants;

@Service
public class FileHandlerService {
	
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
		File tmpFile = new File(FileConstants.TMP_ROUTE, mpf.getOriginalFilename());
		
		tmpFile.createNewFile(); 
		
		OutputStream os = new FileOutputStream(tmpFile);
		
		os.write(mpf.getBytes());
		
		os.close();
		
		return tmpFile;
	}
	
	public void createPackagedTextInFileSystem(byte[] data, String path, String filename) throws IOException {
		File file = new File(path + "/" + filename);
		
		file.createNewFile();
				
		OutputStream os = new FileOutputStream(file);
		os.write(data);
		os.close();
	}

	public void createNonTextNonTiffNonImageNonPdfFileInFileSystem(byte[] data, String path, String filename) throws IOException {
		File file = new File(path + "/" + filename);
		
		file.createNewFile();
		
		OutputStream os = new FileOutputStream(file);
		os.write(data);
		os.close();
	}
	
	public String createDir(String user, String note) throws IOException {
		Path path = Paths.get(FileConstants.LOCAL_ROUTE + user + "/" + note + "/");
		
		if (Files.notExists(path)) {
			Files.createDirectories(path);
		} 
		
		return FileConstants.LOCAL_ROUTE + user + "/" + note + "/";
	}
}
