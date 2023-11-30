package com.example.first.web;

import com.example.first.config.GlobalConfig;
import com.example.first.entites.Product;
import com.example.first.reposotry.ProductRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestConProduct {

    @Autowired
    ProductRepositry productRepositry;
    @Autowired
    GlobalConfig globalConfig;

    @GetMapping("/config")
    public GlobalConfig globalConfig(){
        return globalConfig;
    }
    @GetMapping("/products")
    public List<Product> getAll(){
        return productRepositry.findAll();
    }

    @GetMapping("/products/{id}")
    public Product productbyid(@PathVariable Integer id){
        return productRepositry.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
    }

}
