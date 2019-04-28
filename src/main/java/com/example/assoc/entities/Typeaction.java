package com.example.assoc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the typeaction database table.
 * 
 */
@Entity
@NamedQuery(name="Typeaction.findAll", query="SELECT t FROM Typeaction t")
public class Typeaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id_typeAction;

	private String nom;

	@Lob
	private String note;

	//bi-directional many-to-one association to Action
	@OneToMany(mappedBy="typeaction")
	private List<Action> actions;

	public Typeaction() {
	}

	public Integer getId_typeAction() {
		return this.id_typeAction;
	}

	public void setId_typeAction(Integer id_typeAction) {
		this.id_typeAction = id_typeAction;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<Action> getActions() {
		return this.actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public Action addAction(Action action) {
		getActions().add(action);
		action.setTypeaction(this);

		return action;
	}

	public Action removeAction(Action action) {
		getActions().remove(action);
		action.setTypeaction(null);

		return action;
	}

}