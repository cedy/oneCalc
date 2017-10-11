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
        String exmp = "(12234.4545+7.923420/234)*023423.5234267";
        String text = "";
        List<String> expressionList = StringCalc.parseCharArrayToMathList(exmp.toCharArray());
        for(String str: expressionList){
            System.out.println(str);
        }
    }
    
}
