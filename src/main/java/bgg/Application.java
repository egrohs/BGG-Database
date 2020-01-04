package bgg;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;

@SpringBootApplication
//@ComponentScan("bgg")
//@EnableNeo4jRepositories(basePackages = "bgg")
public class Application {
	@Autowired
	private Environment env;

	@Bean
	public Configuration configuration() {
		String s = env.getProperty("neo4j-db");
		System.out.println(s);
		return new Configuration.Builder().uri(s).build();
	}

	@Bean
	public SessionFactory sessionFactory() {
		// with domain entity base package(s)
		return new SessionFactory(configuration(), "bgg");
	}

	@Bean
	public Neo4jTransactionManager transactionManager() {
		return new Neo4jTransactionManager(sessionFactory());
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
