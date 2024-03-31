package more.oop.employees;

import java.time.LocalDate;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Manager {
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private orgSize = 0;
    private directReports = 0;


    private final String mgrRegex = "\\w+=(?<orgSize>\\w+),\\w+=(?<dr>\\w+)";
    private final Pattern mgrPat = Pattern.compile(mgrRegex);
    private final String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)\\n";
    private final Pattern peoplePat = Pattern.compile(peopleRegex);

    private final DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    private final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();



    public Manager(String personText) {
        Matcher peopleMat = peoplePat.matcher(personText);

        if(peopleMat.find()){
            this.lastName = peopleMat.group("lastName");
            this.firstName = peopleMat.group("firstName");
            this.dob = LocalDate.from(dtFormatter.parse(peopleMat.group("dob")));
        }
        Matcher mgrMat = mgrPat.matcher(peopleMat.group("details"));
        if(mgrMat.find()){
            this.orgSize = Integer.parseInt(mgrMat.group("orgSize"));
            this.directReports = Integer.parseInt(mgrMat.group("dr"));
        }
    }

    public int getSalary(){
        return 3500 + orgSize * dr;
    }

    //    @override
    public String toString(){
        return String.format("%s, %s: %s", lastName, firstName, moneyFormat.format(getSalary()));
    }
}
