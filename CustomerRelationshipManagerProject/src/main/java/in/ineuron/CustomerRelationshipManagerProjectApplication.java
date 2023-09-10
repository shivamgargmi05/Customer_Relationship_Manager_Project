package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* This app can be used in two diff GUIs - 
 * 1. Using .jsp files as a view -
 * 2. Using thymeLeaf files as a view -  
 * 
 * After successful migration from .jsp to thymeLeaf files as a view, you can delete below files -
 * 		css/style.css, css/add-customer-style.css, webapp/index.jsp, webapp/views/listCustomers.jsp, webapp/views/customerForm.jsp
 */

@SpringBootApplication
public class CustomerRelationshipManagerProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerRelationshipManagerProjectApplication.class, args);
	}

}
