import java.util.Random;

import static java.lang.Math.abs;

class U2 extends Rocket {
    U2()
    {
        cost = 120000000;
        cargo_carried = 180000;
        max_cargo = 29000;
    }
    public boolean launch()
    {
        int randNo = abs((int) Math.floor(Math.random()*101));
        return (4*(cargo_carried/ max_cargo) < randNo);
    }
    public boolean land() {
        int randNo = abs((int) Math.floor(Math.random()*101));
        return (8*( cargo_carried / max_cargo) < randNo);
    }
}
