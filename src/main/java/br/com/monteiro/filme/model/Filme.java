package br.com.monteiro.filme.model;

import javax.persistence.*;

@Entity
@Table(name = "filmes")
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "year")
	private Integer year;

	@Column(name = "title")
	private String title;

	@Column(name = "studios")
	private String studios;

	@Column(name = "producers")
	private String producers;

	@Column(name = "winner")
	private boolean winner;

	public static void main(String[] args) {
		
	}

	public Filme() {
	}

	public Filme(Integer year, String title, String studios, String producers, String winner) {
		this.year = year;
		this.title = title;
		this.studios = studios;
		this.producers = producers;
		this.winner =  (winner.equals("yes") ? true : false);
	}

	public String getWinner() {
		return (winner ? "yes" : "");
	}

	public void setWinner(String winner) {
		this.winner = (winner.equals("yes") ? true : false);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public Integer getYear() {
		return year;
	}
	
	public String getTitle() {
		return title;
	}
	

	public void setProducers(String producers) {
		this.producers = producers;
	}

	public String getProducers() {
		return producers;
	}

	public void setStudios(String studios) {
		this.studios = studios;
	}

	public String getStudios() {
		return studios;
	}

	public void setPublished(boolean winner) {
		this.winner = winner;
	}

	public boolean isPublished() {
		return winner;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
