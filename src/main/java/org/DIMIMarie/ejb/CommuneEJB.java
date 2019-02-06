package org.DIMIMarie.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.DIMIMarie.dto.Communes;
import org.DIMIMarie.model.Commune;

@Stateless
public class CommuneEJB {

	@PersistenceContext(unitName = "jpa-test")
	private EntityManager em;

	public long createCommune(String codeCommune,String nomCommune, String codePostale) {
		Commune commune = new Commune();
		Query query = em.createQuery("select c from Commune c");
		int id=(query.getResultList().size())+1;
		commune.setId((long) id);
		commune.setCode_commune(codeCommune);
		commune.setNom_commune(nomCommune);
		commune.setCode_postale(codePostale);
		commune.setLibelle_Acheminement(nomCommune);
		commune.setLigne_5(null);
		em.persist(commune);
		return commune.getId();
	}
	
	public long deleteCommune(long id) {
		long result=0;
		Commune commune=em.find(Commune.class, id);
		em.remove(commune);
		if(em.find(Commune.class, id)==null)
			result=1;
		else
			result=0;
		return result;
	}

	public Commune getById(long id) {
		Commune commune=em.find(Commune.class, id);
		return commune;
	}

	@SuppressWarnings("unchecked")
	public Communes retrieveCommune() {
		Query query = em.createQuery("select c from Commune c");
		Communes communes = new Communes();
		communes.setCommunes(query.getResultList());
		return communes;
	}
}
