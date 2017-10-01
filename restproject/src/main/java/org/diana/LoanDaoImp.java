package org.diana;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.tools.examples.model.Loan;

public class LoanDaoImp implements LoanDao {

	@Inject
	private EntityManager em;

	@Override
	public void removeLoan(Loan loan) {
		em.remove(loan);

	}

	@Override 
	public void renewLoan(Loan loan) {
		Loan l = new Loan();
		l.renewLoan();

	}

	@Override
	public List<Loan> getAll() {
		return em.createQuery("from Loan l", Loan.class).getResultList();
	}

}
