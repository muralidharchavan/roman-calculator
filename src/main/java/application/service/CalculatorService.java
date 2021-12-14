package application.service;

import application.rest.v1.CalculatorInterface;

public class CalculatorService implements CalculatorInterface {

    public ConverterInterface injectedConverter;
    private String SPACE = " ";

    public CalculatorService(ConverterInterface injectedConverter) {
        this.injectedConverter = injectedConverter;
    }

    public String calculate(String operator, String numerals) throws Exception {

        String numberResult = calculate(operator, stringToInteger(numerals));
        if (numberResult.equals("nulla")) {
            return "nulla";
        }

        if (operator.equals("div")) {
            return representDivResultAsMixedFraction(numberResult);
        }

        return injectedConverter.toNumeral(numberResult);
    }

    public static String calculate(String operation, int[] numbers) throws Exception {
        String result = "";
        operation = operation.toLowerCase();
        switch (operation) {
            case "add":
                result = Calculator.add(numbers) + "";
                break;
            case "sub":
                result = Calculator.subtract(numbers) + "";
                break;
            case "mult":
                result = Calculator.multiply(numbers) + "";
                break;
            case "div":
                result = Calculator.divide(numbers);
                break;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
        if (result.equals("0")) {
            return "nulla";
        }
        return result;
    }

    private int[] stringToInteger(String strNumerals) throws Exception {

        String[] numeralsArray = toList(strNumerals);
        int[] intNumbersArray = new int[numeralsArray.length];
        for (int i = 0; i < numeralsArray.length; i++) {
            intNumbersArray[i] = this.injectedConverter.toNumber(numeralsArray[i]);
        }

        return intNumbersArray;
    }

    // method to convert a comma separated String to an array
    private String[] toList(String commaSeparatedNumerals) {
        String[] numeralsList = commaSeparatedNumerals.split(",");
        for (int i = 0; i < numeralsList.length; i++) {
            numeralsList[i] = numeralsList[i].trim();
        }
        return numeralsList;
    }

    private String representDivResultAsMixedFraction(String divResult) throws Exception {
        // divResult is in the form of "3(1/3)""
        // Convert numbers to numerals and represent them in the for of "III (I/III)"
        if (divResult.length() > 1) {
            String quotientNumber = divResult.substring(0, divResult.indexOf("("));
            String remainderNumber = divResult.substring(divResult.indexOf("(") + 1,
                    divResult.indexOf("/"));
            String divisorNumber = divResult.substring(divResult.indexOf("/") + 1,
                    divResult.indexOf(")"));

            String quotientNumeral = injectedConverter.toNumeral(quotientNumber);
            String remainderNumeral = injectedConverter.toNumeral(remainderNumber);
            String divisorNumeral = injectedConverter.toNumeral(divisorNumber);

            String response = quotientNumeral + SPACE + "(" + remainderNumeral + "/" + divisorNumeral + ")";

            return response;
        }
        return injectedConverter.toNumeral(divResult);
    }

}
