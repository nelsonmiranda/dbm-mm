package com.mm.database.dbmmm.helpers;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.mm.database.dbmmm.entity.Person;
import com.mm.database.dbmmm.jdbc.PersonJdbcDao;

//@Component
public class InitJdbcCommandLine implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDao dao;
	
	@Override
	public void run(String... args) throws Exception {
		Thread.sleep(5000);
		logger.info("*********************findAll**************************");
		logger.info("User -> {}", dao.findAll());
		logger.info("*********************findById 1001**************************");
		logger.info("User -> {}", dao.findById(1001));
		logger.info("*********************findByName 1001**************************");
		logger.info("All User -> {}", dao.findByName("Nelson Miranda"));
		logger.info("*********************deleteById 1002**************************");
		logger.info("Rows affected -> {}", dao.deleteById(1002));
		logger.info("*********************insert 1004**************************");
		logger.info("Rows affected -> {}", dao.insert(new Person(1004, "Rodolfo Ramos", "San Salvador", new Date())));
		logger.info("*********************update 1003**************************");
		logger.info("Rows affected -> {}", dao.update(new Person(1003, "Ricardo Miranda", "La Libertad", new Date())));
	}
   
}
	