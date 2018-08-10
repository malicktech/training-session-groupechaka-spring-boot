package com.chaka.demo;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Interface dans spring boot qui permet d'Exécuter du code au démarrage de
 * l'application spring boot
 * 
 * @author citizendiop
 */
@Component
public class DemoStartupCommandLineRunner implements CommandLineRunner {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void run(String... args) throws Exception {
		log.info("-------------------------------");
		log.info("Application started with command-line arguments: {}", Arrays.toString(args));
		log.info("-------------------------------\n ");
	}

}
