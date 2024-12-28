import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFiletoArrayList {
    public static void main(String[] args) {
        // Define the file path
        String filePath = "Week 14 - Strings   Collections\\Reading Files with Scanner\\sample.txt";

        // Create an ArrayList to store the strings
        ArrayList<String> fruitList = new ArrayList<>();
        int lines = 0;
        try {
            // Step 1: Create a new File object directing to filePath
            File file = new File(filePath);

            // Step 2: Create a new Scanner object with file as input object
            // Create a Scanner to read the file
            Scanner scanner = new Scanner(file);

            // Step 3: Read the file line by line
            while (scanner.hasNextLine()) {
                // Get the next line
                lines++;
                String line = scanner.nextLine();

                // Step 4: Split the line by commas and add each item to the ArrayList
                String[] fruits = line.split(",");
                for (String fruit : fruits) {
                    // Step 5: Add the fruit to the list of fruits
                    fruitList.add(fruit.trim());
                }
            }

            // Step 6: Close the scanner and the file objects
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print information and contents of the ArrayList
        System.out.println("Lines in the file: " + lines);
        System.out.println("Size of the list: " + fruitList.size());
        System.out.println("Fruits in the list:");
        for (String fruit : fruitList) {
            System.out.println(fruit);
        }
    }
}
