package component;

import org.junit.Assert;
import org.junit.Test;

public class HandleFunctionPrimaryTest {

  HandlerFunction handlerFunction = new HandlerFunction();

  @Test
  public void testPrimary001() {
    String expression = "3;";
    Token_Stream ts = new Token_Stream(expression);
    Error error = new Error();
    double var = handlerFunction.primary(ts, error);
    Assert.assertEquals(var, 3, 0.0001);
  }

  @Test
  public void testPrimary002() {
    String expression = "+4;";
    Token_Stream ts = new Token_Stream(expression);
    Error error = new Error();
    double var = handlerFunction.primary(ts, error);
    Assert.assertEquals(var, 7, 0.0001);
  }

  @Test
  public void testPrimary003() {
    String expression = "-3;";
    Token_Stream ts = new Token_Stream(expression);
    Error error = new Error();
    double var = handlerFunction.primary(ts, error);
    Assert.assertEquals(1, var, 0.0001);
  }

  @Test
  public void testPrimary004() {
    String expression = "(4-2;";
    Token_Stream ts = new Token_Stream(expression);
    Error error = new Error();
    double var = handlerFunction.primary(ts, error);
    Assert.assertEquals(error.getError(), 5);
  }

  @Test
  public void testPrimary005() {
    String expression = "(4-2);";
    Token_Stream ts = new Token_Stream(expression);
    Error error = new Error();
    double var = handlerFunction.primary(ts, error);
    Assert.assertEquals(var, 2, 0.0001);
  }

  @Test
  public void testPrimary006() {
    String expression = ");";
    Token_Stream ts = new Token_Stream(expression);
    Error error = new Error();
    double var = handlerFunction.primary(ts, error);
    Assert.assertEquals(error.getError(), 6);
  }
}
