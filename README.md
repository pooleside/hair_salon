In PSQL:

CREATE DATABASE hair_salon;
CREATE DATABASE hair_salon_test WITH TEMPLATE hair_salon;

\c hair_salon;

CREATE TABLE clients (id serial PRIMARY KEY, description varchar);

ALTER TABLE clients ADD stylistId int;

CREATE TABLE stylists (id serial primary key, name varchar);
