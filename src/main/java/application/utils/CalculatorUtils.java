package application.utils;

public class CalculatorUtils {

    public static int add(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static int subtract(int[] numbers) {
        System.out.println("Subtracting Numbers = " + numbers);
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i];
        }
        System.out.println("Result = " + result);
        return result;
    }

    public static int multiply(int[] numbers) {
        int result = 1;
        for (int number : numbers) {
            result *= number;
        }
        return result;
    }

    public static String divide(int[] numbers) {

        int product = 1;
        for (int i = 1; i < numbers.length; i++) {
            product = product * numbers[i];
        }

        int whole = numbers[0] / product;
        int numerator = numbers[0] % product;
        int denominator = product;

        if (numerator == 0) {
            return whole + "";
        }
        return whole + "(" + numerator + "/" + denominator + ")";
    }

}
