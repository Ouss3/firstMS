package com.example.first;

import com.example.first.entites.Product;
import com.example.first.reposotry.ProductRepositry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class FirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepositry productReposetry){
        return args -> {
            for (int i=0;i<10;i++){
                Product c = Product.builder().marque("marque"+i).description("description"+i).price((float)(10*i)).quantity(i).build();
                productReposetry.save(c);
            }
        };
    }
}
