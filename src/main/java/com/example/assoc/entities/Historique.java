package com.example.assoc.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the historique database table.
 * 
 */
@Entity
@NamedQuery(name="Historique.findAll", query="SELECT h FROM Historique h")
public class Historique implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_historique")
	private Integer idHistorique;

	private String dateOperation;

	@Lob
	private String operation;

	//bi-directional many-to-one association to Contact
	@ManyToOne
	@JoinColumn(name="id_contact")
	private Contact contact;

	public Historique() {
	}

	public Integer getIdHistorique() {
		return this.idHistorique;
	}

	public void setIdHistorique(Integer idHistorique) {
		this.idHistorique = idHistorique;
	}

	public String getDateOperation() {
		return this.dateOperation;
	}

	public void setDateOperation(String dateOperation) {
		this.dateOperation = dateOperation;
	}

	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}