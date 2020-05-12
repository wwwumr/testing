package component;

public class HandlerFunction implements FunctionHanlder {
  @Override
  public double single(Token_Stream ts, Error error) {
    double val = primary(ts, error);
    Token token = ts.get();
    if (token.getKind() == '!') {
      int tempValue = (int) val;
      if (tempValue == val) {
        int a = (int) val;
        val = fac(a);
        return val;
      } else {
        error.setError(4);
      }
    } else {
      ts.push_back(token);
    }
    return val;
  }

  @Override
  public double term(Token_Stream ts, Error error) {
    double val = single(ts, error);
    while (true) {
      Token token = ts.get();
      switch (token.getKind()) {
        case '*':
          val *= single(ts, error);
          break;
        case '/':
          double a;
          a = single(ts, error);
          if (a == 0) {
            error.setError(1);
          } else
            val /= a;
          break;
        case '%':
          double b;
          b = single(ts, error);
          if (val != (int) val || b != (int) b) {
            error.setError(2);
          } else if (b == 0) {
            error.setError(3);
          } else {
            int c = (int) val;
            int d = (int) b;
            val = c % d;
          }
          break;
        default:
          ts.push_back(token);
          return val;
      }
    }
  }

  @Override
  public double expression(Token_Stream ts, Error error) {
    double val = term(ts, error);
    Token t = ts.get();
    while (t.getKind() == '+' || t.getKind() == '-') {
      if (t.getKind() == '+') {
        val += term(ts, error);
        t = ts.get();
      }
      if (t.getKind() == '-') {
        val -= term(ts, error);
        t = ts.get();
      }
    }
    ts.push_back(t);
    return val;
  }

  @Override
  public double primary(Token_Stream ts, Error error) {
    Token token = ts.get();
    double val = 0;
    switch (token.getKind()) {
      case '8':
        val = token.getValue();
        break;
      case '(':
        val = expression(ts, error);
        token = ts.get();
        if (token.getKind() != ')') {
          error.setError(5);
        }
        break;
      case '+':
        val = primary(ts, error);
        break;
      case '-':
        val = -primary(ts, error);
        break;
      default:
        error.setError(6);
    }
    return val;
  }

  @Override
  public int fac(int val) {
    if (val == 0) {
      return 1;
    } else {
      int a = Math.abs(val);
      return val * fac(a - 1);
    }
  }
}
