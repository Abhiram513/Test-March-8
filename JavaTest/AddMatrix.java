import java.util.Arrays;

public class AddMatrix 
{
    public static void main(String[] args) 
    {
        int[][] matrix1 = {{5, 9}, {7, 3}};
        int[][] matrix2 = {{9, 1}, {2, 6}};

        int[][] resultMatrix = sumMatrices(matrix1, matrix2);

        System.out.println("The Sum of given Matrices is: ");
        for (int[] row : resultMatrix) 
        {
            
            System.out.println( Arrays.toString(row));
        }
    }

    
    public static int[][] sumMatrices(int[][] matrix1, int[][] matrix2) 
    {
        int rows = matrix1.length, cols = matrix1[0].length;
        int[][] resultMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++)
         {
            for (int j = 0; j < cols; j++) 
            {
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return resultMatrix;
    }

   
}
