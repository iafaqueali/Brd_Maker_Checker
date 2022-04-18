package com.BRDApp.service;

import com.BRDApp.entity.Customer;
import com.BRDApp.entity.CustomerMaster;

import java.util.List;

public interface CustomerMasterService {
    CustomerMaster addCustomer(CustomerMaster customerMaster);
    CustomerMaster addCustomer(CustomerMaster customerMaster,String recordStatus,boolean isAuthorizable);
    List<CustomerMaster> getAllCustomers();
    CustomerMaster modifyCustomer(CustomerMaster customerMaster);
    Customer searchCustomerById(int customerId);
    CustomerMaster getCustomerByCode(String customerCode);
    void deleteCustomer(String customerCode);

}
