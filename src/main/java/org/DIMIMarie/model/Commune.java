package org.DIMIMarie.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="commune")
public class Commune {

	@XmlAttribute
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;

	@XmlElement(name = "code_commune")
	String code_commune;

	@XmlElement(name = "nom_commune")
	String nom_commune;

	@XmlElement(name = "code_postale")
	String code_postale;

	@XmlElement(name = "libelle_Acheminement")
	String libelle_Acheminement;

	@XmlElement(name = "ligne_5")
	String ligne_5;

	public Commune() {

	}

	public String getCode_commune() {
		return code_commune;
	}

	public void setCode_commune(String code_commune) {
		this.code_commune = code_commune;
	}

	public String getNom_commune() {
		return nom_commune;
	}

	public void setNom_commune(String nom_commune) {
		this.nom_commune = nom_commune;
	}


	public String getLibelle_Acheminement() {
		return libelle_Acheminement;
	}

	public void setLibelle_Acheminement(String libelle_Acheminement) {
		this.libelle_Acheminement = libelle_Acheminement;
	}


	public String getCode_postale() {
		return code_postale;
	}

	public void setCode_postale(String code_postale) {
		this.code_postale = code_postale;
	}

	public String getLigne_5() {
		return ligne_5;
	}

	public void setLigne_5(String ligne_5) {
		this.ligne_5 = ligne_5;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Commune [id=" + id + ", code_commune=" + code_commune + ", nom_commune=" + nom_commune
				+ ", code_postale=" + code_postale + ", libelle_Acheminement=" + libelle_Acheminement + ", ligne_5="
				+ ligne_5 + "]";
	}

	
}
