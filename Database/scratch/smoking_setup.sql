-- create database ceg_compass_data;
-- create database ceg_analysis_data;

drop table ceg_analysis_data.observation_original_code;
drop table ceg_analysis_data.original_code;
drop table ceg_compass_data.observation;
drop table ceg_compass_data.episode_of_care;

create table ceg_compass_data.observation (
  id bigint primary key auto_increment,
  original_code varchar(20),
  person_id bigint,
  clinical_effective_date date
);

create table ceg_compass_data.episode_of_care (
  person_id bigint primary key auto_increment
);

insert into ceg_compass_data.episode_of_care (person_id) values ( 1 );
insert into ceg_compass_data.episode_of_care (person_id) values ( 2 );
insert into ceg_compass_data.episode_of_care (person_id) values ( 3 );
insert into ceg_compass_data.episode_of_care (person_id) values ( 4 );
insert into ceg_compass_data.episode_of_care (person_id) values ( 5 );
insert into ceg_compass_data.episode_of_care (person_id) values ( 6 );
insert into ceg_compass_data.episode_of_care (person_id) values ( 7 );
insert into ceg_compass_data.episode_of_care (person_id) values ( 8 );
insert into ceg_compass_data.episode_of_care (person_id) values ( 9 );


insert into ceg_compass_data.observation (original_code, person_id, clinical_effective_date) values ('Fh', 1, now());
insert into ceg_compass_data.observation (original_code, person_id, clinical_effective_date) values ('FH', 2, now());
insert into ceg_compass_data.observation (original_code, person_id, clinical_effective_date) values ('fH', 3, now());
insert into ceg_compass_data.observation (original_code, person_id, clinical_effective_date) values ('FH.', 4, now());
insert into ceg_compass_data.observation (original_code, person_id, clinical_effective_date) values ('137I', 5, now());
insert into ceg_compass_data.observation (original_code, person_id, clinical_effective_date) values ('137I', 6, now());
insert into ceg_compass_data.observation (original_code, person_id, clinical_effective_date) values ('137i', 7, now());
insert into ceg_compass_data.observation (original_code, person_id, clinical_effective_date) values ('137i.', 8, now());
insert into ceg_compass_data.observation (original_code, person_id, clinical_effective_date) values ('137I.', 9, now());
