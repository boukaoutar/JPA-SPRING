package com.example.assoc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the typeadresse database table.
 * 
 */
@Entity
@NamedQuery(name="Typeadresse.findAll", query="SELECT t FROM Typeadresse t")
public class Typeadresse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id_typeAdrs;

	@Lob
	private String description;

	private String nom;

	//bi-directional many-to-one association to Adresse
	@OneToMany(mappedBy="typeadresse")
	private List<Adresse> adresses;

	public Typeadresse() {
	}

	public Integer getId_typeAdrs() {
		return this.id_typeAdrs;
	}

	public void setId_typeAdrs(Integer id_typeAdrs) {
		this.id_typeAdrs = id_typeAdrs;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Adresse> getAdresses() {
		return this.adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	public Adresse addAdress(Adresse adress) {
		getAdresses().add(adress);
		adress.setTypeadresse(this);

		return adress;
	}

	public Adresse removeAdress(Adresse adress) {
		getAdresses().remove(adress);
		adress.setTypeadresse(null);

		return adress;
	}

}