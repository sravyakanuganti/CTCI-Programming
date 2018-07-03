import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * To check if the given string is a permutation of a palindrome. For a string to be palindrome, 
 * 1) if the length of the string is even, then every character in the string should occur even times.
 * 2) if the length is odd, then every character except one should occur even times. The one odd character 
 * 	  can be placed in the middle.
 * 
 * For any implementation we need to remove the spaces in the given string.
 * 
 * Brute force:
 * 1) Generate each possible permutation for the given string and check if it is a palindrome. 
 * Time: O(n*n!) where n is the length of the string.
 * Space: O(n) to store each new permutation.
 * 
 * 2) For each character in the given string, count the number of occurrences of the character and if 
 * more than one character has odd number of occurrences, return false else true.
 * Time: O(n^2) for each character, we need to traverse n characters of the given string
 * Space: O(1) 
 *  
 * Sorting: 
 * Sort the given string using char array and count the number of occurrences of each character by comparing
 * adjacent characters. If more than one character has odd number of occurrences, return false else true.
 * Time: O(n log n) for sorting.
 * Space: O(1) 
 * 
 */

public class PalindromePermutation {
	
	/*
	 * Firstly, we construct a new String by removing spaces in the given string.
	 * Then, each unique character in the given string is stored in a hash table along with its count.
	 * If more than one character in the hash table has odd number of occurrences, return false else true. 
	 * 
	 * Time: O(n) as we traverse through the string once.
	 * Space:O(min(c,n)) where n is the length of string and c is the size of character set which is constant
	 *  
	 */
	
	public boolean isPalindromePermutation(String str)
	{
		str = str.toLowerCase();		
		
		String[] words = str.split(" ");
		StringBuilder strWithoutSpaces = new StringBuilder();
		for(String s : words)
			strWithoutSpaces.append(s);
		
		
		Map<Character, Integer> charMap = new HashMap<>();
		for(int i = 0; i < strWithoutSpaces.length(); i++)
		{
			int count = charMap.getOrDefault(strWithoutSpaces.charAt(i), 0);
			charMap.put(strWithoutSpaces.charAt(i), ++count);
		}
		
		int numOfOddChars = 0;
		Set<Character> uniqueChars = charMap.keySet();
		
		for(char c : uniqueChars)
		{
			if(charMap.get(c) % 2 != 0)
			{
				numOfOddChars ++;
				if(numOfOddChars > 1)
					return false;
			}
		}
			
		return true;
	}
	
	public static void main(String[] args)
	{
		String s = "lbaa iblciA cat";
		PalindromePermutation p = new PalindromePermutation();
		System.out.println(p.isPalindromePermutation(s));
				
	}

}
