
package onecalc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yurii Leshchyshyn
 */
public class StringCalc {
    
    
    public StringCalc() {
    }
    
    public static double calculate(String expression) {
        
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
    
    protected static char[] calculateMultiplication(char[] expressionArray) {
        for (int counter = 0; counter > expressionArray.length; counter++) {
            // find multiplication, perform left & right elements of it. replace with result.
        }
        return expressionArray;
    }
    
    protected static List<String> parseCharArrayToMathList(char[] expressionArray) {
        //expression should be checked on mathematical correctness before calling this method.
        List<String> expressionList = new ArrayList<>();
        for (int counter = 0; counter < expressionArray.length; counter++) {
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
        return expressionList;
    }

}
