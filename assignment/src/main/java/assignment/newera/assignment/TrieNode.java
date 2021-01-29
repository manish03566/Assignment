package assignment.newera.assignment;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class TrieNode {
    HashMap<Character,TrieNode> child; 
    boolean isLast; 
    public TrieNode() 
    { 
        child = new HashMap<Character,TrieNode>(); 
        for (char i = 'a'; i <= 'z'; i++) 
             child.put(i,null); 
        isLast = false; 
    } 
}
