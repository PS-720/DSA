import java.util.Arrays;
class SpiralTwo {
    public int[][] generateMatrix(int n) {
        int element = 1;
        int[][] matrix = new int[n][n];

        int startRow = 0;
        int endRow = n - 1;
        int startCol = 0;
        int endCol = n - 1;
        while (startRow <= endRow && startCol <= endCol) {
            for(int i = startCol; i <= endCol; i++) {
                matrix[startRow][i] = element++;
            }
            startRow++;
            for(int i = startRow; i <= endRow; i++) {
                matrix[i][endCol] = element++;
            }
            endCol--;
            if(startRow <= endRow) {
                for(int i = endCol; i >= startCol; i--) {
                matrix[endRow][i] = element++;
            }
            endRow--;
            }
            if(startCol <= endCol){
                for(int i = endRow; i >= startRow; i--) {
                matrix[i][startCol] = element++;
            }
            startCol++;
            }
        }
        return matrix;
    }
    public static void main(String[] args) {
        SpiralTwo solution = new SpiralTwo();
        int n = 3;
        int[][] result = solution.generateMatrix(n);

        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}