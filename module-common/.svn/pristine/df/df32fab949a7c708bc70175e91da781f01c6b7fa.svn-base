package com.keysoft.pigfarm.common.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.keysoft.pigfarm.common.SymbolEnum;

public class SpringUploadUtil {
	
	/**
	 * Upload list of files
	 * @param uploadedFiles
	 * @throws Exception
	 */
	public static void uploadFiles(List<UploadedFile> uploadedFiles) throws Exception {
		if (!uploadedFiles.isEmpty()) {
			for (UploadedFile uploadedFile : uploadedFiles) {
				SpringUploadUtil.uploadFile(uploadedFile);
			}
		}
	}
	
	/**
	 * Upload file
	 * @param uploadedFile
	 * @throws IOException
	 */
	public static void uploadFile(UploadedFile uploadedFile) throws IOException {
		if (uploadedFile != null) {
			Path uploadedFolder = Paths.get(uploadedFile.getUploadedPath());
			if (!uploadedFolder.toFile().exists()) {
				Files.createDirectories(uploadedFolder);
			}
			
			Path file = Paths.get(uploadedFile.getUploadedPath() + SymbolEnum.SLASH.val + uploadedFile.getUploadedFileName());
			if (file.toFile().exists()) {
				Files.delete(file);
			}
			
			Files.write(file, uploadedFile.getUploadedFileContent());
		}
	}
}
