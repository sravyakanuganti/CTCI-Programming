import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
 * To check if a string is permutation of the other string. For two strings to be permutation of each other,
 * they need to satisfy below conditions:
 * a) both the strings need to be of equal length.
 * b) all the characters in both the strings must be the same.
 * 
 * Brute force: 
 * 1)Generate each possible permutation for the first string and check if it is equal to the 
 * second string. 
 * Time: O(n*n!) where n is the length of the string.
 * Space: O(n) to store each new permutation.
 * 
 * 2) For each character in the first string, count the number of occurrences of the character in both 
 * strings and compare. If they are equal, continue. Else return false.
 * Time: O(n^2) for each character, we need to traverse n characters of both strings
 * Space: O(1) 
 *  
 * Sorting: Sort both strings using char arrays and compare them. 
 * If they are equal, return true. Else, false.
 * Time: O(n log n) for sorting.
 * Space: O(1)
 * 
 * 
 */
public class CheckPermutation {
	
	/*
	 * Check if both the strings are of equal length. If yes,
	 * Then, each character in the first string is stored in a hash table along with its count.
	 * Then, for each character in the second string, check if it is present in the table, 
	 * if yes, check the number of occurrences of that char, if it is less or equal to 0 (i.e.,the number
	 * of occurrences of that char is not the same), return false. 
	 * Else, decrement the count and continue. Return true when all characters are checked.
	 * 
	 *Time: O(n) as we traverse once through both the strings.
	 *Space: O(min(c,n)) where n is the length of string and c is the size of character set which is constant
	 */
	
	public boolean IsPermutation(String a, String b)
	{
		if(a.length() != b.length())
			return false;
		
		int count = 0;
		
		Map<Character, Integer> charCount = new HashMap<>();
		for(int i = 0; i < a.length(); i++)
		{
			count = charCount.getOrDefault(a.charAt(i), 0);
			charCount.put(a.charAt(i), ++count);
		}
		
		for(int i = 0; i < b.length(); i++)
		{
			if(!charCount.containsKey(b.charAt(i)))
				return false;
			
			count = charCount.get(b.charAt(i));
			
			if(count <= 0)
				return false;
			
			charCount.put(b.charAt(i), --count);
		}
		
		return true;
		
	}
	
	public static void main(String args[]) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Give the two strings to check for permutation");
		String a = reader.readLine();
		String b = reader.readLine();		
		CheckPermutation check = new CheckPermutation();
		System.out.println(check.IsPermutation(a, b));
	}

}
