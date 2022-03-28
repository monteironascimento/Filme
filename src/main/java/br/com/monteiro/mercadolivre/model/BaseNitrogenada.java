package br.com.monteiro.mercadolivre.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "base")
public class BaseNitrogenada implements Serializable{
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dna")
	private String dna;

    public void setBase(String dna) {
        this.dna = dna;
    }

    public String getBase() {
        return dna;
    }
}
