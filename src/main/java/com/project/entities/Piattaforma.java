package com.project.entities;

@Entity
public class Piattaforma {

	private int IDPiattaforma;
	private String nomePiattaforma;
	
	public Piattaforma(int IDPiattaforma, String nomePiattaforma) {
		super();
		this.IDPiattaforma= IDPiattaforma;
		this.nomePiattaforma = nomePiattaforma;
	}

	public String getNomePiattaforma() {
		return nomePiattaforma;
	}

	public void setNomePiattaforma(String nomePiattaforma) {
		this.nomePiattaforma = nomePiattaforma;
	}

	public int getIDPiattaforme() {
		return IDPiattaforma;
	}

	public void setIDPiattaforme(int IDPiattaforma) {
		this.IDPiattaforma = IDPiattaforma;
	}
	
	
}
