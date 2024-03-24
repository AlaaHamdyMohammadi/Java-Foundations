public class RegexPractice {
    public static void main(String[] args) {
        System.out.println("gat".matches("[a-fA-F]at"));
        System.out.println("Bat".matches("[^a-f]at"));
    }
}
