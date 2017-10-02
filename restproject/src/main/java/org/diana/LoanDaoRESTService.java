package org.diana;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.tools.examples.model.Loan;

@Path("/loan")
public class LoanDaoRESTService {

	@Inject
	LoanDao loandao;

	@POST
	@Path("/renewloan")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void renewLoan(Loan loan) {
		loandao.renewLoan(loan);
	}

	@POST
	@Path("/removeloan")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void removeLoan(Loan loan) {
		loandao.removeLoan(loan);
	}

	@GET
	@Path("/loanlist")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Loan> l() {
		return loandao.getAll();
	}
}
