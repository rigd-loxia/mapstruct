package org.mapstruct.ap.test.bugs._131.dto;

import java.util.ArrayList;
import java.util.Collection;

public class VehicleCollection {
    private Collection<Vehicle> vehicles = new ArrayList<>();

    public Collection<Vehicle> getVehicles() {
        return vehicles;
    }
}
