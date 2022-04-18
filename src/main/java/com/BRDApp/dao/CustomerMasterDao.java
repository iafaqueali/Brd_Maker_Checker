package com.BRDApp.dao;

import com.BRDApp.entity.Customer;
import com.BRDApp.entity.CustomerMaster;

import java.util.List;

public interface CustomerMasterDao {
    CustomerMaster addCustomer(CustomerMaster customerMaster);
    CustomerMaster addCustomer(CustomerMaster customerMaster,String recordStatus,boolean isAuthorizable);
    List<CustomerMaster> getAllCustomers();
    CustomerMaster modifyCustomer(CustomerMaster customerMaster);
    void deleteCustomer(String customerCode);
    CustomerMaster getCustomerByCode(String customerCode);
    Customer searchCustomerById(int customerId);

}
