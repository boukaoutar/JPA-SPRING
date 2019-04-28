package com.example.assoc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the partenaire database table.
 * 
 */
@Entity
@NamedQuery(name="Partenaire.findAll", query="SELECT p FROM Partenaire p")
public class Partenaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_partenaire")
	private Integer idPartenaire;

	@Lob
	private String description;

	private String nom;

	//bi-directional many-to-many association to Action
	@ManyToMany
	@JoinTable(
		name="partneraction"
		, joinColumns={
			@JoinColumn(name="id_partenaire")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_action")
			}
		)
	private List<Action> actions;

	public Partenaire() {
	}

	public Integer getIdPartenaire() {
		return this.idPartenaire;
	}

	public void setIdPartenaire(Integer idPartenaire) {
		this.idPartenaire = idPartenaire;
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

	public List<Action> getActions() {
		return this.actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

}