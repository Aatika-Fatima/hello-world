import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import junit.framework.TestCase;

public class PasswordTest extends TestCase{
	public void testBCryptPassword(){
		String password ="secret";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashPassword = passwordEncoder.encode(password);
		System.out.println(hashPassword);
	}
}
