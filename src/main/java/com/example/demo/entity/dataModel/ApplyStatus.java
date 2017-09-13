package com.example.demo.entity.dataModel;



import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ApplyStatus implements Serializable{
    @Id
    @GeneratedValue
    private long id;
    private boolean accepted;
    private boolean passed;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="applyTest_id",unique=true)
    private ApplyInfo apply;
    public ApplyInfo getApply() {
        return apply;
    }

    public void setApply(ApplyInfo apply_test) {
        this.apply = apply_test;
    }


    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
