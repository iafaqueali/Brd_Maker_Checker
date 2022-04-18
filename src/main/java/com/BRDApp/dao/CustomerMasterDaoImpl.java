package com.BRDApp.dao;

import com.BRDApp.entity.Customer;
import com.BRDApp.entity.CustomerMaster;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;


@SuppressWarnings("deprecation")
@Repository
public class CustomerMasterDaoImpl implements CustomerMasterDao {

    @Autowired
    public SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public CustomerMaster addCustomer(CustomerMaster customerMaster) {
        System.out.println("customer comes in addCustomer method :"+customerMaster);
        Date authorizedDate=new Date();
        customerMaster.setAuthorizedDate(authorizedDate);
//        customerMaster.setRecordStatus("A");
        System.out.println("customer to add in database : "+customerMaster);
        sessionFactory.getCurrentSession().saveOrUpdate(customerMaster);
        System.out.println("successfully added in database!");
        return customerMaster;
    }
    @Override
    public CustomerMaster addCustomer(CustomerMaster customerMaster,String recordStatus,boolean isAuthorizable) {
        System.out.println("customer comes in addCustomer method :"+customerMaster);
        if(isAuthorizable){
            Date authorizedDate=new Date();
            customerMaster.setAuthorizedDate(authorizedDate);
        }
        customerMaster.setRecordStatus(recordStatus);
        System.out.println("customer to add in database : "+customerMaster);
        sessionFactory.getCurrentSession().saveOrUpdate(customerMaster);
        System.out.println("successfully added in database!");
        return customerMaster;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<CustomerMaster> getAllCustomers() {
        System.out.println("~~~~enter in getAllCustomers method in dao~~~~~");
        List<CustomerMaster> customerMasterList=sessionFactory.getCurrentSession().createQuery("from CustomerMaster").list();
//        Session session = sessionFactory.getCurrentSession();
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
//        Root<Customer> root = cq.from(Customer.class);
//        cq.select(root);
//        Query query = session.createQuery(cq);
//        return query.getResultList();
        System.out.println("customerLst in dao from database : "+customerMasterList);
        return customerMasterList;
    }

    @Override
    public CustomerMaster modifyCustomer(CustomerMaster customerMaster) {
        CustomerMaster customer2 = getCustomerByCode(customerMaster.getCustomerCode());

        customer2.setCustomerName(customerMaster.getCustomerName());
        customer2.setCustomerPinCode(customerMaster.getCustomerPinCode());
        customer2.setEmailAddress(customerMaster.getEmailAddress());
        customer2.setContactNumber(customerMaster.getContactNumber());
        customer2.setPrimaryContactPerson(customerMaster.getPrimaryContactPerson());
        customer2.setModifiedBy(customerMaster.getModifiedBy());
        Date modifiedDate=new Date();
        customer2.setModifiedDate(modifiedDate);
        customer2.setRecordStatus("M");

        sessionFactory.getCurrentSession().merge(customer2);
//        System.out.println("customer comes in modifyCustomer method :"+customer);
//        Date modifiedDate=new Date();
//        customer.setModifiedDate(modifiedDate);
//        customer.setRecordStatus("M");
//        System.out.println("customer to update in database : "+customer);
//        sessionFactory.getCurrentSession().merge(customer);
//        return customer;
        return customer2;
    }


    @Override
    public CustomerMaster getCustomerByCode(String customerCode) {
        CustomerMaster customerMaster = new CustomerMaster();

        Query query = sessionFactory.getCurrentSession().createQuery("select c from CustomerMaster c where c.customerCode=:customerCodeParam");

        query.setParameter("customerCodeParam", customerCode);

        @SuppressWarnings("unchecked")
        List<CustomerMaster> customers = query.getResultList();

        if (customers.size() > 0) {

            customerMaster = customers.get(0);

        }
        System.out.println("customerMaster to modify obtained in dao : "+customerMaster);
        return customerMaster;
    }

    @Override
    public Customer searchCustomerById(int customerId) {
        return null;
    }

    @Override
    public void deleteCustomer(String customerCode) {
        try {
            CustomerMaster customerMaster = getCustomerByCode(customerCode);
            sessionFactory.getCurrentSession().delete(customerMaster);
        }catch (Exception e){
            e.printStackTrace();
        }


    }


}
