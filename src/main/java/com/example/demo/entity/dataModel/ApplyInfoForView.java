package com.example.demo.entity.dataModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties(value = {"form1","form2","form3","form4","form5","form6","form7","form8",})
public class ApplyInfoForView  implements Serializable {

}
