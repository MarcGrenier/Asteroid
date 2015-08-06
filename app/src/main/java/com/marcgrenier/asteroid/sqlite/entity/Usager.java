package com.marcgrenier.asteroid.sqlite.entity;

public class Usager {
	
	private int id;
	private String nom;
	private int score;
	
	public Usager(String nom, int score, int id) {
		this.nom = nom;
		this.score = score;
		this.id = id;
	}

	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

}
