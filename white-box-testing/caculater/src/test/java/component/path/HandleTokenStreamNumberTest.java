package component.path;

import component.Token_Stream;
import org.junit.Assert;
import org.junit.Test;

public class HandleTokenStreamNumberTest {
    @Test
    public void test001() {
        String expression = "";
        Token_Stream ts = new Token_Stream(expression);
        Double number = ts.number();
        Assert.assertEquals(number,0,0.001);
    }
    @Test
    public void test002() {
        String expression = "1.2";
        Token_Stream ts = new Token_Stream(expression);
        Double number = ts.number();
        Assert.assertEquals(number,1.2,0.001);
    }
}
