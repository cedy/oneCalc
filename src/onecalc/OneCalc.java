/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onecalc;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yurii Leshchyshyn
 */
public class OneCalc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String exmp = "1+2*3*4/3-0.5*10+5"; // equals -1
        String text = "";
        List<String> expressionList = StringCalc.parseCharArrayToStringList(exmp.toCharArray());
        //StringCalc.calculateMultiplication(expressionList);
        //StringCalc.calculateDivision(expressionList);
        //StringCalc.calculateAddition(expressionList);
        //StringCalc.calculateSubtraction(expressionList);
        for(int i = 0; i < expressionList.size();i++) {
           System.out.println(expressionList.get(i));
        }
//        
//        double n1 = -10;
//        double n2 = -3;
//        System.out.println(n1*n2);
//        System.out.println(n1/n2);
//        System.out.println(n1-n2);
//        System.out.println(n1+n2);
    }
    
}
