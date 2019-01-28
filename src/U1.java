public class U1 extends Rocket{
    U1() {
        cost = 100;
        cargo_carried = 10000;
        max_cargo = 18000;
    }
    public boolean launch() {
int randNo = (Math.abs((int) Math.floor(Math.random()*100)));
boolean success = 0.05 * (cargo_carried / max_cargo) < randNo;
//if(!success){System.out.println("U1 exploded while launching, pls send it again");}
return success;}
    public boolean land() {
int randNo = (Math.abs((int) Math.floor(Math.random()*100)));
boolean suceess = 0.01 * (cargo_carried / max_cargo ) < randNo;
//if (!suceess){System.out.println("U1 crashed while landing, pls send it again");}
return suceess;}}
