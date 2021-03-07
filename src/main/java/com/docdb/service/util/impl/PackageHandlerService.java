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
			Image image = Image.load(pathIn);
			
			TiffOptions outputSettings = new TiffOptions(TiffExpectedFormat.Default);
			
			outputSettings.setBitsPerSample(new int[] { 4 });
			outputSettings.setCompression(TiffCompressions.Lzw);
			outputSettings.setPhotometric(TiffPhotometrics.Palette);
			outputSettings.setPalette(ColorPaletteHelper.create8Bit());

			image.save(pathOut, outputSettings);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public byte[] packageTextFile(String path, byte[] data) throws IOException {
		Deflater deflater = new Deflater();  
		  
		deflater.setInput(data);  
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);   
		deflater.finish();  
		
		byte[] buffer = new byte[1024];   
		  
		while (!deflater.finished()) {  
			int count = deflater.deflate(buffer); 
		    outputStream.write(buffer, 0, count);   
		}  
		
		outputStream.close();  
		
		byte[] output = outputStream.toByteArray();   
		
		
		return output;
	}
	
	public byte[] unpackageTextFile(String path, byte[] data) throws DataFormatException, IOException {
		Inflater inflater = new Inflater();    
		inflater.setInput(data);  
		   
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);  
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
