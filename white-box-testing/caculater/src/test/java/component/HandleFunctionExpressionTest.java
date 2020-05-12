package component;

import org.junit.Assert;
import org.junit.Test;

public class HandleFunctionExpressionTest {

  HandlerFunction handlerFunction = new HandlerFunction();

  @Test
  public void testExpression001() {
    String expression = "3+4-5;";
    Token_Stream ts = new Token_Stream(expression);
    Error error = new Error();
    double var = handlerFunction.expression(ts, error);
    Assert.assertEquals(var, 2, 0.0001);
  }

  @Test
  public void testExpression002() {
    String expression = "3;";
    Token_Stream ts = new Token_Stream(expression);
    Error error = new Error();
    double var = handlerFunction.expression(ts, error);
    Assert.assertEquals(var, 3, 0.0001);
  }

  @Test
  public void testExpression003() {
    String expression = "3+4;";
    Token_Stream ts = new Token_Stream(expression);
    Error error = new Error();
    double var = handlerFunction.expression(ts, error);
    Assert.assertEquals(var, 7, 0.0001);
  }

  @Test
  public void testExpression004() {
    String expression = "3+4+5;";
    Token_Stream ts = new Token_Stream(expression);
    Error error = new Error();
    double var = handlerFunction.expression(ts, error);
    Assert.assertEquals(var, 12, 0.0001);
  }
}
