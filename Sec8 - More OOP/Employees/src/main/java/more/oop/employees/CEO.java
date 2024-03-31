package more.oop.employees;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class CEO extends Employee implements IEmployee {
    private int avgStockPrice = 0;


    private final String ceotRegex = "\\w+=(?<avgStockPrice>\\w+)";
    private final Pattern ceoPat = Pattern.compile(ceotRegex);


    public CEO(String personText) {
        super(personText);
        Matcher CEOMat = ceoPat.matcher(peopleMat.group("details"));
        if(CEOMat.find()){
            this.avgStockPrice = Integer.parseInt(CEOMat.group("avgStockPrice"));
        }
    }

    public int getSalary(){
        return 5000 + avgStockPrice;
    }
}

