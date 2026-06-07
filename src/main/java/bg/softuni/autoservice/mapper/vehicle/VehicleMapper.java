package bg.softuni.autoservice.mapper.vehicle;

import bg.softuni.autoservice.model.dto.vehicle.VehicleAddDTO;
import bg.softuni.autoservice.model.dto.vehicle.VehicleViewDTO;
import bg.softuni.autoservice.model.entity.User;
import bg.softuni.autoservice.model.entity.Vehicle;

public class VehicleMapper {
    public static VehicleViewDTO toViewDTO(Vehicle vehicle) {
        if (vehicle == null) {
            return null;
        }

        return VehicleViewDTO.builder()
                .make(vehicle.getMake())
                .model(vehicle.getModel())
                .licensePlate(vehicle.getLicensePlate())
                .year(vehicle.getYear())
                .vin(vehicle.getVin())
                .build();
    }

    public static Vehicle toVehicleEntity(VehicleAddDTO dto, User owner) {
        if (dto == null) {
            return null;
        }

        return Vehicle.builder()
                .make(dto.getMake())
                .model(dto.getModel())
                .licensePlate(dto.getLicensePlate())
                .year(dto.getYear())
                .vin(dto.getVin())
                .owner(owner) // Закачаме собственика тук
                .build();
    }
}
