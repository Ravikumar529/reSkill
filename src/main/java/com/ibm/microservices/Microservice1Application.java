package com.ibm.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
@EnableHystrix
@EnableCircuitBreaker
public class Microservice1Application {

	
	public static void main(String[] args) {
		SpringApplication.run(Microservice1Application.class, args);
	}
	
	@Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

	
	/*
	 * @Bean public HibernateJpaSessionFactoryBean
	 * sessionFactory(EntityManagerFactory emf) { HibernateJpaSessionFactoryBean
	 * factory = new HibernateJpaSessionFactoryBean();
	 * factory.setEntityManagerFactory(emf); return factory; }
	 */
	
	/*@PostConstruct
	private void initDb() {
	    String sqlStatements[] = {
	      "drop table CURRENCYCONVERTER if exists",
	      "create table CURRENCYCONVERTER(id serial,countrycode number,countryname varchar(255),currency varchar(255),conversionfactor number)",
	      "insert into CURRENCYCONVERTER(countrycode, countryname,currency,conversionfactor) values('91','India','INR','1.0')",
	      "insert into CURRENCYCONVERTER(countrycode, countryname,currency,conversionfactor) values('1684','America','USD','71.8')",
	      "insert into CURRENCYCONVERTER(countrycode, countryname,currency,conversionfactor) values('33','France','EURO','79.1')",
	      "insert into CURRENCYCONVERTER(countrycode, countryname,currency,conversionfactor) values('81','Japan','YEN','0.6')",
	      "insert into CURRENCYCONVERTER(countrycode, countryname,currency,conversionfactor) values('60','Malaysia','MYR','17.4')",
	      "insert into CURRENCYCONVERTER(countrycode, countryname,currency,conversionfactor) values('971','United Arab Emirates','AED','19.6')",
	      "insert into CURRENCYCONVERTER(countrycode, countryname,currency,conversionfactor) values('41','Switzerland','CHF','74.5')"
	    };
	 
	    Arrays.asList(sqlStatements).forEach(sql -> {
	        jdbcTemplate.execute(sql);
	    });*/

//}
}
