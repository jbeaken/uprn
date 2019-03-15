-- drop table uprn.ons_match;

create table uprn.mumps_match(
       ID bigint,
       DiscoveryAddress VARCHAR(500),
       APBAddress varchar(500),
       Algorithm  varchar(50),
       Qualifier varchar(50),
       UPRN  varchar(50),
       Table_Col varchar(50),
       Key_Col varchar(50),
       Status varchar(50)
);

LOAD DATA LOCAL INFILE '/media/ext/LearningHealth/batch/input/mumps.csv'
  INTO TABLE uprn.mumps_match
  FIELDS TERMINATED BY '\t'
  ENCLOSED BY '"'
  LINES TERMINATED BY '\n'
  IGNORE 1 ROWS;

-- alter table address add column onsAddress VARCHAR(255);
-- alter table address add column score INT;
