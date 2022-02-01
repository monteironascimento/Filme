package br.com.monteiro.filme.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produtor_max")
public class Produtor {

	@Id
	private Integer id;

	private String producer;
	private Long interva;
	private Long previousWin;
	private Long followingWin;

	
	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getProducer() {
		return producer;
	}

	public void setInterva(Long interva) {
		this.interva = interva;
	}

	public Long getInterva() {
		return interva;
	}

	public void setPreviousWin(Long previousWin) {
		this.previousWin = previousWin;
	}

	public Long getPreviousWin() {
		return previousWin;
	}

	public void setFollowingWin(Long followingWin) {
		this.followingWin = followingWin;
	}

	public Long getFollowingWin() {
		return followingWin;
	}


}