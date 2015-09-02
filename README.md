
# _Hair Salon_

##### _Create an app for a hair salon._

#### By _Leslie Poole_

## Description

The app user is able to add a list of the stylists, and for each stylist, add clients who see that stylist. The stylists work independently, so each client only belongs to a single stylist.  

## Setup

* Clone or fork from github
* Adjust settings in DB.java to work with your db setup
* Create a database hair_salon
* Run on gradle or on a server
* Open in your browser!

## Create Database
In PSQL:
CREATE DATABASE hair_salon;
CREATE DATABASE hair_salon_test WITH TEMPLATE hair_salon;

\c hair_salon;

CREATE TABLE clients (id serial PRIMARY KEY, description varchar);

ALTER TABLE clients ADD stylistId int;

CREATE TABLE stylists (id serial primary key, name varchar);


## Technologies Used

Java, Velocity Templating, Postgres Database, HTML and CSS



### Legal

Copyright (c) 2015 _Leslie Poole_

This software is licensed under the MIT license.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
