# select d.postcode, b.postcode_locator from abp_blpu b join abp_dpa d on d.uprn = b.uprn where d.postcode != b.postcode_locator;


-- insert dpa record
# Post code -> BLPU – Post code
# Locality -> locality  ??what
# Dependent locality -> dependent locality
# Street -> thoroughfare
# Dependent thoroughfare -> Dependent thoroughfare
# Number -> Building number
# Building name or house name -> Building
# Flat number and flat number prefix -> sub building
# uprn
# type (d = dpa)


select b.POSTCODE,    # Post code
       d.DEPENDENT_LOCALITY,   # Locality  ??what
       d.DEPENDENT_LOCALITY,  # Dependent locality
       d.THOROUGHFARE,  # Street
       d.DEPENDENT_THOROUGHFARE,  # Dependent thoroughfare
       d.BUILDING_NUMBER,  # Number
       d.BUILDING_NAME,  # Building name or house name
       d.SUB_BUILDING_NAME,  # Flat number and flat number prefix
       d.UPRN,
       "D"
from blpu b
join dpa d on d.uprn = b.uprn
limit 200;

-- insert lpi record
# Post code -> BLPU – Post code
# Locality -> Street Descriptor-> Locality
# Dependent locality -> null
# Street -> Street Descriptor / Street
# Dependent thoroughfare -> null
# Number -> Pao start + pao suffix ..{+ - “-“} + pao end + pao end suffix e.g. 45a-56b 45
# Building name or house name -> PAO text
# Flat number and flat number prefix -> Either Sao start + sao start suffix +- {“-“} + sao end + sao end suffix  e.g. 1a- 1b 1a 1 Or sao text e.g. flat 1
# uprn
# type (l = lpi)
select b.POSTCODE_LOCATOR,
       sd.LOCALITY_NAME,   # Rename to locality?
       null,  # Dependent locality
       sd.STREET_DESCRIPTION, # Street
       null, # Dependent thoroughfare -> null
       case
              when l.PAO_START_NUMBER = '' and  l.PAO_END_NUMBER = '' then l.PAO_TEXT
              when l.PAO_START_NUMBER != '' and  l.PAO_END_NUMBER = '' then concat( l.PAO_START_NUMBER, l.PAO_START_SUFFIX )
              else concat( l.PAO_START_NUMBER, l.PAO_START_SUFFIX, "-", l.PAO_END_NUMBER, l.PAO_END_SUFFIX )
              end,
       l.PAO_TEXT, # Building name or house name
       case
              when l.SAO_START_NUMBER = '' and  l.SAO_END_NUMBER = '' then l.SAO_TEXT
              when l.SAO_START_NUMBER != '' and  l.SAO_END_NUMBER = '' then concat( l.SAO_START_NUMBER, l.SAO_START_SUFFIX )
              else concat( l.SAO_START_NUMBER, l.SAO_START_SUFFIX, "-", l.SAO_END_NUMBER, l.SAO_END_SUFFIX )
              end,
       l.SAO_START_SUFFIX,
       b.UPRN,
       "L"

from blpu b
  join lpi l on l.uprn = b.uprn
  join street s on l.usrn = s.USRN
  join streetdesc sd on s.usrn
limit 200;



# Tester
select
       b.uprn,
       case
              when l.PAO_START_NUMBER = '' and  l.PAO_END_NUMBER = '' then l.PAO_TEXT
              when l.PAO_START_NUMBER != '' and  l.PAO_END_NUMBER = '' then concat( l.PAO_START_NUMBER, l.PAO_START_SUFFIX )
              else concat( l.PAO_START_NUMBER, l.PAO_START_SUFFIX, "-", l.PAO_END_NUMBER, l.PAO_END_SUFFIX )
              end,

       case
              when l.SAO_START_NUMBER = '' and  l.SAO_END_NUMBER = '' then l.SAO_TEXT
              when l.SAO_START_NUMBER != '' and  l.SAO_END_NUMBER = '' then concat( l.SAO_START_NUMBER, l.SAO_START_SUFFIX )
              else concat( l.SAO_START_NUMBER, l.SAO_START_SUFFIX, "-", l.SAO_END_NUMBER, l.SAO_END_SUFFIX )
              end,

       "L"

from blpu b
            join lpi l on l.uprn = b.uprn
            join street s on l.usrn = s.USRN
            join streetdesc sd on s.usrn
limit 20;

select PAO_START_NUMBER, PAO_START_SUFFIX, PAO_END_NUMBER, PAO_END_SUFFIX, PAO_TEXT from lpi where uprn = 10014292169;
select SAO_START_NUMBER, SAO_START_SUFFIX, SAO_END_NUMBER, SAO_END_SUFFIX, SAO_TEXT from lpi where uprn = 10014292169;