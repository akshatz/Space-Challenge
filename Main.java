import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class Main{
    public static void main(String args[]) throws IOException {
        Simulation mySim = new Simulation();
        File phase1File = new File("phase-1.txt");
        File phase2File = new File("phase-2.txt");
        ArrayList<Item> phase1Items = new ArrayList<Item>();
        ArrayList<Item> phase2Items = new ArrayList<Item>();
        try {
            phase1Items = mySim.loadItems(phase1File);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            phase2Items = mySim.loadItems(phase2File);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Rocket> phase1U1Rockets = new ArrayList<Rocket>();
        ArrayList<Rocket> phase2U1Rockets = new ArrayList<Rocket>();
        phase1U1Rockets = mySim.loadU1(phase1Items);
        phase2U1Rockets = mySim.loadU1(phase2Items);
        ArrayList<Rocket> phase1U2Rockets = new ArrayList<Rocket>();
        ArrayList<Rocket> phase2U2Rockets = new ArrayList<Rocket>();
        phase1U2Rockets = mySim.loadU2(phase1Items);
        phase2U2Rockets = mySim.loadU2(phase2Items);
        int trials = mySim.runSimulation(phase1U1Rockets);
        int trials2 = mySim.runSimulation(phase2U1Rockets);
        int trials3 = mySim.runSimulation(phase1U2Rockets);
        int trials4 = mySim.runSimulation(phase2U2Rockets);
        System.out.println("Total cost for U1 fleet phase 1: " + (trials+trials2));
        System.out.println("Total cost for U1 fleet, phase 2: " + trials2);
        System.out.println("Total cost for U2 fleet, phase 1: " + trials3);
        System.out.println("Total cost for U2 fleet phase 2: " + trials4);
    }
}
