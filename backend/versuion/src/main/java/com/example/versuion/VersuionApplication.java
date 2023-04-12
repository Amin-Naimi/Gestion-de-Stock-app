package com.example.versuion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
/* Spring doit activer l'auditing  ou
*  on peut crée une classe de configuration
* pour obtenir la date de création et de modifiction de l'entity
* */
public class VersuionApplication {

	public static void main(String[] args) {
		SpringApplication.run(VersuionApplication.class, args);
	}

}
