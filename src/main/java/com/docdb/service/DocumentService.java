package com.docdb.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.docdb.model.entity.Document;
import com.docdb.model.entity.Note;
import com.docdb.model.entity.dto.DocumentDTO;
import com.docdb.model.repository.NoteRepository;
import com.docdb.model.repository.base.BaseRepository;
import com.docdb.service.base.BasePersistenceService;
import com.docdb.service.common.FileConstants;
import com.docdb.service.util.dto.DTOConverter;
import com.docdb.service.util.impl.FileHandlerService;
import com.docdb.service.util.impl.PackageHandlerService;


@Service
public class DocumentService extends BasePersistenceService<Document, DocumentDTO, Integer> {
			
	@Autowired
	private PackageHandlerService phService;

	@Autowired 
	private FileHandlerService fhService;
	
	@Autowired
	private NoteRepository noteRepository;
	
	public DocumentService(BaseRepository<Document, Integer> baseRepository, DTOConverter<Document, DocumentDTO> dtoConverter) {
		super(baseRepository, dtoConverter);
	}
	
	public Document saveDocument(MultipartFile mpf, String user, String note, String extension) throws IOException {
		Document document;
		Note noteEntity;
		
		String filename = mpf.getOriginalFilename().replaceAll(FileConstants.REGEX_NAME, "_");
		
		
		if (FileConstants.IMAGE_UNPACKAGED_EXTENSIONS.stream().anyMatch(ext -> ext.equals(extension.toUpperCase()))) {
			
			document = this.saveTiff(mpf, user, note, filename);	
		
		} else if (FileConstants.TEXT_EXTENSION.stream().anyMatch(ext -> ext.equals(extension.toUpperCase()))) {
			
			document = this.saveTextFile(mpf, user, note, filename);
		
		} else if (FileConstants.PDF_CONTENT_TYPE.toUpperCase().equals(mpf.getContentType().toUpperCase()) || 
				(!FileConstants.IMAGE_UNPACKAGED_EXTENSIONS.stream().anyMatch(ext -> ext.equals(extension.toUpperCase())))
				&& mpf.getContentType().startsWith("image/")) {
			
			document = this.saveBlobForPdfOrImageNonTiff(mpf, user, note, filename);			
		} else {
			document = this.saveNonTextNonTiffNonImageNonPdfFileInFileSystem(mpf, user, note, filename);
		
		}
		
		noteEntity = noteRepository.findById(Integer.parseInt(note)).get();
		
		document.setNote(noteEntity);
		noteEntity.addDocument(document);
		
		noteRepository.save(noteEntity);
		baseRepository.save(document);
		
		return document;
	}
	
	public Document saveTextFile(MultipartFile mpf, String user, String note, String filename) throws IOException {
		Document document = new Document();
		String path = fhService.createDir(user, note);
		
		document.setName(filename);
		document.setPath(path);
		document.setContentType(mpf.getContentType());
		document.setSize(mpf.getSize());
		
		fhService.createPackagedTextInFileSystem(phService.packageTextFile(path, mpf.getBytes()), path, filename);
		
		return document;
	}
	
	public Document saveTiff(MultipartFile mpf, String user, String note, String filename) throws IOException {
		Document document = new Document();
		String path = fhService.createDir(user, note);

		File file = fhService.createTiffInFileSystem(mpf);
		
		document.setName(filename);
		document.setPath(path);
		document.setContentType(mpf.getContentType());
		document.setSize(mpf.getSize());
		
		phService.packageTiff(FileConstants.TMP_ROUTE + filename, path+filename);
		
		file.delete();
		
		return document;		
	}
	
	public Document saveNonTextNonTiffNonImageNonPdfFileInFileSystem(MultipartFile mpf, String user, String note, String filename) throws IOException {
		Document document = new Document();
		String path = fhService.createDir(user, note);
		
		fhService.createNonTextNonTiffNonImageNonPdfFileInFileSystem(mpf.getBytes(), path, filename);
		
		document.setName(filename);
		document.setPath(path);
		document.setContentType(mpf.getContentType());
		document.setSize(mpf.getSize());
		
		return document;
	}
	
	public Document saveBlobForPdfOrImageNonTiff(MultipartFile mpf, String user, String note, String filename) throws IOException {
		Document document = new Document();
		String path = fhService.createDir(user, note);
		
		document.setData(fhService.createBlobForPdfOrImageNonTiff(mpf));
		
		document.setName(filename);
		document.setPath(path);
		document.setContentType(mpf.getContentType());
		document.setSize(mpf.getSize());
		
		return document;
	}
	
}