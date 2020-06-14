package component;

import component.Error;
import component.HandlerFunction;
import component.Token_Stream;
import org.junit.Assert;
import org.junit.Test;

public class HandleFunctionPrimaryTest {

  HandlerFunction handlerFunction = new HandlerFunction();

  @Test
  public void test001() {
    String expression = "3;";
    Token_Stream ts = new Token_Stream(expression);
    Error error = new Error();
    double var = handlerFunction.primary(ts, error);
    Assert.assertEquals(var, 3, 0.0001);
  }

  @Test
  public void test002() {
    String expression = "+4;";
    Token_Stream ts = new Token_Stream(expression);
    Error error = new Error();
    double var = handlerFunction.primary(ts, error);
    Assert.assertEquals(var, 4, 0.0001);
  }

  @Test
  public void test003() {
    String expression = "-3;";
    Token_Stream ts = new Token_Stream(expression);
    Error error = new Error();
    double var = handlerFunction.primary(ts, error);
    Assert.assertEquals(-3, var, 0.0001);
  }

  @Test
  public void test004() {
    String expression = "(4-2;";
    Token_Stream ts = new Token_Stream(expression);
    Error error = new Error();
    handlerFunction.primary(ts, error);
    Assert.assertEquals(error.getError(), 5);
  }

  @Test
  public void test005() {
    String expression = "(4-2);";
    Token_Stream ts = new Token_Stream(expression);
    Error error = new Error();
    double var = handlerFunction.primary(ts, error);
    Assert.assertEquals(var, 2, 0.0001);
  }

  @Test
  public void test006() {
    String expression = ");";
    Token_Stream ts = new Token_Stream(expression);
    Error error = new Error();
    handlerFunction.primary(ts, error);
    Assert.assertEquals(error.getError(), 6);
  }

  @Test
  public void test008() {
    String expression = "(1);";
    Token_Stream ts = new Token_Stream(expression);
    Error error = new Error();
    double var = handlerFunction.primary(ts, error);
    Assert.assertEquals(var, 1, 0001);
  }

  @Test
  public void test009() {
    String expression = "+1;";
    Token_Stream ts = new Token_Stream(expression);
    Error error = new Error();
    double var = handlerFunction.primary(ts, error);
    Assert.assertEquals(var, 1, 0001);
  }

  @Test
  public void test007() {
    String expression = "-1;";
    Token_Stream ts = new Token_Stream(expression);
    Error error = new Error();
    double var = handlerFunction.primary(ts, error);
    Assert.assertEquals(var, -1, 0001);
  }
}
