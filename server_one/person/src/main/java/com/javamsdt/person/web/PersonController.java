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

package com.javamsdt.person.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javamsdt.person.domain.Person;
import com.javamsdt.person.service.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Person> persons() {

		List<Person> persons = personService.getPersons();
		return persons;
	}

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Person> getPersonById(@PathVariable("id") final long id) {
		Person person = personService.getPersonById(id);
		if (person.getPersonId() != 0) {
			return ResponseEntity.status(HttpStatus.OK).body(person);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(person);

		}
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> addPerson(@RequestBody final Person person) {
		personService.addPerson(person);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> updatePerson(@RequestBody final Person person) {
		personService.updatePerson(person);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletePerson(@PathVariable("id") final long id) {
		personService.removePerson(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
