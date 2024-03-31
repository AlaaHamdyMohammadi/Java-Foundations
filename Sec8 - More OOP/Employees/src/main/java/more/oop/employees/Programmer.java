package more.oop.employees;

import java.time.LocalDate;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Programmer {
    private String firstName;
    private String lastName;
    private int linesOfCode = 0;
    private int yearsOfExp = 0;
    private int iq = 0;
    private LocalDate dob;



    private final String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)\\n";
    private final Pattern peoplePat = Pattern.compile(peopleRegex);

    private final String progRegex = "\\w+\\=(?<locpd>\\w+)\\,\\w+\\=(?<yoe>\\w+)\\,\\w+\\=(?<iq>\\w+)";
    private final Pattern progPat = Pattern.compile(progRegex);
    private final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();

    DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");

    public Programmer(String personText){
    Matcher peopleMat = peoplePat.matcher(personText);
    if(peopleMat.find()){
        this.lastName = peopleMat.group("lastName");
        this.firstName = peopleMat.group("firstName");
        this.dob = LocalDate.from(dtFormatter.parse(peopleMat.group("dob")));
        Matcher progMat = progPat.matcher(peopleMat.group("details"));
        if(progMat.find()){
            this.linesOfCode = Integer.parseInt(progMat.group("locpd"));
            this.yearsOfExp = Integer.parseInt(progMat.group("yoe"));
            this.iq = Integer.parseInt(progMat.group("iq"));

        }
    }
    }

    public int getSalary(){
        return 3000 + linesOfCode * yearsOfExp * iq;
    }

//    @override
    public String toString(){
        return String.format("%s, %s: %s", lastName, firstName, moneyFormat.format(getSalary()));
    }
}
