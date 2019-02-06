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

import org.DIMIMarie.dto.Maires;
import org.DIMIMarie.ejb.MaireEJB;
import org.DIMIMarie.model.Maire;


@Path("maire")
public class MaireRS {
	@EJB
	private MaireEJB maireEJB;

	/* find all*/
	@GET
	@Path("retrieveMaire")
	@Produces(MediaType.APPLICATION_XML)
	public Response retrieve() {
		Maires maires =   maireEJB.retrieveMaire();
		return Response.ok().entity(maires).build();
	}
	
	/*find one*/
	@POST
	@Path("findMaire")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response findCommune(@FormParam("id") long id) {
		Maire maire = maireEJB.getById(id);
		return Response.ok().entity("Maire trouvé : "+ maire.getNom()+ " "+ maire.getPrenom()).build();
	}

	
	/* Create*/
	@POST
	@Path("createMaire")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response create(@FormParam("nom") String nom, @FormParam("prenom") String prenom, @FormParam("dateDeNaissance") String dateDeNaissance, @FormParam("civilite") String civilite) {
		long id = maireEJB.createMaire(nom,prenom,civilite,dateDeNaissance);
		return Response.ok().entity("le maire crée avec l'ID " + id + " est " + nom + " "+ prenom).build();
	}

	
	/* delete  39202*/
	@POST
	@Path("deleteMaire")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response delete(@FormParam("id") int id) {
		long resultat=maireEJB.deleteMaire(id);
		if(resultat!=0)
		return Response.ok().entity("le maire avec l'ID " + id  + " est effacée").build();
		else
			return Response.ok().entity("effacement non réussi").build();
		
	}
}
