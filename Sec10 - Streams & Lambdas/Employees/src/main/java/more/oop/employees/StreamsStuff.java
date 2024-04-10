package more.oop.employees;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class StreamsStuff {
    public static void main(String[] args) {
        String people = """
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Flinstone2, Fred2, 1/1/1900, Programmer, {locpd=1300,yoe=14,iq=100}
            Flinstone3, Fred3, 1/1/1900, Programmer, {locpd=2300,yoe=8,iq=105}
            Flinstone4, Fred4, 1/1/1900, Programmer, {locpd=1630,yoe=3,iq=115}
            Flinstone5, Fred5, 1/1/1900, Programmer, {locpd=5,yoe=10,iq=100}
            Rubble, Barney, 2/2/1905, Manager, {orgSize=300,dr=10}
            Rubble2, Barney2, 2/2/1905, Manager, {orgSize=100,dr=4}
            Rubble3, Barney3, 2/2/1905, Manager, {orgSize=200,dr=2}
            Rubble4, Barney4, 2/2/1905, Manager, {orgSize=500,dr=8}
            Rubble5, Barney5, 2/2/1905, Manager, {orgSize=175,dr=20}
            Flinstone, Wilma, 3/3/1910, Analyst, {projectCount=3}
            Flinstone2, Wilma2, 3/3/1910, Analyst, {projectCount=4}
            Flinstone3, Wilma3, 3/3/1910, Analyst, {projectCount=5}
            Flinstone4, Wilma4, 3/3/1910, Analyst, {projectCount=6}
            Flinstone5, Wilma5, 3/3/1910, Analyst, {projectCount=9}
            Rubble, Betty, 4/4/1915, CEO, {avgStockPrice=300}
            """;

        int sum = people.lines()
//                .map(s -> Employee.createEmployee(s)) // Lambda
                .map(Employee::createEmployee) // Method reference
//                .mapToInt(IEmployee::getSalary)
                .mapToInt(e -> e.getSalary())
                .sum();
        System.out.println(sum);

        try {
            Files.lines(Path.of("E:\\Udemy\\JAVA\\Sec10 - Streams & Lambdas\\Employees\\src\\main\\java\\more\\oop\\employees\\employees.txt"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        List<String> nums = List.of("one", "two", "Three", "Four");
        Collection<String> nums = Set.of("one", "two", "Three", "Four");
        nums.stream()
//                .map(n -> n.toUpperCase()) // Lambda
//                .map(String::toUpperCase)
                .map(String::hashCode)
                .forEach(System.out::println);

        IntStream.range(1, 11) // 1 -> 10
                .mapToObj(String::valueOf)
                .map(s -> s.concat("-"))
                .forEach(System.out::print);

        IntStream.rangeClosed(1, 10) // 1 -> 10
                .boxed()
                .map(String::valueOf)
                .map(s -> s.concat("-"))
                .forEach(System.out::println);
    }
}
