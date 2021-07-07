package org.mapstruct.ap.test.bugs._131.dto;

public class Car extends Vehicle {
    private boolean manual;

    public boolean isManual() {
        return manual;
    }

    public void setManual(boolean manual) {
        this.manual = manual;
    }
}