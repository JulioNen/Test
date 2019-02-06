package org.DIMIMarie.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.DIMIMarie.model.Departement;

@XmlRootElement
public class Departements {

	List<Departement> departements = new ArrayList<Departement>();

	public List<Departement> getDepartements() {
		return departements;
	}

	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}

}
