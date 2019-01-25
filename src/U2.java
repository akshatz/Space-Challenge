class U2 extends Rocket {
    U2() {
        cost = 120;
        cargo_carried = 18000;
        max_cargo = 29000;
    }
    public boolean launch(){
        int randNo = (Math.abs((int) Math.floor(Math.random()*100)));
        boolean success = 0.04 * ( cargo_carried/ max_cargo) < randNo;
        //if(!success){System.out.println("U2 exploded while launching, pls send it again");}
        return success;
    }
    public boolean land() {
        int randNo = (Math.abs((int) Math.floor(Math.random()*100)));
        boolean success = 0.08 * ( cargo_carried / max_cargo) < randNo;
        //if(!success){System.out.println("U2 crashed while landing, pls send it again");}
        return success;
    }
}