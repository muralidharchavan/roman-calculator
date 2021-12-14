package application.utils;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import application.rest.v1.Router;
import application.service.CalculatorService;
import application.service.ConverterClient;

public class APIUtils {
    public static ResponseBuilder getResponseWithHeaders() {
        ResponseBuilder responseBuilder = Response.noContent();
        responseBuilder.header("Content-Type", "text/plain");
        return responseBuilder;
    }

    public static void validateOperands(String operands) {
        if (operands == null || operands.length() == 0) {
            throw new IllegalArgumentException("Bad Request");
        }
    }

    public static Router getRouter() {
        return new Router(new CalculatorService(new ConverterClient(Config.getUrl())));
    }
}
