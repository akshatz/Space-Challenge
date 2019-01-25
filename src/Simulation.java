import java.io.*;
import java.util.ArrayList;

class Simulation {
    ArrayList<Item> loadItems(File file) throws IOException {
        ArrayList<Item> Items;
        try (FileReader filereader = new FileReader(file)) {
            BufferedReader bufferedreader = new BufferedReader(filereader);
            String item_name;
            item_name = null;
            int item_weight = 0;
            Items = new ArrayList<Item>();
            String line = null;
            while ((line = bufferedreader.readLine()) != null) {
                String[] splitByEquals = line.split("=");
                for (String splitPart : splitByEquals) {
                    char check = splitPart.charAt(0);
                    if (Character.isDigit(check)) {
                        item_weight = Integer.parseInt(splitPart);
                    } else {
                        item_name = splitPart;
                    }
                }
                Item item = new Item();
                Items.add(item);
            }
        }
        return Items;
    }

    ArrayList<Rocket> loadU1(ArrayList<Item> list) {
        ArrayList<Rocket> rocketsOne = new ArrayList<>();
        Rocket newOne = new U1();
        for (Item thisItem : list) {
            if (newOne.carry(thisItem)) {
                if (newOne.canCarry(thisItem)) {
                    rocketsOne.add(newOne);
                }
            } else {
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
            if (newTwo.carry(thisItem)) {
                if (newTwo.canCarry(thisItem)) {
                    rocketsTwo.add(newTwo);
                }
            } else {
                rocketsTwo.add(newTwo);
            }
        }
        return rocketsTwo;
    }

    int runSimulation(ArrayList<Rocket> rockets) {
        int totalCost = 0;
        for (Rocket currentRocket : rockets) {
            totalCost += currentRocket.getCost();
            if (totalCost < 0) {
                totalCost = 0;
            }
            while (!currentRocket.launch() || !currentRocket.land()) {
                totalCost += currentRocket.getCost();
            }
        }
        return totalCost;
    }
}