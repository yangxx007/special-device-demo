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
    private NeededFile file_type;
    private byte file_content;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public NeededFile getFile_type() {
        return file_type;
    }

    public void setFile_type(NeededFile file_type) {
        this.file_type = file_type;
    }

    public byte getFile_content() {
        return file_content;
    }

    public void setFile_content(byte file_content) {
        this.file_content = file_content;
    }
}
