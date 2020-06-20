package com.mm.database.dbmmm.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.mm.database.dbmmm.entity.Person;
import com.mm.database.dbmmm.jpa.PersonReposity;

class PersonControllerTest {

	@Mock
	PersonReposity personReposity;
	
	private Person person;
	
	@BeforeEach
	void init() {
		person = new Person(1002,"Natalia Miranda","San Salvador", new Date());
	}
	
	@Test
	void save() {
		PersonReposity personReposity = mock(PersonReposity.class);
		when(personReposity.insert(Mockito.any(Person.class))).thenReturn(person);
	
		assertEquals(person, personReposity.insert(person));
	}

}
