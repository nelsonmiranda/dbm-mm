package com.mm.database.dbmmm.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mm.database.dbmmm.entity.Person;
import com.mm.database.dbmmm.jpa.PersonReposity;

@Controller
public class PersonController {

	@Autowired
	PersonReposity personReposity;
	
	@RequestMapping(path = "/persons", method = RequestMethod.POST)
	public Person save(Person person) {
		return personReposity.insert(person);
	}
	
}
