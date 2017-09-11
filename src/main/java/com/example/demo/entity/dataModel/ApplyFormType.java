package com.example.demo.entity.dataModel;



import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class ApplyFormType implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    private String description;
    private String table_name;
    @ManyToMany
    @JoinTable(name="action_with_forms",joinColumns={@JoinColumn(name="apply_form_id")},inverseJoinColumns={@JoinColumn(name="action_id")})
    private List<Action> actions;

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }
}
