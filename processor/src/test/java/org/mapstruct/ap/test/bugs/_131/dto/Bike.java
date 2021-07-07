package org.mapstruct.ap.test.bugs._131.dto;

public class Bike extends Vehicle {
    private int numberOfGears;

    public int getNumberOfGears() {
        return numberOfGears;
    }

    public void setNumberOfGears(int numberOfGears) {
        this.numberOfGears = numberOfGears;
    }
}