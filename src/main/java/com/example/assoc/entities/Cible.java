package com.example.assoc.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cible database table.
 * 
 */
@Entity
@NamedQuery(name="Cible.findAll", query="SELECT c FROM Cible c")
public class Cible implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cible")
	private Integer idCible;

	@Lob
	private String description;

	private int nombre;

	//bi-directional many-to-one association to Action
	@ManyToOne
	@JoinColumn(name="id_action")
	private Action action;

	//bi-directional many-to-one association to Typebeneficiaire
	@ManyToOne
	@JoinColumn(name="id_typebenef")
	private Typebeneficiaire typebeneficiaire;

	public Cible() {
	}

	public Integer getIdCible() {
		return this.idCible;
	}

	public void setIdCible(Integer idCible) {
		this.idCible = idCible;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNombre() {
		return this.nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public Action getAction() {
		return this.action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Typebeneficiaire getTypebeneficiaire() {
		return this.typebeneficiaire;
	}

	public void setTypebeneficiaire(Typebeneficiaire typebeneficiaire) {
		this.typebeneficiaire = typebeneficiaire;
	}

}