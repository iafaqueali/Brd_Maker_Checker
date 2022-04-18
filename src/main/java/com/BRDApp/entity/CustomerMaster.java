package com.BRDApp.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
//@Repository
@Entity
@Table(name = "customer_brd_app_master_tbl")
public class CustomerMaster {
    //customer id--------------------------------------------
//    @NotEmpty
//    @NotBlank
//    @NotNull

    //    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @NotEmpty
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @Size(min = 1, max = 10)
//    @Column(name = "customer_id",unique = true,nullable = false,insertable = false,updatable = false)
    @Column(name = "customer_id")
    private int customerID;




    //customer code-------------------------------------
    @Id
    @Pattern(regexp = "^[a-zA-Z0-9]+$")  // alpha numeric
    @Column(nullable = false, unique = true,name = "customer_code")
    private String customerCode;

    //customer name-------------------------------------
//    @NotEmpty
    @Size(min = 1, max = 30)
//    @Pattern(regexp = "^[a-zA-Z0-9]+$")  // alpha numeric
    @Column(length = 30,name = "customer_name",nullable = false)
    private String customerName;

    //customer Address 1 ---------- mandatory---------------------------
//    @NotEmpty
    @Size(min = 1, max = 100)
    @Pattern(regexp = "^[a-zA-Z0-9]+$")  // alpha numeric
    @Column(length = 100,name = "customer_address_1",nullable = false)
    private String customerAddress1;

    //customer Address 2 -------------- not mandatory-----------------------
    @Size(min = 1, max = 100)
    @Pattern(regexp = "^[a-zA-Z0-9]+$")  // alpha numeric
    @Column(length = 100,name = "customer_address_2")
    private String customerAddress2;

    //customer pin code  -------------------------------------
//    @NotEmpty
    @Column(length = 6,name = "customer_pin_code",nullable = false)
    @Size(min = 6, max = 6) //since pin code is of 6 digit so,min=6 and max=6
    @Pattern(regexp = "(^$|[0-9]{6})")
    private String customerPinCode;

    //email address -------------------------------------
//    @NotEmpty
    @Email
//    @Pattern(regexp = "^[a-zA-Z0-9]+$")  // alpha numeric
    @Column(name = "email_address",nullable = false)
    private String emailAddress;

    //contact number-------------------------------------
//    @NotEmpty
    @Size(min = 10, max = 10) //phone no is of length 10
    @Pattern(regexp = "(^$|[0-9]{10})")
    @Column(length = 10,name = "contact_number")
    private String contactNumber;

    //primary contact person

    //    @NotEmpty
    @Size(min = 1,max = 100)
//    @Pattern(regexp = "^[a-zA-Z0-9]+$")  // alpha numeric
    @Column(length = 100,name ="primary_contact_person",nullable = false)
    private String primaryContactPerson;


    //record status
//    @NotEmpty
    @Size(min = 1,max = 2)
    @Column(length = 100,name ="record_status",nullable = false)
    private String recordStatus;

    // Active/inactive flag
//    @NotEmpty
    @Size(min = 1,max = 1)
    @Column(length = 100,name ="is_active",nullable = false)
    private String isActive;

    //create date

//    @NotEmpty
@Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date createdDate;

    //created by

    //    @NotEmpty
    @Size(min = 1,max = 30)
//    @Pattern(regexp = "^[a-zA-Z0-9]+$")  // alpha numeric
    @Column(length = 30,name = "created_by",nullable = false)
    private String createdBy;

    //modified date
    @Temporal(TemporalType.DATE)
    @Column(name = "modified_date")
    private Date modifiedDate;

    //modified by
    @Size(min = 1,max = 30)
//    @Pattern(regexp = "^[a-zA-Z0-9]+$")  // alpha numeric
    @Column(length = 30,name = "modified_by")
    private String modifiedBy;

    //authorized date
    @Temporal(TemporalType.DATE)
    @Column(name = "authorized_date")
    private Date authorizedDate;

    //authorized by
    @Size(min = 1,max = 30)
//    @Pattern(regexp = "^[a-zA-Z0-9]+$")  // alpha numeric
    @Column(length = 30,name = "authorized_by")
    private String authorizedBy;

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress1() {
        return customerAddress1;
    }

    public void setCustomerAddress1(String customerAddress1) {
        this.customerAddress1 = customerAddress1;
    }

    public String getCustomerAddress2() {
        return customerAddress2;
    }

    public void setCustomerAddress2(String customerAddress2) {
        this.customerAddress2 = customerAddress2;
    }

    public String getCustomerPinCode() {
        return customerPinCode;
    }

    public void setCustomerPinCode(String customerPinCode) {
        this.customerPinCode = customerPinCode;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPrimaryContactPerson() {
        return primaryContactPerson;
    }

    public void setPrimaryContactPerson(String primaryContactPerson) {
        this.primaryContactPerson = primaryContactPerson;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getAuthorizedDate() {
        return authorizedDate;
    }

    public void setAuthorizedDate(Date authorizedDate) {
        this.authorizedDate = authorizedDate;
    }

    public String getAuthorizedBy() {
        return authorizedBy;
    }

    public void setAuthorizedBy(String authorizedBy) {
        this.authorizedBy = authorizedBy;
    }

    public CustomerMaster() {
    }

    public CustomerMaster(Customer customer) {
        this.customerID = customer.getCustomerID();
        this.customerCode = customer.getCustomerCode();
        this.customerName = customer.getCustomerName();
        this.customerAddress1 = customer.getCustomerAddress1();
        this.customerAddress2 = customer.getCustomerAddress2();
        this.customerPinCode = customer.getCustomerPinCode();
        this.emailAddress = customer.getEmailAddress();
        this.contactNumber = customer.getContactNumber();
        this.primaryContactPerson = customer.getPrimaryContactPerson();
        this.recordStatus = customer.getRecordStatus();
        this.isActive = customer.getIsActive();
        this.createdDate = customer.getCreatedDate();
        this.createdBy = customer.getCreatedBy();
        this.modifiedDate = customer.getModifiedDate();
        this.modifiedBy = customer.getModifiedBy();
        this.authorizedDate = customer.getAuthorizedDate();
        this.authorizedBy = customer.getAuthorizedBy();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", customerCode='" + customerCode + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerAddress1='" + customerAddress1 + '\'' +
                ", customerAddress2='" + customerAddress2 + '\'' +
                ", customerPinCode='" + customerPinCode + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", primaryContactPerson='" + primaryContactPerson + '\'' +
                ", recordStatus='" + recordStatus + '\'' +
                ", isActive='" + isActive + '\'' +
                ", createdDate=" + createdDate +
                ", CreatedBy='" + createdBy + '\'' +
                ", modifiedDate=" + modifiedDate +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", authorizedDate=" + authorizedDate +
                ", authorizedBy='" + authorizedBy + '\'' +
                '}';
    }
}
