package bgg.BGGDatabase;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;

@SpringBootApplication
//@ComponentScan("com.example.demo")
//@EnableNeo4jRepositories(basePackages = "com.example.demo")
public class BggDatabaseApplication {
	@Autowired
	private Environment env;

	@Bean
	public Configuration configuration() {
		return new Configuration.Builder().uri(env.getProperty("neo4j.db")).build();
	}

	@Bean
	public SessionFactory sessionFactory() {
		// with domain entity base package(s)
		return new SessionFactory(configuration(), "com.example.demo");
	}

	@Bean
	public Neo4jTransactionManager transactionManager() {
		return new Neo4jTransactionManager(sessionFactory());
	}

	public static void main(String[] args) {
		SpringApplication.run(BggDatabaseApplication.class, args);
	}

}
