class Main {
    public static void main(String[] args) throws Exception {
        Simulation mySim = new Simulation();
        System.out.println("Total cost for U1 fleet, phase 1: " + mySim.runSimulation(mySim.loadU1(mySim.loadItemsOne())));
        System.out.println("Total cost for U1 fleet, phase 2: " + mySim.runSimulation(mySim.loadU1(mySim.loadItemsTwo())));
        System.out.println("Total cost for U2 fleet, phase 1: " + mySim.runSimulation(mySim.loadU2(mySim.loadItemsOne())));
        System.out.println("Total cost for U2 fleet, phase 2: " + mySim.runSimulation(mySim.loadU2(mySim.loadItemsTwo())));
    }
}