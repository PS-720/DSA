import java.util.Arrays;
class ReshapeMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;

        if(m * n != r * c) {
            return mat;
        }

        int[][] ans = new int[r][c];

        for (int i = 0; i < m * n; i++) {
            ans[i / c][i % c] = mat[i / n][i % n];
        }

        return ans;
    }
    public static void main(String[] args) {
        ReshapeMatrix solution = new ReshapeMatrix();
        int[][] mat = {{1, 2}, {3, 4}};
        int r = 1;
        int c = 4;
        int[][] reshapedMatrix = solution.matrixReshape(mat, r, c);

        for(int i = 0; i < reshapedMatrix.length; i++) {
            for(int j = 0; j < reshapedMatrix[0].length; j++) {
                System.out.print(reshapedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}