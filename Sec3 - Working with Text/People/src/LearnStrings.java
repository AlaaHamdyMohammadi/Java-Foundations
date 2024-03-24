public class LearnStrings {
    public static void main(String[] args) {
       String text = """
               Alaa, Hamdy, Mohammadi
               Alaa, Hamdy, Mohammadi
               Alaa, Hamdy, Mohammadi
               Alaa, Hamdy, Mohammadi
               Alaa, Hamdy, Mohammadi
               """;
       String[] me = text.split("\n");
       System.out.println(me.length);
       String[] meItems = me[2].split(", ");
        System.out.println(meItems[0]);
    }



}
