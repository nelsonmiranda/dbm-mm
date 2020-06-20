package com.mm.database.dbmmm.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.mm.database.dbmmm.entity.Person;
import com.mm.database.dbmmm.entity.mapper.PersonRowMapper;

@Repository
@Transactional
public class PersonReposity {

	@PersistenceContext
	EntityManager entityManager;

	public List<Person> findAll() {
		TypedQuery<Person> nameQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
		return nameQuery.getResultList();
	}

	public List<Person> findByName(String name) {
		return entityManager.createQuery("select p from Person p where p.name = :name", Person.class)
				.setParameter("name", name)
				.getResultList(); 
	}

	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}

	public Person insert(Person person) {
		return entityManager.merge(person);
	}

	public Person update(Person person) {
		return entityManager.merge(person);
	}

	public int deleteById(int id) {
		Person person = findById(id);
		if (person != null) {
			entityManager.remove(person);
			return 1;
		}
		return 0;
	}
}
