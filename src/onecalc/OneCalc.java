
package onecalc;

/**
 *
 * @author Yurii Leshchyshyn
 */
public class OneCalc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String exmp = "2^(2+2)+2*2-(-5)/5"; // equals 21
        double result = StringCalc.calculate(exmp);
        System.out.println(result);

    }
    
}
