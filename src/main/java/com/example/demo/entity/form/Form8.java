package com.example.demo.entity.form;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Form8 extends Form {
    @Id
    @GeneratedValue
    private long id;
}
