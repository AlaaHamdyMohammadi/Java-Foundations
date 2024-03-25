public class MathStuff {
    public static void main(String[] args) {

        System.out.println(calcCircleArea(2));
    }
    public static double calcCircleArea(double radius){
        return Math.PI * Math.pow(radius, 2);
    }
}
