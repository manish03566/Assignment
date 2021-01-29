package assignment.newera.assignment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TelephoneDirectoryTest {
	@Autowired
	TelephoneDirectory telephoneDirectory;
	@Test
	void testPallindrome() {
		String contacts [] = {"London", "Laketown","Lonston"}; 
        telephoneDirectory.insertIntoTrie(contacts); 
        String query = "Lon"; 
        telephoneDirectory.displayContacts(query); 
	}
}
