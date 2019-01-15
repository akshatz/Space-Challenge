import static java.lang.Math.abs;
public class U1 extends Rocket{
    U1() {
        cost = 100000000;
        cargo_carried = 10000;
        max_cargo = 18000;
    }
    public boolean launch() {
        int randNo = abs((int) Math.floor(Math.random() * 100));
        return (5 * (currentWeight / maxWeight)) < randNo;
    }
    public boolean land() {
        int randNo = abs((int) Math.floor(Math.random() * 100));
        return (currentWeight / maxWeight) < randNo;
    }
}
