package com.example.testcontainersdemo.cusbo.tech;

import org.testcontainers.containers.PostgreSQLContainer;

/**
 * Creating a single database instance for all tests
 * See details:
 * https://www.baeldung.com/spring-boot-testcontainers-integration-test#common-configuration
 */
public class CusboPostgresqlContainer extends PostgreSQLContainer<CusboPostgresqlContainer> {
  private static final String IMAGE_VERSION = "postgres:12.8";
  private static CusboPostgresqlContainer container;

  private CusboPostgresqlContainer() {
    super(IMAGE_VERSION);
  }

  public static CusboPostgresqlContainer getInstance() {
    if (container == null) {
      container = new CusboPostgresqlContainer();
    }
    return container;
  }

  @Override
  public void start() {
    super.start();
    System.setProperty("DB_URL", container.getJdbcUrl());
    System.setProperty("DB_USERNAME", container.getUsername());
    System.setProperty("DB_PASSWORD", container.getPassword());
  }

  @Override
  public void stop() {
    //do nothing, JVM handles shut down
  }
}
