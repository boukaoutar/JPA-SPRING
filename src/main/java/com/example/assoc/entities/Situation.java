package com.example.assoc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the situation database table.
 * 
 */
@Entity
@NamedQuery(name="Situation.findAll", query="SELECT s FROM Situation s")
public class Situation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_situation")
	private Integer idSituation;

	private String couleur;

	@Lob
	private String description;

	private String nom;

	//bi-directional many-to-one association to Action
	@OneToMany(mappedBy="situation")
	private List<Action> actions;

	public Situation() {
	}

	public Integer getIdSituation() {
		return this.idSituation;
	}

	public void setIdSituation(Integer idSituation) {
		this.idSituation = idSituation;
	}

	public String getCouleur() {
		return this.couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
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
		action.setSituation(this);

		return action;
	}

	public Action removeAction(Action action) {
		getActions().remove(action);
		action.setSituation(null);

		return action;
	}

}