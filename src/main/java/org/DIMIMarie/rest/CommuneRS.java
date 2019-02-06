package org.DIMIMarie.rest;

import javax.ejb.EJB;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.DIMIMarie.dto.Communes;
import org.DIMIMarie.ejb.CommuneEJB;
import org.DIMIMarie.model.Commune;

@Path("commune")
public class CommuneRS {

	@EJB
	private CommuneEJB communeEJB;

	/* Create*/
	@POST
	@Path("createCommune")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response create(@FormParam("CodeCommune") String codeCommune, @FormParam("NomCommune") String nomCommune, @FormParam("CodePostale") String codePostale) {
		long id = communeEJB.createCommune(codeCommune,nomCommune,codePostale);
		return Response.ok().entity("Departement creee avec l'ID " + id + " / " + nomCommune).build();
	}
	
	
	/*find one*/
	@POST
	@Path("findCommune")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response findCommune(@FormParam("id") long id) {
		Commune commune = communeEJB.getById(id);
		return Response.ok().entity("Commune trouvee : "+ commune.getNom_commune()).build();
	}

	/* Find all */
	@GET
	@Path("retrieveCommune")
	@Produces(MediaType.APPLICATION_XML)
	public Response retrieve() {
		Communes communes = communeEJB.retrieveCommune();
		return Response.ok().entity(communes).build();
	}
	
	/* delete  39202*/
	@POST
	@Path("deleteCommune")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response delete(@FormParam("id") int id) {
		long resultat=communeEJB.deleteCommune(id);
		if(resultat!=0)
		return Response.ok().entity("la commune avec l'ID " + id  + " est effacée").build();
		else
			return Response.ok().entity("effacement non réussi").build();
		
	}
}
