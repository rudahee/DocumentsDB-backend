package com.docdb.service.util.impl;

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
}
