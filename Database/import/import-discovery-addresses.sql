-- "OrgPostcode","PersonPseudoId","AddressLine1","AddressLine2","AddressLine3","AddressLine4","County","Postcode"

drop table uprn.address;

create table uprn.address (
     originalPostcode VARCHAR(35),
     id BIGINT,
     line1 VARCHAR(255),
     line2 VARCHAR(255),
     line3 VARCHAR(255),
     line4 VARCHAR(255),
     county VARCHAR(35),
     postcode VARCHAR(35)
);

LOAD DATA LOCAL INFILE '/media/ext/LearningHealth/address_extract2.csv'
  INTO TABLE uprn.address
  FIELDS TERMINATED BY ','
  ENCLOSED BY '"'
  LINES TERMINATED BY '\n'
  IGNORE 1 ROWS;

alter table address add column onsAddress VARCHAR(255);
alter table address add column score INT;
