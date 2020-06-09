import component.Error;
import component.HandlerFunction;
import component.Token_Stream;

public class Main {
<<<<<<< HEAD
    public static void main(String[] args) {
        HandlerFunction handlerFunction = new HandlerFunction();
        String expression = "1+2*3-2/5;";
        Token_Stream ts = new Token_Stream(expression);
        Error error = new Error();
        error.setError(0);
        System.out.println(handlerFunction.expression(ts,error));
    }
=======

  public static void main(String[] args) {
    HandlerFunction handlerFunction = new HandlerFunction();
    String expression = "1+2*3-2/5;";
    Token_Stream ts = new Token_Stream(expression);
    Error error = new Error();
    error.setError(0);
    System.out.println(handlerFunction.expression(ts, error));
  }
>>>>>>> 00d40ac7c69cd4dc8e8ceadd0e65f90f5d5a9b9f
}
