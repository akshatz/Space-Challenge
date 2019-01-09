public class Rocket implements SpaceShip {
    int cost;
    double cargo_carried;
    double max_cargo;
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
        return false;
    }
    public int getCost() {

        return (int) cost;
    }
}
