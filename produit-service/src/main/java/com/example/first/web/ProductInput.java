package com.example.first.web;

import lombok.*;

@Data
@AllArgsConstructor@NoArgsConstructor@ToString@Builder
public class ProductInput {
    private String marque;
    private String description;
    private Float price;
    private Integer quantity;
}
