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
            System.out.println("All hardware assets have been stored");
        }
    }

    public void addSoftware(Software software) {
        if (softwareCount < softwares.length) {
            softwares[softwareCount++] = software;
        } else {
            System.out.println("All software assets have been stored");
        }
    }

    public void printHardwareDetails(int i) {
        System.out.println(hardwares[i].toString());
    }

    public void printSoftwareDetails(int i) {
        System.out.println(softwares[i].toString());
    }

}
