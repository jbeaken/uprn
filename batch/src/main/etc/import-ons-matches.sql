-- drop table uprn.ons_match;

create table uprn.ons_match(
       DiscoveryAddress VARCHAR(255),
       Score  DECIMAL(6,2),
       ONSAddress varchar(255),
       UPRN varchar(30),
       Status varchar(30),
       Classification varchar(30),
       Line1 varchar(30),
       Line2 varchar(30),
       Line3 varchar(30),
       Line4 varchar(30),
       County varchar(30),
       Postcode varchar(30),
       OrgPostcode varchar(30),
       PseudoPersonid BIGINT

);

LOAD DATA LOCAL INFILE '/media/ext/LearningHealth/output2.csv'
  INTO TABLE uprn.ons_match
  FIELDS TERMINATED BY ','
  ENCLOSED BY '"'
  LINES TERMINATED BY '\n'
  IGNORE 1 ROWS;

-- alter table address add column onsAddress VARCHAR(255);
-- alter table address add column score INT;
