package com.javamsdt.frontdesk.model;

import java.util.List;

public class PersonList {

	private List<Person> persons;

	public PersonList() {
	}

	public PersonList(final List<Person> persons) {
		this.persons = persons;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(final List<Person> persons) {
		this.persons = persons;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PersonList [persons=");
		builder.append(persons);
		builder.append("]");
		return builder.toString();
	}

}
