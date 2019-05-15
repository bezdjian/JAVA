package example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import example.pojos.RequestClass;
import example.pojos.ResponseClass;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class HelloTest {

    //I want to test with real response and request. not mock
    private Hello hello = new Hello();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void handleRequest() {
        RequestClass req = new RequestClass("Harhar", "facereqimages");
        Context context = mock(Context.class);
        LambdaLogger logger = mock(LambdaLogger.class);

        doNothing().when(logger).log(anyString());
        doReturn(logger).when(context).getLogger();
        ResponseClass res = hello.handleRequest(req, context);
        System.out.println("RESPONSE: " + res.toString());
    }
}