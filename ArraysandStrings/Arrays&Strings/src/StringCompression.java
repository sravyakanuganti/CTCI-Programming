/*
 * To compress a string using counts of repeated characters (ex: aabcccccaaa will be a2b1c5a3).
 * If compressed string is not smaller than the given string return the given string.
 */
public class StringCompression {
	
	/*
	 * We use StringBuilder to store the compressed string. For each character in the given string, 
	 * we increment the count of that character and check if we reached end of string or if the current 
	 * character and next character don't match, if yes append the current character and the count of that
	 * char to the StringBuilder and move onto the next character.
	 * Now, if length of the compressed string is greater than or equal to the given string,
	 * return given string else return compressed string.
	 * 
	 * Time: O(n) where n is length of the given string as we traverse through the given string once.
	 * Space: O(len(compressed string)) as we construct the compressed string and then check the lengths
	 * 
	 * 
	 */
	public String compressString(String str)
	{
		StringBuilder compStr = new StringBuilder();
		int charCount = 0;
		
		for(int i = 0; i < str.length(); i++)
		{
			charCount++;
			if(i+1 == str.length() || str.charAt(i) != str.charAt(i+1))
			{
				compStr.append(str.charAt(i));
				compStr.append(charCount); 
				charCount = 0;					//as we need to count the occurrences of next character.		
			}			
		}
		if(compStr.length() >= str.length())
			return str;
		
		return compStr.toString();
	}
	
	public static void main(String[] args)
	{
		StringCompression sc = new StringCompression();
		System.out.println(sc.compressString("aabbccdddd"));
	}

}
