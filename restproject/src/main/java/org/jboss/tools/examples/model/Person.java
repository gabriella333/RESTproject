package org.jboss.tools.examples.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
	private List<Loan> loans = new ArrayList<>();

	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

	public String toString() {
		return "Person: " + name;
	}

}