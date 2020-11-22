package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.FileDBEntity;

@Repository
public interface FileDBRepository extends JpaRepository<FileDBEntity, String>{

}