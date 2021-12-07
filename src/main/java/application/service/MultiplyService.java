package application.service;

public class MultiplyService {
    public static int multiply(int[] numbers) {
        int result = 1;
        for (int number : numbers) {
            result *= number;
        }
        return result;
    }
}
