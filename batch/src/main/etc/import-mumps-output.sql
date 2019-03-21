-- drop table uprn.ons_match;

create table uprn.mumps_match {
  Discovery Address varchar(255),
  ONS Score FLOAT,
  ONS ABP Address  varchar(255),
  ONS UPRN BIGINT,
  ONS Classification  varchar(20),

  Mumps_UPRN BIGINT,
  Mumps ABP Address  varchar(255),
  Mumps_ID PRIMARY KEY,
  Mumps Algorithm  varchar(255),
  Mumps Qualifier  varchar(255),
  Mumps Table varchar(255),
  Mumps Key varchar(255),

  DiscoveryLine1 varchar(255),
  DiscoveryLine2 varchar(255),
  DiscoveryLine3 varchar(255),
  DiscoveryLine4 varchar(255),
  DiscoveryCounty varchar(255),
  DiscoveryPostcode varchar(255)
);

LOAD DATA LOCAL INFILE '/media/ext/LearningHealth/batch/input/mumps.csv'
  INTO TABLE uprn.mumps
  FIELDS TERMINATED BY '\t'
  ENCLOSED BY '"'
  LINES TERMINATED BY '\n'
  IGNORE 1 ROWS;



create table uprn.mumps(
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
  INTO TABLE uprn.mumps
  FIELDS TERMINATED BY '\t'
  ENCLOSED BY '"'
  LINES TERMINATED BY '\n'
  IGNORE 1 ROWS;

-- alter table address add column onsAddress VARCHAR(255);
-- alter table address add column score INT;
