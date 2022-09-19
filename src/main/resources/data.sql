/*create table equipment
("id"  serial not null,
 "company" varchar(255) not null,
  "description" varchar(120) not null,
   "release_date" date,
   "responsible_person" varchar(255),
    "type_of" varchar(255),
    primary key ("id"));*/
INSERT INTO equipment (company, description, responsible_person, release_date,type_of)
VALUES ('company1', 'description1',  'responsible_person1','2021-01-03','OFFICE_EQUIPMENT'),
       ('company2', 'description2',  'responsible_person2','2022-02-02','OTHER');
