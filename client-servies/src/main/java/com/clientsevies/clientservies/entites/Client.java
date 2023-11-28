package com.clientsevies.clientservies.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
 @Data @AllArgsConstructor@NoArgsConstructor@ToString@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ida;
    private String nom;
    private String prenom;
    private String ville;
}
