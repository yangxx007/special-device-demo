package com.example.demo.entity.dataModel;



import com.example.demo.enums.ApplyStatesEnum;
import com.example.demo.service.view.View;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplyStatus implements Serializable{
    @Id
    @GeneratedValue
    private long id;
    @JsonView(View.ApplyForView.class)
    private ApplyStatesEnum states=ApplyStatesEnum.未提交;
    private String acceptedComments;
    private String approveComments;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ApplyStatesEnum getStates() {
        return states;
    }

    public void setStates(ApplyStatesEnum states) {
        this.states = states;
    }

    public String getAcceptedComments() {
        return acceptedComments;
    }

    public void setAcceptedComments(String acceptedComments) {
        this.acceptedComments = acceptedComments;
    }

    public String getApproveComments() {
        return approveComments;
    }

    public void setApproveComments(String approveComments) {
        this.approveComments = approveComments;
    }
}
