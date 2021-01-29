package assignment.newera.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelephoneDirectory {
	@Autowired
	TrieNode root; 
    public void insertIntoTrie(String contacts[]) 
    { 
        int n = contacts.length; 
        for (int i = 0; i < n; i++) 
        { 
            insert(contacts[i]); 
        } 
    } 
    public void insert(String s) 
    { 
        int len = s.length(); 
        TrieNode itr = root; 
        for (int i = 0; i < len; i++) 
        { 
            TrieNode nextNode = itr.child.get(s.charAt(i)); 
            if (nextNode == null) 
            { 
                nextNode = new TrieNode(); 
                itr.child.put(s.charAt(i),nextNode); 
            } 
            itr = nextNode; 
            if (i == len - 1) 
                itr.isLast = true; 
        } 
    } 
    public void displayContactsUtil(TrieNode curNode, 
                                   String prefix) 
    { 
        if (curNode.isLast) 
            System.out.println(prefix); 
        for (char i = 'a'; i <= 'z'; i++) 
        { 
            TrieNode nextNode = curNode.child.get(i); 
            if (nextNode != null) 
            { 
                displayContactsUtil(nextNode, prefix + i); 
            } 
        } 
    } 
    void displayContacts(String str) 
    { 
        TrieNode prevNode = root; 
        String prefix = ""; 
        int len = str.length(); 
        int i; 
        for (i = 0; i < len; i++) 
        { 
            prefix += str.charAt(i); 
            char lastChar = prefix.charAt(i); 
            TrieNode curNode = prevNode.child.get(lastChar); 
            if (curNode == null) 
            { 
                System.out.println("No Results Found for  "
                                          + prefix + " "); 
                i++; 
                break; 
            } 
            System.out.println("Suggestions based on "
                                    + prefix + " are"); 
            displayContactsUtil(curNode, prefix); 
            prevNode = curNode; 
        } 
  
        for ( ; i < len; i++) 
        { 
            prefix += str.charAt(i); 
            System.out.println("No Results Found for " 
                                          + prefix + ""); 
        } 
    } 
}
