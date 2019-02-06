package org.DIMIMarie.ejb;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.DIMIMarie.dto.Departements;
import org.DIMIMarie.model.Departement;


@Stateless
public class DepartementEJB {

	@PersistenceContext(unitName = "jpa-test")
	private EntityManager em;

	public long createDepartement(String codeDepartement,String nomDepartement) {
		Departement departement = new Departement();
		Query query = em.createQuery("select d from Departement d");
		int id=(query.getResultList().size())+1;
		departement.setId(id);
		departement.setCode_departement(codeDepartement);
		departement.setNom_departement(nomDepartement);
		em.persist(departement);
		return departement.getId();
	}
	
	public long deleteDepartement(int id) {
		long result=0;
		Departement departement=em.find(Departement.class, id);
		em.remove(departement);
		if(em.find(Departement.class, id)==null)
			result=1;
		else
			result=0;
		return result;
	}

	
	public Departement getById(long id) {
		return em.find(Departement.class, id);
	}

	@SuppressWarnings("unchecked")
	public Departements retrieveDepartement() {
		Query query = em.createQuery("select d from Departement d ");
		Departements depts= new Departements();
		depts.setDepartements(query.getResultList());
		return depts;
	}
	
	
}
