create table speciality (
   id                serial not null,
   description       varchar(255),

   constraint pk_speciality primary key (id)
);

create table doctor (
   id               serial not null,
   name             varchar(255),
   speciality       int4 not null,

   constraint pk_doctor primary key (id)
);

alter table if exists doctor add constraint FK_DOCTOR_ON_SPECIALITY foreign key (speciality) references speciality (id);

create table patient (
   id               serial not null,
   name             varchar(255) not null,
   age              integer,

   constraint pk_patient primary key (id)
);

create table consult (
   id               serial not null,
   patient          int4 not null,
   doctor           int4 not null,
   speciality       int4 not null,
   
   constraint pk_consult primary key (id)
);

alter table if exists consult add constraint FK_CONSULT_ON_DOCTOR foreign key (doctor) references doctor (id);

alter table if exists consult add constraint FK_CONSULT_ON_PATIENT foreign key (patient) references patient (id);

alter table if exists consult add constraint FK_CONSULT_ON_SPECIALITY foreign key (speciality) references speciality (id);

create table pathology (
   id               serial not null,
   description      varchar(255),

   constraint pk_pathology primary key (id)
);

create table symptom (
    id               serial not null,
    description      varchar(255),

    constraint pk_symptom primary key (id)
);

create table symptom_pathology(
 pathology_id         int4,
 symptom_id           int4,

 constraint pk_symptom_pathology primary key (pathology_id, symptom_id)
);

alter table if exists symptom_pathology add constraint FK_SYMPTOM_ON_SYMPTOM_PATHOLOGY foreign key (symptom_id) references symptom (id);
alter table if exists symptom_pathology add constraint FK_PATHOLOGY_ON_SYMPTOM_PATHOLOGY foreign key (pathology_id) references pathology (id);


create table patient_pathology(
 pathology_id          int4,
 patient_id            int4,

 constraint pk_patient_pathology primary key (pathology_id, patient_id)
);

alter table if exists patient_pathology add constraint FK_PATIENT_ON_PATIENT_PATHOLOGY foreign key (patient_id) references patient (id);
alter table if exists patient_pathology add constraint FK_PATHOLOGY_ON_PATIENT_PATHOLOGY foreign key (pathology_id) references pathology (id);