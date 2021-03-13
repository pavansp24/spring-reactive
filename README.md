# spring-reactive r2dbc application

This spring boot app demonstrates the usage of reactive database which supports non blocking reactive jdbc driver (<a href="https://r2dbc.io">r2dbc.io</a>).

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
		
		
Spring Configs:

spring.r2dbc.protocol=mysql

spring.r2dbc.url=r2dbc:mysql://localhost

spring.r2dbc.user=root

spring.r2dbc.pswd=1008

spring.r2dbc.schema=r2dbcl

spring.r2dbc.pool.max=15

spring.r2dbc.pool.initial=10

spring.r2dbc.host=localhost
