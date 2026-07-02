import java.util.Arrays;
class DiagonalSum {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum += mat[i][i];
            sum += mat[i][n - 1 -i];
        }

        if(n % 2 == 1) {
            sum -= mat[n / 2][n / 2];
        }

        return sum;
    }
    public static void main(String[] args) {
        DiagonalSum solution = new DiagonalSum();
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int result = solution.diagonalSum(mat);
        System.out.println("Diagonal Sum: " + result);
    }
}