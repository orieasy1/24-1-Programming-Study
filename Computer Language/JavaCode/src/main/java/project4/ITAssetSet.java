package project4;

import project3.asset.AssetSet;
import project3.Hardware;
import project3.Software;
import java.util.ArrayList;

public class ITAssetSet {
    private ArrayList<ITAsset> assets;

    public ITAssetSet() {
        this.assets = new ArrayList<>();
    }

    public void addAsset(ITAsset asset) {
        assets.add(asset);
    }

    public ITAsset getAssetById(int id) {
        for (ITAsset asset : assets) {
            if (asset.getId() == id) {
                return asset;
            }
        }
        return null;
    }

    public void printAllAssets() {
        for (ITAsset asset : assets) {
            asset.print();
        }
    }

    public void printHardwareAssets() {
        for (ITAsset asset : assets) {
            if (asset instanceof Hardware) {
                asset.print();
            }
        }
    }

    public void printSoftwareAssets() {
        for (ITAsset asset : assets) {
            if (asset instanceof Software) {
                asset.print();
            }
        }
    }

    public void searchAssetsByName(String name) {
        for (ITAsset asset : assets) {
            if (asset.getName().equalsIgnoreCase(name)) {
                asset.print();
            }
        }
    }

    // Method to print details of a specific hardware asset
    public void printHardwareDetails(Hardware hardware) {
        System.out.println("\nHardware registered successfully!");
        System.out.println(hardware.toString());
    }

    // Method to print details of a specific software asset
    public void printSoftwareDetails(Software software) {
        System.out.println("\nSoftware registered successfully!");
        System.out.println(software.toString());
    }
}
