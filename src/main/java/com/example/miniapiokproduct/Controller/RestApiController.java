package com.example.miniapiokproduct.Controller;

import com.example.miniapiokproduct.dataBase.ReportFbOrderList;
import com.example.miniapiokproduct.models.ProductModel;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestApiController {

    @GetMapping("/product")
    public String getProduct(){
        ReportFbOrderList db = new ReportFbOrderList();
        ProductModel productModel = db.SelectProduct(db.selectCount(1));
        Gson gson = new Gson();
        return gson.toJson(productModel).toString();
    }

    @GetMapping("/count")
    public String updateCount(){
        ReportFbOrderList db = new ReportFbOrderList();
        db.updateCount(db.selectCount(1)+1,1);
        return "Ok";
    }




}
