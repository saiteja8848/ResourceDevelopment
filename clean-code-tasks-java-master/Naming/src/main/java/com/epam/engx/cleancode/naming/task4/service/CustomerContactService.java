package com.epam.engx.cleancode.naming.task4.service;


import com.epam.engx.cleancode.naming.task4.thirdpartyjar.CustomerContact;

public interface CustomerContactService {

    CustomerContact getCustomerContactDetails(Long customerId);

    void updateCustomerContactDetails(CustomerContact CustomerContact);

}
