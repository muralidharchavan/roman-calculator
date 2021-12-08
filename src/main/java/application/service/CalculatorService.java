package application.service;

import application.utils.CalculatorUtils;

public class CalculatorService {

    public static String calculate(String operation, int[] numbers) {
        String result = "";
        operation = operation.toLowerCase();
        switch (operation) {
            case "add":
                result = CalculatorUtils.add(numbers) + "";
                break;
            case "sub":
                result = CalculatorUtils.subtract(numbers) + "";
                break;
            case "mult":
                result = CalculatorUtils.multiply(numbers) + "";
                break;
            case "div":
                result = CalculatorUtils.divide(numbers);
                break;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
        return result;
    }
}
