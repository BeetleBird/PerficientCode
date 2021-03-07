BEGIN TRANSACTION;
DROP TABLE IF EXISTS skill;
DROP TABLE IF EXISTS field;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS address;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";


CREATE TABLE address (
  address_uid UUID DEFAULT uuid_generate_v4 (),
  street varchar(40) NOT NULL,
  city varchar(40) NOT NULL,
  region varchar(40) NOT NULL,
  postal varchar(40) NOT NULL,
  country varchar(40) NOT NULL,
  "stamp" timestamp not null default CURRENT_TIMESTAMP, 
  PRIMARY KEY (address_uid)
);


CREATE TABLE employees (
  employees_uid uuid DEFAULT uuid_generate_v4 (),
  first_name VARCHAR(20),
  last_name VARCHAR(30),
  address_uid UUID,
  company_email VARCHAR(20),
  birth_date VARCHAR(30),
  hire_date VARCHAR(30),
  role VARCHAR(20),
   "stamp" timestamp not null default CURRENT_TIMESTAMP, 
  PRIMARY KEY (employees_uid),
  CONSTRAINT address_fk FOREIGN KEY (address_uid) REFERENCES address(address_uid)
);

CREATE TABLE field (
	field_uid UUID DEFAULT uuid_generate_v4 (),
	name varchar(40),
	type varchar(40),
	 "stamp" timestamp not null default CURRENT_TIMESTAMP, 
	PRIMARY KEY (field_uid)
);

CREATE TABLE skill (
        skill_uid UUID,
        field_uid UUID,
        experience integer,
         "stamp" timestamp not null default CURRENT_TIMESTAMP, 
        PRIMARY KEY (skill_uid, field_uid),
        CONSTRAINT fk_skill FOREIGN KEY (skill_uid) REFERENCES employees(employees_uid),
        CONSTRAINT fk_field FOREIGN KEY (field_uid) REFERENCES field(field_uid)
);


INSERT INTO address (street, city, region, postal, country)
VALUES ('bla bla St', 'SuperCity', 'MI', '48183', 'USA');
INSERT INTO employees(first_name, last_name, address_uid, company_email, birth_date, hire_date, role)
VALUES ('Mac', 'Keppard', (SELECT address_uid from address), '123@gmail.com', '1953-07-15', '2001-04-01', 'Technical Consultant');
INSERT INTO field (name, type) VALUES ('Java', 'Technical Consultant');
INSERT INTO skill (skill_uid, field_uid, experience) 
VALUES ((SELECT employees_uid from employees), ( SELECT field_uid from field), 30);

COMMIT TRANSACTION;

BEGIN TRANSACTION;

INSERT INTO address (street, city, region, postal, country)
VALUES ('bla la St', 'SuperDuperCity', 'MI', '48183', 'USA');
INSERT INTO employees(first_name, last_name, address_uid, company_email, birth_date, hire_date, role)
VALUES ('Lew', 'Kep', (SELECT address_uid from address ORDER BY "stamp" DESC LIMIT 1), 'abc@gmail.com', '1989-07-30', '2003-06-03', 'Chief');
INSERT INTO field (name, type) VALUES ('Java', 'Chief');
INSERT INTO skill (skill_uid, field_uid, experience) 
VALUES ((SELECT employees_uid from employees ORDER BY "stamp" DESC LIMIT 1), ( SELECT field_uid from field ORDER BY "stamp" DESC LIMIT 1), 50);

COMMIT TRANSACTION;

BEGIN TRANSACTION;

INSERT INTO address (street, city, region, postal, country)
VALUES ('Ehh St', 'City City', 'OH', '90210', 'USA');
INSERT INTO employees(first_name, last_name, address_uid, company_email, birth_date, hire_date, role)
VALUES ('Mac', 'Keppard', (SELECT address_uid from address  ORDER BY "stamp" DESC LIMIT 1), '123@gmail.com', '1953-07-15', '2001-04-01', 'Technical Consultant');
INSERT INTO field (name, type) VALUES ('Java', 'Technical Consultant');
INSERT INTO skill (skill_uid, field_uid, experience) 
VALUES ((SELECT employees_uid from employees ORDER BY "stamp" DESC LIMIT 1), ( SELECT field_uid from field ORDER BY "stamp" DESC LIMIT 1), 2);

COMMIT TRANSACTION;

BEGIN TRANSACTION;

INSERT INTO address (street, city, region, postal, country)
VALUES ('bla bla St', 'SuperCity', 'MI', '48183', 'USA');
INSERT INTO employees(first_name, last_name, address_uid, company_email, birth_date, hire_date, role)
VALUES ('Lew', 'Kep', (SELECT address_uid from address ORDER BY "stamp" DESC LIMIT 1), 'abc@gmail.com', '1989-07-30', '2003-06-03', 'Chief');
INSERT INTO field (name, type) VALUES ('Java', 'Chief');
INSERT INTO skill (skill_uid, field_uid, experience) 
VALUES ((SELECT employees_uid from employees ORDER BY "stamp" DESC LIMIT 1), ( SELECT field_uid from field ORDER BY "stamp" DESC LIMIT 1), 50);

COMMIT TRANSACTION;

BEGIN TRANSACTION;

INSERT INTO address (street, city, region, postal, country)
VALUES ('bla la St', 'SuperDuperCity', 'MI', '48183', 'USA');
INSERT INTO employees(first_name, last_name, address_uid, company_email, birth_date, hire_date, role)
VALUES ('Fred', 'Bauer', (SELECT address_uid from address  ORDER BY "stamp" DESC LIMIT 1), '4352@gmail.com', '1980-07-14', '1998-09-01', 'Technical Consultant');
INSERT INTO field (name, type) VALUES ('Java', 'Technical Consultant');
INSERT INTO skill (skill_uid, field_uid, experience) 
VALUES ((SELECT employees_uid from employees ORDER BY "stamp" DESC LIMIT 1), ( SELECT field_uid from field ORDER BY "stamp" DESC LIMIT 1), 4);

COMMIT TRANSACTION;

BEGIN TRANSACTION;

INSERT INTO address (street, city, region, postal, country)
VALUES ('Owow St', 'That City', 'MI', '48183', 'USA');
INSERT INTO employees(first_name, last_name, address_uid, company_email, birth_date, hire_date, role)
VALUES ('Delora', 'City', (SELECT address_uid from address ORDER BY "stamp" DESC LIMIT 1), '43452@gmail.com', '1976-07-04', '2009-03-01', 'Technical Consultant');
INSERT INTO field (name, type) VALUES ('Java', 'Technical Consultant');
INSERT INTO skill (skill_uid, field_uid, experience) 
VALUES ((SELECT employees_uid from employees ORDER BY "stamp" DESC LIMIT 1), ( SELECT field_uid from field ORDER BY "stamp" DESC LIMIT 1), 1);

COMMIT TRANSACTION;


BEGIN TRANSACTION;
INSERT INTO address (street, city, region, postal, country)
VALUES ('Haha St', 'Bat City', 'OH', '90210', 'USA');
INSERT INTO employees(first_name, last_name, address_uid, company_email, birth_date, hire_date, role)
VALUES ('Charlie', 'Kelly', (SELECT address_uid from address  ORDER BY "stamp" DESC LIMIT 1), '5352@gmail.com', '1972-06-04', '1998-09-01', 'Technical Consultant');
INSERT INTO field (name, type) VALUES ('Java', 'Technical Consultant');
INSERT INTO skill (skill_uid, field_uid, experience) 
VALUES ((SELECT employees_uid from employees ORDER BY "stamp" DESC LIMIT 1), ( SELECT field_uid from field ORDER BY "stamp" DESC LIMIT 1), 3);

COMMIT TRANSACTION;

BEGIN TRANSACTION;
INSERT INTO address (street, city, region, postal, country)
VALUES ('Gogo St', 'Rat City', 'MI', '48183', 'USA');
INSERT INTO employees(first_name, last_name, address_uid, company_email, birth_date, hire_date, role)
VALUES ('Mary Lou', 'Who', (SELECT address_uid from address ORDER BY "stamp" DESC LIMIT 1), '6352@gmail.com', '1983-04-08', '2012-04-01', 'Chief');
INSERT INTO field (name, type) VALUES ('Java', 'Chief');
INSERT INTO skill (skill_uid, field_uid, experience) 
VALUES ((SELECT employees_uid from employees ORDER BY "stamp" DESC LIMIT 1), ( SELECT field_uid from field ORDER BY "stamp" DESC LIMIT 1), 12);

COMMIT TRANSACTION;

BEGIN TRANSACTION;
INSERT INTO address (street, city, region, postal, country)
VALUES ('Street St', 'Hat City', 'OH', '90210', 'USA');
INSERT INTO employees(first_name, last_name, address_uid, company_email, birth_date, hire_date, role)
VALUES ('Jammie', 'How', (SELECT address_uid from address  ORDER BY "stamp" DESC LIMIT 1), '7352@gmail.com', '1987-11-11', '2013-02-16', 'Technical Consultant');
INSERT INTO field (name, type) VALUES ('Java', 'Technical Consultant');
INSERT INTO skill (skill_uid, field_uid, experience) 
VALUES ((SELECT employees_uid from employees ORDER BY "stamp" DESC LIMIT 1), ( SELECT field_uid from field ORDER BY "stamp" DESC LIMIT 1), 25);

COMMIT TRANSACTION;

BEGIN TRANSACTION;

INSERT INTO address (street, city, region, postal, country)
VALUES ('Ilu St', 'Move City', 'NY', '13166', 'USA');
INSERT INTO employees(first_name, last_name, address_uid, company_email, birth_date, hire_date, role)
VALUES ('Dennis', 'Reynolds', (SELECT address_uid from address ORDER BY "stamp" DESC LIMIT 1), '4359@gmail.com', '1983-04-04', '2013-07-01', 'Director');
INSERT INTO field (name, type) VALUES ('Java', 'Director');
INSERT INTO skill (skill_uid, field_uid, experience) 
VALUES ((SELECT employees_uid from employees ORDER BY "stamp" DESC LIMIT 1), ( SELECT field_uid from field ORDER BY "stamp" DESC LIMIT 1), 6);

COMMIT TRANSACTION;

BEGIN TRANSACTION;

INSERT INTO address (street, city, region, postal, country)
VALUES ('Wow St', 'Cow City', 'MI', '48183', 'USA');
INSERT INTO employees(first_name, last_name, address_uid, company_email, birth_date, hire_date, role)
VALUES ('Meg', 'Buskirk', (SELECT address_uid from address  ORDER BY "stamp" DESC LIMIT 1), '4382@gmail.com', '1987-05-13', '2007-11-01', 'Technical Consultant');
INSERT INTO field (name, type) VALUES ('Java', 'Technical Consultant');
INSERT INTO skill (skill_uid, field_uid, experience) 
VALUES ((SELECT employees_uid from employees ORDER BY "stamp" DESC LIMIT 1), ( SELECT field_uid from field ORDER BY "stamp" DESC LIMIT 1), 5);

COMMIT TRANSACTION;

BEGIN TRANSACTION;

INSERT INTO address (street, city, region, postal, country)
VALUES ('Dada St', 'Duck City', 'MI', '48183', 'USA');
INSERT INTO employees(first_name, last_name, address_uid, company_email, birth_date, hire_date, role)
VALUES ('Matthew', 'Duford', (SELECT address_uid from address ORDER BY "stamp" DESC LIMIT 1), '8352@gmail.com', '1968-04-05', '2016-02-16', 'Director');
INSERT INTO field (name, type) VALUES ('Java', 'Director');
INSERT INTO skill (skill_uid, field_uid, experience) 
VALUES ((SELECT employees_uid from employees ORDER BY "stamp" DESC LIMIT 1), ( SELECT field_uid from field ORDER BY "stamp" DESC LIMIT 1), 7);

COMMIT TRANSACTION;

BEGIN TRANSACTION;

INSERT INTO address (street, city, region, postal, country)
VALUES ('Love St', 'Zebra City', 'CA', '75419', 'USA');
INSERT INTO employees(first_name, last_name, address_uid, company_email, birth_date, hire_date, role)
VALUES ('Frank', 'Reynolds', (SELECT address_uid from address  ORDER BY "stamp" DESC LIMIT 1), '9352@gmail.com', '1981-09-25', '2003-05-01', 'Chief');
INSERT INTO field (name, type) VALUES ('Java', 'Chief');
INSERT INTO skill (skill_uid, field_uid, experience) 
VALUES ((SELECT employees_uid from employees ORDER BY "stamp" DESC LIMIT 1), ( SELECT field_uid from field ORDER BY "stamp" DESC LIMIT 1), 8);

COMMIT TRANSACTION;

BEGIN TRANSACTION;

INSERT INTO address (street, city, region, postal, country)
VALUES ('Super St', 'Doge City', 'MI', '48183', 'USA');
INSERT INTO employees(first_name, last_name, address_uid, company_email, birth_date, hire_date, role)
VALUES ('Gabreila', 'Christie', (SELECT address_uid from address ORDER BY "stamp" DESC LIMIT 1), '4952@gmail.com', '1980-03-17', '1999-08-01', 'Project Manager');
INSERT INTO field (name, type) VALUES ('Java', 'Project Manager');
INSERT INTO skill (skill_uid, field_uid, experience) 
VALUES ((SELECT employees_uid from employees ORDER BY "stamp" DESC LIMIT 1), ( SELECT field_uid from field ORDER BY "stamp" DESC LIMIT 1), 9);

COMMIT TRANSACTION;



SELECT employees.employees_uid, employees.first_name, employees.address_uid, employees.last_name, employees.company_email, employees.birth_date, employees.hire_date, employees.role,
address.address_uid, address.street, address.city, address.region, address.postal, address.country,
skill.skill_uid, skill.field_uid, skill.experience, field.field_uid, field.name, field.type 
FROM employees
LEFT JOIN address ON employees.address_uid = address.address_uid
LEFT JOIN skill ON employees_uid = skill.skill_uid
LEFT JOIN field ON skill.field_uid = field.field_uid
WHERE employees.employees_uid = 'e7e2e7f9-c9a1-4626-bd4e-b365c00bf453';