package org.diana;

import java.util.List;

import javax.ejb.Local;

import org.jboss.tools.examples.model.Loan;

@Local
public interface LoanDao {

	void removeLoan(Loan loan);

	void renewLoan(Loan loan);

	List<Loan> getAll();

}
