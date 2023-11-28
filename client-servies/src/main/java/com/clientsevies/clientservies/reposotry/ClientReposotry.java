package com.clientsevies.clientservies.reposotry;

import com.clientsevies.clientservies.entites.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;


public interface ClientReposotry extends JpaRepository<Client,Integer> {
}
