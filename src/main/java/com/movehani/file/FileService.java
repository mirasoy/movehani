package com.movehani.file;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.movehani.util.FileUtil;
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


    public AttachFile saveFile(MultipartFile files) {
    	
    	AttachFile savedFile  = FileUtil.saveFile(files);
    	
    	return fileRepository.save(savedFile);
    }
    
}