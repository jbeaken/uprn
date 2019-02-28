# Create UPRN Address Base Premium (ABP) Database
drop database uprn;
create database uprn;

# ID21_BLPU_Records
# Primary Key is UPRN
create table uprn.blpu (
  RECORD_IDENTIFIER INT,
  CHANGE_TYPE VARCHAR(10),
  PRO_ORDER INT,
  UPRN BIGINT PRIMARY KEY,
  LOGICAL_STATUS INT,
  BLPU_STATE VARCHAR(20),
  BLPU_STATE_DATE DATE,
  PARENT_UPRN BIGINT,
  X_COORDINATE DOUBLE,
  Y_COORDINATE DOUBLE,
  LATITUDE DOUBLE,
  LONGITUDE DOUBLE,
  RPC SMALLINT,
  LOCAL_CUSTODIAN_CODE INT,
  COUNTRY VARCHAR(10),
  START_DATE DATE,
  END_DATE DATE,
  LAST_UPDATE_DATE DATE,
  ENTRY_DATE DATE,
  ADDRESSBASE_POSTAL VARCHAR(10),
  POSTCODE_LOCATOR VARCHAR(20),
  MULTI_OCC_COUNT SMALLINT

 );



LOAD DATA LOCAL INFILE '/media/ext/LearningHealth/ABP_GreaterLondon_Baseline_FTP_1March18/ID21_BLPU_Records.csv'
INTO TABLE uprn.blpu
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;



# ID32_Classification_Records
# Primary Key is CLASS_KEY

create table uprn.classification (
  RECORD_IDENTIFIER INT,
  CHANGE_TYPE VARCHAR(10),
  PRO_ORDER INT,
  UPRN BIGINT,
  CLASS_KEY VARCHAR(100) PRIMARY KEY,
  CLASSIFICATION_CODE VARCHAR(50),
  CLASS_SCHEME VARCHAR(100),
  SCHEME_VERSION SMALLINT,
  START_DATE DATE,
  END_DATE DATE,
  LAST_UPDATE_DATE DATE,
  ENTRY_DATE DATE

 );

LOAD DATA LOCAL INFILE '/media/ext/LearningHealth/ABP_GreaterLondon_Baseline_FTP_1March18/ID32_Class_Records.csv'
INTO TABLE uprn.classification
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

# ID23_XREF_Records
# Primary Key is XREF_KEY

create table uprn.xref (
  RECORD_IDENTIFIER INT,
  CHANGE_TYPE VARCHAR(10),
  PRO_ORDER INT,
  UPRN BIGINT,
  XREF_KEY VARCHAR(100) PRIMARY KEY,
  CROSS_REFERENCE VARCHAR(100),
  VERSION VARCHAR(50),
  SOURCE VARCHAR(50),
  START_DATE DATE,
  END_DATE DATE,
  LAST_UPDATE_DATE DATE,
  ENTRY_DATE DATE

 );

LOAD DATA LOCAL INFILE '/media/ext/LearningHealth/ABP_GreaterLondon_Baseline_FTP_1March18/ID23_XREF_Records.csv'
INTO TABLE uprn.xref
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;




# ID28_DPA_Records
# Primary Key is UDPRN

create table uprn.dpa (
  RECORD_IDENTIFIER INT,
  CHANGE_TYPE VARCHAR(10),
  PRO_ORDER INT,
  UPRN BIGINT,
  UDPRN BIGINT PRIMARY KEY,
  ORGANISATION_NAME VARCHAR(500),
  DEPARTMENT_NAME VARCHAR(500),
  SUB_BUILDING_NAME VARCHAR(200),
  BUILDING_NAME VARCHAR(200),
  BUILDING_NUMBER VARCHAR(50),
  DEPENDENT_THOROUGHFARE VARCHAR(500),
  THOROUGHFARE VARCHAR(500),
  DOUBLE_DEPENDENT_LOCALITY VARCHAR(500),
  DEPENDENT_LOCALITY VARCHAR(500),
  POST_TOWN VARCHAR(300),
  POSTCODE VARCHAR(30),
  POSTCODE_TYPE VARCHAR(10),
  DELIVERY_POINT_SUFFIX VARCHAR(10),
  WELSH_DEPENDENT_THOROUGHFARE VARCHAR(500),
  WELSH_THOROUGHFARE VARCHAR(500),
  WELSH_DOUBLE_DEPENDENT_LOCALITY VARCHAR(500),
  WELSH_DEPENDENT_LOCALITY VARCHAR(500),
  WELSH_POST_TOWN VARCHAR(300),
  PO_BOX_NUMBER VARCHAR(100),
  PROCESS_DATE DATE,
  START_DATE DATE,
  END_DATE DATE,
  LAST_UPDATE_DATE DATE,
  ENTRY_DATE DATE

 );

LOAD DATA LOCAL INFILE '/media/ext/LearningHealth/ABP_GreaterLondon_Baseline_FTP_1March18/ID28_DPA_Records.csv'
INTO TABLE uprn.dpa
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

# ID24_LPI_Records
# Primary Key is LPI_KEY

create table uprn.lpi (
  RECORD_IDENTIFIER INT,
  CHANGE_TYPE VARCHAR(10),
  PRO_ORDER INT,
  UPRN BIGINT,
  LPI_KEY VARCHAR(100) PRIMARY KEY,
  LANGUAGE VARCHAR(30),
  LOGICAL_STATUS INT,
  START_DATE DATE,
  END_DATE DATE,
  LAST_UPDATE_DATE DATE,
  ENTRY_DATE DATE,
  SAO_START_NUMBER VARCHAR(50),
  SAO_START_SUFFIX VARCHAR(50),
  SAO_END_NUMBER VARCHAR(50),
  SAO_END_SUFFIX VARCHAR(50),
  SAO_TEXT VARCHAR(500),
  PAO_START_NUMBER VARCHAR(50),
  PAO_START_SUFFIX VARCHAR(50),
  PAO_END_NUMBER VARCHAR(50),
  PAO_END_SUFFIX VARCHAR(50),
  PAO_TEXT VARCHAR(500),
  USRN BIGINT,
  USRN_MATCH_INDICATOR INT,
  AREA_NAME VARCHAR(500),
  LEVEL VARCHAR(500),
  OFFICIAL_FLAG VARCHAR(50)

 );

LOAD DATA LOCAL INFILE '/media/ext/LearningHealth/ABP_GreaterLondon_Baseline_FTP_1March18/ID24_LPI_Records.csv'
INTO TABLE uprn.lpi
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;


# ID31_Organisation_Records
# Primary Key is ORG_KEY

create table uprn.org (
  RECORD_IDENTIFIER INT,
  CHANGE_TYPE VARCHAR(10),
  PRO_ORDER INT,
  UPRN BIGINT PRIMARY KEY,
  ORG_KEY VARCHAR(100) PRIMARY KEY,
  ORGANISATION VARCHAR(500),
  LEGAL_NAME VARCHAR(500),
  START_DATE DATE,
  END_DATE DATE,
  LAST_UPDATE_DATE DATE,
  ENTRY_DATE DATE

 );

LOAD DATA LOCAL INFILE '/media/ext/LearningHealth/ABP_GreaterLondon_Baseline_FTP_1March18/ID31_Org_Records.csv'
INTO TABLE uprn.org
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

# select count(*) from uprn.org
# '107788' Rows
# select * from uprn.org;


# ID11_Street_Records
# Primary Key is USRN

create table uprn.street (
  RECORD_IDENTIFIER INT,
  CHANGE_TYPE VARCHAR(10),
  PRO_ORDER INT,
  USRN BIGINT PRIMARY KEY,
  RECORD_TYPE INT,
  SWA_ORG_REF_NAMING INT,
  STATE VARCHAR(50),
  STATE_DATE DATE,
  STREET_SURFACE VARCHAR(50),
  STREET_CLASSIFICATION VARCHAR(50),
  VERSION INT,
  STREET_START_DATE DATE,
  STREET_END_DATE DATE,
  LAST_UPDATE_DATE DATE,
  RECORD_ENTRY_DATE DATE,
  STREET_START_X DOUBLE,
  STREET_START_Y DOUBLE,
  STREET_START_LAT DOUBLE,
  STREET_START_LONG DOUBLE,
  STREET_END_X DOUBLE,
  STREET_END_Y DOUBLE,
  STREET_END_LAT DOUBLE,
  STREET_END_LONG DOUBLE,
  STREET_TOLERANCE INT
 );

LOAD DATA LOCAL INFILE '/media/ext/LearningHealth/ABP_GreaterLondon_Baseline_FTP_1March18/ID11_Street_Records.csv'
INTO TABLE uprn.street
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

# select count(*) from uprn.street
# '68763' Rows
# select * from uprn.street;

# ID15_StreetDescriptor_Records
# No Primary Key only USRN is Foreign Key

create table uprn.streetdesc (
  RECORD_IDENTIFIER INT,
  CHANGE_TYPE VARCHAR(10),
  PRO_ORDER INT,
  USRN BIGINT,
  STREET_DESCRIPTION VARCHAR(500),
  LOCALITY_NAME VARCHAR(500),
  TOWN_NAME VARCHAR(500),
  ADMINISTRATIVE_AREA VARCHAR(500),
  LANGUAGE VARCHAR(50),
  START_DATE DATE,
  END_DATE DATE,
  LAST_UPDATE_DATE DATE,
  ENTRY_DATE DATE,
  foreign key(`usrn_fk`) references uprn.street(`USRN`)
 );

LOAD DATA LOCAL INFILE '/media/ext/LearningHealth/ABP_GreaterLondon_Baseline_FTP_1March18/ID15_StreetDesc_Records.csv'
INTO TABLE uprn.streetdesc
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

# select count(*) from uprn.streetdesc
# '68763' Rows
# select * from uprn.streetdesc;


# ID30_Successor_Records
# Primary Key is SUCC_KEY

create table uprn.successor (
  RECORD_IDENTIFIER INT,
  CHANGE_TYPE VARCHAR(10),
  PRO_ORDER INT,
  UPRN BIGINT PRIMARY KEY,
  SUCC_KEY VARCHAR(100) NOT NULL,
  START_DATE DATE,
  END_DATE DATE,
  LAST_UPDATE_DATE DATE,
  ENTRY_DATE DATE,
  SUCCESSOR INT

 );

LOAD DATA LOCAL INFILE '/media/ext/LearningHealth/ABP_GreaterLondon_Baseline_FTP_1March18/ID30_Successor_Records.csv'
INTO TABLE uprn.successor
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

# ID10_Header_Records
# Primary Key is VOLUME_NUMBER

create table uprn.header (
  RECORD_IDENTIFIER INT,
  CUSTODIAN_NAME VARCHAR(100),
  LOCAL_CUSTODIAN_NAME VARCHAR(100),
  PROCESS_DATE DATE,
  VOLUME_NUMBER INT NOT NULL,
  ENTRY_DATE DATE,
  TIME_STAMP DATETIME,
  VERSION INT,
  FILE_TYPE VARCHAR(30)

 );

LOAD DATA LOCAL INFILE '/media/ext/LearningHealth/ABP_GreaterLondon_Baseline_FTP_1March18/ID10_Header_Records.csv'
INTO TABLE uprn.header
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

# ID99_Trailer_Records
# Primary Key is NEXT_VOLUME_NUMBER

create table uprn.trailer (
  RECORD_IDENTIFIER INT,
  NEXT_VOLUME_NUMBER INT NOT NULL,
  RECORD_COUNT BIGINT,
  ENTRY_DATE DATE,
  TIME_STAMP DATETIME

 );

LOAD DATA LOCAL INFILE '/media/ext/LearningHealth/ABP_GreaterLondon_Baseline_FTP_1March18/ID99_Trailer_Records.csv'
INTO TABLE uprn.trailer
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

####################################
# Sanity checks
####################################

# select count(*) from uprn.lpi
# '1048575' Rows
# select * from uprn.lpi;

# select count(*) from uprn.dpa
# '3512745' Rows
# select * from uprn.dpa;

#select count(*) from uprn.classification
# '5381317' Rows
# select * from uprn.classification;

# select count(*) from uprn.xref
# '21941817' Rows
# select * from uprn.xref;

# select count(*) from uprn.header
# '42' Rows
# select * from uprn.header;

# select count(*) from uprn.blpu
# '4861145' Rows
#  select * from uprn.blpu;

# select count(*) from uprn.trailer
# '42' Rows
# select * from uprn.trailer;

# select count(*) from uprn.successor
# '0' Rows
# select * from uprn.successor;
