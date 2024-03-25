public class MathStuff {
    public static void main(String[] args) {

        System.out.println("calcCircleArea = " + calcCircleArea(2));
        System.out.println("calcPath = " + calcPath(0.8, 3));
        System.out.println("calcCentripetal = " + calcCentripetal(1.67, 0.8));
        System.out.println("calcForce = " + calcForce(0.2, calcCentripetal(1.67, 0.8)) );
        System.out.println("calcCentripetalForce = " + calcCentripetalForce(0.8, 3, 0.2));
    }
    public static double calcCircleArea(double radius){
        return Math.PI * Math.pow(radius, 2);
    }

    public static double calcPath(double r, double period){
        double upNumber = 2 * Math.PI * r;
        return upNumber / period;
    }

    public static double calcCentripetal(double v, double r){
        return Math.pow(v, 2) / r;
    }

    public static double calcForce(double m, double acc){
        return m * acc;
    }

    public static double calcCentripetalForce(double r, double period, double v){
        double calcPath = calcPath(r, period);
        double calcCentripetal = calcCentripetal(calcPath, r);
        double calcForce = calcForce(v, calcCentripetal);
        return calcForce;
    }
}
