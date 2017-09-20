package com.example.demo.service;

import com.example.demo.entity.dataModel.FileData;

public interface FileService {
    FileData getFileById(long id);
    void    save(FileData fileData);
    void    delete(FileData fileData);
}
