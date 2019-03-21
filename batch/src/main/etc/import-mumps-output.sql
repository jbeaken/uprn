drop table uprn.mumps_match;

create table uprn.mumps_match (
  Discovery_Address varchar(255),
  ONS_Score FLOAT,
  ONS_ABP_Address  varchar(255),
  ONS_UPRN BIGINT,
  ONS_Classification  varchar(20),

  Mumps_UPRN BIGINT,
  Mumps_ABP_Address  varchar(255),
  Mumps_ID BIGINT PRIMARY KEY,
  Mumps_Algorithm  varchar(255),
  Mumps_Qualifier  varchar(255),
  Mumps_Table varchar(255),
  Mumps_Key varchar(255),

  Discovery_Line1 varchar(255),
  Discovery_Line2 varchar(255),
  Discovery_Line3 varchar(255),
  Discovery_Line4 varchar(255),
  Discovery_County varchar(255),
  Discovery_Postcode varchar(255)
);

LOAD DATA LOCAL INFILE '/media/ext/LearningHealth/batch/output/mumps-sealed-1541082.csv'
  INTO TABLE uprn.mumps_match
  FIELDS TERMINATED BY ','
  ENCLOSED BY '"'
  LINES TERMINATED BY '\n'
  IGNORE 1 ROWS;


