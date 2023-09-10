package in.ineuron.repository;

import org.springframework.data.repository.CrudRepository;

import in.ineuron.model.Customer;

public interface ICustomerRepository extends CrudRepository<Customer, Integer> {

}
