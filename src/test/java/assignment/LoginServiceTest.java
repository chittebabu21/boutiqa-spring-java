/**
 * 
 */
package assignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.assignment.config.JpaConfig;
import com.assignment.config.WebMvcConfig;
import com.assignment.model.Login;
import com.assignment.service.LoginService;

/**
 * @author chittebabu
 *
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= { WebMvcConfig.class, JpaConfig.class })
@WebAppConfiguration
class LoginServiceTest {
	// inject the login service
	@Autowired
	private LoginService loginService;
	
	// inject web application context
	@Autowired
	private WebApplicationContext context;

	/**
	 * Test method for {@link com.assignment.service.LoginService#getUserByEmail(java.lang.String)}.
	 */

	// test for valid user email
	@Test
	void testValidUserEmail() {
		// declare service
		Login login = loginService.getUserByEmail("aaa@id.com");
		
		// assert true if found
		assertTrue(login instanceof Login);
	}

	// test for invalid email
	@Test
	void testInvalidUserEmail() {
		// declare service
		Login login = loginService.getUserByEmail("p12@eoi.co");
		
		// assert null if not found
		assertEquals(null, login);
	}
}
