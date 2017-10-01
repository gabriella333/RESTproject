package org.jboss.tools.examples.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	// @ManyToOne(cascade = CascadeType.PERSIST)
	// @JoinColumn(name = "person")
	// private Person person;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "media")
	private Media media;

	private Date date;
	private boolean reminder;
	private boolean bill;

	public Loan() {
	}

	public Loan(Person person, Media media) {
		// this.person = person;
		this.media = media;
		this.date = generateReturnDate();
		this.reminder = false;
		this.bill = false;
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public void renewLoan() {
		date = generateReturnDate();
	}

	private Date generateReturnDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 30);
		return cal.getTime();
	}

	public String hasBeenReminded() {
		if (reminder)
			return "no";
		return "yes";
	}

	public String hasBeenBilled() {
		if (bill)
			return "no";
		return "yes";
	}

	// public String toString() {
	// return "Loan: " + person.getName() + " has lended book " + media.getTitle() +
	// " by " + media.getAuthor();
	// }

}