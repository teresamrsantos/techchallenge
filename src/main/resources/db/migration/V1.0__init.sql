create table speciality (
   id                bigserial not null,
   uuid              uuid default gen_random_uuid() not null,
   description       varchar(255),

   constraint pk_speciality primary key (id)
);

alter table if exists speciality add constraint uc_speciality_uuid unique (uuid);

create table doctor (
   id               bigserial not null,
   uuid             uuid default gen_random_uuid() not null,
   name             varchar(255),
   speciality       bigserial not null,

   constraint pk_doctor primary key (id)
);

alter table if exists doctor add constraint uc_doctor_uuid unique (uuid);
alter table if exists doctor add constraint FK_DOCTOR_ON_SPECIALITY foreign key (speciality) references speciality (id);

create table patient (
   id               bigserial not null,
   uuid             uuid default gen_random_uuid() not null,
   name             varchar(255) not null,
   age              integer,

   constraint pk_patient primary key (id)
);

alter table if exists patient add constraint uc_patient_uuid unique (uuid);


create table consult (
   id               bigserial not null,
   uuid             uuid default gen_random_uuid() not null,
   patient          bigserial not null,
   doctor           bigserial not null,
   speciality       bigserial not null,
   
   constraint pk_consult primary key (id)
);

alter table if exists consult add constraint uc_consult_uuid unique (uuid);

alter table if exists consult add constraint FK_CONSULT_ON_DOCTOR foreign key (doctor) references doctor (id);

alter table if exists consult add constraint FK_CONSULT_ON_PATIENT foreign key (patient) references patient (id);

alter table if exists consult add constraint FK_CONSULT_ON_SPECIALITY foreign key (speciality) references speciality (id);

create table pathology (
   id               bigserial not null,
   uuid             uuid default gen_random_uuid() not null,
   description      varchar(255),

   constraint pk_pathology primary key (id)
);

alter table if exists pathology add constraint uc_pathology_uuid unique (uuid);

create table symptom (
    id               bigserial not null,
    uuid             uuid default gen_random_uuid() not null,
    description      varchar(255),

    constraint pk_symptom primary key (id)
);

alter table if exists symptom add constraint uc_symptom_uuid unique (uuid);

create table symptom_pathology(
 pathology_id         bigserial,
 symptom_id           bigserial,

 constraint pk_symptom_pathology primary key (pathology_id, symptom_id)
);

alter table if exists symptom_pathology add constraint FK_SYMPTOM_ON_SYMPTOM_PATHOLOGY foreign key (symptom_id) references symptom (id);
alter table if exists symptom_pathology add constraint FK_PATHOLOGY_ON_SYMPTOM_PATHOLOGY foreign key (pathology_id) references pathology (id);


create table patient_pathology(
 pathology_id          bigserial,
 patient_id            bigserial,

 constraint pk_patient_pathology primary key (pathology_id, patient_id)
);

alter table if exists patient_pathology add constraint FK_PATIENT_ON_PATIENT_PATHOLOGY foreign key (patient_id) references patient (id);
alter table if exists patient_pathology add constraint FK_PATHOLOGY_ON_PATIENT_PATHOLOGY foreign key (pathology_id) references pathology (id);