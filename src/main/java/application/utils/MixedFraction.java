package application.utils;

public class MixedFraction {
    int whole; // quotient
    int numerator; // remainder
    int denominator; // divisor

    public MixedFraction(int whole, int numerator, int denominator) {
        this.whole = whole;
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public MixedFraction(int[] numbers) {
        int product = 1;
        for (int i = 1; i < numbers.length; i++) {
            product = product * numbers[i];
        }
        this.whole = numbers[0] / product;
        this.numerator = numbers[0] % product;
        this.denominator = product;
    }

    public MixedFraction(int number, int divisor) {
        this.whole = number / divisor;
        this.numerator = number % divisor;
        this.denominator = divisor;
    }

    public int getWhole() {
        return whole;
    }

    public void setWhole(int whole) {
        this.whole = whole;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public String toString() {
        if (numerator == 0) {
            return whole + "";
        }
        return whole + "(" + numerator + "/" + denominator + ")";
    }

}
