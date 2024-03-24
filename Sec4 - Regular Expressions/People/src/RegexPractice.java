public class RegexPractice {
    public static void main(String[] args) {
        System.out.println("gat".matches("[a-fA-F]at")); // Contain
        System.out.println("Bat".matches("[^a-f]at")); // Not contain
        System.out.println("wat".matches("\\wat")); // String OR Numbers OR Underscore
        System.out.println("5at".matches("\\dat")); // Only numbers
        System.out.println("321.333  7652".matches("\\d{3}[-.\\s]+\\d{3}[-.\\s]+\\d{4}")); // Only numbers
    }
}
