package com.BRDApp.dao;

import com.BRDApp.entity.Customer;

import java.util.List;

public interface CustomerDao {
    Customer addCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer modifyCustomer(Customer customer);
    Customer modifyCustomer(Customer customer,String recordStatus);
    void deleteCustomer(String customerCode);
     Customer getCustomerByCode(String customerCode);
     Customer searchCustomerById(int customerId);

}
