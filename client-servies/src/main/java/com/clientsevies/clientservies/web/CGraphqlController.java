package com.clientsevies.clientservies.web;

import com.clientsevies.clientservies.entites.Client;
import com.clientsevies.clientservies.reposotry.ClientReposotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CGraphqlController {
    @Autowired
    ClientReposotry clientReposotry;

    @MutationMapping
    public void deleteClient(@Argument(name = "id") Integer id){
        clientReposotry.deleteById(id);
    }
    @MutationMapping
    public void updateClient(@Argument(name = "id") Integer id, @Argument(name = "input") ClientInput client){
        Client c = clientReposotry.findById(id).orElseThrow(()-> new RuntimeException("Client not found"));
        if (client.getNom()!=null)c.setNom(client.getNom());
        if (client.getPrenom()!=null)c.setPrenom(client.getPrenom());
        if(client.getVille()!=null)c.setVille(client.getVille());

        clientReposotry.save(c);
    }

    @MutationMapping
    public void createClient(@Argument(name = "input") ClientInput client){
        Client c = new Client();
        c.setNom(client.getNom());
        c.setPrenom(client.getPrenom());
        c.setVille(client.getVille());
        clientReposotry.save(c);
    }
    @QueryMapping
    public Client clientbyid(@Argument Integer id){
        return clientReposotry.findById(id).orElseThrow(()-> new RuntimeException("Client not found"));
    }
    @QueryMapping
    public List<Client> findAllClient(){
        return clientReposotry.findAll();
    }
}
