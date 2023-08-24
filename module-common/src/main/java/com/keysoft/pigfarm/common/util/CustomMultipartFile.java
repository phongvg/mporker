package com.keysoft.pigfarm.common.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomMultipartFile implements MultipartFile {
	
	private byte[] input;
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOriginalFilename() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		return input == null || input.length == 0;
	}

	@Override
	public long getSize() {
		return input.length;
	}

	@Override
	public byte[] getBytes() throws IOException {
		return input;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return new ByteArrayInputStream(input);
	}

	@Override
	public void transferTo(File dest) throws IOException, IllegalStateException {
		FileUtils.writeByteArrayToFile(dest, input);
	}

}
