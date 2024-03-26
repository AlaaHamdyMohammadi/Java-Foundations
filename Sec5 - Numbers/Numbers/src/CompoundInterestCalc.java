import java.math.BigDecimal;

public class CompoundInterestCalc {
    public static void main(String[] args) {
        System.out.println("Result = " + calculate("10000.00", "0.08", 10, "1000"));
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
