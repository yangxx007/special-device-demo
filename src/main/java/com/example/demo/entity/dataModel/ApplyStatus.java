package com.example.demo.entity.dataModel;



import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ApplyStatus implements Serializable{
    @Id
    @GeneratedValue
    private long id;
    private boolean accepted=false;
    private boolean passed=false;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="applyInfo_id",unique=true)
//    private ApplyInfo apply;



    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }
}
