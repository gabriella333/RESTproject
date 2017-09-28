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

import org.jboss.tools.examples.model.Member;

@Path("/members")
@RequestScoped
public class MemberRest {

	@Inject
	MemberDao memberdao;

	@POST
	@Path("/createmember")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addMember(Member member) {
		memberdao.createMember(member);
	}

	@POST
	@Path("/updatemember")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void refreshMember(Member member) {
		memberdao.updateMember(member);
	}

	@POST
	@Path("/deletemember")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMember(Member member) {
		memberdao.removeMember(member);
	}

	@GET
	@Path("/members")
	public List<Member> mem(Member member) {
		return memberdao.getAll(member);
	}
}
