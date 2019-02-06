package org.DIMIMarie.ejb;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.DIMIMarie.dto.Maires;
import org.DIMIMarie.model.Maire;

@Stateless
public class MaireEJB {

	@PersistenceContext(unitName = "jpa-test")
	private EntityManager em;

	public Maire getById(long id) {
		return em.find(Maire.class, id);
	}
	

	@SuppressWarnings("unchecked")
	public Maires retrieveMaire() {
		Query query = em.createQuery("select m from Maire m ");
		Maires maires= new Maires();
		maires.setMaires(query.getResultList());
		return maires;
	}



	public long createMaire(String nom, String prenom, String civilite, String dateDeNaissance) {
		// TODO Auto-generated method stub
		Maire maire = new Maire();
		Query query = em.createQuery("select m from Maire m");
		int id=(query.getResultList().size())+1;
		maire.setId(id);
		maire.setNom(nom);
		maire.setPrenom(prenom);
		maire.setCivilite(civilite);
		maire.setDateDeNaissance(dateDeNaissance);
		em.persist(maire);
		return (long)maire.getId();
	}



	public long deleteMaire(int id) {
		// TODO Auto-generated method stub
		long result=0;
		Maire maire=em.find(Maire.class, id);
		em.remove(maire);
		if(em.find(Maire.class, id)==null)
			result=1;
		else
			result=0;
		return result;
	}
}
