package more.oop.employees;

import java.time.LocalDate;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Employee{
    protected String firstName;
    protected String lastName;
    protected LocalDate dob;
    protected final Matcher peopleMat;

    protected static final String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)\\n";
    public static final Pattern peoplePat = Pattern.compile(peopleRegex);
    protected final DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    protected final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();

    protected Employee(){
        peopleMat = null;
        firstName = "";
        dob = null;
    }

    public Employee(String personText){
        peopleMat = Employee.peoplePat.matcher(personText);
        if(peopleMat.find()) {
            this.lastName = peopleMat.group("lastName");
            this.firstName = peopleMat.group("firstName");
            this.dob = LocalDate.from(dtFormatter.parse(peopleMat.group("dob")));
        }
    }

    public static final Employee createEmployee(String employeeText){
        Matcher peopleMat = Employee.peoplePat.matcher(employeeText);

        if (peopleMat.find()) {
            return switch(peopleMat.group("role")){
                case "Programmer" -> new Programmer(employeeText);
                case "Manager" -> new Manager(employeeText);
                case "Analyst" -> new Analyst(employeeText);
                case "CEO" -> new CEO(employeeText);
                default -> () -> 0; //Lambda expression
                };
            };
        }else {
            return () -> 0; //Lambda expression
        }
    }

    public abstract int getSalary();

    public double getBonus(){
        return getSalary() * 0.10;
    }

    @Override
    public String toString(){
        return String.format("%s, %s: %s - %s", lastName, firstName, moneyFormat.format(getSalary()), moneyFormat.format(getBonus()));
    }

    private static final class DummyEmployee extends Employee implements IEmployee{
        @Override
        public int getSalary(){
            return 0;
        }
    }
}
