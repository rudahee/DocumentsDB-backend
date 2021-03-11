package com.docdb.service.util.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.stereotype.Service;

import com.aspose.imaging.ColorPaletteHelper;
import com.aspose.imaging.Image;
import com.aspose.imaging.fileformats.tiff.enums.TiffCompressions;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.fileformats.tiff.enums.TiffPhotometrics;
import com.aspose.imaging.imageoptions.TiffOptions;

@Service
public class PackageHandlerService {
	
	public void packageTiff(String pathIn, String pathOut) {
		try {
			// PathIn is a temp route.
			Image image = Image.load(pathIn);
			
			// Package tiff: Need set a outputSetting
			TiffOptions outputSettings = new TiffOptions(TiffExpectedFormat.Default);
			
			// Basically, we do a JPG Quality. ONLY FULLY UNCOMPRESSED TIFF WILL LOSE QUALITY
			// Can reduce weight by 50-90%
			outputSettings.setBitsPerSample(new int[] { 4 });
			outputSettings.setCompression(TiffCompressions.Lzw);
			outputSettings.setPhotometric(TiffPhotometrics.Palette);
			outputSettings.setPalette(ColorPaletteHelper.create8Bit());
			
			// PathOut is a final route for a user and note.
			image.save(pathOut, outputSettings);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public byte[] packageTextFile(String path, byte[] data) throws IOException {
		Deflater deflater = new Deflater();  
		 
		// To compress a text file it is not necessary to write it to disk, it can be done from memory.
		// I am going to use deflater for this and it can compress a text file from 70 to 95%
		
		deflater.setInput(data);  
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);   
		deflater.finish();  
		
		// To compress with deflater we need to do it in packets of 1024 bytes, therefore we create a buffer
		byte[] buffer = new byte[1024];   
		  
		while (!deflater.finished()) { 
			int count = deflater.deflate(buffer); 
		    outputStream.write(buffer, 0, count);   
		}  
		
		outputStream.close();  
		
		byte[] output = outputStream.toByteArray();   
		
		
		return output;
	}
	
	public byte[] unpackageTextFile(byte[] data) throws DataFormatException, IOException {
		
		// To uncompress a text file it is not necessary to write it to disk, it can be done from memory.
		// I am going to use inflater for this
				
		Inflater inflater = new Inflater();    
		inflater.setInput(data);  
		   
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);  
		
		// To uncompress with inflater we need to do it in packets of 1024 bytes, therefore we create a buffer
		byte[] buffer = new byte[1024];  
		
		while (!inflater.finished()) {  
			int count = inflater.inflate(buffer);  
			outputStream.write(buffer, 0, count);  
		}  
		
		outputStream.close();  
		byte[] output = outputStream.toByteArray();
		   
		return output;
	}
}
