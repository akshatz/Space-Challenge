public class Rocket implements SpaceShip {
    int cost;
    double currentWeight;
    double maxWeight;
    public boolean launch()
    {
        return true;
    }
    public boolean land()
    {
        return true;
    }
    public final boolean canCarry(Item item) {
        return (currentWeight + item.weight) >= maxWeight;
    }
    public final void carry(Item item) {

        currentWeight += item.weight;
    }
    public int getCost() {

        return (int) cost;
    }
}