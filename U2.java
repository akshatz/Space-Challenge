import static java.lang.Math.abs;

class U2 extends Rocket {
    U2()
    {
        cost = 120000000;
        currentWeight = 180000;
        maxWeight = 29000;
    }
    public boolean launch()
    {
        int randNo = abs((int) Math.floor(Math.random()*100));

        return (4*(currentWeight / maxWeight) < randNo);
    }
    public boolean land() {
        int randNo = abs((int) Math.floor(Math.random()*100));
        return (8*(currentWeight / maxWeight) < randNo);
    }
}