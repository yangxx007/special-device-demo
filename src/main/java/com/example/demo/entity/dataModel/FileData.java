package com.example.demo.entity.dataModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class FileData implements Serializable{
    @Id
    private long id;
    private int fileTypeId;
    private String fileName;
    private long applyId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFileTypeId() {
        return fileTypeId;
    }

    public void setFileTypeId(int fileTypeId) {
        this.fileTypeId = fileTypeId;
    }

    public long getApplyId() {
        return applyId;
    }

    public void setApplyId(long applyId) {
        this.applyId = applyId;
    }
}
