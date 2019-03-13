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

