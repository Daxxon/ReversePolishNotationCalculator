import java.util.Arrays;

public class ReversePolishCalc {
  private int stackHeight = 0;

  private String[] tokens;

  private String[] tempTokens;

  private boolean complete = false;

  public double calculate(String input) {

    tokens = input.split(",");

    // System.out.println("length of index 0: " + tokens[0].length());
    // System.out.println("length of index 1: " + tokens[1].length());
    // System.out.println("length of index 2: " + tokens[2].length());
    // System.out.println("length of index 3: " + tokens[3].length());
    // System.out.println("length of index 4: " + tokens[4].length());
    // System.out.println("length of index 5: " + tokens[5].length());
    // System.out.println("length of index 6: " + tokens[6].length());
    // System.out.println("length of index 7: " + tokens[7].length());
    // System.out.println("length of index 8: " + tokens[8].length());
    double operandOne;
    double operandTwo;

    for (int i=0; i < tokens.length; i++) {
      switch (tokens[i]) {
        case "+" :
          System.out.println("adding");
          printTokens();
          operandOne = Double.parseDouble(tokens[i-2]);
          operandTwo = Double.parseDouble(tokens[i-1]);
          tokens[i-2] = null;
          tokens[i-1] = null;
          tokens[i] = Double.toString(operandOne + operandTwo);
          tokens = cleanUpTokens(tokens);
          break;
        case "-" :
          System.out.println("subtracting");
          printTokens();
          operandOne = Double.parseDouble(tokens[i-2]);
          operandTwo = Double.parseDouble(tokens[i-1]);
          tokens[i-2] = null;
          tokens[i-1] = null;
          tokens[i] = Double.toString(operandOne - operandTwo);
          tokens = cleanUpTokens(tokens);
          break;
        case "*" :
          System.out.println("multiplying?");
          printTokens();
          operandOne = Double.parseDouble(tokens[i-2]);
          operandTwo = Double.parseDouble(tokens[i-1]);
          tokens[i-2] = null;
          tokens[i-1] = null;
          tokens[i] = Double.toString(operandOne * operandTwo);
          tokens = cleanUpTokens(tokens);
          break;
        case "/" :
          System.out.println("dividing");
          printTokens();
          operandOne = Double.parseDouble(tokens[i-2]);
          operandTwo = Double.parseDouble(tokens[i-1]);
          tokens[i-2] = null;
          tokens[i-1] = null;
          tokens[i] = Double.toString(operandOne / operandTwo);
          tokens = cleanUpTokens(tokens);
          break;
        default:
          System.out.println("Found number: " + tokens[i]);
          break;
      }
      // break;
    }

    System.out.println("end of iteration");

    if (tokens[1] != null) {
      String tempTokens = null;
      for (int i=0; i<tokens.length; i++) {
        tempTokens += tokens[i] + ",";
      }
      System.out.println("calculating stuff again");
      // calculate(tempTokens);
    }

    return Double.parseDouble(tokens[tokens.length -1]);
  }

  private String[] cleanUpTokens (String[] myTokens) {
    System.out.println("Cleaning tokens");
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

  private void printTokens () {
    System.out.print("Tokens: ");
    for (int i=0; i<tokens.length; i++){
      System.out.print(tokens[i]);
    }
    System.out.println();
  }
}
