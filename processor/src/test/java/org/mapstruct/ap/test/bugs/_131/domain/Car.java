package org.mapstruct.ap.test.bugs._131.domain;

public class Car extends Vehicle {
    private boolean manual;

    public boolean isManual() {
        return manual;
    }

    public void setManual(boolean manual) {
        this.manual = manual;
    }
}