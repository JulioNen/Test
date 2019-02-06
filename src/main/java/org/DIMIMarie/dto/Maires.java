package org.DIMIMarie.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.DIMIMarie.model.Maire;

@XmlRootElement
public class Maires {
	List<Maire> maires = new ArrayList<Maire>();

	public List<Maire> getMaires() {
		return maires;
	}

	public void setMaires(List<Maire> maires) {
		this.maires = maires;
	}

}
