package component;

import java.util.ArrayList;
import java.util.List;

public class Token_Stream {

  private List<Character> NUMBER_COMPONENT;
  private Token buffer;
  boolean buffered;
  private char[] expression;
  private int length;
  private int currentIndex;

  private double number() {
    String tempNumber = "";
    for (int i = currentIndex; i < length; i++) {
      if (NUMBER_COMPONENT.contains(expression[i])) {
        tempNumber += expression[i];
        currentIndex++;
      } else {
        break;
      }
    }
    try {
      double number = Double.parseDouble(tempNumber);
      return number;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      System.exit(-1);
    }
    return 0;
  }

  public Token_Stream(String expression) {
    this.buffer = new Token('8', 0);
    this.buffered = true;
    this.length = expression.length();
    this.expression = expression.toCharArray();
    this.currentIndex = 0;

    List<Character> temp = new ArrayList<>();
    temp.add('0');
    temp.add('1');
    temp.add('2');
    temp.add('3');
    temp.add('4');
    temp.add('5');
    temp.add('6');
    temp.add('7');
    temp.add('8');
    temp.add('9');
    temp.add('.');

    this.NUMBER_COMPONENT = temp;
  }

  public void push_back(Token t) {
    this.buffer = t;
    this.buffered = false;
  }

  public Token get() {
    if (!this.buffered) {
      this.buffered = true;
      return buffer;
    }
    char ch = this.expression[this.currentIndex];
    this.currentIndex++;
    switch (ch) {
      case ';':
      case '+':
      case '-':
      case '*':
      case '/':
      case '(':
      case ')':
      case '%':
      case '!':
        return new Token(ch);
      case '0':
      case '1':
      case '2':
      case '3':
      case '4':
      case '5':
      case '6':
      case '7':
      case '8':
      case '9': {
        this.currentIndex--;
        double val = this.number();
        return new Token('8', val);
      }
      default: {
        System.out.println("Error token: " + ch);
        return new Token(ch);
      }
    }
  }
}
