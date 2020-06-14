import component.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    HandleFunctionExpressionTest.class,
    HandleFunctionTermTest.class,
    HandleFunctionSingleTest.class,
    HandleFunctionPrimaryTest.class,
    HandleTokenStreamGetTest.class,
    HandleTokenStreamNumberTest.class
})
public class MainTest {

}
