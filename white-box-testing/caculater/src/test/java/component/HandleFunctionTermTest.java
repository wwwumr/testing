package component;

import component.Error;
import component.HandlerFunction;
import component.Token_Stream;
import org.junit.Assert;
import org.junit.Test;

public class HandleFunctionTermTest {

    HandlerFunction handlerFunction = new HandlerFunction();

    @Test
    public void test001() {
        String expression = "3;";
        Token_Stream ts = new Token_Stream(expression);
        Error error = new Error();
        double var = handlerFunction.term(ts, error);
        Assert.assertEquals(var, 3, 0.0001);
    }

    @Test
    public void test002() {
        String expression = "3*3;";
        Token_Stream ts = new Token_Stream(expression);
        Error error = new Error();
        double var = handlerFunction.term(ts, error);
        Assert.assertEquals(var, 9, 0.0001);
    }

    @Test
    public void test003() {
        String expression = "3/2;";
        Token_Stream ts = new Token_Stream(expression);
        Error error = new Error();
        double var = handlerFunction.term(ts, error);
        Assert.assertEquals(1.5, var, 0.0001);
    }

    @Test
    public void test004() {
        String expression = "3/0;";
        Token_Stream ts = new Token_Stream(expression);
        Error error = new Error();
        double var = handlerFunction.term(ts, error);
        Assert.assertEquals(error.getError(), 1);
    }

    @Test
    public void test005() {
            String expression = "3%2.3;";
        Token_Stream ts = new Token_Stream(expression);
        Error error = new Error();
        double var = handlerFunction.term(ts, error);
        Assert.assertEquals(error.getError(),2);
    }

    @Test
    public void test006() {
        String expression = "3%0;";
        Token_Stream ts = new Token_Stream(expression);
        Error error = new Error();
        double var = handlerFunction.term(ts, error);
        Assert.assertEquals(error.getError(),3);
    }
    @Test
    public void test007() {
        String expression = "3%2;";
        Token_Stream ts = new Token_Stream(expression);
        Error error = new Error();
        double var = handlerFunction.term(ts, error);
        Assert.assertEquals(var,1,0.0001);
    }

    @Test
    public void test008() {
        String expression = "1*1/1%1;";
        Token_Stream ts = new Token_Stream(expression);
        Error error = new Error();
        double var = handlerFunction.term(ts, error);
        Assert.assertEquals(var,0,0.0001);
    }
}
