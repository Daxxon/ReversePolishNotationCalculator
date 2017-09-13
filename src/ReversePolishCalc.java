import java.util.Arrays;

public class ReversePolishCalc {
  private int stackHeight = 0;

  private String[] tokens;

  public double calculate(String input) {

    tokens = input.split(",");

    double operandOne;
    double operandTwo;

    for (int i=0; i < tokens.length; i++) {
      switch (tokens[i]) {
        case "+" :
          operandOne = Double.parseDouble(tokens[i-2]);
          operandTwo = Double.parseDouble(tokens[i-1]);
          tokens[i-2] = null;
          tokens[i-1] = null;
          tokens[i] = Double.toString(operandOne + operandTwo);
          tokens = cleanUpTokens(tokens);
          break;
        case "-" :
          operandOne = Double.parseDouble(tokens[i-2]);
          operandTwo = Double.parseDouble(tokens[i-1]);
          tokens[i-2] = null;
          tokens[i-1] = null;
          tokens[i] = Double.toString(operandOne - operandTwo);
          tokens = cleanUpTokens(tokens);
          break;
        case "*" :
          operandOne = Double.parseDouble(tokens[i-2]);
          operandTwo = Double.parseDouble(tokens[i-1]);
          tokens[i-2] = null;
          tokens[i-1] = null;
          tokens[i] = Double.toString(operandOne * operandTwo);
          tokens = cleanUpTokens(tokens);
          break;
        case "/" :
          operandOne = Double.parseDouble(tokens[i-2]);
          operandTwo = Double.parseDouble(tokens[i-1]);
          tokens[i-2] = null;
          tokens[i-1] = null;
          tokens[i] = Double.toString(operandOne / operandTwo);
          tokens = cleanUpTokens(tokens);
          break;
        default:
          break;
      }
    }
    return Double.parseDouble(tokens[tokens.length -1]);
  }

  private String[] cleanUpTokens (String[] myTokens) {
    String[] tempTokens = new String[myTokens.length];
    int count = 0;
    for (int i=0; i<myTokens.length; i++) {
      if (myTokens[i] == null) {
        tempTokens[count] = null;
        count++;
      }
    }
    for (int i=0; i<myTokens.length; i++) {
      if (myTokens[i] != null) {
        tempTokens[count] = myTokens[i];
        count++;
      }
    }
    return tempTokens;
  }
}
