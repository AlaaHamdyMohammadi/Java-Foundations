public class LearnStrings {
    public static void main(String[] args) {
       String firstName = "  Alaa  ";

       System.out.format("'%s'", firstName.strip());
       System.out.println("");
       System.out.format("'%s'", firstName.stripLeading());
       System.out.println("");
       System.out.format("'%s'", firstName.stripTrailing());
       System.out.println("");


    }
}
