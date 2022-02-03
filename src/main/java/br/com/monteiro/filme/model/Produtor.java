package br.com.monteiro.filme.model;

public class Produtor  implements Comparable<Produtor>{

	private String producer;
	private Integer interval;
	private Integer previousWin;
	private Integer followingWin;

	public Produtor(String producer, Integer interval, Integer previousWin, Integer followingWin){
		this.producer = producer;
		this.interval = interval;
		this.previousWin = previousWin;
		this.followingWin = followingWin;
	}

	
	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getProducer() {
		return producer;
	}

	public void setInterval(Integer interval) {
		this.interval = interval;
	}

	public Integer getInterval() {
		return interval;
	}

	public void setPreviousWin(Integer previousWin) {
		this.previousWin = previousWin;
	}

	public Integer getPreviousWin() {
		return previousWin;
	}

	public void setFollowingWin(Integer followingWin) {
		this.followingWin = followingWin;
	}

	public Integer getFollowingWin() {
		return followingWin;
	}


	public int compareTo(Produtor other) {
		return interval.compareTo(other.getInterval());
	}


}