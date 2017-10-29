
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
        String exmp = "((2+((2+2)^2)-5*35^2+(4-5)/2)^2)/3"; // equals 1.2433852083333334E7
        double result = StringCalc.calculate(exmp);
        System.out.println(result);

    }
    
}
