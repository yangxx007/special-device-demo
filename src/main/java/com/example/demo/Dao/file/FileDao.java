package com.example.demo.Dao.file;

import com.example.demo.entity.dataModel.FileData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yang on 2017/8/12.
 */
public interface FileDao  extends JpaRepository<FileData,Integer>{

}
