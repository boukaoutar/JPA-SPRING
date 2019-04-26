package com.example.assoc.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Personne implements Serializable{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length=100)
	private String nom;
	@Column(length=100)
	private String prenom;
	@ManyToOne
	@JoinColumn(name= "ID_Adr")
	private Adresse adresse;
	
	
	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	public Personne(String nom, String prenom, Adresse adresses) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresses;
	}
	public Adresse getAdresses() {
		return adresse;
	}
	public void setAdresses(Adresse adresse) {
		this.adresse = adresse;
	}
	public Personne() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	

}
