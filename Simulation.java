import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    ArrayList<Item> loadItemsOne() throws IOException {
        ArrayList<Item> loadManifest = new ArrayList<>();
        try{
        Scanner fileScanner = new Scanner(new File("phase-1.txt"));
        while (fileScanner.hasNextLine()){
            Item newItem = new Item();
            String[] tokens = fileScanner.nextLine().split("=");
            newItem.name = tokens[0];
            newItem.weight = Integer.parseInt(tokens[tokens.length-1]);
            loadManifest.add(newItem);
        }}
        catch(IOException e){
            e.printStackTrace();
        }
        return loadManifest;
    }
    ArrayList<Item> loadItemsTwo() throws IOException {
        ArrayList<Item> loadManifest = new ArrayList<>();
        try{
            Scanner fileScanner = new Scanner(new File("phase-2.txt"));
            while (fileScanner.hasNextLine()){
                Item newItem = new Item();
                String[] tokens = fileScanner.nextLine().split("=");
                newItem.name = tokens[0];
                newItem.weight = Integer.parseInt(tokens[tokens.length-1]);
                loadManifest.add(newItem);
            }}
        catch(IOException e){
            e.printStackTrace();
        }
        return loadManifest;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> list) {
        ArrayList<Rocket> rocketsOne = new ArrayList<>();
        Rocket newOne = new U1();
        for (Item thisItem : list) {
            if(newOne.carry(thisItem)){
                if (newOne.canCarry(thisItem)) {
                    rocketsOne.add(newOne);
                }
            }
            else {
                newOne = new U1();
                rocketsOne.add(newOne);
             }
         }
         return rocketsOne;
    }
    ArrayList<Rocket> loadU2(ArrayList<Item> list) {
         ArrayList<Rocket> rocketsTwo = new ArrayList<>();
         Rocket newTwo = new U2();
         for (Item thisItem : list) {
             if(newTwo.carry(thisItem)){
                 if (newTwo.canCarry(thisItem)) {
                     rocketsTwo.add(newTwo);
                 }
             }
             else {
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
