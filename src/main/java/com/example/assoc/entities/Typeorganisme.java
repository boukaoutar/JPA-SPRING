package com.example.assoc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the typeorganisme database table.
 * 
 */
@Entity
@NamedQuery(name="Typeorganisme.findAll", query="SELECT t FROM Typeorganisme t")
public class Typeorganisme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_typeOrga;

	@Lob
	private String description;

	private String nom;

	//bi-directional many-to-one association to Organisme
	@OneToMany(mappedBy="typeorganisme")
	private List<Organisme> organismes;

	public Typeorganisme() {
	}

	public Integer getId_typeOrga() {
		return this.id_typeOrga;
	}

	public void setId_typeOrga(Integer id_typeOrga) {
		this.id_typeOrga = id_typeOrga;
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

	public List<Organisme> getOrganismes() {
		return this.organismes;
	}

	public void setOrganismes(List<Organisme> organismes) {
		this.organismes = organismes;
	}

	public Organisme addOrganisme(Organisme organisme) {
		getOrganismes().add(organisme);
		organisme.setTypeorganisme(this);

		return organisme;
	}

	public Organisme removeOrganisme(Organisme organisme) {
		getOrganismes().remove(organisme);
		organisme.setTypeorganisme(null);

		return organisme;
	}

}