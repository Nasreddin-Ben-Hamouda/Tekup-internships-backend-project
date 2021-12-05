package com.internships.rest.data.services.impl;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.internships.rest.data.services.FileSaverService;


@Service
public class FileSaverServiceImpl  implements FileSaverService{
	public static final String rootPath="src/main/resources/static/";

	@Override
	public String saveFile(String folder, MultipartFile file) throws IOException {
			int random = ThreadLocalRandom.current().nextInt();
			String originalFileName=file.getOriginalFilename();
			byte[] bytes=file.getBytes();
			String fileName=random+"."+originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
			Path path=Paths.get(rootPath+folder+fileName);
			Files.write(path,bytes);
			return fileName;
	}


	@Override
	public void deleteFile(String folder, String fileName) throws IOException {
		Path path=Paths.get(rootPath+folder+fileName);
		Files.deleteIfExists(path);		
		
	}
	

}
