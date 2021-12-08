package application.service;

public class RomanCalculatorService {

    public IConverterService converter;

    public RomanCalculatorService(IConverterService converterService) {
        this.converter = converterService;
    }

    public RomanCalculatorService() {
    }

    public String calculateUsingRomanNumbers(String operator, String romanNumbers) {

        String decimalResponse = CalculatorService.calculate(operator, convertToInt(romanNumbers));
        
        if (operator.equals("div")) {
            return convertMixedFractionToRoman(decimalResponse);
        }

        return converter.convertToRoman(decimalResponse);
    }

    private String convertMixedFractionToRoman(String numberMixedFraction) {

        if (numberMixedFraction.length() > 1) {
            String quotientNumber = numberMixedFraction.substring(0, numberMixedFraction.indexOf("("));
            String remainderNumber = numberMixedFraction.substring(numberMixedFraction.indexOf("(") + 1,
                    numberMixedFraction.indexOf(")"));
            String divisorNumber = numberMixedFraction.substring(numberMixedFraction.indexOf(")") + 1);

            String quotientRoman = converter.convertToRoman(quotientNumber);
            String remainderRoman = converter.convertToRoman(remainderNumber);
            String divisorRoman = converter.convertToRoman(divisorNumber);

            return quotientRoman + "(" + remainderRoman + "/" + divisorRoman + ")";
        }
        return converter.convertToRoman(numberMixedFraction);
    }

    private int[] convertToInt(String romanNumbersStr) {

        String[] romanNumbersArray = convertToArray(romanNumbersStr);
        int[] intNumbersArray = new int[romanNumbersArray.length];
        for (int i = 0; i < romanNumbersArray.length; i++) {
            intNumbersArray[i] = this.converter.convertToNumber(romanNumbersArray[i]);
        }

        return intNumbersArray;
    }

    // method to convert a comma separated String to an array
    private String[] convertToArray(String romanNumbers) {
        String[] romanArray = romanNumbers.split(",");
        for (int i = 0; i < romanArray.length; i++) {
            romanArray[i] = romanArray[i].trim();
        }
        return romanArray;
    }
}
