public class LearnStrings {
    public static void main(String[] args) {
       String phoneNumber = "    (234) 333-5551".strip();
       String areaCode = parseAreaCode(phoneNumber);
       String exchange = parseExchange(phoneNumber);
       String lineNumber = parseLineNumber(phoneNumber);

       System.out.println(areaCode);
       System.out.println(exchange);
       System.out.println(lineNumber);
    }

    public static String parseAreaCode(String phoneNumber){
        int openParens = phoneNumber.indexOf("(");
        int closeParens = phoneNumber.indexOf(")");
        return phoneNumber.substring(openParens + 1, closeParens);
    }
    public static String parseExchange(String phoneNumber){
        int space = phoneNumber.indexOf(" ");
        int dash = phoneNumber.indexOf("-");
        return phoneNumber.substring(space + 1, dash);
    }
    public static String parseLineNumber(String phoneNumber){
        int dash = phoneNumber.indexOf("-");
        return phoneNumber.substring(dash + 1);
    }

}
