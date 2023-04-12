package com.example.miniapiokproduct.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductModel {
    private int id;
    private int idShop;
    private int idProduct;
    private String name;
    private double price;
    private double margin;
    private int countImg;
    private String urlImg1;
    private String urlImg2;
    private String urlImg3;
    private String comment;
}
