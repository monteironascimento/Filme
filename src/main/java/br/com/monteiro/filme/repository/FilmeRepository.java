package br.com.monteiro.filme.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.monteiro.filme.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

    public List<Filme> findByWinnerTrue();

}
