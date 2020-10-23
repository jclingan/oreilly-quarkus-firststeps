insert into Training(ID, NAME) values (nextval('hibernate_sequence'), 'Quarkus First Steps');
insert into Training(ID, NAME) values (nextval('hibernate_sequence'), 'Quarkus and MicroProfile');
insert into Student(ID, training_id, NAME) values (nextval('hibernate_sequence'), 1,  'John Doe');
insert into Student(ID, training_id, NAME) values (nextval('hibernate_sequence'), 1,  'Jane Doe');
insert into Student(ID, training_id, NAME) values (nextval('hibernate_sequence'), 2,  'John Duke');
insert into Student(ID, training_id, NAME) values (nextval('hibernate_sequence'), 2,  'Jane Quarkus');