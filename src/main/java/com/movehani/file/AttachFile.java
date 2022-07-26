package com.movehani.file;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.movehani.account.Member;

import lombok.Builder;
import lombok.Data;


@Entity
@Data
@Builder
public class AttachFile {
    @Id
    @GeneratedValue
    private Long id;

    private String origFilename;

    private String filename;

    private String filePath;
    
    public AttachFile() {
    }

	public AttachFile(Long id, String origFilename, String filename, String filePath) {
		super();
		this.id = id;
		this.origFilename = origFilename;
		this.filename = filename;
		this.filePath = filePath;
	}
    
    

}
