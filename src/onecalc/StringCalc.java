
package onecalc;

import java.util.ArrayList;
import java.util.List;
import java.lang.ArithmeticException;
/**
 * @author Yurii Leshchyshyn
 */
public class StringCalc {
    
    
    public StringCalc() {
    }
    
    public static double calculate(String expression) {
        List<String> expressionList = StringCalc.parseCharArrayToStringList(expression.toCharArray());
        
        return 0;
    }
    
    protected static  char[] calculateParentheses(char[] expressionArray) {
        for (int leftCounter = expressionArray.length-1; leftCounter == 0; leftCounter--){
            if(expressionArray[leftCounter] =='(') {
                expressionArray[leftCounter] = '#';
                for(int rightCounter = leftCounter; rightCounter > expressionArray.length; rightCounter++){
                    // call calculate method here
                    if(expressionArray[rightCounter] ==')') {
                        break;
                    }
                }
            }
        }
        return expressionArray;
    }
    
    protected static void calculateMultiplication(List<String> expressionList) {
        boolean calculationPerformed;
        do {
            calculationPerformed = false;
            for(int i = 0; i < expressionList.size();i++) {
                if( expressionList.get(i).equals("*")) {
                    double left = Double.parseDouble(expressionList.get(i-1));
                    double right = Double.parseDouble(expressionList.get(i+1));
                    expressionList.set(i, String.valueOf(left*right));
                    expressionList.remove(i+1);
                    expressionList.remove(i-1);
                    calculationPerformed = true;
                }
            }
        } while (calculationPerformed);
    }
    
    protected static void calculateDivision(List<String> expressionList) throws ArithmeticException {
        boolean calculationPerformed;
        do {
            calculationPerformed = false;
            for(int i = 0; i < expressionList.size();i++) {
                if( expressionList.get(i).equals("/")) {
                    double left = Double.parseDouble(expressionList.get(i-1));
                    double right = Double.parseDouble(expressionList.get(i+1));
                    if (right == 0) throw new ArithmeticException("Can't divide by 0"); // chech division by 0
                    expressionList.set(i, String.valueOf(left/right));
                    expressionList.remove(i+1);
                    expressionList.remove(i-1);
                    calculationPerformed = true;
                }
            }
        } while (calculationPerformed);
    }
    
    protected static void calculateAddition(List<String> expressionList) {
        boolean calculationPerformed;
        do {
            calculationPerformed = false;
            for(int i = 0; i < expressionList.size();i++) {
                if( expressionList.get(i).equals("+")) {
                    double left = Double.parseDouble(expressionList.get(i-1));
                    double right = Double.parseDouble(expressionList.get(i+1));
                    expressionList.set(i, String.valueOf(left+right));
                    expressionList.remove(i+1);
                    expressionList.remove(i-1);
                    calculationPerformed = true;
                }
            }
        } while (calculationPerformed);
    }
    
    protected static void calculateSubtraction(List<String> expressionList) {
        boolean calculationPerformed;
        do {
            calculationPerformed = false;
            for(int i = 0; i < expressionList.size();i++) {
                if( expressionList.get(i).equals("-")) {
                    double left = Double.parseDouble(expressionList.get(i-1));
                    double right = Double.parseDouble(expressionList.get(i+1));
                    expressionList.set(i, String.valueOf(left-right));
                    expressionList.remove(i+1);
                    expressionList.remove(i-1);
                    calculationPerformed = true;
                }
            }
        } while (calculationPerformed);
    }
    
    protected static List<String> parseCharArrayToStringList(char[] expressionArray) {
        //expression should be checked on mathematical correctness before calling this method.
        //only number and mathematical functions such as +,-, *, /, ^ and ( )
        List<String> expressionList = new ArrayList<>();
        for (int counter = 0; counter < expressionArray.length; counter++) {
            //parsing numbers to numbers, actions to actions
            switch(expressionArray[counter]) {
                case '(':   expressionList.add("(");
                               break;
                 case ')':   expressionList.add(")");
                               break;
                 case '+':   expressionList.add("+");
                               break;
                 case '-':   expressionList.add("-");
                               break;
                 case '*':   expressionList.add("*");
                               break;
                 case '/':   expressionList.add("/");
                               break;
           
                default: String number = "";
                    for(; counter < expressionArray.length; counter++) {
                        // check if it is a digit or a point(.)
                        if((expressionArray[counter] > 47 && expressionArray[counter] < 58) || expressionArray[counter] == '.') {
                            number += expressionArray[counter];
                        } else {
                            counter--;
                            break;
                        }
                    }
                    expressionList.add(number);
                    break;
            }
        }
        //distinguishing negative numbers, removing parentheses around them
        for(int i = 0; i < expressionList.size();i++) {
           if (expressionList.get(i).equals("-") && expressionList.get(i-1).equals("(") && expressionList.get(i+2).equals(")")) {
               String number = "-" + expressionList.get(i+1);
               expressionList.set(i+1, number);
               expressionList.remove(i+2);
               expressionList.remove(i);
               expressionList.remove(i-1);
           }
        }
        
        return expressionList;
    }
    
    private static boolean isNumber(String value) {
        
        if( value.length() > 1) {
            return true;
        }
        switch(value.charAt(0)) {
                 case '(':   return false;
                 case ')':   return false;
                 case '+':   return false;
                 case '-':   return false;
                 case '*':   return false;
                 case '/':   return false;
                 case '^':   return false;
           
                 default: return true;
        }
    }

}
