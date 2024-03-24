import java.util.regex.Pattern;

public class RegexPractice {
    public static void main(String[] args) {
        String regex = "\\d{3}[-.\\s]+\\d{3}[-.\\s]+\\d{4}";
        System.out.println("321.333  7652".matches(regex)); // Only numbers
        Pattern phoneNumberPattern = Pattern.compiler(regex);
    }
}
