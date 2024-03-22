public class LearnStrings {
    public static void main(String[] args) {
//       String firstWord = "Apple";
//       String secondWord = "Banana";
//        System.out.println(firstWord.compareTo(secondWord));

        System.out.println(compareToIgnoreCase("Alaa", "arwa"));
    }
    public static int compareToIgnoreCase(String text1, String text2){
         String firstText = text1.toLowerCase();
         String secondText = text2.toLowerCase();
         return firstText.compareTo(secondText);
    }
}
