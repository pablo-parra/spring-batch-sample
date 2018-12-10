CREATE TABLE contact(
  id int AUTO_INCREMENT PRIMARY KEY,
  phone varchar(12) not null,
  email varchar(100) not null UNIQUE
);

CREATE TABLE address(
  id int AUTO_INCREMENT PRIMARY KEY,
  street varchar(250) not null,
  number varchar(5) not null,
  postal_code varchar(7) not null,
  city varchar(50) not null,
  country varchar(50) not null
);

CREATE TABLE personal_info(
  id int AUTO_INCREMENT PRIMARY KEY,
  firstname varchar(100) not null,
  lastname varchar(100) not null,
  birth_date DATE not null,
  address_id INT,
  contact_id INT,
  CONSTRAINT personal_info_FK_address FOREIGN KEY (address_id) REFERENCES address (id),
  CONSTRAINT personal_info_FK_contact FOREIGN KEY (contact_id) REFERENCES contact (id)
);

CREATE TABLE student(
  id int AUTO_INCREMENT PRIMARY KEY,
  person_id INT,
  degree varchar(200) not null,
  enabled boolean not null,
  CONSTRAINT student_FK_person FOREIGN KEY (person_id) REFERENCES personal_info (id)
);

CREATE TABLE enabled_student(
  id int AUTO_INCREMENT PRIMARY KEY,
  name varchar(200) not null,
  degree varchar(200) not null,
  email varchar(100) not null,
  phone varchar(12) not null,
  city varchar(50) not null
);

INSERT INTO contact (id, phone, email) VALUES(1,'637-3821','Tom_Riley7798@nimogy.biz');
INSERT INTO contact (id, phone, email) VALUES(2,'137-1585','Felicity_Holt4849@joiniaa.com');
INSERT INTO contact (id, phone, email) VALUES(3,'656-3146','Ron_Stanton2444@brety.org');
INSERT INTO contact (id, phone, email) VALUES(4,'485-3026','Alexander_Samuel9860@famism.biz');
INSERT INTO contact (id, phone, email) VALUES(5,'341-2110','Mason_Evans2185@grannar.com');
INSERT INTO contact (id, phone, email) VALUES(6,'258-4101','Caleb_May9014@vetan.org');
INSERT INTO contact (id, phone, email) VALUES(7,'768-7486','Josephine_Ballard9295@naiker.biz');
INSERT INTO contact (id, phone, email) VALUES(8,'430-2787','Katelyn_Smith5922@irrepsy.com');
INSERT INTO contact (id, phone, email) VALUES(9,'465-4361','Phoebe_Strong6188@nickia.com');
INSERT INTO contact (id, phone, email) VALUES(10,'216-0130','Noah_Dixon6884@womeona.net');
INSERT INTO contact (id, phone, email) VALUES(11,'643-8611','Dakota_Hall7026@gmail.com');
INSERT INTO contact (id, phone, email) VALUES(12,'608-4110','William_Matthews6884@grannar.com');
INSERT INTO contact (id, phone, email) VALUES(13,'864-6075','Tony_Cobb169@bulaffy.com');
INSERT INTO contact (id, phone, email) VALUES(14,'651-3417','Harry_Todd3006@acrit.org');
INSERT INTO contact (id, phone, email) VALUES(15,'682-4028','Hayden_Cox8055@cispeto.com');
  
INSERT INTO address (id, street,number,postal_code,city,country) VALUES(1,'Bury Drive',123, 4561,'Anaheim','Slovakia');
INSERT INTO address (id, street,number,postal_code,city,country) VALUES(2,'Linda Pass', 76, 1477,'Las Vegas','Cabo Verde');
INSERT INTO address (id, street,number,postal_code,city,country) VALUES(3,'Chicksand Drive', 45, 6580,'Columbus','Zambia');
INSERT INTO address (id, street,number,postal_code,city,country) VALUES(4,'Belmore Pass', 464,5328,'Las Vegas','Tonga');
INSERT INTO address (id, street,number,postal_code,city,country) VALUES(5,'Arbutus Crossroad', 22,2671,'Tokyo','Sao Tome and Principe');
INSERT INTO address (id, street,number,postal_code,city,country) VALUES(6,'King Hill', 68, 5011,'Worcester','Tanzania');
INSERT INTO address (id, street,number,postal_code,city,country) VALUES(7,'Bedford  Rue', 33,9150,'Wien','Latvia');
INSERT INTO address (id, street,number,postal_code,city,country) VALUES(8,'Apothecary Pass', 69, 1219,'Denver','Switzerland');
INSERT INTO address (id, street,number,postal_code,city,country) VALUES(9,'Blackpool Crossroad', 96, 56728,'Wien','Vietnam');
INSERT INTO address (id, street,number,postal_code,city,country) VALUES(10,'Meadow Road', 39,5053,'Chicago','Korea, North');
INSERT INTO address (id, street,number,postal_code,city,country) VALUES(11,'Aylward Way', 35,9872,'Venice','Jamaica');
INSERT INTO address (id, street,number,postal_code,city,country) VALUES(12,'Gate Tunnel', 50,1671,'Las Vegas','Mexico');
INSERT INTO address (id, street,number,postal_code,city,country) VALUES(13,'Blendon Rue', 27,4277,'London','Norway');
INSERT INTO address (id, street,number,postal_code,city,country) VALUES(14,'Cleveland Walk', 64,5909,'Worcester','Eritrea');
INSERT INTO address (id, street,number,postal_code,city,country) VALUES(15,'Tiptree   Walk', 32,4402,'Nashville','Samoa');
  
INSERT INTO personal_info (id, firstname, lastname, birth_date, address_id, contact_id) VALUES(1,'Tom','Riley', '1987-1-23', 1, 1);
INSERT INTO personal_info (id, firstname, lastname, birth_date, address_id, contact_id) VALUES(2,'Felicity','Holt','1953-7-6',2,2);
INSERT INTO personal_info (id, firstname, lastname, birth_date, address_id, contact_id) VALUES(3,'Ron','Stanton','1964-6-15',3,3);
INSERT INTO personal_info (id, firstname, lastname, birth_date, address_id, contact_id) VALUES(4,'Alexander','Samuel','1982-11-2',4,4);
INSERT INTO personal_info (id, firstname, lastname, birth_date, address_id, contact_id) VALUES(5,'Mason','Evans','1997-8-16',5,5);
INSERT INTO personal_info (id, firstname, lastname, birth_date, address_id, contact_id) VALUES(6,'Caleb','May','1975-12-23',6,6);
INSERT INTO personal_info (id, firstname, lastname, birth_date, address_id, contact_id) VALUES(7,'Josephine','Ballard','1999-9-15',7,7);
INSERT INTO personal_info (id, firstname, lastname, birth_date, address_id, contact_id) VALUES(8,'Katelyn','Smith','1947-12-19',8,8);
INSERT INTO personal_info (id, firstname, lastname, birth_date, address_id, contact_id) VALUES(9,'Phoebe','Strong','1981-7-18',9,9);
INSERT INTO personal_info (id, firstname, lastname, birth_date, address_id, contact_id) VALUES(10,'Noah','Dixon','1981-12-9',10,10);
INSERT INTO personal_info (id, firstname, lastname, birth_date, address_id, contact_id) VALUES(11,'Dakota','Hall','1981-7-5',11,11);
INSERT INTO personal_info (id, firstname, lastname, birth_date, address_id, contact_id) VALUES(12,'William','Matthews','1941-6-22',12,12);
INSERT INTO personal_info (id, firstname, lastname, birth_date, address_id, contact_id) VALUES(13,'Tony','Cobb','1976-8-25',13,13);
INSERT INTO personal_info (id, firstname, lastname, birth_date, address_id, contact_id) VALUES(14,'Harry','Todd','1961-8-23',14,14);
INSERT INTO personal_info (id, firstname, lastname, birth_date, address_id, contact_id) VALUES(15,'Hayden','Cox','1950-11-6',15,15);  
  
INSERT INTO student (id, person_id, degree, enabled) VALUES(1,1, 'Computer Engineering', false);
INSERT INTO student (id, person_id, degree, enabled) VALUES(2,2, 'Data Analytics', false);
INSERT INTO student (id, person_id, degree, enabled) VALUES(3,3, 'IT Support', false);
INSERT INTO student (id, person_id, degree, enabled) VALUES(4,4, 'Computer Engineering', false);
INSERT INTO student (id, person_id, degree, enabled) VALUES(5,5, 'Computer Engineering', false);
INSERT INTO student (id, person_id, degree, enabled) VALUES(6,6, 'Data Analytics', true);
INSERT INTO student (id, person_id, degree, enabled) VALUES(7,7, 'Computer Engineering', true);
INSERT INTO student (id, person_id, degree, enabled) VALUES(8,8, 'Management Information Systems', true);
INSERT INTO student (id, person_id, degree, enabled) VALUES(9,9, 'Computer Engineering', true);
INSERT INTO student (id, person_id, degree, enabled) VALUES(10,10, 'Data Analytics', true);
INSERT INTO student (id, person_id, degree, enabled) VALUES(11,11, 'IT Support', true);
INSERT INTO student (id, person_id, degree, enabled) VALUES(12,12, 'Management Information Systems', true);
INSERT INTO student (id, person_id, degree, enabled) VALUES(13,13, 'Computer Engineering', true);
INSERT INTO student (id, person_id, degree, enabled) VALUES(14,14, 'Data Analytics', true);
INSERT INTO student (id, person_id, degree, enabled) VALUES(15,15, 'IT Support', true);