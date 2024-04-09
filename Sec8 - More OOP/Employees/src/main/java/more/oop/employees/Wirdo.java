package more.oop.employees;
import java.time.LocalDate;
public record Wirdo(String firstName, String lastName, LocalDate dob) {
//    public Wirdo (String firstName, String lastName, LocalDate dob){
//        this(firstName, lastName, LocalDate.of(1, 1, 1));
//    }

    public String sayHello(){
        return "Hello";
    }
}
