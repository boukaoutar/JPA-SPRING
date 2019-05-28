package com.example.assoc.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bureauvote database table.
 * 
 */
@Entity
@NamedQuery(name="Bureauvote.findAll", query="SELECT b FROM Bureauvote b")
public class Bureauvote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_bureauV;

	@Lob
	private String adresse;

	private String nom;

	public Bureauvote() {
	}

	public Integer getId_bureauV() {
		return this.id_bureauV;
	}

	public void setId_bureauV(Integer id_bureauV) {
		this.id_bureauV = id_bureauV;
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