package com.BRDApp.service;

import com.BRDApp.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer addCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer modifyCustomer(Customer customer);
    Customer modifyCustomer(Customer customer,String recordStatus);
    Customer searchCustomerById(int customerId);
    Customer getCustomerByCode(String customerCode);
    void deleteCustomer(String customerCode);

}
