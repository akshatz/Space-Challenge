public class Rocket implements SpaceShip {
    public int cost;
    public double cargo_carried;
    private Item item;
    public double max_cargo;
    public boolean launch()
    {
        return true;
    }
    public boolean land()
    {
        return true;
    }
    public final boolean canCarry(Item item) {
        return (cargo_carried + item.weight) <= max_cargo;
    }
    public final boolean carry(Item item) {
        cargo_carried+= item.weight;
        this.item = item;
        return false;
    }
    public int getCost() {
        return cost;
    }
}
