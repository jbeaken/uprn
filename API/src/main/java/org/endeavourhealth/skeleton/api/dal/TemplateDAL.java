package org.endeavourhealth.skeleton.api.dal;


import org.endeavourhealth.propertymanager.model.DiscoveryAddress;

import java.util.List;

public interface TemplateDAL {

    List<DiscoveryAddress> getAddresses();
}
