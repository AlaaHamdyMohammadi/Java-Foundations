package more.oop.employees;

import java.time.LocalDate;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Employee implements IEmployee{
    protected String firstName;
    protected String lastName;
    protected LocalDate dob;
    protected final Matcher peopleMat;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // if the same objects in the same memory location
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(dob, employee.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dob);
    }

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
                default -> new DummyEmployee();
            };
        }else {
            return new DummyEmployee();
        }
    }

    public abstract int getSalary();

    public double getBonus(){
        return getSalary() * 0.10;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString(){
        return String.format("%s, %s: %s - %s", lastName, firstName, moneyFormat.format(getSalary()), moneyFormat.format(getBonus()));
    }

    private static final class DummyEmployee extends Employee {
        @Override
        public int getSalary(){
            return 0;
        }
    }

    @Override
    public int compareTo(IEmployee o){
        Employee other = (Employee) o;
        return this.lastName.compareTo(other.lastName);
    };
}
