package org.DIMIMarie.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
//import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.DIMIMarie.dto.Departements;
import org.DIMIMarie.ejb.DepartementEJB;
import org.DIMIMarie.model.Departement;

@Path("departement")
public class DepartementRS {
	@EJB
	private DepartementEJB departementEJB;

	/* find one*/
	@GET
	@Path("findDepartement")
	@Produces(MediaType.APPLICATION_XML)
	public Departement getDepartement(@PathParam("id") int id) {
		Departement Departement = departementEJB.getById(id);
		return Departement;
	}

	/* Create*/
	@POST
	@Path("createDepartement")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response create(@FormParam("NomDepartement") String nomDepartement,@FormParam("CodeDepartement")String codeDepartement) {
		long id = departementEJB.createDepartement(nomDepartement,codeDepartement);
		return Response.ok().entity("Departement creee avec l'ID " + id + " / " + nomDepartement).build();
	}

	/* find all*/
	@GET
	@Path("retrieveDepartement")
	@Produces(MediaType.APPLICATION_XML)
	public Response retrieve() {
		Departements departements = departementEJB.retrieveDepartement();
		return Response.ok().entity(departements).build();
	}
	
	/* delete */
	@POST
	@Path("deleteDepartement")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response delete(@FormParam("id") int id) {
		long resultat=departementEJB.deleteDepartement(id);
		if(resultat!=0)
		return Response.ok().entity("la commune avec l'ID " + id  + " est effacée").build();
		else
			return Response.ok().entity("effacement non réussi").build();
		
	}
}