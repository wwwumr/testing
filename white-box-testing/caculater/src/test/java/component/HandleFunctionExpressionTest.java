package component;

import component.Error;
import component.HandlerFunction;
import component.Token_Stream;
import org.junit.Assert;
import org.junit.Test;

public class HandleFunctionExpressionTest {

  HandlerFunction handlerFunction = new HandlerFunction();

  @Test
  public void test001() {
    String expression = "3+4-5;";
    Token_Stream ts = new Token_Stream(expression);
    Error error = new Error();
    double var = handlerFunction.expression(ts, error);
    Assert.assertEquals(var, 2, 0.0001);
  }

  @Test
  public void test002() {
    String expression = "3;";
    Token_Stream ts = new Token_Stream(expression);
    Error error = new Error();
    double var = handlerFunction.expression(ts, error);
    Assert.assertEquals(var, 3, 0.0001);
  }

  @Test
  public void test003() {
    String expression = "3+4;";
    Token_Stream ts = new Token_Stream(expression);
    Error error = new Error();
    double var = handlerFunction.expression(ts, error);
    Assert.assertEquals(var, 7, 0.0001);
  }

  @Test
  public void test004() {
    String expression = "3+4+5;";
    Token_Stream ts = new Token_Stream(expression);
    Error error = new Error();
    double var = handlerFunction.expression(ts, error);
    Assert.assertEquals(var, 12, 0.0001);
  }

  @Test
  public void test005() {
    String expression = "1-1+1+1-1;";
    Token_Stream ts = new Token_Stream(expression);
    Error error = new Error();
    double var = handlerFunction.expression(ts, error);
    Assert.assertEquals(var, 1, 0.0001);
  }

  @Test
  public void test006() {
    String expression = "1+1;";
    Token_Stream ts = new Token_Stream(expression);
    Error error = new Error();
    double var = handlerFunction.expression(ts, error);
    Assert.assertEquals(var, 2, 0.0001);
  }

  @Test
  public void test007() {
    String expression = "1-1;";
    Token_Stream ts = new Token_Stream(expression);
    Error error = new Error();
    double var = handlerFunction.expression(ts, error);
    Assert.assertEquals(var, 0, 0.0001);
  }
}
