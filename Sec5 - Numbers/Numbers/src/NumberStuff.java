import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class NumberStuff {
    public static void main(String[] args) {
        float num1 = 2.15f, num2 = 1.10f;

        BigDecimal num3 = new BigDecimal("2.15");
        BigDecimal num4 = new BigDecimal("1.10");
        System.out.println(num1 - num2);
        System.out.println(num3.subtract(num4)); // I can't do that (num3 - num4) because these ara non primitives

        MathContext mc = new MathContext(3, RoundingMode.HALF_UP);
        System.out.println(new BigDecimal("81").sqrt(mc));
    }
}
