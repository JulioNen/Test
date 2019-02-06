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
@Table(name = "maire")
public class Maire {

	@XmlAttribute
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@XmlElement(name = "Civilite")
	private String civilite;

	@XmlElement(name = "dateDeNaissance")
	private String dateDeNaissance;

	@XmlElement(name = "nom")
	private String nom;

	@XmlElement(name = "prenom")
	private String prenom;

	public Maire() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCivilite() {
		return this.civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getDateDeNaissance() {
		return this.dateDeNaissance;
	}

	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Maire [id=" + id + ", civilite=" + civilite + ", dateDeNaissance=" + dateDeNaissance + ", nom=" + nom
				+ ", prenom=" + prenom + "]";
	}

}