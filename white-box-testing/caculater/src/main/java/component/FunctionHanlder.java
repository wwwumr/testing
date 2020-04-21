package component;

public interface FunctionHanlder {
    double single(Token_Stream ts,Error error);
    double term(Token_Stream ts,Error error);
    double expression(Token_Stream ts,Error error);
    double primary(double val,Token_Stream ts,Error error);
    int fac(int val);
}
