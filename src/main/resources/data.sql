/*create table equipment
("id"  serial not null,
 "company" varchar(255) not null,
  "description" varchar(120) not null,
   "release_date" date,
   "responsible_person" varchar(255),
    "type_of" varchar(255),
    primary key ("id"));*/

INSERT INTO equipment (inventory_number,name,company, description, responsible_person, release_date,type_of)
VALUES ('оф-1','принтер','Samsung', 'description1',  'responsible_person1','2021-01-03','OFFICE_EQUIPMENT'),
       ('оф-2','монитор', 'LG','description2',  'responsible_person2','2022-02-02','OTHER');


INSERT INTO equipment (id, inventory_number,name,company, description, responsible_person, release_date,type_of)
VALUES (9,'оф-3','принтер','LG', 'description3',  'responsible_person3','2022-02-03','BUILDINGS');


INSERT INTO USERS (name, email, password)
VALUES ('User', 'test', '{noop}test'),
       ('Admin', 'admin@gmail.com', '{noop}admin'),
       ('test1@mail.ru', 'test1@mail.ru', '{noop}test1@mail.ru'),
       ('123', '123', '{noop}123');

INSERT INTO USER_ROLE (role, user_id)
VALUES ('USER', 1),
       ('ADMIN', 2),
       ('USER', 2),
       ('USER', 3),
       ('USER', 4),
       ('ADMIN', 4);

INSERT INTO COMPANY (name, description)
VALUES ('USER Фирма', 1),
    ('ООО ЖКХ', 1);

INSERT INTO USER_COMPANY (user_id, company_id)
VALUES (4, 1);


