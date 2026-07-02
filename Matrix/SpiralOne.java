import java.util.ArrayList;
import java.util.List;
class SpiralOne {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int startRow = 0;
        int endRow = m - 1;
        int startCol = 0;
        int endCol = n - 1;

        while(startRow <= endRow && startCol <= endCol) {
            for(int i = startCol; i <= endCol; i++) {
                result.add(matrix[startRow][i]);
            }
            startRow++;
            for(int i = startRow; i <= endRow; i++) {
                result.add(matrix[i][endCol]);
            }
            endCol--;
            if(startRow <= endRow) {
                for(int i = endCol; i >= startCol; i--) {
                result.add(matrix[endRow][i]);
            }
            endRow--;
            }
            if(startCol <= endCol){
                for(int i = endRow; i >= startRow; i--) {
                result.add(matrix[i][startCol]);
            }
            startCol++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        SpiralOne solution = new SpiralOne();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> result = solution.spiralOrder(matrix);
        System.out.println(result);
    }
}