package com.tptp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class TptpApplication {

	/**
	 * main함수
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(TptpApplication.class, args);
	}

}
