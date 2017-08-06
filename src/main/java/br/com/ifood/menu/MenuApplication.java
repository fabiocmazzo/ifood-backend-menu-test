package br.com.ifood.menu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

/**
 * MenuApplication main Class.
 * @author Fabio Covolo Mazzo
 */
@SpringBootApplication
@EnableNeo4jRepositories
@EntityScan("br.com.ifood.menu.model")
public class MenuApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenuApplication.class, args);
	}

}
