package com.example.assoc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the typemedia database table.
 * 
 */
@Entity
@NamedQuery(name="Typemedia.findAll", query="SELECT t FROM Typemedia t")
public class Typemedia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id_typeMedia;

	@Lob
	private String description;

	private String nom;

	//bi-directional many-to-one association to Media
	@OneToMany(mappedBy="typemedia")
	private List<Media> medias;

	public Typemedia() {
	}

	public int getId_typeMedia() {
		return this.id_typeMedia;
	}

	public void setId_typeMedia(int id_typeMedia) {
		this.id_typeMedia = id_typeMedia;
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

	public List<Media> getMedias() {
		return this.medias;
	}

	public void setMedias(List<Media> medias) {
		this.medias = medias;
	}

	public Media addMedia(Media media) {
		getMedias().add(media);
		media.setTypemedia(this);

		return media;
	}

	public Media removeMedia(Media media) {
		getMedias().remove(media);
		media.setTypemedia(null);

		return media;
	}

}