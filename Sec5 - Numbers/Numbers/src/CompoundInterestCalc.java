import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class CompoundInterestCalc {
    public static void main(String[] args) {
        NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        BigDecimal result = calculate("10000.00", "0.08", 10, "1000");
//        System.out.println("Result = " + moneyFormatter.format(result));
        System.out.printf("$%,(.4f%n", result);
    }

    public static BigDecimal calculate(String p, String r, int y, String c){
        BigDecimal a = BigDecimal.ONE.add(new BigDecimal(r)); // ( 1 + r )
        BigDecimal b = a.pow(y); // ( 1 + r )^Y
        BigDecimal d = b.subtract(BigDecimal.ONE); // ( ( 1 + r )^Y - 1 )
        BigDecimal e = d.divide(new BigDecimal(r)); // ( ( 1 + r )^Y - 1 ) / r
        BigDecimal f = new BigDecimal(c).multiply(e); // c[ ((1 + r)^Y - 1) / r ]
        BigDecimal g = new BigDecimal(p).multiply(b); // P(1 + r)^Y
        BigDecimal result = g.add(f); // Result = P(1 + r)^Y  +  c[ ((1 + r)^Y - 1) / r ]
        return result;
    }
}
