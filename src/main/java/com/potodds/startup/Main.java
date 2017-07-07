package com.potodds.startup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.potodds.db.MySQLDB;

public class Main {
	public Main() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		MySQLDB mysqldb = (MySQLDB)context.getBean("mySQLdb");
		mysqldb.run();
	}

	public static void main(String[] args) {
		new Main();
	}
}
