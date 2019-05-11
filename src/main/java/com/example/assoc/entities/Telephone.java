package com.example.assoc.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the telephone database table.
 * 
 */
@Entity
@NamedQuery(name="Telephone.findAll", query="SELECT t FROM Telephone t")
public class Telephone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tel")
	private Integer idTel;

	@Lob
	private String description;

	private String telephone;

	//bi-directional many-to-one association to Contact
	@ManyToOne
	@JoinColumn(name="id_contact")
	private Contact contact;

	//bi-directional many-to-one association to Typetelephone
	@ManyToOne
	@JoinColumn(name="id_typetel")
	private Typetelephone typetelephone;

	public Telephone() {
	}

	public Integer getIdTel() {
		return this.idTel;
	}

	public void setIdTel(Integer idTel) {
		this.idTel = idTel;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Typetelephone getTypetelephone() {
		return this.typetelephone;
	}

	public void setTypetelephone(Typetelephone typetelephone) {
		this.typetelephone = typetelephone;
	}

}