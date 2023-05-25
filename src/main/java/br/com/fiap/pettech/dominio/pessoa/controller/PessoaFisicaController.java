package br.com.fiap.pettech.dominio.pessoa.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.pettech.dominio.pessoa.entity.PessoaFisica;
import br.com.fiap.pettech.dominio.pessoa.repository.PessoaFisicaCollectionRepository;

@RestController
@RequestMapping("/pf")
public class PessoaFisicaController {
    
    @Autowired
    private PessoaFisicaCollectionRepository repo;

    @GetMapping("/")
    public ResponseEntity<Collection<PessoaFisica>> findAll(){
        var pessoas = repo.findAll();
        return ResponseEntity.ok(pessoas);
    }

}   
