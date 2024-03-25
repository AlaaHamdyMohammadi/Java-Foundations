public class MathStuff {
    public static void main(String[] args) {

        System.out.println(Math.abs(-5));
        System.out.println(Math.ceil(5.1));
        System.out.println(Math.floor(-5.7)); //-6.0
        System.out.println(Math.floor(5.7)); //5.0
        System.out.println(Math.floor(5.7)); //5.0

        int num1 = 5, num2 = 3;
        System.out.println("Min = " + Math.min(num1, num2));
        System.out.println("Max = " + Math.max(num1, num2));
        System.out.println("Power = " + Math.pow(num1, num2)); // 125.0 => pow return double

        System.out.println((int)(Math.random() * 10));
        System.out.println((int)(Math.random() * 10));
        System.out.println((int)(Math.random() * 10));

        System.out.println((Math.round(5.7))); //
        System.out.println((Math.round(5.1)));


    }
}
