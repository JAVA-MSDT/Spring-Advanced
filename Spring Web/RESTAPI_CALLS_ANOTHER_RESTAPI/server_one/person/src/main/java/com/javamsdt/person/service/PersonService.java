/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.javamsdt.person.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.javamsdt.person.domain.Person;

@Component
public class PersonService {

	private static final Logger LOGGER = LogManager.getLogger();
	private List<Person> updatablePersonList = new ArrayList<>();


	public List<Person> getUpdatablePersonList() {
		return updatablePersonList;
	}

	public void setUpdatablePersonList(final List<Person> updatablePersonList) {
		this.updatablePersonList = updatablePersonList;
	}

	public List<Person> getPersons() {
		return Arrays.asList(
				new Person(1, "Ahmed", "Samy", "serenity", "serenity@email.com",
						"http://dummyimage.com/167x232.png/dddddd/000000"),
				new Person(2, "PersonTwo", "Second", "PersonTwo", "PersonTwo@email.com",
						"http://dummyimage.com/167x232.png/dddddd/000000"),
				new Person(3, "PersonThree", "Third", "PersonThree", "PersonThree@email.com",
						"http://dummyimage.com/167x232.png/dddddd/000000"),
				new Person(4, "PersonFour", "Fourht", "PersonFour", "PersonFour@email.com",
						"http://dummyimage.com/167x232.png/dddddd/000000"),
				new Person(5, "PersonFive", "Fifth", "PersonFive", "PersonFive@email.com",
						"http://dummyimage.com/167x232.png/dddddd/000000"),
				new Person(6, "PersonSix", "Siexth", "PersonSix", "PersonSix@email.com",
						"http://dummyimage.com/167x232.png/dddddd/000000"));
	}

	public Person getPersonById(final long id) {
		LOGGER.info("Requested Person Id: " + id);

		try {
			return getPersons().get((int) id - 1);
		} catch (Exception e) {
			LOGGER.error("Requested Person Id: " + id, e);
			return new Person();
		}
	}

	public void addPerson(final Person Person) {

		LOGGER.info("#1 - Created Person Began: " + Person);
		updatablePersonList.addAll(getPersons());
		updatablePersonList.add(Person);
		LOGGER.info("#2 - Created Person Done Successfully: " + Person);
	}

	public void updatePerson(final Person Person) {

		LOGGER.info("#1 - Update Person Began: " + Person);
		updatablePersonList.addAll(getPersons());
		Person originalPerson = updatablePersonList.get((int) (Person.getPersonId() - 1));

		LOGGER.info("#2 - Update Person [Finding the original Person Before Update]: " + originalPerson);
		updatablePersonList.remove(originalPerson);

		LOGGER.info("#3 - Update Person [removing the original Person from the list]: ");
		updatablePersonList.add(Person);

		LOGGER.info("#4 - Update Person Done Successfully: " + Person);
	}

	public void removePerson(final long id) throws IndexOutOfBoundsException {
		LOGGER.info("#1 - Remove Person By Id Began: " + id);
		updatablePersonList.addAll(getPersons());

		try {
			LOGGER.info("#2 - Remove Person By Id [Finding the original Person Before Update]: ");
			Person originalPerson = updatablePersonList.get((int) id - 1);
			updatablePersonList.remove(originalPerson);
			LOGGER.info("#3 - Remove Person By Id Done Successfully: " + id);
		} catch (IndexOutOfBoundsException e) {
			LOGGER.error("## Remove Person By Id [IndexOutOfBoundsException]: " + id, e);
			throw new IndexOutOfBoundsException();
		}

	}

}
