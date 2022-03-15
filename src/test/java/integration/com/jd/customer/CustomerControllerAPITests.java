package integration.com.jd.customer;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jd.customer.CustomerStarterApp;
import com.jd.customer.controller.CustomerController;
import com.jd.customer.dao.CustomerDAO;
import com.jd.customer.model.Customer;
import com.jd.customer.repository.CustomerRepository;
import com.jd.customer.service.CustomerService;

// Bootstrap the entire container 

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = { CustomerStarterApp.class }, webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
class CustomerControllerAPITests {

	@Test
	void contextLoads() {

	}

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

	Customer customer;

	@BeforeEach
	void setUp() throws Exception {

	}

	@Test
	void test_add_customer() {
		customer = new Customer();
		customer.setCustomerid(1);
		customer.setCustomerName("Rajesh");
		Customer s = customerController.addCustomer(customer);
		assertNotEquals(s.getCustomerid(), 0);
		assertNotEquals(mock, null);
	}

	@Test
	void test_endpoint_add_customer() throws Exception {
		customer = new Customer();
		customer.setCustomerid(1);
		customer.setCustomerName("Rajesh");
		ObjectMapper objectMapper = new ObjectMapper();

		String content = new String(objectMapper.writeValueAsBytes(customer));

		MvcResult mvcResult = mock.perform(get("/addCustomer").content(content).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.customerName", is(notNullValue()))).andReturn();
		System.out.println("mvcResult " + mvcResult.getResponse().getContentAsString());

	}

	
	@Test
	void test_case2_endpoint_add_customer_withdbMock() throws Exception {
	
		customer = new Customer();
	
		customer.setCustomerName("Rajesh");
		ObjectMapper objectMapper = new ObjectMapper();

		Customer customerReturn = new Customer();
		customerReturn.setCustomerid(1);
		customerReturn.setCustomerName("RajeshDB");
		
		String content = new String(objectMapper.writeValueAsBytes(customer));
		
		// integration test also mock 
		doReturn(customerReturn).when(customerDAO).addCustomer(Mockito.any());

		MvcResult mvcResult = mock.perform(get("/addCustomer").content(content).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.customerName", is(notNullValue()))).andReturn();
		System.out.println("mvcResult " + mvcResult.getResponse().getContentAsString());

	}

}
