
package com.oracle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.oracle.model.Customer;
import com.oracle.service.CustomerService;



@Controller
public class CustomerController {
//	public String addCustomer() {
//		return "addCustomer";
//	}

	@Autowired
	 private CustomerService service;
	// @Autowired
	// private Customer customer;

	@GetMapping("/home")
	public String home() {
		return "home pauk walker";
	}
	@PostMapping("/signup")
	public void signup(@RequestBody Customer customer) {
		// Logic for signup can be added here
	}
	@PostMapping("/login")
	public void login(@RequestBody Customer customer) {
		// Logic for signup can be added here
	}

	//open customer form
	@GetMapping("/addCustomer.view")
	public String addCustomer() {
		return "addCustomer";
	}
	//
	@PostMapping("/saveCustomer.do")
	
		public String saveCustomer(@ModelAttribute("customer") Customer customer,Model model) //model attribute define in html for fetching exact date
		{
			service.saveCustomer(customer);
			List<Customer> customerList=service.findAllCustomers();
			model.addAttribute("customerList",customerList);
			return "customers";  //we pass model to jsp of all details of custoyy
		}
	
	
	@GetMapping("/customers")
	public String getAllCustomer(Model model) {
		List<Customer> customerList=service.findAllCustomers();
		System.out.println(customerList);
		model.addAttribute("customerList",customerList);
		System.out.println(model);
		return "customers";  //we pass model to jsp of all details of custoyy
	}
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("id") String id, Model model) {
	    service.removeCustomer(id);
	    List<Customer> customerList = service.findAllCustomers();
	    model.addAttribute("customerList", customerList);
	    return "customers";
	}
	
	@GetMapping("/editCustomer")
	public String editCustomer(@RequestParam("id") String id, Model model) {
	    Customer customer = service.findCustomerById(id);
	    model.addAttribute("customer", customer);
	    return "updateCustomer";  // This is your JSP form (update.jsp)
	}

	@PostMapping("/updateCustomer")
	public String updateCustomer(@ModelAttribute("customer") Customer customer, Model model) {
	    service.modifyCustomer(customer);
	    List<Customer> customerList = service.findAllCustomers();
	    model.addAttribute("customerList", customerList);
	    return "customers";
	}



	
}
