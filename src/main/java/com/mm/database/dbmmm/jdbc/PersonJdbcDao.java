package com.mm.database.dbmmm.jdbc;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mm.database.dbmmm.entity.Person;
import com.mm.database.dbmmm.entity.mapper.PersonRowMapper;

@Repository
public class PersonJdbcDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//select * from person
	public List<Person> findAll(){
		return jdbcTemplate.query("select * from person", 
				new PersonRowMapper());
	}
	
	//select * from person where id=?
	public Person findById(int id) {
		return jdbcTemplate.queryForObject("select * from person where id=?", 
				new Object[] {id}, new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	//select * from person where name=?
	public List<Person> findByName(String name){
		return jdbcTemplate.query("select * from person where name = ?",
				new Object[] {name},new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	//delete from person where id=?
	public int deleteById(int id) {
		return jdbcTemplate.update("delete from person where id=?", new Object[] {id});
	}
	
	public int insert(Person person) {
		return jdbcTemplate.update("insert into person(id,name,location,birthdate) "
				+ "values (?,?,?,?);", 
				new Object[] {person.getId(), person.getName(),
						person.getLocation(), new Timestamp(person.getBirthDate().getTime())});
	}
	
	public int update(Person person) {
		return jdbcTemplate.update("update person "
				+ "set name = ?, location=?, birthdate=? "
				+ "where id=?", 
				new Object[] {person.getName(), person.getLocation(),
						new Timestamp(person.getBirthDate().getTime()),
						person.getId()});
	}
	
}
