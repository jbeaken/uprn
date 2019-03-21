# ONS_MATCH

# Average score of all results
select avg(score) from ons_match;

# Total rows
SELECT
  @total := count(*)
FROM
  ons_match;

# Number of matches in each score range
select
       sum(case when score > 0.9 then 1 else 0 end) as "90+",
       sum(case when score > 0.8 and score <= 0.9 then 1 else 0 end) as "80-90",
       sum(case when score > 0.7 and score <= 0.8 then 1 else 0 end) as "70-80",
       sum(case when score > 0.6 and score <= 0.7 then 1 else 0 end) as "60-70",
       sum(case when score > 0.5 and score <= 0.6 then 1 else 0 end) as "50-60",
       sum(case when score > 0.4 and score <= 0.5 then 1 else 0 end) as "40-50",
       sum(case when score > 0.3 and score <= 0.4 then 1 else 0 end) as "30-40",
       sum(case when score <= 0.3 then 1 else 0 end) as "30-"
from
       ons_match;

# Score ranges as percentage
select
  sum(case when score > 0.9 then 1 else 0 end) / @total * 100 as "90+  as %",
  sum(case when score > 0.8 and score <= 0.9 then 1 else 0 end) / @total * 100 as "80-90 as %",
  sum(case when score > 0.7 and score <= 0.8 then 1 else 0 end) / @total * 100 as "70-80 as %",
  sum(case when score > 0.6 and score <= 0.7 then 1 else 0 end) / @total * 100 as "60-70 as %",
  sum(case when score > 0.5 and score <= 0.6 then 1 else 0 end) / @total * 100 as "50-60 as %",
  sum(case when score > 0.4 and score <= 0.5 then 1 else 0 end) / @total * 100 as "40-50 as %",
  sum(case when score > 0.3 and score <= 0.4 then 1 else 0 end) / @total * 100 as "30-40 as %",
  sum(case when score <= 0.3 then 1 else 0 end) / @total * 100 as "30- as %"
from
  ons_match;


# MUMPS_MATCH

select count(*) from mumps_match;
+----------+
| count(*) |
+----------+
|  1514278 |
+----------+

select count(*) from mumps_match where ONS_UPRN != Mumps_UPRN;
+----------+
| count(*) |
+----------+
|    76477 |
+----------+

select count(*) from mumps_match where ONS_UPRN = Mumps_UPRN;
+----------+
| count(*) |
+----------+
|  1437801 |
+----------+

select 1437801 / 1514278;
+-------------------+
| 1437801 / 1514278 |
+-------------------+
|            0.9495 |
+-------------------+

select count(*) from mumps_match where ONS_UPRN = '';
+----------+
| count(*) |
+----------+
|     2256 |
+----------+

select  "Discovery_Address",
  "ONS_Score",
  "ONS_ABP_Address",
  "ONS_UPRN",
  "ONS_Classification",
  "Mumps_UPRN",
  "Mumps_ABP_Address",
  "Mumps_ID",
  "Mumps_Algorithm",
  "Mumps_Qualifier",
  "Mumps_Table",
  "Mumps_Key",
  "Discovery_Line1",
  "Discovery_Line2",
  "Discovery_Line3",
  "Discovery_Line4",
  "Discovery_County",
  "Discovery_Postcode"
UNION
select * from mumps_match where ONS_UPRN = ''
INTO OUTFILE '/var/lib/mysql-files/mumps_match_ons_nomatch_.csv'
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n';

select  "Discovery_Address",
        "ONS_Score",
        "ONS_ABP_Address",
        "ONS_UPRN",
        "ONS_Classification",
        "Mumps_UPRN",
        "Mumps_ABP_Address",
        "Mumps_ID",
        "Mumps_Algorithm",
        "Mumps_Qualifier",
        "Mumps_Table",
        "Mumps_Key",
        "Discovery_Line1",
        "Discovery_Line2",
        "Discovery_Line3",
        "Discovery_Line4",
        "Discovery_County",
        "Discovery_Postcode"
UNION
select * from mumps_match where ONS_UPRN != Mumps_UPRN
INTO OUTFILE '/var/lib/mysql-files/mumps_ons_different_uprn.csv'
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n';





