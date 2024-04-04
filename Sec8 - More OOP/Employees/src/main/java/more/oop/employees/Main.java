package more.oop.employees;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
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


        Matcher peopleMat = Employee.peoplePat.matcher(people);

        Programmer coder = new Programmer("");

        Flyer flyer = new CEO("");
        flyer.fly();

        int totalSalaries = 0;
        IEmployee employee = null;
        List<IEmployee> employees = new LinkedList<>();
        while (peopleMat.find()) {
            employee = Employee.createEmployee(peopleMat.group());
            employees.add(employee);
        }

        employees.remove(0);
        employees.remove(1);
        employees.remove(2);

        List<String> undesirable = new ArrayList<>(List.of("Wilma5", "Barney2", "Fred3"));
        removeUndesirables(employees, undesirable);

        for(IEmployee worker: employees){
            System.out.println(worker.toString());
            totalSalaries += worker.getSalary();
        }
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        System.out.printf("The total should be %s%n", currencyInstance.format(totalSalaries));

        Wirdo name = new Wirdo("Alaa", "Hamdy", 26);
        Wirdo modifyName = new Wirdo(name.firstName() + "k");
    }

    private static void removeUndesirables(List<IEmployee> employees, List<String> removalName){
        for(Iterator<IEmployee> it = employees.iterator(); it.hasNext();) {
            IEmployee worker = it.next();
            if (worker instanceof Employee) {
                Employee tmpWorker = (Employee) worker;
                if (removalName.contains(tmpWorker.firstName)) {
                    it.remove();
                }
            }
        }
    }
}
