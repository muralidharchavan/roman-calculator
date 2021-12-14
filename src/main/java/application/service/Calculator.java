package application.service;

public class Calculator {

    public static int add(int[] numbers) throws Exception {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return validateResult(sum);
    }

    public static int subtract(int[] numbers) throws Exception {
        System.out.println("Subtracting Numbers = " + numbers);
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i];
        }
        return validateResult(result);

    }

    public static int multiply(int[] numbers) throws Exception {
        int result = 1;
        for (int number : numbers) {
            result *= number;
        }
        return validateResult(result);
    }

    public static String divide(int[] numbers) throws Exception {

        // First multiply all numbers except the first number
        // Then divide the result by the first number
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
        validateResult(whole - 1);
        return whole + "(" + numerator + "/" + denominator + ")";
    }

    private static int validateResult(int num) throws Exception {
        if (num < 0 || num > 3999) {
            throw new Exception("Not Implemented.");
        }
        return num;
    }

}
