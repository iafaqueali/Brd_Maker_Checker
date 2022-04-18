package com.BRDApp.service;

import com.BRDApp.dao.CustomerDao;
import com.BRDApp.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{


    @Autowired
    private CustomerDao dao;

    public CustomerDao getDao() {
        return dao;
    }

    public void setDao(CustomerDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public Customer addCustomer(Customer customer) {
        return dao.addCustomer(customer);
    }

    @Override
    @Transactional
    public List<Customer> getAllCustomers() {
        return dao.getAllCustomers();
    }

    @Override
    @Transactional
    public Customer modifyCustomer(Customer customer) {
        return dao.modifyCustomer(customer);
    }

    @Override
    @Transactional
    public Customer modifyCustomer(Customer customer, String recordStatus) {
        return dao.modifyCustomer(customer,recordStatus);
    }

    @Override
    @Transactional
    public Customer searchCustomerById(int customerId) {
        return null;
    }

    @Override
    @Transactional
    public Customer getCustomerByCode(String customerCode) {
        return dao.getCustomerByCode(customerCode);
    }

    @Override
    @Transactional
    public void deleteCustomer(String customerCode)
    {
       dao.deleteCustomer(customerCode);
    }


}
