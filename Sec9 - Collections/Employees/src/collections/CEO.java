package collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class CEO extends Employee implements IEmployee, Flyer {
    private int avgStockPrice = 0;
    private Flyer flyer = new Pilot(1000, true);

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

    public void fly() {
        flyer.fly();
    }

    public int getHoursFlown() {
        return flyer.getHoursFlown();
    }

    public void setHoursFlown(int hoursFlown) {
        flyer.setHoursFlown(hoursFlown);
    }

    public boolean isIfr() {
        return flyer.isIfr();
    }

    public void setIfr(boolean ifr) {
        flyer.setIfr(ifr);
    }
}

