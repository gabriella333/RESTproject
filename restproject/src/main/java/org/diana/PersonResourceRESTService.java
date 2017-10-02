package org.diana;

import java.util.List;

//import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.tools.examples.model.Person;

@Path("/person")
//@RequestScoped
public class PersonResourceRESTService {

	@Inject
	PersonDao persondao;
	
	@OPTIONS
	@Produces(MediaType.APPLICATION_JSON)
	public Response optionsForAuthorResource() {
		return Response.status(200)
				.header("Allow", "POST,GET,PUT,DELETE")
				.header("Content-Type", MediaType.APPLICATION_JSON)
				.header("Content-Length", "0")
				.build();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMember(Person person) {
		persondao.createPerson(person);
		return Response.status(201).build();
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public void refreshMember(Person person) {
		persondao.updatePerson(person);
	}

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteMember(Person person) {
		persondao.removePerson(person);
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> p() {
		return persondao.getAll();
	}
}
