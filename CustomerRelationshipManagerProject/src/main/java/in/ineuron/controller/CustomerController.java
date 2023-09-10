package in.ineuron.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ineuron.model.Customer;
import in.ineuron.service.ICustomerService;

@Controller
@RequestMapping(value="/customer")
public class CustomerController {

	@Autowired
	private ICustomerService service;
	
	@GetMapping(value="/list")
	public String showCustomers(Map<String, Object> model) {
		Iterable<Customer> i=service.getAllCustomers();
		
		i.forEach(System.out::println);
		model.put("customers", i);
		
		//	return "listCustomers"; for jsp view 
		
		return "/customers/listCustomers";	// for thymeLeaf view
	}
	
	@GetMapping(value="/addForm")
	public String getCustomerFormForAdd(Map<String, Object> model) {
		Customer obj=new Customer();	// as to use the customer object fields in form, form will have empty fields as customer object is also not initialized
		
		model.put("customer", obj);
		
		// for jsp view
		//	return "customerForm"; // same customerForm will be displayed to insert new Customer with empty fields and to update old customer, fields with old values
		
		// for thymeLeaf view
		return "/customers/customerForm";
	}
	
	@PostMapping(value="/saveOrUpdate")
	public String saveOrUpdateCustomer(@ModelAttribute("customer") Customer obj) {	// entire form customer object will be mapped to entity customer object
		service.saveCustomer(obj);	// id will be null while inserting new customer, and same old id will be reused to update the existing customer
		
		System.out.println(obj);
		
		return "redirect:/customer/list";
	}
	
	@PostMapping(value="/updateForm")
	public String getCustomerFormForUpdate(@RequestParam("customerId") Integer cid, Map<String, Object> model) {
		Customer obj=service.getCustomerById(cid);	// save this in model to display old values in form
		
		model.put("customer", obj);
		
		// for jsp view
		// return "customerForm"; // same customerForm will be displayed to insert new Customer with empty fields and to update old customer, fields with old values
	
		// for thymeLeaf view
		return "/customers/customerForm";
	}
	
	@PostMapping(value="/delete")
	public String deleteCustomer(@RequestParam("customerId") Integer cid) {
		service.deleteCustomerById(cid);
		
		return "redirect:/customer/list";
	}
	
}
