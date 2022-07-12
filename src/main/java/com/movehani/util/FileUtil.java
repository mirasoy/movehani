package com.movehani.util;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

import com.movehani.file.AttachFile;

public class FileUtil {

	
	
	
	static public AttachFile saveFile (MultipartFile files) {
		AttachFile fileDto = new AttachFile();
    	
    	try {
    		
    		String origFilename = files.getOriginalFilename();
    		String filename = new MD5Generator(origFilename).toString();
    		/* 실행되는 위치의 'files' 폴더에 파일이 저장됩니다. */
    		String savePath = "D:\\mira\\uploadFile";
    		/* 파일이 저장되는 폴더가 없으면 폴더를 생성합니다. */
    		if (!new File(savePath).exists()) {
    			try{
    				new File(savePath).mkdir();
    			}
    			catch(Exception e){
    				e.getStackTrace();
    			}
    		}
    		String ext = origFilename.substring(origFilename.lastIndexOf( "." ) + 1 );
    		String filePath = savePath + "\\"+filename + "."+ext;
    		files.transferTo(new File(filePath));
    		fileDto.setOrigFilename(origFilename);
    		fileDto.setFilename(filename);
    		fileDto.setFilePath(filePath);
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return fileDto;
	}
}
