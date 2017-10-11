package com.example.demo.entity.formModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Form8 implements Serializable {
    @Id
    @GeneratedValue
    private long id;
}
