package com.example.demo.entity.data;



import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class ApplyFormType implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    private String description;
    private String tableName;
    @ManyToMany
    @JoinTable(name="action_with_forms",joinColumns={@JoinColumn(name="apply_form_id")},inverseJoinColumns={@JoinColumn(name="action_id")})
    private List<Action> actions;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}
