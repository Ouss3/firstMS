package com.example.first.reposotry;

import com.example.first.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface ProductRepositry extends JpaRepository<Product,Integer> {
}
