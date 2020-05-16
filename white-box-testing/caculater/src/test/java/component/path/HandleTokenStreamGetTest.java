package component.path;

import component.Token;
import component.Token_Stream;
import org.junit.Assert;
import org.junit.Test;

public class HandleTokenStreamGetTest {
    @Test
    public void test001() {
        String expression = ";";
        Token_Stream ts = new Token_Stream(expression);
        Token token = ts.get();
        Assert.assertEquals(token.getKind(),';');
    }
    @Test
    public void test003() {
        String expression = "+";
        Token_Stream ts = new Token_Stream(expression);
        Token token = ts.get();
        Assert.assertEquals(token.getKind(),'+');
    }
    @Test
    public void test004() {
        String expression = "-";
        Token_Stream ts = new Token_Stream(expression);
        Token token = ts.get();
        Assert.assertEquals(token.getKind(),'-');
    }
    @Test
    public void test005() {
        String expression = "*";
        Token_Stream ts = new Token_Stream(expression);
        Token token = ts.get();
        Assert.assertEquals(token.getKind(),'*');
    }
    @Test
    public void test006() {
        String expression = "/";
        Token_Stream ts = new Token_Stream(expression);
        Token token = ts.get();
        Assert.assertEquals(token.getKind(),'/');
    }
    @Test
    public void test007() {
        String expression = "%";
        Token_Stream ts = new Token_Stream(expression);
        Token token = ts.get();
        Assert.assertEquals(token.getKind(),'%');
    }
    @Test
    public void test008() {
        String expression = "(";
        Token_Stream ts = new Token_Stream(expression);
        Token token = ts.get();
        Assert.assertEquals(token.getKind(),'(');
    }
    @Test
    public void test009() {
        String expression = ")";
        Token_Stream ts = new Token_Stream(expression);
        Token token = ts.get();
        Assert.assertEquals(token.getKind(),')');
    }
    @Test
    public void test010() {
        String expression = "!";
        Token_Stream ts = new Token_Stream(expression);
        Token token = ts.get();
        Assert.assertEquals(token.getKind(),'!');
    }
    @Test
    public void test002() {
        String expression = "0";
        Token_Stream ts = new Token_Stream(expression);
        Token token = ts.get();
        Assert.assertEquals(token.getValue(),0,0.001);
    }
    @Test
    public void test011() {
        String expression = "1";
        Token_Stream ts = new Token_Stream(expression);
        Token token = ts.get();
        Assert.assertEquals(token.getValue(),1,0.001);
    }
    @Test
    public void test012() {
        String expression = "2";
        Token_Stream ts = new Token_Stream(expression);
        Token token = ts.get();
        Assert.assertEquals(token.getValue(),2,0.001);
    }
    @Test
    public void test013() {
        String expression = "3";
        Token_Stream ts = new Token_Stream(expression);
        Token token = ts.get();
        Assert.assertEquals(token.getValue(),3,0.001);
    }
    @Test
    public void test014() {
        String expression = "4";
        Token_Stream ts = new Token_Stream(expression);
        Token token = ts.get();
        Assert.assertEquals(token.getValue(),4,0.001);
    }
    @Test
    public void test015() {
        String expression = "5";
        Token_Stream ts = new Token_Stream(expression);
        Token token = ts.get();
        Assert.assertEquals(token.getValue(),5,0.001);
    }
    @Test
    public void test016() {
        String expression = "6";
        Token_Stream ts = new Token_Stream(expression);
        Token token = ts.get();
        Assert.assertEquals(token.getValue(),6,0.001);
    }
    @Test
    public void test017() {
        String expression = "7";
        Token_Stream ts = new Token_Stream(expression);
        Token token = ts.get();
        Assert.assertEquals(token.getValue(),7,0.001);
    }
    @Test
    public void test018() {
        String expression = "8";
        Token_Stream ts = new Token_Stream(expression);
        Token token = ts.get();
        Assert.assertEquals(token.getValue(),8,0.001);
    }
    @Test
    public void test019() {
        String expression = "9";
        Token_Stream ts = new Token_Stream(expression);
        Token token = ts.get();
        Assert.assertEquals(token.getValue(),9,0.001);
    }
    @Test
    public void test020() {
        String expression = "~";
        Token_Stream ts = new Token_Stream(expression);
        Token token = ts.get();
        Assert.assertEquals(token.getKind(),'~');
    }
    @Test
    public void test021() {
        String expression = "1";
        Token_Stream ts = new Token_Stream(expression);
        Token token1 = new Token('*');
        ts.push_back(token1);
        Token token = ts.get();
        Assert.assertEquals(token.getKind(),'*');
    }
}
