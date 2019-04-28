package com.example.assoc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the quartier database table.
 * 
 */
@Entity
@NamedQuery(name="Quartier.findAll", query="SELECT q FROM Quartier q")
public class Quartier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_quartier")
	private Integer idQuartier;

	@Lob
	private String description;

	private String nom;

	//bi-directional many-to-one association to Action
	@OneToMany(mappedBy="quartier")
	private List<Action> actions;

	//bi-directional many-to-one association to Zone
	@ManyToOne
	@JoinColumn(name="id_zone")
	private Zone zone;

	public Quartier() {
	}

	public Integer getIdQuartier() {
		return this.idQuartier;
	}

	public void setIdQuartier(Integer idQuartier) {
		this.idQuartier = idQuartier;
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
		action.setQuartier(this);

		return action;
	}

	public Action removeAction(Action action) {
		getActions().remove(action);
		action.setQuartier(null);

		return action;
	}

	public Zone getZone() {
		return this.zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

}