# springboot-tc-example

This project is an example of using testcontainers in tests.

### Build the project

Please try to build this project using the following command:
```shell
./mvnw clean package
```

!!! But, the current project is not able to build on MacBook Pro with M1 Apple Silicon chip.  
The build fails with the following error:

```text
...
2022-10-26 14:23:55.925  INFO 42990 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
2022-10-26 14:23:55.970  INFO 42990 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2022-10-26 14:23:55.989  INFO 42990 --- [           main] o.t.utility.ImageNameSubstitutor         : Image name substitution will be performed by: DefaultImageNameSubstitutor (composite of 'ConfigurationFileImageNameSubstitutor' and 'PrefixingImageNameSubstitutor')
2022-10-26 14:23:56.002  INFO 42990 --- [           main] .t.d.DockerMachineClientProviderStrategy : docker-machine executable was not found on PATH ([/opt/homebrew/bin, /usr/local/bin, /usr/bin, /bin, /usr/sbin, /sbin, /opt/homebrew/Cellar/maven/3.8.6/libexec/bin])
2022-10-26 14:23:56.002 ERROR 42990 --- [           main] o.t.d.DockerClientProviderStrategy       : Could not find a valid Docker environment. Please check configuration. Attempted configurations were:
2022-10-26 14:23:56.002 ERROR 42990 --- [           main] o.t.d.DockerClientProviderStrategy       :     UnixSocketClientProviderStrategy: failed with exception InvalidConfigurationException (Could not find unix domain socket). Root cause NoSuchFileException (/var/run/docker.sock)
2022-10-26 14:23:56.002 ERROR 42990 --- [           main] o.t.d.DockerClientProviderStrategy       : As no valid configuration was found, execution cannot continue
2022-10-26 14:23:57.013 ERROR 42990 --- [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Exception during pool initialization.

java.lang.IllegalStateException: Could not find a valid Docker environment. Please see logs and check configuration
        at org.testcontainers.dockerclient.DockerClientProviderStrategy.lambda$getFirstValidStrategy$6(DockerClientProviderStrategy.java:257) ~[testcontainers-1.17.3.jar:na]
        at java.base/java.util.Optional.orElseThrow(Optional.java:403) ~[na:na]
        at org.testcontainers.dockerclient.DockerClientProviderStrategy.getFirstValidStrategy(DockerClientProviderStrategy.java:247) ~[testcontainers-1.17.3.jar:na]
        at org.testcontainers.DockerClientFactory.getOrInitializeStrategy(DockerClientFactory.java:135) ~[testcontainers-1.17.3.jar:na]
        at org.testcontainers.DockerClientFactory.client(DockerClientFactory.java:171) ~[testcontainers-1.17.3.jar:na]
        at org.testcontainers.DockerClientFactory$1.getDockerClient(DockerClientFactory.java:89) ~[testcontainers-1.17.3.jar:na]
        at com.github.dockerjava.api.DockerClientDelegate.authConfig(DockerClientDelegate.java:108) ~[docker-java-api-3.2.13.jar:na]
        at org.testcontainers.containers.GenericContainer.start(GenericContainer.java:321) ~[testcontainers-1.17.3.jar:na]
        at org.testcontainers.jdbc.ContainerDatabaseDriver.connect(ContainerDatabaseDriver.java:124) ~[jdbc-1.17.3.jar:na]
        at com.zaxxer.hikari.util.DriverDataSource.getConnection(DriverDataSource.java:121) ~[HikariCP-4.0.3.jar:na]
        at com.zaxxer.hikari.pool.PoolBase.newConnection(PoolBase.java:364) ~[HikariCP-4.0.3.jar:na]
        at com.zaxxer.hikari.pool.PoolBase.newPoolEntry(PoolBase.java:206) ~[HikariCP-4.0.3.jar:na]
        at com.zaxxer.hikari.pool.HikariPool.createPoolEntry(HikariPool.java:476) ~[HikariCP-4.0.3.jar:na]
        at com.zaxxer.hikari.pool.HikariPool.checkFailFast(HikariPool.java:561) ~[HikariCP-4.0.3.jar:na]
        at com.zaxxer.hikari.pool.HikariPool.<init>(HikariPool.java:115) ~[HikariCP-4.0.3.jar:na]
        at com.zaxxer.hikari.HikariDataSource.getConnection(HikariDataSource.java:112) ~[HikariCP-4.0.3.jar:na]
        at org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl.getConnection(DatasourceConnectionProviderImpl.java:122) ~[hibernate-core-5.6.12.Final.jar:5.6.12.Final]
        at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess.obtainConnection(JdbcEnvironmentInitiator.java:181) ~[hibernate-core-5.6.12.Final.jar:5.6.12.Final]
...
```

### Local run

Please change the DB properties in `src/main/resources/application.properties` before run.
