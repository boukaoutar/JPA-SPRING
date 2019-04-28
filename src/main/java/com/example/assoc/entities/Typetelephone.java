package com.example.assoc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the typetelephone database table.
 * 
 */
@Entity
@NamedQuery(name="Typetelephone.findAll", query="SELECT t FROM Typetelephone t")
public class Typetelephone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_typetel")
	private Integer idTypetel;

	@Lob
	private String description;

	private String nom;

	//bi-directional many-to-one association to Telephone
	@OneToMany(mappedBy="typetelephone")
	private List<Telephone> telephones;

	public Typetelephone() {
	}

	public Integer getIdTypetel() {
		return this.idTypetel;
	}

	public void setIdTypetel(Integer idTypetel) {
		this.idTypetel = idTypetel;
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

	public List<Telephone> getTelephones() {
		return this.telephones;
	}

	public void setTelephones(List<Telephone> telephones) {
		this.telephones = telephones;
	}

	public Telephone addTelephone(Telephone telephone) {
		getTelephones().add(telephone);
		telephone.setTypetelephone(this);

		return telephone;
	}

	public Telephone removeTelephone(Telephone telephone) {
		getTelephones().remove(telephone);
		telephone.setTypetelephone(null);

		return telephone;
	}

}