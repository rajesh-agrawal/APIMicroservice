package unit.com.jd.customer.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.jd.customer.controller.CustomerController;
import com.jd.customer.model.Customer;
import com.jd.customer.service.CustomerService;

class CustomerControllerTest {
	@InjectMocks
	CustomerController customerController;

	@Mock
	CustomerService customerService;
	@Mock
	Customer customer;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	void test() {

		customer = new Customer();
		customer.setCustomerid(1);
		customer.setCustomerName("Rajesh");
		Mockito.when(customerService.addCustomer(customer)).thenReturn(customer);
		Customer s = customerController.addCustomer(customer);
		assertNotEquals(s.getCustomerid(), 0);

	}

}
