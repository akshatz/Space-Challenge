import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
public class Simulation {
    ArrayList<Item> loadItemsOne() throws Exception {
        ArrayList<Item> loadManifest = new ArrayList();
        Scanner fileScanner = new Scanner(new File("C:\\Users\\User2\\Desktop\\ud282-master\\SpaceChallange\\src\\phase-1.txt"));
        while (fileScanner.hasNextLine()){
            Item newItem = new Item();
            String[] tokens = fileScanner.nextLine().split("=");
            newItem.name = tokens[0];
            newItem.weight = Integer.parseInt(tokens[tokens.length-1]);
            loadManifest.add(newItem);
        }
        return loadManifest;
    }
    ArrayList<Item> loadItemsTwo() throws Exception {
        ArrayList<Item> loadManifest = new ArrayList();
        Scanner fileScanner = new Scanner(new File("C:\\Users\\User2\\Desktop\\ud282-master\\SpaceChallange\\src\\phase-2.txt"));
        while (fileScanner.hasNextLine()) {
            Item newItem = new Item();
            String[] tokens = fileScanner.nextLine().split("=");
            newItem.name = tokens[0];
            newItem.weight = Integer.parseInt(tokens[tokens.length-1]);
            loadManifest.add(newItem);
        }
        return loadManifest;
    }
    ArrayList<Rocket> loadU1(ArrayList<Item> list) {
        ArrayList<Rocket> rocketsOne = new ArrayList();
        Rocket newOne = new U1();
        for (Item thisItem : list) {
            if (newOne.canCarry(thisItem)) {
                rocketsOne.add(newOne);
            } else {
                newOne = new U1();
                rocketsOne.add(newOne);
            }
        }
        return rocketsOne;
    }
    ArrayList<Rocket> loadU2(ArrayList<Item> list) {
        ArrayList<Rocket> rocketsTwo = new ArrayList();
        Rocket newTwo = new U2();
        for (Item thisItem : list) {
            if (newTwo.canCarry(thisItem)) {
                rocketsTwo.add(newTwo);
            } else {
                newTwo = new U2();
                rocketsTwo.add(newTwo);
            }

        }
        return rocketsTwo;
    }
    int runSimulation(ArrayList<Rocket> rockets) {
        int totalCost = 0;
        for (Rocket currentRocket : rockets) {
            totalCost += currentRocket.getCost();
            while (!currentRocket.launch() || !currentRocket.land()) {
                totalCost += currentRocket.getCost();
            }
        }
        return totalCost;
    }
}