package com.example.first.web;

import com.example.first.entites.Product;
import com.example.first.reposotry.ProductRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PGraphqlController {
    @Autowired
    ProductRepositry productRepositry;

   @QueryMapping
    public List<Product> findAllProducts(){
        return productRepositry.findAll();
    }
    @QueryMapping
    public Product findProductbyid(@Argument Integer id){
        return productRepositry.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
    }

    @MutationMapping
    public void createProduct(@Argument(name = "input") ProductInput product){
        Product p = new Product();
        p.setMarque(product.getMarque());
        p.setDescription( product.getDescription());
        p.setPrice(product.getPrice());
        p.setQuantity(product.getQuantity());
        productRepositry.save(p);
    }
    @MutationMapping
    public void updateProduct(@Argument(name = "id") Integer id, @Argument(name = "input") ProductInput product){
        Product p = productRepositry.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
        if (product.getMarque()!=null)p.setMarque(product.getMarque());
        if (product.getDescription()!=null)p.setDescription(product.getDescription());
        if (product.getPrice() != null)p.setPrice(product.getPrice());
        if (product.getQuantity() != null)p.setQuantity(product.getQuantity());
        productRepositry.save(p);
    }

    @MutationMapping
    public void deleteProduct(@Argument(name = "id") Integer id){
        productRepositry.deleteById(id);
    }

}
