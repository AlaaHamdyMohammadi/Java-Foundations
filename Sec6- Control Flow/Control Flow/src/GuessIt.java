import java.util.Random;
public class GuessIt {
    public static void main(String[] args) {
        System.out.println(guessNumber(3));
    }
    public static int guessNumber(int number){
        Random random = new Random();
        int result = random.nextInt(number + 1);
        switch (result){
            case 1:
                System.out.println("The color is RED");
                break;
            case 2:
                System.out.println("The color is yellow");
                break;
            case 3:
                System.out.println("The color is green");
                break;
            default:
                System.out.println("OUT");
                break;
        }
        return result;
    }
}
