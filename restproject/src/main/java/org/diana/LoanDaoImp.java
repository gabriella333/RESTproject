package org.diana;

import java.util.Date;
import java.util.Scanner;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.tools.examples.model.Loan;

public class LoanDaoImp implements LoanDao {

	@Inject
	private EntityManager em;
	Date date;
	Scanner sc = new Scanner(System.in);

	@Override
	public void removeLoan(Loan loan) {
		em.remove(loan);

	}

	//TODO
	@Override
	public void renewLoan(Loan loan) {
		loan.setDate(date);

	}

}
