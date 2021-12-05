package com.internships.rest.data.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileSaverService {
	
	String saveFile(String folder,MultipartFile file) throws IOException;
	void deleteFile(String folder,String fileName) throws IOException;

}
