package com.mm.database.dbmmm.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mm.database.dbmmm.jdbc.PersonJdbcDao;

@Component
public class InitCommandLine implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDao dao;
	
	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}", dao.findAll());
	}
   
}
	