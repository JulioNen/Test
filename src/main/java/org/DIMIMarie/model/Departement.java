package org.DIMIMarie.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "departement")
public class Departement {

	@XmlAttribute
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@XmlElement(name = "code_departement")
	private String code_departement;

	@XmlElement(name = "nom_departement")
	private String nom_departement;

	public Departement() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode_departement() {
		return code_departement;
	}

	public void setCode_departement(String code_departement) {
		this.code_departement = code_departement;
	}

	public String getNom_departement() {
		return nom_departement;
	}

	public void setNom_departement(String nom_departement) {
		this.nom_departement = nom_departement;
	}

	@Override
	public String toString() {
		return "Departement [id=" + id + ", code_departement=" + code_departement + ", nom_departement="
				+ nom_departement + "]";
	}



}
