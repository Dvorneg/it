/*create table equipment
("id"  serial not null,
 "company" varchar(255) not null,
  "description" varchar(120) not null,
   "release_date" date,
   "responsible_person" varchar(255),
    "type_of" varchar(255),
    primary key ("id"));*/

/*no added id!*/
INSERT INTO COMPANY (name, description)
VALUES ('USER Фирма', ''),
       ('ООО ЖКХ', '');

INSERT INTO equipment (inventory_number,name,manufacturer, description, responsible_person, release_date,type_of,company_id)
VALUES ('оф-1','принтер','Samsung', 'description1',  'responsible_person1','2021-01-03','OFFICE_EQUIPMENT',1),
       ('оф-2','монитор', 'LG','description2',  'responsible_person2','2022-02-02','OTHER',1);


INSERT INTO equipment (id, inventory_number,name, manufacturer, description, responsible_person, release_date,type_of,company_id)
VALUES (9,'оф-3','принтер','LG', 'description3',  'responsible_person3','2022-02-03','BUILDINGS',2);


INSERT INTO USERS (name, email, password, default_company_id)
VALUES ('User', 'test', '{noop}test', 2),
       ('Admin', 'admin@gmail.com', '{noop}admin', 2),
       ('test1@mail.ru', 'test1@mail.ru', '{noop}test1@mail.ru', 2),
       ('test', '123@mail.ru', '{noop}123', 1);

/*INSERT INTO USERS (name, email, password)
VALUES      ('test', '123@mail.ru', '{noop}123');*/

INSERT INTO USER_ROLE (role, user_id)
VALUES ('USER', 1),
       ('ADMIN', 2),
       ('USER', 2),
       ('USER', 3),
       ('USER', 4),
       ('ADMIN', 4);


INSERT INTO USER_COMPANY (user_id, company_id)
VALUES (4, 1);


