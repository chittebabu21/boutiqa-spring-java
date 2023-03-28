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

import com.assignment.config.JpaConfig;
import com.assignment.config.WebMvcConfig;
import com.assignment.model.Profile;
import com.assignment.service.ProfileService;

/**
 * @author chittebabu
 *
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= { WebMvcConfig.class, JpaConfig.class })
@WebAppConfiguration
class ProfileServiceTest {
	// inject profile service
	@Autowired
	private ProfileService profileService;

	/**
	 * Test method for {@link com.assignment.service.ProfileService#getProfileByEmail(java.lang.String)}.
	 */
	@Test
	void testGetProfileByEmail() {
		// declare service
		Profile profile = profileService.getProfileByEmail("ed@email.com");
		
		// assert true if found
		assertTrue(profile instanceof Profile);
	}
}
