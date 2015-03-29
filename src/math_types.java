import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by odogryk on 14.03.2015.
 */
public class math_types {

/*
    public static String ToBinaryString {
        //dd
    }
*/
    private static String tobit(int y) {
        return String.format("%32s", Integer.toBinaryString(y)).replace(' ', '0');
    }

    public static void main(String[] args) {
        BigInteger i = new BigInteger("12345");
        BigDecimal d = new BigDecimal("1239.9393");

        System.out.println(i.toString()+d.toString());
        System.out.println(d.divide(new BigDecimal("3"),3));

        int x = 2345;
        System.out.println(tobit(x));
        System.out.println(String.format("%32s", Integer.toBinaryString(x)).replace(' ', '0'));

    }
}
