package br.com.monteiro.filme.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.monteiro.filme.model.Filme;
import br.com.monteiro.filme.model.PremioView;
import br.com.monteiro.filme.model.Produtor;
import br.com.monteiro.filme.repository.FilmeRepository;


@RestController
@RequestMapping("/api")
public class FilmeController {

    @Autowired
    FilmeRepository filmeRepository;

    @PostConstruct
    public void init(){

        try {
			carregaDados();           
        } catch (Exception e) {
           e.printStackTrace();
        }

    }


    @GetMapping("/premios")
    public ResponseEntity<PremioView> getAllFilmesV2() {
        try {
            List<Produtor> produtores = new ArrayList<Produtor>();
            List<Filme> filmes = new ArrayList<Filme>();
            HashMap<String, ArrayList<Integer>> map = new HashMap<>();

            filmeRepository.findByWinnerTrue().forEach(filmes::add);

            map = ordenaProdutores(map, filmes);

            produtores = buscaIntervalosPremios(produtores, map);

            if (produtores.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
          
            PremioView premios = ordernarPremios(produtores);

            if (premios == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            
            return new ResponseEntity<>(premios, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/filmes")
    public ResponseEntity<List<Filme>> getAllFilmes() {
        try {
            List<Filme> filmes = new ArrayList<Filme>();

            filmeRepository.findAll().forEach(filmes::add);

            if (filmes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(filmes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/filmes/{id}")
    public ResponseEntity<Filme> getFilmeById(@PathVariable("id") long id) {

        try {
            Optional<Filme> objData = filmeRepository.findById(id);

            if (objData.isPresent()) {
                return new ResponseEntity<>(objData.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @PostMapping("/filmes")
    public ResponseEntity<Filme> createFilme(@RequestBody Filme filme) {
        try {
            Filme objData = filmeRepository
                    .save(new Filme(filme.getYear(), filme.getTitle(), filme.getStudios(), filme.getProducers() , filme.getWinner()));
            return new ResponseEntity<>(objData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/filmes/{id}")
    public ResponseEntity<Filme> updateFilme(@PathVariable("id") long id, @RequestBody Filme filme) {

        try {

            Optional<Filme> filmeData = filmeRepository.findById(id);

            if (filmeData.isPresent()) {
                Filme objData = filmeData.get();
                objData.setYear(filme.getYear());
                objData.setTitle(filme.getTitle());
                objData.setStudios(filme.getStudios());
                objData.setProducers(filme.getProducers());
                objData.setWinner(filme.getWinner() == null ? "" : filme.getWinner());
                return new ResponseEntity<>(filmeRepository.save(objData), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        
    }

    @DeleteMapping("/filmes/{id}")
    public ResponseEntity<HttpStatus> deleteFilme(@PathVariable("id") long id) {
        try {
            filmeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/filmes")
    public ResponseEntity<HttpStatus> deleteAllFilmes() {
        try {
            filmeRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

	public void carregaDados() throws Exception {
        String linha = "";
        BufferedReader br = null;
        try {
    
            br = new BufferedReader(new FileReader("movielist.csv"));
            while (( linha = br.readLine()) != null) {
    
                String[] objLinha = linha.split(";");

                if(!objLinha[0].equals("year")){

                    Filme filme = new Filme();

                    try {
                        filme.setYear(Integer.parseInt(objLinha[0]) );
                    } catch (Exception e) {
                        
                    }

                    try {
                        filme.setTitle(objLinha[1]);
                    } catch (Exception e) {
                        filme.setTitle("");
                    }

                    try {
                        filme.setStudios(objLinha[2]);
                    } catch (Exception e) {
                        filme.setStudios("");
                    }

                    try {
                        filme.setProducers(objLinha[3]);
                    } catch (Exception e) {
                        filme.setProducers("");
                    }


                    try {
                        filme.setWinner(objLinha[4]);
                    } catch (Exception e) {
                        filme.setWinner("");
                    }
                    
                    try {
						filmeRepository.save(filme);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }               
                }
    
            }
    
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private PremioView ordernarPremios(List<Produtor> produtores) throws Exception {
        PremioView premios = new PremioView();

        Collections.sort(produtores);
        
        premios.getMax().add(produtores.get(produtores.size() - 1));
        premios.getMin().add(produtores.get(0));

        return premios;
    }

    private HashMap<String, ArrayList<Integer>> ordenaProdutores(HashMap<String, ArrayList<Integer>> map, List<Filme> filmes) throws Exception {

        for (Filme filme : filmes) {

            if(filme.getWinner().equals("yes")){

                String[] producer =  filme.getProducers().replaceAll(", ", ";").replaceAll(" , ", ";").replaceAll(" and ", ";").split(";");
    
                
                for (String objProdutor : producer) {
                    
                    if(map.get(objProdutor) == null) {

                        ArrayList<Integer> anos = new ArrayList<>();
                        anos.add(filme.getYear());
                        
                        map.put(objProdutor, anos);
                    }else{

                        ArrayList<Integer> anos =map.get(objProdutor);  
                        Collections.sort(anos);
                        anos.add(filme.getYear()); 
                    }

                }
            }
            
            
        }
        return map;
    }

    private List<Produtor> buscaIntervalosPremios(List<Produtor> produtores, HashMap<String, ArrayList<Integer>> map) throws Exception {

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            
            Map.Entry pairs = (Map.Entry) it.next();
            ArrayList<Integer> anos = (ArrayList<Integer>) pairs.getValue();
            if(anos.size() < 2){
                it.remove();
            }else{
                
                Integer previousWin = 0;     
                for (Integer followingWin : anos) {

                    if(previousWin > 0){
                       
                        Integer interval = (followingWin - previousWin);

                        produtores.add(new Produtor(String.valueOf(pairs.getKey()), interval, previousWin, followingWin));  
                        previousWin = followingWin;  
                    }else{
                        previousWin = followingWin;  
                    }

                }

            }
           
        }
        return produtores;
    }

}



