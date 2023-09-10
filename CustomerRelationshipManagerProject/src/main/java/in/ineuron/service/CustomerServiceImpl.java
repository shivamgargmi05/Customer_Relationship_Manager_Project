package in.ineuron.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.model.Customer;
import in.ineuron.repository.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository repository;
	
	@Override
	public Iterable<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		
		System.out.println("O/P : Implementation/Inmemory proxy class of ICustomerRepository : " + repository.getClass().getName() );
		
		return repository.findAll();
	}

	@Override
	public void saveCustomer(Customer obj) {
		// TODO Auto-generated method stub
		
		repository.save(obj);	// repository same save() will be used to insert new record or update the existing record
	}

	@Override
	public Customer getCustomerById(Integer id) {
		// TODO Auto-generated method stub
		
		Optional<Customer> op=repository.findById(id);
		
		return op.get();
	}

	@Override
	public void deleteCustomerById(Integer id) {
		// TODO Auto-generated method stub
	
		repository.deleteById(id);
	}

}
