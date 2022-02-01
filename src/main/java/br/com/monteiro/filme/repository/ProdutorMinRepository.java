package br.com.monteiro.filme.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.monteiro.filme.model.ProdutorMinView;

public interface ProdutorMinRepository extends JpaRepository<ProdutorMinView, Long> {


}


