package integration.com.jd.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.jd.customer.CustomerStarterApp;
import com.jd.customer.controller.CustomerController;
import com.jd.customer.dao.CustomerDAO;
import com.jd.customer.model.Customer;
import com.jd.customer.repository.CustomerRepository;
import com.jd.customer.service.CustomerService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CustomerStarterApp.class)
@AutoConfigureMockMvc
class CustomerControllerMVCTest {

	@Autowired
	CustomerController customerController;

	@SpyBean
	CustomerService customerService;

	@SpyBean
	CustomerDAO customerDAO;
	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	MockMvc mock;

//
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

//incremental integration testing
	// Database has been mocked
	@Test
	void test_add_customer_case1_dbMock() {
		Customer customerBefore = new Customer();
		customerBefore.setCustomerName("Kunal");
		Customer customerAfter = new Customer();
		customerAfter.setCustomerid(1);
		customerAfter.setCustomerName("Kunal");
		System.out.println(" " + customerController.getCustomerService() + " " + this.customerService);
		customerController.setCustomerService(customerService);
		customerService.setCustomerDAO(customerDAO);
		customerDAO.setCustomerRepository(customerRepository);

		doReturn(customerAfter).when(customerDAO).addCustomer(Mockito.any());

		System.out.println("IN here ");

		Customer customerReturned = customerController.addCustomer(customerBefore);
		assertEquals(customerAfter, customerReturned);

	}

	@Test
	void test_add_customer_complete_case2() {
		Customer customerBefore = new Customer();
		customerBefore.setCustomerName("Kunal");
	
		System.out.println(" " + customerController.getCustomerService() + " " + this.customerService);
		customerController.setCustomerService(customerService);
		customerService.setCustomerDAO(customerDAO);
		customerDAO.setCustomerRepository(customerRepository);

		System.out.println("IN here ");

		Customer customerReturned = customerController.addCustomer(customerBefore);
		assertEquals(customerBefore, customerReturned);

	}
}
