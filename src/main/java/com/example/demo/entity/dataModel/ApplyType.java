package com.example.demo.entity.dataModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
public class ApplyType implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
}
