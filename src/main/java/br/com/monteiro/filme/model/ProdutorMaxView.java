package br.com.monteiro.filme.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produtor_max")
public class ProdutorMaxView implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "producer")
	private String producer;

	@Column(name = "interva")
	private Long interval;

	@Column(name = "previousWin")
	private Long previousWin;

	@Column(name = "followingWin")
	private Long followingWin;

	
	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getProducer() {
		return producer;
	}

	public void setInterval(Long interval) {
		this.interval = interval;
	}

	public Long getInterval() {
		return interval;
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