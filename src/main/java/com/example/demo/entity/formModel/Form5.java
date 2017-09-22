package com.example.demo.entity.formModel;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Form5 implements Serializable {
    @Id
    @GeneratedValue
    private long  id;
}
