package assignment.newera.assignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LongestPallindromeTest {
	@Autowired
	LongestPallindrome lp;
	@Test
	void testPallindrome() {
		String inputString = "HelloWelcomeemoclewHelloolle";
		String message = lp.longestPalSubstr(inputString.toUpperCase());
		int i = inputString.toUpperCase().indexOf(message);
		assertEquals("Welcomeemoclew", inputString.substring(i, message.length()+i));
	}
}
