package com.ridho.uploadfile.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ridho.uploadfile.model.FileDB;
import com.ridho.uploadfile.repository.FileDBRepository;

@Service
public class FileStorageService {

	@Autowired
	private FileDBRepository fileDBRepository;

	public FileDB store(MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		FileDB fileDB = new FileDB(fileName, file.getContentType(), file.getBytes());
		fileDB = fileDBRepository.save(fileDB);
		return fileDB;
	}

	public FileDB getFile(String id) {
		return fileDBRepository.findById(id).get();
	}
  
	public Stream<FileDB> getAllFiles() {
		return fileDBRepository.findAll().stream();
	}
}
