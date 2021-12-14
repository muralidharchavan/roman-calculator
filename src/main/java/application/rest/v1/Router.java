package application.rest.v1;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import application.utils.APIUtils;

public class Router {

    CalculatorInterface calculatorService;

    public Router(CalculatorInterface calculatorService) {
        this.calculatorService = calculatorService;
    }

    public void setCalculatorService(CalculatorInterface calculatorService) {
        this.calculatorService = calculatorService;
    }

    public Response calculate(String operation, String parameters) {
        operation = getOperation(operation);
        ResponseBuilder responseBuilder = APIUtils.getResponseWithHeaders();
        try {
            APIUtils.validateOperands(parameters);
        } catch (IllegalArgumentException e) {
            return responseBuilder.status(400).entity(e.getMessage()).build();
        }

        try {
            String result = this.calculatorService.calculate(operation, parameters);
            return responseBuilder.status(200).entity(result).build();
        } catch (Exception e) {
            return responseBuilder.status(400).entity(e.getMessage()).build();
        }
    }

    private static String getOperation(String operation) throws IllegalArgumentException {
        System.out.println("operation: " + operation);
        if (operation.equals("add")) {
            return "add";
        } else if (operation.equals("sub")) {
            return "sub";
        } else if (operation.equals("mult")) {
            return "mult";
        } else if (operation.equals("div")) {
            return "div";
        }
        System.out.println("Invalid operation");
        throw new IllegalArgumentException("Invalid operation");
    }
}
