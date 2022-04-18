package com.BRDApp.service;

import com.BRDApp.dao.CustomerMasterDao;
import com.BRDApp.entity.Customer;
import com.BRDApp.entity.CustomerMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomeMasterServiceImpl implements CustomerMasterService {


    @Autowired
    private CustomerMasterDao dao;

    public CustomerMasterDao getDao() {
        return dao;
    }

    public void setDao(CustomerMasterDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public CustomerMaster addCustomer(CustomerMaster customerMaster) {
        return dao.addCustomer(customerMaster);
    }

//

    @Override
    @Transactional
    public CustomerMaster addCustomer(CustomerMaster customerMaster, String recordStatus, boolean isAuthorizable) {
        return dao.addCustomer(customerMaster,recordStatus,isAuthorizable);
    }

    @Override
    @Transactional
    public List<CustomerMaster> getAllCustomers() {
        return dao.getAllCustomers();
    }

    @Override
    @Transactional
    public CustomerMaster modifyCustomer(CustomerMaster customerMaster) {
        return dao.modifyCustomer(customerMaster);
    }

    @Override
    @Transactional
    public Customer searchCustomerById(int customerId) {
        return null;
    }

    @Override
    @Transactional
    public CustomerMaster getCustomerByCode(String customerCode) {
        return dao.getCustomerByCode(customerCode);
    }

    @Override
    @Transactional
    public void deleteCustomer(String customerCode)
    {
        dao.deleteCustomer(customerCode);
    }


}
