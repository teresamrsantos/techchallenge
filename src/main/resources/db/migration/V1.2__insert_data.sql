
insert into speciality(id, description) values (1,'Dermatology');
insert into speciality(id, description) values (2,'Ophthalmology');
insert into speciality(id, description) values (3,'Radiology');
insert into speciality(id, description) values (4,'Family Medicine');
insert into speciality(id, description) values (5,'Pediatrics');

insert into doctor(id, name, speciality) values (1,'António',1);
insert into doctor(id, name, speciality) values (2,'Maria', 2);
insert into doctor(id, name, speciality) values (3,'Carlos', 3);
insert into doctor(id, name, speciality) values (4,'Gabriela', 4);
insert into doctor(id, name, speciality) values (5,'Paulo', 5);

insert into patient(id, name, age) values (1,'Manuel', 53);
insert into patient(id, name, age) values (2,'Joana', 32);
insert into patient(id, name, age) values (3,'Ana', 25);
insert into patient(id, name, age) values (4,'Diogo', 33);
insert into patient(id, name, age) values (5,'Catarina', 33);
insert into patient(id, name, age) values (6,'Miguel', 40);

insert into pathology(id,description) values (1, 'Pathology 1');
insert into pathology(id,description) values (2, 'Pathology 2');
insert into pathology(id,description) values (3, 'Pathology 3');
insert into pathology(id,description) values (4, 'Pathology 4');
insert into pathology(id,description) values (5, 'Pathology 5');
insert into pathology(id,description) values (6, 'Pathology 6');
insert into pathology(id,description) values (7, 'Pathology 7');

insert into symptom(id,description) values (1, 'Symptom 1 Description');
insert into symptom(id,description) values (2, 'Symptom 2 Description');
insert into symptom(id,description) values (3, 'Symptom 3 Description');
insert into symptom(id,description) values (4, 'Symptom 4 Description');
insert into symptom(id,description) values (5, 'Symptom 5 Description');
insert into symptom(id,description) values (6, 'Symptom 6 Description');
insert into symptom(id,description) values (7, 'Symptom 7 Description');
insert into symptom(id,description) values (8, 'Symptom 8 Description');
insert into symptom(id,description) values (9, 'Symptom 9 Description');
insert into symptom(id,description) values (10, 'Symptom 10 Description');
insert into symptom(id,description) values (11, 'Symptom 11 Description');
insert into symptom(id,description) values (12, 'Symptom 12 Description');
insert into symptom(id,description) values (13, 'Symptom 13 Description');
insert into symptom(id,description) values (14, 'Symptom 14 Description');
insert into symptom(id,description) values (15, 'Symptom 15 Description');

insert into consult(id, doctor, speciality, patient) values (1, 1, 1, 1);
insert into consult(id, doctor, speciality, patient) values (2, 1, 1, 1);
insert into consult(id, doctor, speciality, patient) values (3, 2, 2, 1);
insert into consult(id, doctor, speciality, patient) values (4, 2, 2, 2);
insert into consult(id, doctor, speciality, patient) values (5, 3, 3, 3);
insert into consult(id, doctor, speciality, patient) values (6, 4, 4, 4);
insert into consult(id, doctor, speciality, patient) values (7, 5, 5, 5);
insert into consult(id, doctor, speciality, patient) values (8, 2, 2, 6);

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