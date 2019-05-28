package com.example.assoc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the projet database table.
 * 
 */
@Entity
@NamedQuery(name="Projet.findAll", query="SELECT p FROM Projet p")
public class Projet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_projet")
	private Integer idProjet;

	@Lob
	private String description;

	private String nom;

	//bi-directional many-to-one association to Action
	@OneToMany(mappedBy="projet")
	private List<Action> actions;

	//bi-directional many-to-one association to Organisme
	@ManyToOne
	@JoinColumn(name="id_organisme")
	private Organisme organisme;

	public Projet() {
	}

	public Integer getIdProjet() {
		return this.idProjet;
	}

	public void setIdProjet(Integer idProjet) {
		this.idProjet = idProjet;
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

	public Action addAction(Action action) {
		getActions().add(action);
		action.setProjet(this);

		return action;
	}

	public Action removeAction(Action action) {
		getActions().remove(action);
		action.setProjet(null);

		return action;
	}

	public Organisme getOrganisme() {
		return this.organisme;
	}

	public void setOrganisme(Organisme organisme) {
		this.organisme = organisme;
	}

}