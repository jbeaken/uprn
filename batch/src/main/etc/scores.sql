# Scores
select ONSAddress, DiscoveryAddress, Score, Classification
from ons_match where
  Score > 0.9
limit 100;

select ONSAddress, DiscoveryAddress, Score, Classification
from ons_match where
  Score between  0.6 and 0.7
limit 100;

select ONSAddress, DiscoveryAddress, Score, Classification
from ons_match where
  Score between  0.5 and 0.6
limit 100;

select ONSAddress, DiscoveryAddress, Score, Classification
from ons_match where
  Score < 0.5 and ONSAddress != ''
limit 100;



# Minimum

select count(*) from ons_match where score > 0.59;

