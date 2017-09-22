package com.example.demo.entity.formModel;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Form1 implements Serializable{
    @Id
    @GeneratedValue
    private long id;
    private String deviceType;
    private String deviceClass;
    private String deviceVarieties;
    private String productName;
    private String deviceCode;
    private String modelSpecifications;
}
