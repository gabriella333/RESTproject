package org.diana;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.tools.examples.model.Person;

@Path("/persons")
@RequestScoped
public class PersonResourceRESTService {

	@Inject
	PersonDao persondao;

	@POST
	@Path("/createperson")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addMember(Person person) {
		persondao.createPerson(person);
	}

	@POST
	@Path("/updateperson")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void refreshMember(Person person) {
		persondao.updatePerson(person);
	}

	@POST
	@Path("/deleteperson")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMember(Person person) {
		persondao.removePerson(person);
	}

	@GET
	@Path("/personslist")
	public List<Person> p(Person person) {
		return persondao.getAll(person);
	}
}
