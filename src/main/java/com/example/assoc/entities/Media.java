package com.example.assoc.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the media database table.
 * 
 */
@Entity
@NamedQuery(name="Media.findAll", query="SELECT m FROM Media m")
public class Media implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_media")
	private Integer idMedia;

	private String dateAjout;

	@Lob
	private String fichier;

	private String nom;

	@Lob
	private String note;

	//bi-directional many-to-one association to Action
	@ManyToOne
	@JoinColumn(name="id_action")
	private Action action;

	//bi-directional many-to-one association to Typemedia
	@ManyToOne
	@JoinColumn(name="id_typeMedia")
	private Typemedia typemedia;

	public Media() {
	}

	public Integer getIdMedia() {
		return this.idMedia;
	}

	public void setIdMedia(Integer idMedia) {
		this.idMedia = idMedia;
	}

	public String getDateAjout() {
		return this.dateAjout;
	}

	public void setDateAjout(String dateAjout) {
		this.dateAjout = dateAjout;
	}

	public String getFichier() {
		return this.fichier;
	}

	public void setFichier(String fichier) {
		this.fichier = fichier;
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

	public Action getAction() {
		return this.action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Typemedia getTypemedia() {
		return this.typemedia;
	}

	public void setTypemedia(Typemedia typemedia) {
		this.typemedia = typemedia;
	}

}