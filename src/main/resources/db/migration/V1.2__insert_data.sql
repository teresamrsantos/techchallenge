
insert into speciality( description) values ('Dermatology');
insert into speciality( description) values ('Ophthalmology');
insert into speciality( description) values ('Radiology');
insert into speciality( description) values ('Family Medicine');
insert into speciality( description) values ('Pediatrics');

insert into doctor( name, speciality) values ('António',1);
insert into doctor( name, speciality) values ('Maria', 2);
insert into doctor( name, speciality) values ('Carlos', 3);
insert into doctor( name, speciality) values ('Gabriela', 4);
insert into doctor( name, speciality) values ('Paulo', 5);

insert into patient( name, age) values ('Manuel', 53);
insert into patient( name, age) values ('Joana', 32);
insert into patient( name, age) values ('Ana', 25);
insert into patient( name, age) values ('Diogo', 33);
insert into patient( name, age) values ('Catarina', 33);
insert into patient( name, age) values ('Miguel', 40);

insert into pathology(description) values ('Pathology 1');
insert into pathology(description) values ('Pathology 2');
insert into pathology(description) values ('Pathology 3');
insert into pathology(description) values ('Pathology 4');
insert into pathology(description) values ('Pathology 5');
insert into pathology(description) values ('Pathology 6');
insert into pathology(description) values ('Pathology 7');

insert into symptom(description) values ('Symptom 1 Description');
insert into symptom(description) values ('Symptom 2 Description');
insert into symptom(description) values ('Symptom 3 Description');
insert into symptom(description) values ('Symptom 4 Description');
insert into symptom(description) values ('Symptom 5 Description');
insert into symptom(description) values ('Symptom 6 Description');
insert into symptom(description) values ('Symptom 7 Description');
insert into symptom(description) values ('Symptom 8 Description');
insert into symptom(description) values ('Symptom 9 Description');
insert into symptom(description) values ('Symptom 10 Description');
insert into symptom(description) values ('Symptom 11 Description');
insert into symptom(description) values ('Symptom 12 Description');
insert into symptom(description) values ('Symptom 13 Description');
insert into symptom(description) values ('Symptom 14 Description');
insert into symptom(description) values ('Symptom 15 Description');

insert into consult( doctor, speciality, patient) values ( 1, 1, 1);
insert into consult( doctor, speciality, patient) values ( 1, 1, 1);
insert into consult( doctor, speciality, patient) values ( 2, 2, 1);
insert into consult( doctor, speciality, patient) values ( 2, 2, 2);
insert into consult( doctor, speciality, patient) values ( 3, 3, 3);
insert into consult( doctor, speciality, patient) values ( 4, 4, 4);
insert into consult( doctor, speciality, patient) values ( 5, 5, 5);
insert into consult( doctor, speciality, patient) values ( 2, 2, 6);

insert into symptom_pathology(pathology_id, symptom_id) values (1,1);
insert into symptom_pathology(pathology_id, symptom_id) values (1,2);
insert into symptom_pathology(pathology_id, symptom_id) values (2,3);
insert into symptom_pathology(pathology_id, symptom_id) values (2,4);
insert into symptom_pathology(pathology_id, symptom_id) values (2,5);
insert into symptom_pathology(pathology_id, symptom_id) values (3,6);
insert into symptom_pathology(pathology_id, symptom_id) values (3,7);
insert into symptom_pathology(pathology_id, symptom_id) values (4,8);
insert into symptom_pathology(pathology_id, symptom_id) values (5,9);
insert into symptom_pathology(pathology_id, symptom_id) values (5,10);
insert into symptom_pathology(pathology_id, symptom_id) values (5,11);
insert into symptom_pathology(pathology_id, symptom_id) values (6,12);
insert into symptom_pathology(pathology_id, symptom_id) values (6,13);
insert into symptom_pathology(pathology_id, symptom_id) values (7,14);
insert into symptom_pathology(pathology_id, symptom_id) values (7,15);

insert into patient_pathology(pathology_id, patient_id) values(1,1);
insert into patient_pathology(pathology_id, patient_id) values(2,1);
insert into patient_pathology(pathology_id, patient_id) values(3,1);
insert into patient_pathology(pathology_id, patient_id) values(3,2);
insert into patient_pathology(pathology_id, patient_id) values(4,3);
insert into patient_pathology(pathology_id, patient_id) values(5,4);
insert into patient_pathology(pathology_id, patient_id) values(6,5);
insert into patient_pathology(pathology_id, patient_id) values(7,6);