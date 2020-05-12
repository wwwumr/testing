import component.Error;
import component.HandlerFunction;
import component.Token_Stream;
import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    @Test
    public void testCase0001(){
        HandlerFunction handlerFunction = new HandlerFunction();
        String expression = "1+2*3-2/5;";
        Token_Stream ts = new Token_Stream(expression);
        Error error = new Error();
        error.setError(0);
        Assert.assertEquals(handlerFunction.expression(ts,error),6.6,0.0001);
    }

  @Test
  public void testCase0002(){
    HandlerFunction handlerFunction = new HandlerFunction();
    String expression = "1+2*3-2/5;";
    Token_Stream ts = new Token_Stream(expression);
    Error error = new Error();
    error.setError(0);
    Assert.assertEquals(handlerFunction.expression(ts,error),6.6,0.0001);
  }
}
