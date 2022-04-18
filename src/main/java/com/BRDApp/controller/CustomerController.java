package com.BRDApp.controller;

import com.BRDApp.entity.Customer;
import com.BRDApp.entity.CustomerMaster;
import com.BRDApp.entity.User;
import com.BRDApp.service.CustomerService;
import com.BRDApp.service.CustomerMasterService;
import com.BRDApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping
public class CustomerController {

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerService customerService;

  @Autowired
  private CustomerMasterService customerMasterService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public CustomerMasterService getCustomerMasterService() {
        return customerMasterService;
    }

    public void setCustomerMasterService(CustomerMasterService customerMasterService) {
        this.customerMasterService = customerMasterService;
    }

    //    testing purpose
    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("noneUser","noneUser");
        return "homePage";
    }
    @RequestMapping("/")
    public String redirectToHome(Model model){
        model.addAttribute("noneUser","noneUser");
        return "redirect:/BRD-maker-checker-app/home";
    }
    @RequestMapping("/customerentryform")
    public String customerEntryForm(){
        return "customerEntryForm";
    }
    @RequestMapping("/userregistrationform")
    public String userRegistrationForm(Model model){

        model.addAttribute("user", new User());
        Map<String, String> roleTypeItems = new LinkedHashMap<String, String>();
        roleTypeItems.put("M", "Maker");
        roleTypeItems.put("C", "Checker");
         model.addAttribute("roleTypeItems",roleTypeItems);
        return "userRegistrationForm";
    }


    @RequestMapping(value = "/saveuser",method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {

            return "userRegistrationForm";
        }

        else {

            System.out.println("user in saveUser method : " + user);
            userService.save(user);

            return "redirect:/home";
        }
    }
//
    @RequestMapping("/loginform")
    public String showLoginForm(Model model){
        model.addAttribute("user", new User());
        Map<String, String> roleTypeItems = new LinkedHashMap<String, String>();
        roleTypeItems.put("M", "Maker");
        roleTypeItems.put("C", "Checker");
        model.addAttribute("roleTypeItems",roleTypeItems);
        return "loginForm";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String loginUser(@ModelAttribute("user") User user,@ModelAttribute("customer") Customer customer, Model model, HttpSession session){
        System.out.println("enter into loginUser method");
            System.out.println("inside user loginUser method : " + user);
            Boolean isLogin = userService.loginUser(user);
            System.out.println("isLogin : " + isLogin);
            if (isLogin) {
                model.addAttribute("loggedUser", user);
                String role=user.getRoleType();
                String maker=null;
                String checker=null;
                System.out.println("role is : "+role);
                if (role.equals("M")){
                    maker=user.getUsername();
                    System.out.println("Maker role found!");
                    model.addAttribute("maker",maker);
                    model.addAttribute("customer",new Customer());
                    Map<String, String> flagStatus = new LinkedHashMap<String, String>();
                    flagStatus.put("1", "Active");
                    flagStatus.put("0", "InActive");
                    model.addAttribute("flagStatus",flagStatus);

                }else if (role.equals("C")){
                    checker=user.getUsername();
                    System.out.println("checker role found!");
                    model.addAttribute("checker",checker);
                }

//                session.setAttribute("loggedUser", loggedUser);
                return "homePage";
            }else{
                System.out.println("invalid credentionls : " + user);
                model.addAttribute("invalidCredentionls", "Invalid Credentials");
                return "redirect:/loginform";
            }
    }

    @RequestMapping(value = "/addcustomer",method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute("customer") Customer customer,Model model){

        System.out.println("customer comes in controller :"+customer);
       Customer addedCustomer= customerService.addCustomer(customer);
        System.out.println("added customer : "+customer);
        if (addedCustomer!=null){
            model.addAttribute("addedCustomer",addedCustomer);
            model.addAttribute("maker",addedCustomer.getCreatedBy());
            model.addAttribute("customerSuccessfullyAdd","customer Details Successfully Added");
            return "homePage";
        }else{
            model.addAttribute("errMsg","something went wrong!");
            return "errPage";
        }
    }
    @RequestMapping("showcustomers/{username}")
        public String showCustomers(@PathVariable String username,Model model){
       List<Customer> customerTempLst= customerService.getAllCustomers();
       List<CustomerMaster> customerMasterLst= customerMasterService.getAllCustomers();
        System.out.println("customerLst comes from dao in controller : "+customerTempLst);
        model.addAttribute("customerTempLst",customerTempLst);
        model.addAttribute("customerMasterLst",customerMasterLst);
        model.addAttribute("username",username);
        return "showCustomer";

        }
    @RequestMapping(value = "/searchResultByStatus")
    public String searchResultByStatus(HttpServletRequest req, Model model){
        String recordStatus=req.getParameter("recordStatus");
        String flagStatus=req.getParameter("flagStatus");
//        model.addAttribute("recordStatus",recordStatus);
        System.out.println("recordStatus to show : "+recordStatus);
        List<Customer> tempLst= customerService.getAllCustomers();
        List<CustomerMaster> masterLst= customerMasterService.getAllCustomers();
        List<Customer> customerTempLst=new ArrayList<>();
        List<CustomerMaster> customerMasterLst=new ArrayList<>();
        for (Customer customer:tempLst){
            if (customer.getRecordStatus().equals(recordStatus) && customer.getIsActive().equals(flagStatus)){
                customerTempLst.add(customer);
            }
        }
        for (CustomerMaster customerMaster:masterLst){
            if (customerMaster.getRecordStatus().equals(recordStatus) && customerMaster.getIsActive().equals(flagStatus)){
                customerMasterLst.add(customerMaster);
            }
        }
        System.out.println("customerLst comes from dao in controller : "+customerTempLst);
        model.addAttribute("customerTempLst",customerTempLst);
        model.addAttribute("customerMasterLst",customerMasterLst);
//        model.addAttribute("username",username);
     return "searchResultByStatus";
    }
//  @RequestMapping("showcustomers")
//    public String showCustomers(@ModelAttribute("user") User user, Model model){
//        List<Customer> customerLst= customerService.getAllCustomers();
//        System.out.println("customerLst comes from dao in controller : "+customerLst);
//        model.addAttribute("customerLst",customerLst);
//      System.out.println(" user is : "+user.getUsername());
//        return "showCustomer";
//    }



    @RequestMapping(value="/modifycustomerform/{customerCode}/{username}")
    public String modifyCustomerForm(@PathVariable String customerCode, @PathVariable String username, Model model){
//        System.out.println("customerCode : "+customerCode);
        Customer customer=customerService.getCustomerByCode(customerCode);
        System.out.println("customer to modify comes in controller : "+customer);
        model.addAttribute("customer",customer);
        System.out.println("username is : "+username);
//        System.out.println("customerCode : "+customerCode);
        model.addAttribute("username",username);
//        System.out.println("maker is : "+maker);
        return "modifyCustomerForm";
    }
    @RequestMapping(value="/modifycustomerfrommasterform/{customerCode}/{username}")
    public String modifyCustomerMasterForm(@PathVariable String customerCode, @PathVariable String username, Model model){
//        System.out.println("customerCode : "+customerCode);
        Customer customer=customerService.getCustomerByCode(customerCode);
        System.out.println("customer to modify comes in controller : "+customer);
        model.addAttribute("customer",customer);
        System.out.println("username is : "+username);
//        System.out.println("customerCode : "+customerCode);
        model.addAttribute("username",username);
//        System.out.println("maker is : "+maker);
        return "modifyCustomerFromMasterForm";
    }
    @RequestMapping(value = "/modifycustomer",method = RequestMethod.POST)
    public String modifyCustomer(@ModelAttribute("customer") Customer customer, Model model){

        System.out.println("customer comes in controller in modify method:"+customer);
        Customer modifiedCustomer= customerService.modifyCustomer(customer);
        System.out.println("modified customer : "+modifiedCustomer);
        if (modifiedCustomer!=null){
            return "redirect:/showcustomers/"+modifiedCustomer.getModifiedBy();
        }else{
            model.addAttribute("errMsg","something went wrong!");
            return "errPage";
        }
    }
    @RequestMapping(value = "/modifycustomerfrommaster",method = RequestMethod.POST)
    public String modifyCustomerFromMaster(@ModelAttribute("customer") Customer customer, Model model){

        System.out.println("customer comes in controller in modify method:"+customer);
        Customer modifiedCustomer= customerService.addCustomer(customer);
        System.out.println("modified customer : "+modifiedCustomer);
        if (modifiedCustomer!=null){
            return "redirect:/showcustomers/"+modifiedCustomer.getModifiedBy();
        }else{
            model.addAttribute("errMsg","something went wrong!");
            return "errPage";
        }
    }
    @RequestMapping(value="/deletecustomer/{customerCode}/{recordStatus}/{username}")
    public String deleteCustomer(@PathVariable String customerCode,@PathVariable String recordStatus,@PathVariable String username){

       if(recordStatus.equals("N")){
           customerService.deleteCustomer(customerCode);
       }
      if (recordStatus.equals("M")){
          Customer customer=customerService.getCustomerByCode(customerCode);
          CustomerMaster customerMaster=new CustomerMaster(customer);
          customerMasterService.addCustomer(customerMaster,"A",true);
          customerService.deleteCustomer(customerCode);

      }
      if (recordStatus.equals("NR")){
          customerService.deleteCustomer(customerCode);
//          customerMasterService.deleteCustomer(customerCode);
      }
      if (recordStatus.equals("MR")){
              customerService.deleteCustomer(customerCode);
      }
      if (recordStatus.equals("A")){
          Customer customer=customerService.getCustomerByCode(customerCode);
          customerService.modifyCustomer(customer,"D");
      }

//        String tmp="maker1";
        return "redirect:/showcustomers/"+username;
    }

//    checker section-------------------------

    @RequestMapping("showcustomersbychecker/{username}")
    public String showCustomersByChecker(@PathVariable String username,Model model){
        List<Customer> customerTempLst= customerService.getAllCustomers();
        List<CustomerMaster> customerMasterLst= customerMasterService.getAllCustomers();
        System.out.println("customerLst comes from dao in controller : "+customerTempLst);
        model.addAttribute("customerTempLst",customerTempLst);
        model.addAttribute("customerMasterLst",customerMasterLst);
        model.addAttribute("username",username);
        return "showCustomerByChecker";
    }
//    authorizecustomer
@RequestMapping(value="/authorizecustomer/{customerCode}/{recordStatus}/{username}")
public String authorizeCustomer(@PathVariable String customerCode,@PathVariable String recordStatus,@PathVariable String username){
       if (recordStatus.equals("N") || recordStatus.equals("M")){
           Customer customer=customerService.getCustomerByCode(customerCode);
           CustomerMaster customerMaster=new CustomerMaster(customer);
           customerMaster.setAuthorizedBy(username);
           customerMasterService.addCustomer(customerMaster);
           customerService.deleteCustomer(customerCode);
       }



//        String tmp="maker1";
    return "redirect:/showcustomersbychecker/"+username;
}
    @RequestMapping(value="/rejectcustomer/{customerCode}/{recordStatus}/{username}")
    public String rejectCustomer(@PathVariable String customerCode,@PathVariable String recordStatus,@PathVariable String username){
        if (recordStatus.equals("N")){
            Customer customer=customerService.getCustomerByCode(customerCode);
           Customer modifiedCustomer= customerService.modifyCustomer(customer,"NR");
        }
        if (recordStatus.equals("M")){
            Customer customer=customerService.getCustomerByCode(customerCode);
            Customer modifiedCustomer= customerService.modifyCustomer(customer,"MR");
            CustomerMaster customerMaster=new CustomerMaster(modifiedCustomer);
//           CustomerMaster customerMaster2= customerMasterService.addCustomer(customerMaster,"R");
           CustomerMaster customerMaster2= customerMasterService.addCustomer(customerMaster,"MR",false);

        }
//        String tmp="maker1";
        return "redirect:/showcustomersbychecker/"+username;
    }
}


