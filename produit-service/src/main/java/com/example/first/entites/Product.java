package com.example.first.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.repository.cdi.Eager;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor@Builder@ToString
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idp;
    private String marque;
    private String description;
    private Float price;
    private Integer quantity;
}
