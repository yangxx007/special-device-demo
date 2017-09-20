package com.example.demo.service.impl;

import com.example.demo.Dao.file.FileDao;
import com.example.demo.entity.dataModel.FileData;
import com.example.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    FileDao fileDao;
    @Override
    public FileData getFileById(long id) {
        return fileDao.findFileDataById(id);
    }

    @Override
    public void save(FileData fileData) {
        fileDao.save(fileData);

    }

    @Override
    public void delete(FileData fileData) {
        fileDao.delete(fileData);
        //要删除相应的file
    }
}
