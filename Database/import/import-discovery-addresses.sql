drop table uprn.address;

create table uprn.address (
     originalPostcode VARCHAR(255),
     id BIGINT PRIMARY KEY,
     line1 VARCHAR(255),
     line2 VARCHAR(255),
     line3 VARCHAR(255),
     line4 VARCHAR(255),
     county VARCHAR(255),
     postcode  VARCHAR(255),
     onsAddress VARCHAR(255),
     score INT
);



LOAD DATA LOCAL INFILE '/media/ext/LearningHealth/address_extract.csv'
  INTO TABLE uprn.address
  FIELDS TERMINATED BY ','
  ENCLOSED BY '"'
  LINES TERMINATED BY '\n'
  IGNORE 1 ROWS;