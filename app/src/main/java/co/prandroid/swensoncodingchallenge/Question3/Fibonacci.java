package co.prandroid.swensoncodingchallenge.Question3;

/**
 * Created by dharmakshetri on 10/18/17.
 */

public class Fibonacci {

    //recursive method
    public static int recursiveMethod(int n) {
        if (n <= 1)
            return n;
        return recursiveMethod(n-1) + recursiveMethod(n-2);
    }

    //iterative method
    public  static int iterativeMethod(int number) {
        if (number == 0 || number == 1)
            return number;

        int firstNumber = 0, secondNumber = 1;
        int fibNumber = 0;
        for (int series = 2; series <= number; series++) {
            fibNumber = firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber = fibNumber;
        }
        return fibNumber;
    }

    public static void main(String[] args) {
        int upto=10;
        for (int number = 0; number <= upto; number++) {
            System.out.printf("%d ", recursiveMethod(number));
        }

        System.out.println("\n");
        for (int number = 0; number <= upto; number++) {
            System.out.printf("%d ", iterativeMethod(number));
        }

    }
}
