package com.example.assoc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the adresse database table.
 * 
 */
@Entity
@NamedQuery(name="Adresse.findAll", query="SELECT a FROM Adresse a")
public class Adresse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_adresse")
	private Integer idAdresse;

	@Column(name="code_postal")
	private int codePostal;

	private String quartier;

	private String ville;

	//bi-directional many-to-one association to Typeadresse
	@ManyToOne
	@JoinColumn(name="id_typeAdrs")
	private Typeadresse typeadresse;

	//bi-directional many-to-many association to Contact
	@ManyToMany
	@JoinTable(
		name="contactadresse"
		, joinColumns={
			@JoinColumn(name="id_adresse")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_contact")
			}
		)
	private List<Contact> contacts;

	public Adresse() {
	}

	public int getIdAdresse() {
		return this.idAdresse;
	}

	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}

	public int getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getQuartier() {
		return this.quartier;
	}

	public void setQuartier(String quartier) {
		this.quartier = quartier;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Typeadresse getTypeadresse() {
		return this.typeadresse;
	}

	public void setTypeadresse(Typeadresse typeadresse) {
		this.typeadresse = typeadresse;
	}

	public List<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

}