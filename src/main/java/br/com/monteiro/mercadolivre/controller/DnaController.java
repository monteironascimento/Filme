package br.com.monteiro.mercadolivre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.monteiro.mercadolivre.model.BaseNitrogenada;
import br.com.monteiro.mercadolivre.model.Dna;
import br.com.monteiro.mercadolivre.repository.DnaRepository;


@RestController
@RequestMapping("/")
public class DnaController {

    @Autowired
    DnaRepository dnaRepository;

    @PostMapping("/mutant")
    public ResponseEntity<Dna> postDna(@RequestBody List<BaseNitrogenada> bases) {
        try {

            System.out.println(bases);    
            Dna dna = new Dna();
            dna.setMutante(dna.isMutante(bases));
            dna.setBases(bases);
            Dna objData = dnaRepository.save(dna);

            return new ResponseEntity<>(objData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping
    public ResponseEntity<List<String>> getAllFilmes() {
        try {
           
           /* List<Filme> filmes = new ArrayList<Filme>();

            filmeRepository.findAll().forEach(filmes::add);

            if (filmes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }*/

            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}



