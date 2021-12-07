package application.service;

public class DivisionService {

    public static String divide(int[] numbers) {

        int product = 1;
        for (int i = 1; i < numbers.length; i++) {
            product = product * numbers[i];
        }

        int whole = numbers[0] / product;
        int numerator = numbers[0] % product;
        int denominator = product;
        return whole + "(" + numerator + "/" + denominator + ")";
    }
}
