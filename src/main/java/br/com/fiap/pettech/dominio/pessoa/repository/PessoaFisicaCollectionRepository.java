package br.com.fiap.pettech.dominio.pessoa.repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Repository;

import br.com.fiap.pettech.dominio.pessoa.entity.PessoaFisica;

@Repository
public class PessoaFisicaCollectionRepository {
    
    private static Set<PessoaFisica> pessoas;

    static {
        pessoas = new LinkedHashSet<>();

        PessoaFisica p1 = new PessoaFisica();
        p1.setCpf("12345678910").setNome("Kelvin Natal").setNascimento(LocalDate.of(2002, 10, 11));

        PessoaFisica dep1 = new PessoaFisica();
        dep1.setCpf("12345678911").setNome("Maria Jose").setNascimento(LocalDate.of(2000, 05, 15));

        p1.addDependente(dep1);

        save(p1);
        save(dep1);
    }

    public Collection<PessoaFisica> findAll(){
        return pessoas;
    }

    public Optional<PessoaFisica> findById(Long id){
        return pessoas.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public static PessoaFisica save(PessoaFisica p){
        p.setId(pessoas.size() + 1L);
        pessoas.add(p);
        return p;
    }
}
