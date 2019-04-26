package com.example.assoc.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the communaute database table.
 * 
 */
@Entity
@NamedQuery(name="Communaute.findAll", query="SELECT c FROM Communaute c")
public class Communaute implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_communaute")
	private Integer idCommunaute;

	@Lob
	private String adresse;

	private String nom;

	public Communaute() {
	}

	public int getIdCommunaute() {
		return this.idCommunaute;
	}

	public void setIdCommunaute(int idCommunaute) {
		this.idCommunaute = idCommunaute;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}