package com.ridho.uploadfile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ridho.uploadfile.model.FileDB;

public interface FileDBRepository extends JpaRepository<FileDB, String> {

}
