package edu.fpezzati.jsfci;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jboss.weld.junit5.EnableWeld;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import liquibase.Contexts;
import liquibase.Liquibase;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

@EnableWeld
@Testcontainers
public class KindControllerIT {

	@Container
	private static PostgreSQLContainer<?> database = new PostgreSQLContainer<>(DockerImageName.parse("postgres:10"));
	private static EntityManagerFactory emf;

	@Inject
	private KindController sut;


	@BeforeAll
	public static void initOnce() throws IOException, SQLException, LiquibaseException {
		database.waitingFor(Wait.forLogMessage(".*database system is ready*\\s", 1));
		database.start();

		System.out.println("database jdbc url: " + database.getJdbcUrl() + ", user: " + database.getUsername() + ", password: " + database.getPassword());

		Liquibase liquibase = new Liquibase("./database/testdbchangelog.xml", new ClassLoaderResourceAccessor(), DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(DriverManager.getConnection(database.getJdbcUrl(), database.getUsername(), database.getPassword()))));
		liquibase.update(new Contexts());
		liquibase.close();

		Map<String,String> entityManagerFactoryProperties = new HashMap<>();
		entityManagerFactoryProperties.put("javax.persistence.jdbc.url", database.getJdbcUrl());
		entityManagerFactoryProperties.put("javax.persistence.jdbc.user", database.getUsername());
		entityManagerFactoryProperties.put("javax.persistence.jdbc.password", database.getPassword());
		entityManagerFactoryProperties.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
		emf = Persistence.createEntityManagerFactory("jscihw", entityManagerFactoryProperties);
	}

	@Test
	public void kindControllerCanFetchData() {
		EntityManager em = emf.createEntityManager();
		em.createNativeQuery("select table_name from information_schema.tables").getResultList();
		sut.getKinds();
	}
}
