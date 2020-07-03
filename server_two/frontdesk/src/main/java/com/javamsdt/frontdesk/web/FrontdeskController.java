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

package com.javamsdt.frontdesk.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.javamsdt.frontdesk.model.Person;

@RestController
public class FrontdeskController {

	private static final String BASE_URL = "http://localhost:8081";
	private static final String GET_PERSONS_URL = BASE_URL + "/persons";
	private static final String GET_PERSON_BY_ID_URL = GET_PERSONS_URL + "/{id}";

	@RequestMapping("/")
	@ResponseBody
	public String helloWorld() {
		return "Hello FrontDesk";
	}

	@RequestMapping(value = "/persons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Person>> getPersons() {

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Person[]> personListResponse = restTemplate.getForEntity(GET_PERSONS_URL, Person[].class);
		List<Person> persons = Arrays.asList(personListResponse.getBody());

		return new ResponseEntity<>(persons, HttpStatus.OK);
	}

	@RequestMapping(value = "/persons/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> getPersonById(@PathVariable("id") final long id) {

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Person> personListResponse = restTemplate.getForEntity(GET_PERSON_BY_ID_URL, Person.class, id);

		return personListResponse;
	}



}
