package integration.com.jd.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.jd.customer.CustomerStarterApp;
import com.jd.customer.controller.CustomerController;
import com.jd.customer.controller.ReportController;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { CustomerStarterApp.class })
@WebMvcTest(controllers = { ReportController.class })
class ReportControllerMVCTest {
	@Autowired
	ReportController reportController;

	@Autowired
	MockMvc mock;

	@BeforeEach
	void setUp() throws Exception {
//		MockitoAnnotations.initMocks(this);
	}

	@Test
	void test_remove_report_controller() {
		String s = reportController.viewReport();
		System.out.println("Report Controller " + s);
		assertEquals(s,"viewReport");
	}
}
