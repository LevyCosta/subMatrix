
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package submatrix;

/**
 *
 * @author Levy
 */
public class Submatrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        boolean matrix[][] = {{true, false, true, false, false},
        {true, false, true, true, true},
        {true, true, true, true, true},
        {true, false, false, true, false}};

        maxSubMatrix(matrix);

    }

    static void maxSubMatrix(boolean matrix[][]) {

        //creating 0 and 1 matrix to help with calculations
        int[][] intMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] = true) {
                    intMatrix[i][j] = 1;
                } else {
                    intMatrix[i][j] = 0;
                }
            }
        }
        
        int subM[][] = new int[intMatrix.length][intMatrix[0].length]; //auxiliary matrix 
        int max_of_s, max_i, max_j;

        // Preparing collumn
        for (int i = 0; i < intMatrix.length; i++) {
            subM[i][0] = intMatrix[i][0];
        }
        //and row
        for (int j = 0; j < intMatrix[0].length; j++) {
            subM[0][j] = intMatrix[0][j];
        }

        // Filling auxiliary matrix
        for (int i = 1; i < intMatrix.length; i++) {
            for (int j = 1; j < intMatrix[0].length; j++) {
                if (intMatrix[i][j] == 1) {
                    subM[i][j] = Math.min(subM[i][j - 1],
                            Math.min(subM[i - 1][j], subM[i - 1][j - 1])) + 1;
                } else {
                    subM[i][j] = 0;
                }
            }
        }

        /* Find the maximum entry, and indexes of maximum entry  
            in S[][] */
        max_of_s = subM[0][0];
        max_i = 0;
        max_j = 0;
        for (int i = 0; i < intMatrix.length; i++) {
            for (int j = 0; j < intMatrix[0].length; j++) {
                if (max_of_s < subM[i][j]) {
                    max_of_s = subM[i][j];
                    max_i = i;
                    max_j = j;
                }
            }
        }
        System.out.println("Maximum size sub-matrix is: ");
        for (int i = max_i; i > max_i - max_of_s; i--) {
            for (int j = max_j; j > max_j - max_of_s; j--) {
                System.out.print(intMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}

