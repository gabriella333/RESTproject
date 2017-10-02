package org.diana;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.tools.examples.model.Loan;
import org.jboss.tools.examples.model.Person;

@Stateless
public class PersonDaoImp implements PersonDao {

	@Inject
	private EntityManager em;

	@Override
	public void createPerson(Person person) {
		em.persist(person);
	}

	@Override
	public void removePerson(Person person) {

		if (!em.contains(person)) {
			System.out.println("There is no such a person!");
		} else
			em.remove(person);

	}

	@Override
	public List<Person> findPersonByName(String name) {

		return em.createQuery("from Person p where p.firstname like: firstname", Person.class)
				.setParameter("firstname", name).getResultList();
	}

	@Override
	public void updatePerson(Person person) {

		if (!em.contains(person)) {
			System.out.println("There is no such a person!");
		}
		em.merge(person);

	}

	@Override
	public List<Person> getAll() {
		return em.createQuery("from Person p", Person.class).getResultList();
	}

	@Override
	public Person findPersonById(int id) {
		return em.find(Person.class, id);

	}

	@Override
	public List<Loan> getAllLoans(Person person) {
		return em.find(Person.class, person).getLoans();
	}

}
