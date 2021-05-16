# Construindo uma API Rest de consulta de cidades do Brasil do zero ate a producao
 Construindo uma API Rest de consulta de cidades do Brasil do zero ate a producaoo

API de cidades
Requisitos
•	Linux
•	Git
•	Java 8
•	Docker
•	Comunidade IntelliJ
•	Heroku CLI
Base de dados
Postgres
•	Postgres Docker Hub
docker run --name cities-db -d -p 5432: 5432 -e POSTGRES_USER = postgres_user_city -e POSTGRES_PASSWORD = super_password -e POSTGRES_DB = cidades postgres
Povoar
•	dados
cd  ~ / workspace / sql-paises-estados-cidades / PostgreSQL

docker run -it --rm --net = host -v $ PWD : / tmp postgres / bin / bash

psql -h localhost -U postgres_user_city cities -f /tmp/pais.sql
psql -h localhost -U postgres_user_city cities -f /tmp/estado.sql
psql -h localhost -U postgres_user_city cities -f /tmp/cidade.sql

psql -h localhost -U postgres_user_city cities

CRIAR cubo de EXTENSÃO ;  
CRIAR EXTENSÃO distância da terra ;
•	Distância Postgres da Terra
•	earthdistance - 1.0--1.1.sql
•	OPERADOR <@>
•	postgrescheatsheet
•	tipo de dados geométrico
Acesso
docker exec -it cities-db / bin / bash

psql -U postgres_user_city cities
Distância da Terra de Consulta
Apontar
select ((select lat_lon from cidade where id = 4929) <@> (select lat_lon from cidade where id=5254)) as distance;
Cubo
select earth_distance(
    ll_to_earth(-21.95840072631836,-47.98820114135742), 
    ll_to_earth(-22.01740074157715,-47.88600158691406)
) as distance;
Spring Boot
•	https://start.spring.io/
•	Java 8
•	Projeto Gradle
•	Jarra
•	Spring Web
•	Spring Data JPA
•	Driver PostgreSQL
Spring Data
•	métodos jpa.query
Propriedades
•	propriedades do aplicativo apêndice
•	jdbc-database-connectio
Tipos
•	JsonTypes
•	Tipo de usuário
Heroku
•	DevCenter
