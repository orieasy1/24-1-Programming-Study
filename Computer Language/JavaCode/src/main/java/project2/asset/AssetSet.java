package project2.asset;

import project2.Hardware;
import project2.Software;

public class AssetSet {
    private Hardware[] hardwares;
    private Software[] softwares;
    private int hardwareCount;
    private int softwareCount;

    public AssetSet(int hardwareSize, int softwareSize) {
        this.hardwares = new Hardware[hardwareSize];
        this.softwares = new Software[softwareSize];
        this.hardwareCount = 0;
        this.softwareCount = 0;
    }

    public void addHardware(Hardware hardware) {
        if (hardwareCount < hardwares.length) {
            hardwares[hardwareCount++] = hardware;
        } else {
            System.out.println("Hardware array is full.");
        }
    }

    public void addSoftware(Software software) {
        if (softwareCount < softwares.length) {
            softwares[softwareCount++] = software;
        } else {
            System.out.println("Software array is full.");
        }
    }
}
