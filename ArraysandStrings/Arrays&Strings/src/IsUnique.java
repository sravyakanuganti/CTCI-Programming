import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;
/*
 * To determine if a string has all unique characters with and without using Data Structures.
 * Here, we assume that the input is an ASCII string (128 chars).
 * First two methods don't use any data structures and the next two methods use HashSet and BitSet 
 * respectively.
 */
public class IsUnique {
	
	/* Brute Force:
	 * To check if the string contains all unique characters by comparing every character in the string to
	 * all the characters that follow it till the end of the string.
	 * 
	 * Time: O(n^2) where n is the length of the string.
	 * Space: O(1) since no additional space is required.
	 */
	public boolean AreUniqueCharsBruteForce(String s)
	{
		
		if(s.length() > 128)
			return false;
		
		for(int i = 0; i < s.length() - 1; i++)
			for(int j = i + 1; j < s.length(); j++)
				if(s.charAt(i) == s.charAt(j))
					return false;
		
		return true;
		
	}
	
	/* Sorting:
	 * To check if the string contains all unique characters by sorting the characters in the input 
	 * character array and comparing the adjacent characters.
	 * 
	 * Time: O(n log n) to sort the input string.
	 * Space: O(1)
	 */
	public boolean AreUniqueCharsSorting(char[] s)
	{
		
		if(s.length > 128)
			return false;
				
		Arrays.sort(s);
		
		for(int i = 0; i < s.length - 1; i++)
			if(s[i] == s[i+1])
				return false;
			
		
		return true;
		
	}
	
	/*
	 * To check if the string contains all unique characters using HashSet. 
	 * For each character in the string, check if it is present in the set (i.e., if that character already
	 * appeared in the string), 
	 * if yes, return false. Else, add the character to the set and continue. 
	 * Return true once all the characters are checked.
	 * 
	 * Time: O(n) since every char in the string is checked once.
	 * Space: O( min(c, n) ) where n is the length of the string and c is size of character set(128). 
	 */
	public boolean AreUniqueCharsSet(String s)
	{
		if(s.length() > 128)	
			return false;
		
		Set<Character> uniqueChars = new HashSet<>();
		
		for(int i = 0; i < s.length(); i++)
		{
			if(uniqueChars.contains(s.charAt(i)))
				return false;
			
			uniqueChars.add(s.charAt(i));				
		}
		return true;
		
	}
	
	/*
	 * To check if the string contains all unique characters using BitSet. 
	 * Construct an array of bits using BitSet with size 128. For each character in the string, check if the 
	 * bit corresponding to it in the bit array is true (i.e., that character already appeared in the astring)
	 * if yes, return false. Else, set the bit to true and continue.
	 * Return true once all the characters are checked.
	 * 
	 * Time: O(n) since every char in the string is checked once.
	 * Space: O(1) since we use 128 bits to store the chars.
	 */
	public boolean AreUniqueCharsBitSet(String s)
	{
		if(s.length() > 128)
			return false;
		
		BitSet uniqueChars = new BitSet(128);		
		
		for(int i = 0; i < s.length(); i++)
		{
			if(uniqueChars.get(s.charAt(i)))
				return false;
			
			uniqueChars.set(s.charAt(i));
		}
		return true;
		
	}
	
	
	
	
	public static void main(String args[]) throws IOException
	{
		IsUnique unique = new IsUnique();
		System.out.println("Give the string to check for unique characters:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		System.out.println("Checked using BitSet: " + unique.AreUniqueCharsBitSet(s));
		System.out.println("Checked using Sorting: " +unique.AreUniqueCharsSorting(s.toCharArray()));
		System.out.println("Checked using Brute force: " +unique.AreUniqueCharsBruteForce(s));
		System.out.println("Checked using HashSet: " +unique.AreUniqueCharsSet(s));
	}

}
