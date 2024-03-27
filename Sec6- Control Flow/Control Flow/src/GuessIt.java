import java.util.Random;
public class GuessIt {
    public static void main(String[] args) {
        System.out.println(guessNumber(3));
    }
    public static int guessNumber(int number){
        Random random = new Random();
        int result = random.nextInt(number + 1);
            System.out.printf("Your Guess = %d%n", result);
        if(result == 3){
            System.out.printf("Your Guess is right");
        }else{
            System.out.printf("Your Guess is wrong");
        }
        return result;
    }
}
