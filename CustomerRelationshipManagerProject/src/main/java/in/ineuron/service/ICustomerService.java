package in.ineuron.service;

import in.ineuron.model.Customer;

public interface ICustomerService {

	public Iterable<Customer> getAllCustomers();
	
	public void saveCustomer(Customer obj);
	
	public Customer getCustomerById(Integer id);
	
	public void deleteCustomerById(Integer id);
	
}
