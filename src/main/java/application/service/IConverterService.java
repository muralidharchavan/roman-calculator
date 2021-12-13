package application.service;

public interface IConverterService {

    public int convertToNumber(String romanNumber) throws Exception;

    public String convertToRoman(String number) throws Exception;

}