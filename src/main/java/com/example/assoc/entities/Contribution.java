package com.example.assoc.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the contribution database table.
 * 
 */
@Entity
@NamedQuery(name="Contribution.findAll", query="SELECT c FROM Contribution c")
public class Contribution implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_contribution")
	private Integer idContribution;

	@Lob
	private String description;

	private String nom;

	//bi-directional many-to-one association to Ressource
	@ManyToOne
	@JoinColumn(name="id_ressource")
	private Ressource ressource;

	public Contribution() {
	}

	public Integer getIdContribution() {
		return this.idContribution;
	}

	public void setIdContribution(Integer idContribution) {
		this.idContribution = idContribution;
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

	public Ressource getRessource() {
		return this.ressource;
	}

	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}

}