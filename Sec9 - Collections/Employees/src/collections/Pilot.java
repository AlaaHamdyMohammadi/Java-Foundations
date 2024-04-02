package collections;
public class Pilot implements Flyer {
    private int hoursFlown = 0;
    private boolean ifr = false;

    public Pilot(int hoursFlown, boolean ifr) {
        this.hoursFlown = hoursFlown;
        this.ifr = ifr;
    }

    @java.lang.Override
    public void fly(){
        System.out.println("Prepare for take off!");
    }

    @java.lang.Override
    public int getHoursFlown() {
        return hoursFlown;
    }

    @java.lang.Override
    public void setHoursFlown(int hoursFlown) {
        this.hoursFlown = hoursFlown;
    }

    @java.lang.Override
    public boolean isIfr() {
        return ifr;
    }

    @java.lang.Override
    public void setIfr(boolean ifr) {
        this.ifr = ifr;
    }
}
