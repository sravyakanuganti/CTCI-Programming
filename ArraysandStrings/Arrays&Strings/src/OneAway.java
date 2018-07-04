/*
 * Given two strings check if they are one or zero edit away.
 * Three types of edit: insert a char, remove a char, or replace a char.
 */
public class OneAway {
	/*
	 * The difference between length of the two strings cannot be more than 1 as we can insert/remove only 
	 * one character. So, if the difference is more than 1, return false.
	 * 
	 * Now, we have a pointer at the beginning of each string. 
	 * If the character at both pointers is matching,increment both the pointers as we want to check the next
	 * character, else
	 * check if one edit is already found, if yes return false else,
	 * update foundOne as true
	 * if lengths of the two strings is different, increment the pointer of the longer string (as insertion 
	 * or deletion of one character is allowed) 
	 * else increment both the pointers (as replacement of one char is allowed if lengths are equal).
	 *  
	 * Time: O(n) where n is the length of the smaller string, length of longer string = n + 1.
	 * Space: O(1)
	 */
	public boolean isOneEditAway(String s1, String s2)
	{
		if(Math.abs(s1.length() - s2.length()) > 1)
			return false;
		
		boolean foundOne = false;
		
		for(int i = 0, j = 0; i < s1.length() && j < s2.length();)
		{			
			if(s1.charAt(i) == s2.charAt(j))
			{
				i++;
				j++;
			}
			
			else{
				if(foundOne) return false;
				
				foundOne = true;
				
				if(s1.length() > s2.length())
					i++;
				else if(s1.length() < s2.length())
					j++;
				else	//On replace of one char, move both the pointers
				{
					i++;
					j++;
				}
			}
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{
		OneAway oneAway = new OneAway();
		System.out.println(oneAway.isOneEditAway("pale", "bale"));
	}

}
