// import au.com.dius.pact.consumer.ConsumerPactBuilder;
// import au.com.dius.pact.consumer.MockServer;
// import au.com.dius.pact.consumer.PactTestExecutionContext;
// import au.com.dius.pact.consumer.PactTestRun;
// import au.com.dius.pact.consumer.PactVerificationResult;
// import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
// import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
// import au.com.dius.pact.consumer.junit5.PactTestFor;
// import au.com.dius.pact.consumer.model.MockProviderConfig;
// import au.com.dius.pact.core.model.RequestResponsePact;
// import au.com.dius.pact.core.model.annotations.Pact;

// import org.apache.commons.collections4.MapUtils;
// import org.apache.http.entity.ContentType;
// import org.jetbrains.annotations.NotNull;
// import org.junit.Test;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.extension.ExtendWith;
// import static org.hamcrest.Matchers.notNullValue;
// import static org.hamcrest.Matchers.is;

// import application.service.IConverterService;
// import application.service.IConverterServiceImpl;

// import java.io.IOException;
// import java.util.HashMap;
// import java.util.Map;

// import static au.com.dius.pact.consumer.ConsumerPactRunnerKt.runConsumerTest;
// import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertThat;

// @ExtendWith(PactConsumerTestExt.class)
// @PactTestFor(providerName = "converter")
// public class CalculatorConsumerPactTest {

// private Map<String, String> headers = MapUtils.putAll(new HashMap<>(), new
// String[] {
// "Content-Type", "text/plain"
// });

// @BeforeEach
// public void setUp(MockServer mockServer) {
// System.out.println("Mock server " + mockServer);
// assertThat(mockServer, is(notNullValue()));
// }

// @Pact(provider = "converter", consumer = "calculator")
// public RequestResponsePact convertToNumberPact(PactDslWithProvider builder) {
// return builder
// .given("test state")
// .uponReceiving("ExampleJavaConsumerPactTest test interaction")
// .path("/to-number")
// .method("GET")
// .query("value=I")
// .willRespondWith()
// .headers(headers)
// .status(200)
// .body("1")
// .toPact();
// }

// @Test
// void test(MockServer mockServer) throws IOException {
// HttpResponse httpResponse = Request.Get(mockServer.getUrl() +
// "/articles.json").execute().returnResponse();
// assertThat(httpResponse.getStatusLine().getStatusCode(), is(equalTo(200)));
// }

// }