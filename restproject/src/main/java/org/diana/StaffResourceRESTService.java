package org.diana;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.tools.examples.model.Staff;

@Path("/staff")
//@RequestScoped
public class StaffResourceRESTService {

	@Inject
	StaffDao staffdao;

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
	public void addMember(Staff staff) {
		staffdao.createStaff(staff);
	}

	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
	public void refreshStaff(Staff staff) {
		staffdao.updateStaff(staff);
	}

	@POST
	@Path("/delete")
	//@Path("/deletestaff/{staffId}")
	@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
	public void deleteStaff(Staff staff) {		
		staffdao.removeStaff(staff);
	}

	@GET
	@Path("/stafflist")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Staff> s() {
		return staffdao.getAllStaff();
	}

}