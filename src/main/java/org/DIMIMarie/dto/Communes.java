package org.DIMIMarie.dto;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

import org.DIMIMarie.model.Commune;

@XmlRootElement
public class Communes {

	List<Commune> communes = new ArrayList<Commune>();

	public Communes() {

	}

	public List<Commune> getCommunes() {
		return communes;
	}

	public void setCommunes(List<Commune> communes) {
		this.communes = communes;
	}
}
