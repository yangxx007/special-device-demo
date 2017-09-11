package com.example.demo.entity.dataModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class Action implements Serializable{


    @Id@GeneratedValue
    private int id;

    private boolean needed_file;
    private String action_name;
    @ManyToMany
    @JoinTable(name="action_with_forms",joinColumns={@JoinColumn(name="action_id")},inverseJoinColumns={@JoinColumn(name="form_id" )})
    private List<ApplyFormType> forms;

    @ManyToMany
    @JoinTable(name="action_with_files",joinColumns={@JoinColumn(name="action_id")},inverseJoinColumns={@JoinColumn(name="file_type_id" )})
    private List<NeededFile> files;

    public List<ApplyFormType> getForms() {
        return forms;
    }

    public void setForms(List<ApplyFormType> forms) {
        this.forms = forms;
    }

    public List<NeededFile> getFiles() {
        return files;
    }

    public void setFiles(List<NeededFile> files) {
        this.files = files;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNeeded_file() {
        return needed_file;
    }

    public void setNeeded_file(boolean needed_file) {
        this.needed_file = needed_file;
    }

    public String getAction_name() {
        return action_name;
    }

    public void setAction_name(String action_name) {
        this.action_name = action_name;
    }
}
