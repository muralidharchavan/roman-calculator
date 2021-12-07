package application.service;

public class CalculatorService {

    public static int calculate(String operation, int[] numbers) throws Exception {
        int result = 0;
        operation = operation.toLowerCase();
        switch (operation) {
            case "add":
                result = AddService.add(numbers);
                break;
            case "sub":
                result = SubtractService.subtract(numbers);
                break;
            case "mult":
                result = MultiplyService.multiply(numbers);
                break;
            case "div":
                result = DivisionService.divide(numbers);
                break;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
        return result;
    }
}
