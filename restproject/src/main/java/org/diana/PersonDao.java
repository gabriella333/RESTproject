package org.diana;

import java.util.List;

import javax.ejb.Local;

import org.jboss.tools.examples.model.Loan;
import org.jboss.tools.examples.model.Person;

@Local
public interface PersonDao {

	void createPerson(Person person);

	void removePerson(Person person);

	void updatePerson(Person person);

	List<Person> getAll();

	Person findPersonById(int id);

	List<Person> findPersonByName(String name);

	List<Loan> getAllLoans(Person person);

}
