import java.util.Arrays;

/*
 * Given an integer matrix of size NxN, rotate the matrix by 90 degrees within the matrix.
 * Here we consider clock wise rotation, i.e, top goes to right, right goes to bottom, bottom goes to left,
 * and left goes to top.
 * 
 */
public class RotateMatrix {
	
	/*
	 * Firstly we check if the matrix is NxN, if not return false
	 * 
	 * We approach the problem in terms of each layer starting from outer layer to inner layer. As we move
	 * from outer layer to inner layer, two elements get reduced at each layer. So, the innermost layer ends
	 * at N/2.
	 * 
	 * At each layer from outer to inner, we determine the end of that layer and traverse through each 
	 * element in the top array till end of that layer and store it, and shift the corresponding element in 
	 * the left array to top, corresponding bottom array element to left, corresponding right array element 
	 * to bottom and saved top array element to right
	 *  
	 * Time: O(N^2) as we need to visit each element in the given matrix
	 * Space: O(1) 
	 */
	
	public boolean rotateMat(int [][] mat)
	{
		if(mat.length == 0 || mat.length != mat[0].length)
			return false;
		
		for(int i = 0; i < mat.length/2; i++)	//loop from outer to innermost layer
		{
			int end = mat.length - 1 - i;	//determining where each layer ends
			for(int j = i; j < end; j++)	//loop from first to end of each layer
			{
				//determining the offset required to move from start of each layer to the required position
				int offset = j - i;	
				
				int top = mat[i][j];	//moving top to temporary variable
				
				mat[i][j] = mat[end-offset][i];	//moving left to top
				
				mat[end-offset][i] = mat[end][end-offset];	//moving bottom to left
				
				mat[end][end-offset] = mat[j][end];	//moving right to bottom
				
				mat[j][end] = top;	//moving top to right
			}
		}
		return true;		
	}
	
	public static void main(String[] args)
	{
		int [][] mat = new int[4][4];
		int count = 1;
		
		//Creating a matrix
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
				mat[i][j] = count++;
			System.out.println(Arrays.toString(mat[i]));
		}
		
		RotateMatrix rm = new RotateMatrix();
		System.out.println();
		
		if(rm.rotateMat(mat)){			//rotating the matrix
			//Printing the rotated matrix
			for(int i = 0; i < 4; i++)
				System.out.println(Arrays.toString(mat[i]));
		}
	}
}
