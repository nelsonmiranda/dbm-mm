create table person
(
	id integer not null,
	name varchar(255) not null,
	location varchar(255),
	birthDate timestamp,
	constraint pk_person primary key(id)
);

insert into person(id,name,location,birthDate)
values (1001,'Nelson Miranda', 'San Salvador', sysdate());

insert into person(id,name,location,birthDate)
values (1002,'Natalia Miranda', 'San Salvador', sysdate());

insert into person(id,name,location,birthDate)
values (1003,'Ricardo Miranda', 'San Salvador', sysdate());