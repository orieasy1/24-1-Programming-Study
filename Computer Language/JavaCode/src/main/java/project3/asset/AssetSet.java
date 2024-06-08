package project3.asset;

import project3.Hardware;
import project3.Software;
import java.util.ArrayList;

public class AssetSet {
    // List to store hardware assets
    private ArrayList<Hardware> hardwares;

    // List to store software assets
    private ArrayList<Software> softwares;

    // Constructor to initialize the hardware and software lists
    public AssetSet() {
        this.hardwares = new ArrayList<>();
        this.softwares = new ArrayList<>();
    }

    // Method to add a hardware asset to the list
    public void addHardware(Hardware hardware) {
        hardwares.add(hardware);
    }

    // Method to add a software asset to the list
    public void addSoftware(Software software) {
        softwares.add(software);
    }

    // Method to get the list of hardware assets
    public ArrayList<Hardware> getHardwares() {
        return hardwares;
    }

    // Method to get the list of software assets
    public ArrayList<Software> getSoftwares() {
        return softwares;
    }

    // Method to display all assets (both hardware and software)
    public void displayAllAssets() {
        if (hardwares.isEmpty() && softwares.isEmpty()) {
            System.out.println("No assets found.");
        } else {
            System.out.println("Hardware");
            for (Hardware hardware : hardwares) {
                System.out.println(hardware);
            }
            System.out.println();

            System.out.println("Software");
            for (Software software : softwares) {
                System.out.println(software);
            }
            System.out.println();
        }
    }

    // Method to display only hardware assets
    public void displayHardwareAssets() {
        if (hardwares.isEmpty()) {
            System.out.println("No hardware assets found.");
        } else {
            System.out.println("Hardware");
            for (Hardware hardware : hardwares) {
                System.out.println(hardware);
            }
        }
    }

    // Method to display only software assets
    public void displaySoftwareAssets() {
        if (softwares.isEmpty()) {
            System.out.println("No software assets found.");
        } else {
            System.out.println("Software");
            for (Software software : softwares) {
                System.out.println(software);
            }
        }
    }

    // Method to print details of a specific hardware asset by index
    public void printHardwareDetails(int i) {
        System.out.println("\nHardware registered successfully!");
        System.out.println(hardwares.get(i).toString());
    }

    // Method to print details of a specific software asset by index
    public void printSoftwareDetails(int i) {
        System.out.println("\nSoftware registered successfully!");
        System.out.println(softwares.get(i).toString());
    }
}
