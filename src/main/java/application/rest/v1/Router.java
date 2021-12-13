package application.rest.v1;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import application.service.IConverterServiceImpl;
import application.service.RomanCalculatorService;
import application.utils.Config;

public class Router {

    // public static void main(String[] args) {
    // route("add", "I,II");
    // }

    public static Response route(String operation, String parameters) {
        ResponseBuilder responseBuilder = Response.noContent();
        responseBuilder.header("Content-Type", "text/plain");

        if (parameters == null || parameters.length() == 0) {
            return responseBuilder.status(400).entity("Bad Request").build();
        }

        System.out.println("URL = " + Config.getUrl());

        RomanCalculatorService romanCalculatorService = new RomanCalculatorService(
                new IConverterServiceImpl(Config.getUrl()));

        try {
            String result = romanCalculatorService.calculateUsingRomanNumbers(operation, parameters);
            return responseBuilder.status(200).entity(result).build();
        } catch (Exception e) {
            e.printStackTrace();
            return responseBuilder.status(400).entity(e.getMessage()).build();
        }
    }
}
