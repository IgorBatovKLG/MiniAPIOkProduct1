package com.example.miniapiokproduct.Controller;

import com.example.miniapiokproduct.dataBase.ReportFbOrderList;
import com.example.miniapiokproduct.models.ProductModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/product/add_index")
    public String addProductIndex(){
        return "product/add_index";
    }

    @PostMapping("/product/add_product_csv")
    public String addProductPOSTCSV(@RequestParam("text") String text) {
        String[] split = text.split("\n");
        ReportFbOrderList db = new ReportFbOrderList();
        ArrayList<ProductModel> productModels = new ArrayList<>();
        for (String s : split) {

            String[] split1 = s.split(";");
            split1[3] = split1[3].replace(",",".");
            split1[4] = split1[4].replace(",",".");
            productModels.add(new ProductModel(0, Integer.parseInt(split1[0]), Integer.parseInt(split1[1]), split1[2], Double.parseDouble(split1[3]), Double.parseDouble(split1[4]), Integer.parseInt(split1[5]), split1[6], split1[7], split1[8], split1[9]));
        }
        for (ProductModel productModel : productModels) {
            db.insertProduct(productModel);
        }
        //log.info("Product added with CSV");
        return "redirect:/product/add_index";
    }
}
