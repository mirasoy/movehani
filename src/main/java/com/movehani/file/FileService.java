package com.movehani.file;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.movehani.util.MD5Generator;

import java.io.File;
import java.util.concurrent.ExecutionException;

import javax.transaction.Transactional;

@Service
public class FileService {
    private FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Transactional
    public Long saveFile(FileDto fileDto) {
        return fileRepository.save(fileDto.toEntity()).getId();
    }

    public AttachFile saveFile(MultipartFile files) {
    	AttachFile fileDto = new AttachFile();
    	
    	try {
    		
    		String origFilename = files.getOriginalFilename();
    		String filename = new MD5Generator(origFilename).toString();
    		/* 실행되는 위치의 'files' 폴더에 파일이 저장됩니다. */
    		String savePath = System.getProperty("user.dir") + "\\files";
    		/* 파일이 저장되는 폴더가 없으면 폴더를 생성합니다. */
    		if (!new File(savePath).exists()) {
    			try{
    				new File(savePath).mkdir();
    			}
    			catch(Exception e){
    				e.getStackTrace();
    			}
    		}
    		String filePath = savePath + "\\" + filename;
    		files.transferTo(new File(filePath));
    		fileDto.setOrigFilename(origFilename);
    		fileDto.setFilename(filename);
    		fileDto.setFilePath(filePath);
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    
         
    	return fileRepository.save(fileDto);
    }
    
    @Transactional
    public FileDto getFile(Long id) {
        AttachFile file = fileRepository.findById(id).get();

        FileDto fileDto = FileDto.builder()
                .id(id)
                .origFilename(file.getOrigFilename())
                .filename(file.getFilename())
                .filePath(file.getFilePath())
                .build();
        return fileDto;
    }
}