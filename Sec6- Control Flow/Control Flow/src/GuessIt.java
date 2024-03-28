public class GuessIt {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        while( i < 5){
            System.out.printf("While Result = %d%n", i);
            i++;
        }
        do{
            System.out.printf("Do While Result = %d%n", j);
            j++;
        }while(j < 5);
    }

}
