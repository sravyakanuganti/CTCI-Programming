import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * If an element in an MxN matrix is 0, its entire row and column are set to zero.
 */
public class ZeroMatrix {
	
	/*
	 * The main idea is to store the row and column at which we encountered a zero. Then we iterate through 
	 * the stored rows and columns and set all the elements in those rows and columns to zero. We use Set 
	 * to store rows and columns to avoid duplicates.
	 * 
	 * We traverse the whole matrix and if a zero is found at i, j then, i and j are added to rows and
	 * cols set respectively.
	 * Then, for each row in rows set, we set every element in that row to zero. Do the same to columns.
	 * 
	 * @param	mat	Matrix to set zeroes to.
	 * 
	 * Time: O(MxN) since we traverse through the whole matrix at least once to find zeroes.
	 * Space: O(M+N) since we store rows and columns.
	 * 
	 */
	public void zeroMatSet(int [][] mat)
	{		
		Set<Integer> rows = new HashSet<>(mat.length);
		Set<Integer> cols = new HashSet<>(mat[0].length);
		
		//Storing row and column at which zero is encountered
		for(int i = 0; i < mat.length; i++){
			for(int j = 0; j < mat[0].length; j++){
				if(mat[i][j] == 0)
				{
					rows.add(i);
					cols.add(j);
				}
			}
		}
		
		//Setting zeroes to rows
		for(int i : rows)
			setZeroRow(mat, i);
		
		//Setting zeroes to columns
		for(int i : cols)
			setZeroCol(mat, i);		
		
	}
	
	/*
	 * The main idea is to store the row and column at which we encountered a zero in the same matrix in 
	 * fisrt column of that row and first row of that column respectively. We use separate boolean 
	 * variables to find out if first row and first column has any zeroes.
	 * 
	 * We traverse through the first row and if a zero is found, we set the boolean variable firstRow to
	 * true and the same is done for the first column. 
	 * Then, we traverse the rest of the matrix and if a zero is found at i, j then first element in i th 
	 * row, i.e., mat[i][0] and first element in j th column, i.e., mat[0][j] are set to zero.
	 * Now, we traverse through the first row to set all elements of a column to zero if zero is found in
	 * that column. Do the same with rows by traversing through first column.
	 * We then set first row and first column elements to zero if needed.
	 * 
	 * @param	mat	Matrix to set zeroes to.
	 * 
	 * Time: O(MxN)
	 * Space: O(1) since no additional space is required.
	 * 
	 */
	public void zeroMat(int[][] mat)
	{
		boolean firstRow = false, firstCol = false;
		
		//Checking if first row has any zero
		for(int i = 0; i < mat[0].length; i++){
			if(mat[0][i] == 0){
				firstRow = true;
				break;
			}
		}
		
		//Checking if first column has any zero
		for(int i = 0; i < mat.length; i++){
			if(mat[i][0] == 0){
				firstCol = true;
				break;
			}
		}
		
		//Storing row and column at which zero is encountered
		for(int i = 1; i < mat.length; i++){
			for(int j = 1; j < mat[0].length; j++){
				if(mat[i][j] == 0)
				{
					mat[i][0] = 0;
					mat[0][j] = 0;
				}
			}
		}
		
		//Setting zeroes to rows
		for(int i = 1; i < mat.length; i++){
			if(mat[i][0] == 0)
				setZeroRow(mat, i);
		}
		
		//Setting zeroes to columns
		for(int j = 1; j < mat[0].length; j++){
			if(mat[0][j] == 0)
				setZeroCol(mat, j);
		}
		
		//Setting zeroes to first row
		if(firstRow)
			setZeroRow(mat, 0);
		
		//Setting zeroes to first column
		if(firstCol)
			setZeroCol(mat, 0);
	}
	
	/*
	 * Sets every element in the given row to zero
	 * 
	 * @param	mat	Matrix to set zeroes to.
	 * @param	r	row in which all elements need to be set to zero
	 * 
	 */
	private void setZeroRow(int[][] mat, int r)
	{
		for(int j = 0; j < mat[0].length; j++)
			mat[r][j] = 0;
	}
	
	/*
	 * Sets every element in the given column to zero
	 * 
	 * @param	mat	Matrix to set zeroes to.
	 * @param	c	column in which all elements need to be set to zero
	 * 
	 */
	private void setZeroCol(int[][] mat, int c)
	{
		for(int j = 0; j < mat.length; j++)
			mat[j][c] = 0;
	}
	
	public static void main(String[] args)
	{
		System.out.println("With Set");
		int [][] mat = {{1, 7, 0, 5, 6},
						{4, 0, 6, 9, 0},
						{3, 5, 0, 6, 0},
						{2, 4, 6, 7, 9},
						{1, 2, 4, 6, 8},
						{1, 9, 7, 8, 9}};
		
		ZeroMatrix zm = new ZeroMatrix();
		zm.zeroMatSet(mat);
		for(int i = 0; i < mat.length; i++)
			System.out.println(Arrays.toString(mat[i]));
		
		
		System.out.println("Without Set");
		
		int [][] mat1 = {{1, 7, 0, 5, 6},
				{4, 0, 6, 9, 0},
				{3, 5, 0, 6, 0},
				{2, 4, 6, 7, 9},
				{1, 2, 4, 6, 8},
				{1, 9, 7, 8, 9}};
		
		zm.zeroMatSet(mat1);
		for(int i = 0; i < mat1.length; i++)
			System.out.println(Arrays.toString(mat1[i]));
		
		
		
	}

}
