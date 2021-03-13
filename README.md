# spring-reactive r2dbc application

This spring boot app demonstrates the usage of reactive database which supports non blocking reactive jdbc driver (r2dbc.io).

- R2DBC implements reactive streams and offers fully non blocking interfaces to interact with the database
- POJO Based Support
- Connection pooling support
- Native client for executing the queries

Used MySQL Database in this example. R2DBC Supported mysql driver

		<dependency>
			<groupId>dev.miku</groupId>
			<artifactId>r2dbc-mysql</artifactId>
			<scope>runtime</scope>
		</dependency>
