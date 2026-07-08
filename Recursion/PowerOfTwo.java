public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        }
        if (n <= 0 || n % 2 != 0) {
            return false;
        }
        return isPowerOfTwo(n / 2);
    }

    public static void main(String[] args) {
        PowerOfTwo solution = new PowerOfTwo();

        int[] testValues = {1, 2, 3, 4, 8, 16, 18, 0, -2};

        for (int n : testValues) {
            System.out.println(n + " -> " + solution.isPowerOfTwo(n));
        }
    }
}