package com.docdb.service.common;

import java.util.List;

public class FileConstants {
	public static final long MAX_IMAGE_USER_SIZE = 1_164_578L;
	
	public static final List<String> IMAGE_USER_TYPES = List.of(
			"image/jpeg", "image/jpg", "image/pjpeg", "image/x-jpeg", 
			"image/png", 
			"image/gif", 
			"image/bmp", "image/x-windows-bmp");
	
	public static final List<String> IMAGE_UNPACKAGED_EXTENSIONS = List.of("TIFF", "TIF");
	
	public static final List<String> TEXT_EXTENSION = List.of(
				"TXT", "PY", "PYW", "C", "CPP", "JS", "HTML", "CSS", "SCSS", "SASS", "LESS", "JAVA", "TS", "ASPX", 
				"XML", "JSON", "RB", "SQL", "PHP", "INO", "AU3", "BAT", "CMD", "SH", "H", "C++", "HPP", "CMAKE", "CSV", 
				"GML", "GO", "HS", "INI", "CFG", "IPYNB", "KT", "LUA", "MD", "SVG", "BASH", "ZSH", "YML", "RSS", "CS"
			);

	public static final String PDF_CONTENT_TYPE = "application/pdf";
	
	public static final List<String> WARNING_FORMATS = List.of("WAR", "JAR");
	
	public static final String REGEX_NAME = "[^a-zA-Z0-9\\.\\-]";
	
	// NEED CHANGE!!!
	public static final String LOCAL_ROUTE = "/home/ruben/Desktop/files/";
	public static final String TMP_ROUTE = "/home/ruben/Desktop/temp/";

}
