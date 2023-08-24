package com.keysoft.pigfarm.common.util;

import lombok.Data;

@Data
public class UploadedFile {
	
	private String uploadedPath;
	private String uploadedFileName;
	private byte[] uploadedFileContent;
	
}
