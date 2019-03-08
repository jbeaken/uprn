package org.endeavourhealth.propertymatcher.repository;

import java.util.List;

import org.endeavourhealth.propertymatcher.domain.Address;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long>{

	List<Address> findAll(Pageable pageable);
}
