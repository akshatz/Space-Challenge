import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;

class Main{
    public static void main(String args[]) throws FileNotFoundException {
        Simulation mySim = new Simulation();
        ArrayList<Item> phase1Items = new ArrayList<Item>();
        ArrayList<Item> phase2Items = new ArrayList<Item>();
        try {
            phase1Items = mySim.loadItems(new File("phase_1.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            phase2Items = mySim.loadItems(new File("phase_2.txt"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Rocket> phase1U1Rockets = new ArrayList<Rocket>();
        ArrayList<Rocket> phase2U1Rockets = new ArrayList<Rocket>();
        phase1U1Rockets = mySim.loadU1(phase1Items);
        phase2U1Rockets = mySim.loadU1(phase2Items);
        ArrayList<Rocket> phase1U2Rockets;
        ArrayList<Rocket> phase2U2Rockets;
        phase1U2Rockets = mySim.loadU2(phase1Items);
        phase2U2Rockets = mySim.loadU2(phase2Items);
        int trials = mySim.runSimulation(phase1U1Rockets);
        int trials2 = mySim.runSimulation(phase2U1Rockets);
        int costu1 = trials+trials2;
        System.out.println("Total cost for U1 fleet: $ " + costu1 + " millions");
        int trials3 = mySim.runSimulation(phase1U2Rockets);
        int trials4 = mySim.runSimulation(phase2U2Rockets);
        int costu2 = trials3 + trials4;
        System.out.println("Total cost for U2 fleet: $ "+costu2 +" millions");
    }
}
