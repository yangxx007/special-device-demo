package com.example.demo.entity.dataModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Action implements Serializable{


    @Id@GeneratedValue
    private int id;

    private boolean neededFile;
    private String actionName;
    @ManyToMany
    @JoinTable(name="action_with_forms",joinColumns={@JoinColumn(name="action_id")},inverseJoinColumns={@JoinColumn(name="form_id" )})
    private List<ApplyFormType> forms;

    @ManyToMany
    @JoinTable(name="action_with_files",joinColumns={@JoinColumn(name="action_id")},inverseJoinColumns={@JoinColumn(name="file_type_id" )})
    private List<FileType> files;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isNeededFile() {
        return neededFile;
    }

    public void setNeededFile(boolean neededFile) {
        this.neededFile = neededFile;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public List<ApplyFormType> getForms() {
        return forms;
    }

    public void setForms(List<ApplyFormType> forms) {
        this.forms = forms;
    }

    public List<FileType> getFiles() {
        return files;
    }

    public void setFiles(List<FileType> files) {
        this.files = files;
    }
}
