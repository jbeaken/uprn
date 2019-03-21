use ceg_analysis_data;

-- Holds unique original codes in utf8_bin (case sensitive)
create table original_code (
	id bigint primary key auto_increment,
  original_code varchar(20) character set utf8 collate utf8_bin not null unique -- varchar(?) where ? should be as small as possible
);
insert into original_code (original_code) select distinct binary original_code from ceg_compass_data.observation;

-- build join table between ceg_compass_data.observations and orginal_code
create table observation_original_code (
	observation_id bigint,
  original_code_id bigint,
  foreign key (observation_id) references ceg_compass_data.observation(id),
  foreign key (original_code_id) references original_code(id)
);

-- Populate observation_original_code join table
insert into observation_original_code (observation_id, original_code_id)
 select ob.id, oc.id
 from ceg_compass_data.observation ob
 join original_code oc on oc.original_code = ob.original_code;

-- ### THE QUERY ###
-- Smoking query, using join table to enable case sensitivity and speed up query time
SELECT
 ec.person_id,
 oc.original_code,
 ob.clinical_effective_date
FROM
 ceg_compass_data.episode_of_care ec
 INNER JOIN ceg_compass_data.observation ob ON ec.person_id = ob.person_id
 INNER JOIN observation_original_code obor ON obor.observation_id = ob.id
 INNER JOIN original_code oc ON obor.original_code_id = oc.id
 WHERE
 oc.original_code LIKE '137%'
AND
 oc.original_code  NOT IN ('137D', '137E', '137i', '137I', '137k', '137o', '137U', '137W', 'EMISNQSM14', 'EMISNQSN1')
 ORDER BY ec.person_id;
