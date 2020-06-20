package com.mm.database.dbmmm.helpers;

import java.util.Date;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mm.database.dbmmm.entity.Person;
import com.mm.database.dbmmm.jpa.PersonReposity;

@Component
public class InitJpaCommandLine implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonReposity personReposity;
	
	@Override
	public void run(String... args) throws Exception {
//		Thread.sleep(5000);
		logger.info("*********************findAll**************************");
		logger.info("User -> {}", personReposity.findAll());
		logger.info("*********************findById 1001**************************");
		logger.info("User -> {}", personReposity.findById(1001));
		logger.info("*********************insert 1004**************************");
		logger.info("Insert -> {}", personReposity.insert(new Person("Rodolfo Ramos", "San Salvador", new Date())));
		logger.info("*********************update 1003**************************");
		logger.info("Update -> {}", personReposity.update(new Person(1003, "Ricardo Miranda", "La Libertad", new Date())));
		logger.info("*********************deleteById 1002**************************");
		logger.info("Rows affected -> {}", personReposity.deleteById(1002));
		logger.info("*********************findByName 1001**************************");
		logger.info("All User -> {}", personReposity.findByName("Nelson Miranda"));
	}
   
}
	