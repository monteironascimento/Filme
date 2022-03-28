package br.com.monteiro.mercadolivre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.monteiro.mercadolivre.model.Dna;


public interface DnaRepository extends JpaRepository<Dna, Long> {

    //public List<Dna> findByWinnerTrue();

}
