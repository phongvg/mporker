package com.keysoft.pigfarm.production.dto;

import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AttachmentDto {

	private Long id;
	private Long moduleId;
	private String moduleType;
	private String functionType;
	private String name;
	private String url;
	private String absolutePath;
	private String fileName;
	private String fileType;
	private String createdBy;
	private LocalDateTime createdTime;
	private String status;
	
	@JsonIgnore
	private MultipartFile file;
	private  Long fileSize;
}
