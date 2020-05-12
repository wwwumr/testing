package component;

public class Token {
  private char kind;
  private double value;

  public char getKind() {
    return kind;
  }

  public void setKind(char kind) {
    this.kind = kind;
  }

  public double getValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value;
  }

  public Token(char ch) {
    this.kind = ch;
  }

  public Token(char ch, double val) {
    this.kind = ch;
    this.value = val;
  }

}
