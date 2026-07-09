import java.util.Scanner;

public class PowerOfThree {

    public boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        }

        if (n <= 0 || n % 3 != 0) {
            return false;
        }

        return isPowerOfThree(n / 3);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        PowerOfThree obj = new PowerOfThree();

        if (obj.isPowerOfThree(n)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        sc.close();
    }
}