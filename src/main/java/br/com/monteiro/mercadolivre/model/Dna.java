package br.com.monteiro.mercadolivre.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "dna")
public class Dna {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "bases")
	private List<BaseNitrogenada> bases;

	@Column(name = "mutante")
	private Boolean mutante;


	public void setBases(List<BaseNitrogenada> bases) {
		this.bases = bases;
	}
	
	
	public List<BaseNitrogenada> getBases() {
		return bases;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setMutante(Boolean mutante) {
		this.mutante = mutante;
	}

	public Boolean getMutante() {
		return mutante;
	}


	public Boolean isMutante(String[] dna){
	

		String[] montaColuna;


		for (String string : dna) {

			
			
		}	



		return true;
	}

	private Boolean validaDna(String cadeia){

		if("AAAA"){

		}

		if("TTTT"){

		}

		if("CCCC"){

		}

		if("GGGG"){

		}

		

		return false;
	}
}
