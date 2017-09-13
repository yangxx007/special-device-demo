package com.example.demo.entity.dataModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class FileData implements Serializable{
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fileType_id")
    private NeededFile fileType;
    private byte fileContent;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public NeededFile getFileType() {
        return fileType;
    }

    public void setFileType(NeededFile fileType) {
        this.fileType = fileType;
    }

    public byte getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte fileContent) {
        this.fileContent = fileContent;
    }
}
