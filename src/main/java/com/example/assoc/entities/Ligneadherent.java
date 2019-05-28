package com.example.assoc.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ligneadherent database table.
 * 
 */
@Entity
@NamedQuery(name="Ligneadherent.findAll", query="SELECT l FROM Ligneadherent l")
public class Ligneadherent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_ligneAder;

	private byte role;

	//bi-directional many-to-one association to Organisateur
	@ManyToOne
	@JoinColumn(name="id_organisateurs")
	private Organisateur organisateur;

	public Ligneadherent() {
	}

	public Integer getId_ligneAder() {
		return this.id_ligneAder;
	}

	public void setId_ligneAder(Integer id_ligneAder) {
		this.id_ligneAder = id_ligneAder;
	}

	public byte getRole() {
		return this.role;
	}

	public void setRole(byte role) {
		this.role = role;
	}

	public Organisateur getOrganisateur() {
		return this.organisateur;
	}

	public void setOrganisateur(Organisateur organisateur) {
		this.organisateur = organisateur;
	}

}