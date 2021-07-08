package org.mapstruct.ap.test.bugs._131;

import org.mapstruct.Mapper;
import org.mapstruct.SubClassMapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface Issue131Mapper {
    Issue131Mapper INSTANCE = Mappers.getMapper( Issue131Mapper.class );

    org.mapstruct.ap.test.bugs._131.dto.VehicleCollection map(org.mapstruct.ap.test.bugs._131.domain.VehicleCollection vehicles);

    org.mapstruct.ap.test.bugs._131.dto.Car map(org.mapstruct.ap.test.bugs._131.domain.Car car);

    org.mapstruct.ap.test.bugs._131.dto.Bike map(org.mapstruct.ap.test.bugs._131.domain.Bike bike);

    @SubClassMapping( sourceClass = org.mapstruct.ap.test.bugs._131.domain.Car.class, targetClass = org.mapstruct.ap.test.bugs._131.dto.Car.class )
    @SubClassMapping( sourceClass = org.mapstruct.ap.test.bugs._131.domain.Bike.class, targetClass = org.mapstruct.ap.test.bugs._131.dto.Bike.class )
    org.mapstruct.ap.test.bugs._131.dto.Vehicle map(org.mapstruct.ap.test.bugs._131.domain.Vehicle vehicle);

}
