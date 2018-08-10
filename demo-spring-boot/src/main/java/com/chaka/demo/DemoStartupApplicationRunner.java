package com.chaka.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoStartupApplicationRunner implements ApplicationRunner {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("-------------------------------");
		log.info("Your application started with option names ");
		log.info("-------------------------------\n ");
		args.getOptionNames().forEach(x -> {
			log.info("{} : {}", x, args.getOptionValues(x));
		});
	}
}