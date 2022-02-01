package br.com.monteiro.filme.repository;



import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.monteiro.filme.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {


    //@Query("select * form filme")
    //public List<Filme> getFilmesSelecionados();

}
