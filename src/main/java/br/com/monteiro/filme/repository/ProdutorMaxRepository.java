package br.com.monteiro.filme.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.monteiro.filme.model.ProdutorMaxView;

public interface ProdutorMaxRepository extends JpaRepository<ProdutorMaxView, Long> {


}


