# Create UPRN Address Base Premium (ABP) Database
drop database uprn;
create database uprn;

# ID21_BLPU_Records
# Primary Key is UPRN
drop table if exists uprn.abp_blpu;
create table uprn.abp_blpu (
  RECORD_IDENTIFIER INT,
  CHANGE_TYPE VARCHAR(10),
  PRO_ORDER INT,
  UPRN BIGINT NOT NULL,
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


truncate table uprn.abp_blpu;
LOAD DATA LOCAL INFILE 'ID21_BLPU_Records.csv'
INTO TABLE uprn.abp_blpu
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;



# ID32_Classification_Records
# Primary Key is CLASS_KEY
drop table if exists uprn.abp_class;
create table uprn.abp_class (
  RECORD_IDENTIFIER INT,
  CHANGE_TYPE VARCHAR(10),
  PRO_ORDER INT,
  UPRN BIGINT,
  CLASS_KEY VARCHAR(100) NOT NULL,
  CLASSIFICATION_CODE VARCHAR(50),
  CLASS_SCHEME VARCHAR(100),
  SCHEME_VERSION SMALLINT,
  START_DATE DATE,
  END_DATE DATE,
  LAST_UPDATE_DATE DATE,
  ENTRY_DATE DATE

 );
truncate table uprn.abp_class;
LOAD DATA LOCAL INFILE 'ID32_Class_Records.csv'
INTO TABLE uprn.abp_class
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

# ID23_XREF_Records
# Primary Key is XREF_KEY
drop table if exists uprn.abp_xref;
create table uprn.abp_xref (
  RECORD_IDENTIFIER INT,
  CHANGE_TYPE VARCHAR(10),
  PRO_ORDER INT,
  UPRN BIGINT,
  XREF_KEY VARCHAR(100) NOT NULL,
  CROSS_REFERENCE VARCHAR(100),
  VERSION VARCHAR(50),
  SOURCE VARCHAR(50),
  START_DATE DATE,
  END_DATE DATE,
  LAST_UPDATE_DATE DATE,
  ENTRY_DATE DATE

 );
truncate table uprn.abp_xref;
LOAD DATA LOCAL INFILE 'ID23_XREF_Records.csv'
INTO TABLE uprn.abp_xref
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;




# ID28_DPA_Records
# Primary Key is UDPRN
drop table if exists uprn.abp_dpa;
create table uprn.abp_dpa (
  RECORD_IDENTIFIER INT,
  CHANGE_TYPE VARCHAR(10),
  PRO_ORDER INT,
  UPRN BIGINT,
  UDPRN BIGINT NOT NULL,
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
truncate table uprn.abp_dpa;
LOAD DATA LOCAL INFILE 'ID28_DPA_Records.csv'
INTO TABLE uprn.abp_dpa
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;



# ID24_LPI_Records
# Primary Key is LPI_KEY
drop table if exists uprn.abp_lpi;
create table uprn.abp_lpi (
  RECORD_IDENTIFIER INT,
  CHANGE_TYPE VARCHAR(10),
  PRO_ORDER INT,
  UPRN BIGINT,
  LPI_KEY VARCHAR(100) NOT NULL,
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
truncate table uprn.abp_lpi;
LOAD DATA LOCAL INFILE 'ID24_LPI_Records.csv'
INTO TABLE uprn.abp_lpi
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;


# ID31_Organisation_Records
# Primary Key is ORG_KEY
drop table if exists uprn.abp_org;
create table uprn.abp_org (
  RECORD_IDENTIFIER INT,
  CHANGE_TYPE VARCHAR(10),
  PRO_ORDER INT,
  UPRN BIGINT,
  ORG_KEY VARCHAR(100) NOT NULL,
  ORGANISATION VARCHAR(500),
  LEGAL_NAME VARCHAR(500),
  START_DATE DATE,
  END_DATE DATE,
  LAST_UPDATE_DATE DATE,
  ENTRY_DATE DATE

 );
truncate table uprn.abp_org;
LOAD DATA LOCAL INFILE 'ID31_Org_Records.csv'
INTO TABLE uprn.abp_org
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

# select count(*) from uprn.abp_org
# '107788' Rows
# select * from uprn.abp_org;


# ID11_Street_Records
# Primary Key is USRN
drop table if exists uprn.abp_street;
create table uprn.abp_street (
  RECORD_IDENTIFIER INT,
  CHANGE_TYPE VARCHAR(10),
  PRO_ORDER INT,
  USRN BIGINT NOT NULL,
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
truncate table uprn.abp_street;
LOAD DATA LOCAL INFILE 'ID11_Street_Records.csv'
INTO TABLE uprn.abp_street
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

# select count(*) from uprn.abp_street
# '68763' Rows
# select * from uprn.abp_street;

# ID15_StreetDescriptor_Records
# No Primary Key only USRN is Foreign Key
drop table if exists uprn.abp_streetdesc;
create table uprn.abp_streetdesc (
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
  ENTRY_DATE DATE

 );
truncate table uprn.abp_streetdesc;
LOAD DATA LOCAL INFILE 'ID15_StreetDesc_Records.csv'
INTO TABLE uprn.abp_streetdesc
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

# select count(*) from uprn.abp_streetdesc
# '68763' Rows
# select * from uprn.abp_streetdesc;


# ID30_Successor_Records
# Primary Key is SUCC_KEY
drop table if exists uprn.abp_successor;
create table uprn.abp_successor (
  RECORD_IDENTIFIER INT,
  CHANGE_TYPE VARCHAR(10),
  PRO_ORDER INT,
  UPRN BIGINT,
  SUCC_KEY VARCHAR(100) NOT NULL,
  START_DATE DATE,
  END_DATE DATE,
  LAST_UPDATE_DATE DATE,
  ENTRY_DATE DATE,
  SUCCESSOR INT

 );
truncate table uprn.abp_successor;
LOAD DATA LOCAL INFILE 'ID30_Successor_Records.csv'
INTO TABLE uprn.abp_successor
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

# select count(*) from uprn.abp_successor
# '0' Rows
# select * from uprn.abp_successor;


# ID10_Header_Records
# Primary Key is VOLUME_NUMBER
drop table if exists uprn.abp_header;
create table uprn.abp_header (
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
truncate table uprn.abp_header;
LOAD DATA LOCAL INFILE 'ID10_Header_Records.csv'
INTO TABLE uprn.abp_header
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

# ID99_Trailer_Records
# Primary Key is NEXT_VOLUME_NUMBER
drop table if exists uprn.abp_trailer;
create table uprn.abp_trailer (
  RECORD_IDENTIFIER INT,
  NEXT_VOLUME_NUMBER INT NOT NULL,
  RECORD_COUNT BIGINT,
  ENTRY_DATE DATE,
  TIME_STAMP DATETIME

 );
truncate table uprn.abp_trailer;
LOAD DATA LOCAL INFILE 'ID99_Trailer_Records.csv'
INTO TABLE uprn.abp_trailer
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

####################################
# Sanity checks
####################################

# select count(*) from uprn.abp_lpi
# '1048575' Rows
# select * from uprn.abp_lpi;

# select count(*) from uprn.abp_dpa
# '3512745' Rows
# select * from uprn.abp_dpa;

#select count(*) from uprn.abp_class
# '5381317' Rows
# # select * from uprn.abp_class;

# select count(*) from uprn.abp_xref
# '21941817' Rows
# select * from uprn.abp_xref;

# select count(*) from uprn.abp_header
# '42' Rows
# select * from uprn.abp_header;

# select count(*) from uprn.abp_blpu
# '4861145' Rows
#  select * from uprn.abp_blpu;

# select count(*) from uprn.abp_trailer
# '42' Rows
# select * from uprn.abp_trailer;
