package more.oop.employees;

import java.time.LocalDate;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class CEO extends Employee{
    private int avgStockPrice = 0;


    private final String ceotRegex = "\\w+=(?<avgStockPrice>\\w+)";
    private final Pattern ceoPat = Pattern.compile(ceotRegex);
    private final String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)\\n";
    private final Pattern peoplePat = Pattern.compile(peopleRegex);

    private final DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    private final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();



    public CEO(String personText) {
        Matcher peopleMat = peoplePat.matcher(personText);

        if(peopleMat.find()){
            this.lastName = peopleMat.group("lastName");
            this.firstName = peopleMat.group("firstName");
            this.dob = LocalDate.from(dtFormatter.parse(peopleMat.group("dob")));
        }
        Matcher CEOMat = ceoPat.matcher(peopleMat.group("details"));
        if(CEOMat.find()){
            this.avgStockPrice = Integer.parseInt(CEOMat.group("avgStockPrice"));
        }
    }

    public int getSalary(){
        return 5000 + avgStockPrice;
    }

    //    @override
    public String toString(){
        return String.format("%s, %s: %s", lastName, firstName, moneyFormat.format(getSalary()));
    }
}

