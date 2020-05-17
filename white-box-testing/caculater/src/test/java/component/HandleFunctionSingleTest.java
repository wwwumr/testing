package component;

import component.Error;
import component.HandlerFunction;
import component.Token_Stream;
import org.junit.Assert;
import org.junit.Test;

public class HandleFunctionSingleTest {

  HandlerFunction handlerFunction = new HandlerFunction();

  // test case 3!
  @Test
  public void test001() {
    String expression = "3!;";
    Token_Stream ts = new Token_Stream(expression);
    Error error = new Error();
    double var = handlerFunction.single(ts, error);
    Assert.assertEquals(var, 6, 0.0001);
  }

  // test case 3.5!
  @Test
  public void test002() {
    String expression = "3.5!;";
    Token_Stream ts = new Token_Stream(expression);
    Error error = new Error();
    double var = handlerFunction.single(ts, error);
    Assert.assertEquals(error.getError(), 4);
  }

  // test case 3
  @Test
  public void test003() {
    String expression = "3;";
    Token_Stream ts = new Token_Stream(expression);
    Error error = new Error();
    double var = handlerFunction.single(ts, error);
    Assert.assertEquals(var, 3, 0.0001);
  }
}
