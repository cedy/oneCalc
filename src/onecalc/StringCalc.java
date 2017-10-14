
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
        // converts string to list of string's elements
        List<String> expressionList = StringCalc.parseCharArrayToStringList(expression.toCharArray());
        // calculates expression inside parentheses
        StringCalc.calculateParentheses(expressionList);
        // final calculation after all parentheses are calculated
        String result = StringCalc.calculate(expressionList);
        return Double.parseDouble(result);
    }
    
    protected static  void calculateParentheses(List<String> expressionList) {
        //method to calculate expression in parentheses
            for(int rightP = 0; rightP < expressionList.size(); rightP++) {
                //loop through list until found ')'
                if( expressionList.get(rightP).equals(")")) {
                     for(int leftP = rightP; leftP >= 0 ; leftP--) {
                         //loop backwards until found matching '('
                           if( expressionList.get(leftP).equals("(")) {
                               //calculate expression inside parentheses
                               String result = StringCalc.calculate(expressionList.subList(leftP+1, rightP));
 
                               //remove parentheses around inner expression
                               expressionList.remove(leftP+2);
                               expressionList.remove(leftP);
                               rightP = 0;                            
                           }
                     }
                }
            }

    }
    
    private static String calculate(List<String> expressionList) {
        //calculating expression in mathematical order. Method returns result of the expression.
        StringCalc.calculatePower(expressionList);
        StringCalc.calculateMultiplication(expressionList);
        StringCalc.calculateDivision(expressionList);
        StringCalc.calculateAddition(expressionList);
        StringCalc.calculateSubtraction(expressionList);
        
        return expressionList.get(0);
    }
    
    protected static void calculatePower(List<String> expressionList) {
        // calculates power and substitutes expression with a result
        boolean calculationPerformed;
        do {
            calculationPerformed = false;
            for(int i = 0; i < expressionList.size();i++) {
                if( expressionList.get(i).equals("^")) {
                    double left = Double.parseDouble(expressionList.get(i-1));
                    double right = Double.parseDouble(expressionList.get(i+1));
                    expressionList.set(i, String.valueOf(Math.pow(left, right)));
                    expressionList.remove(i+1);
                    expressionList.remove(i-1);
                    calculationPerformed = true;
                }
            }
        } while (calculationPerformed);
    }
    
    protected static void calculateMultiplication(List<String> expressionList) {
        // calculates multiplication and substitutes expression with a result
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
        // calculates division and substitutes expression with a result
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
        // calculates addition and substitutes expression with a result
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
        // calculates subtraction and substitutes expression with a result
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
        // returns list of string where each element a number or mathematical function or parentheses
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
                 case '^':   expressionList.add("^");
                               break;              
           
                default: String number = "";
                    for(; counter < expressionArray.length; counter++) {
                        // checks if it is a digit or a point and compiles number from digits and point
                        if((expressionArray[counter] > 47 && expressionArray[counter] < 58) || expressionArray[counter] == '.') {
                            number += expressionArray[counter];
                        } else {
                           //stops when non digit or a point goes next. puts array pointer counter in a right position
                            counter--;
                            break;
                        }
                    }
                    expressionList.add(number);
                    break;
            }
        }
        //negative numbers in expression should be surrounded by parentheses 
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
    
}
