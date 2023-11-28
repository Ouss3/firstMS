package com.clientsevies.clientservies;

import com.clientsevies.clientservies.entites.Client;
import com.clientsevies.clientservies.reposotry.ClientReposotry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientServiesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientServiesApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ClientReposotry clientReposetry){
        return args -> {
            for (int i=0;i<10;i++){
                Client c = Client.builder().nom("nom"+i).prenom("prenom"+i).ville("ville"+i).build();
                clientReposetry.save(c);
            }
        };
    }
}
