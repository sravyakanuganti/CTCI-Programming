/*
 * To replace spaces in a string with "%20", assuming that there is sufficient space at the end to hold 
 * additional characters.
 * The actual size of the string is given in the input.
 */
public class URLify {

	/*
	 * Here we use StringBuilder to replace spaces with "%20". It works even if there is no space at the end
	 * of the string to hold additional characters.
	 * 
	 * We scan through the string till the given size and if we encounter a space
	 * append "%20" to the StringBuilder object,
	 * else, append the character.
	 * 
	 * Time: O(size) since we scan once from beginning to size
	 * Space: O(size + number of spaces * 2) since we create a new StringBuilder object and append the 
	 * characters from the original string along with replacing spaces with "%20"
	 */
	public String urlifyStringBuilder(String s, int size)
	{
		StringBuilder url = new StringBuilder();
		for(int i = 0; i < size; i++)
		{
			if(s.charAt(i) == ' ')
				url.append("%20");
			else
				url.append(s.charAt(i));
		}
		return url.toString();
	}
	
	/*
	 * Here, we modify the given char array assuming that there is sufficient space at the end to hold any 
	 * additional characters.
	 * 
	 * First we scan through the array to count the number of spaces.
	 * Then we set the index to size + num of spaces * 2 which would be the length of the new string.
	 * Now to edit the char array, we have two pointers i and index, where i goes from end of original char 
	 * array to the beginning and index goes from end of modified char array to the beginning.
	 * 
	 * If we encounter space at i we place "%20" in reverse order from index - 1 to index - 3,
	 * else we place character at i to index - 1.
	 *
	 * Time: O(2* size) since we traverse twice through the string
	 * Space: O(1) since we modify given char array
	 */
	public String urlifyCharArray(char[] s, int size)
	{
		int count = 0;
		for(int i = 0; i < size; i++)
		{
			if(s[i] == ' ')
				count ++;
			
		}
		int index = size + count * 2;
		
		for(int i = size - 1; i >= 0 ; i--)
		{
			if(s[i] == ' '){
				s[-- index] = '0';
				s[-- index] = '2';
				s[-- index] = '%';
			}
			
			else 
				s[-- index] = s[i]; 
			
		}
		
		/*
		 *  Java doesn't recognize '\0' as end of String so we create a new String with the known length of 
		 *  url to ignore any characters after the required url.
		 */
		return new String(s, 0, size + count * 2);  
		
	}
	
	public static void main(String[] args)
	{
		URLify url = new URLify();
		String str = "Mr John Smith              ";
		System.out.println(url.urlifyCharArray(str.toCharArray(), 13));
		System.out.println(url.urlifyStringBuilder(str, 13));
	}
	
}
