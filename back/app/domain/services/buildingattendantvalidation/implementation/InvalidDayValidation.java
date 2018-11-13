package domain.services.buildingattendantvalidation.implementation;

import com.google.inject.Inject;
import domain.entity.Building;
import domain.exception.implementation.InvalidDayException;
import domain.services.buildingattendantutil.BuildingCalendar;
import domain.services.buildingattendantvalidation.BuildingAttendantValidation;

public class InvalidDayValidation implements BuildingAttendantValidation {

    private final BuildingCalendar buildingCalendar;

    @Inject
    public InvalidDayValidation(BuildingCalendar buildingCalendar) {
        this.buildingCalendar = buildingCalendar;
    }

    public void execute(Building building) throws InvalidDayException {
        if(isBuildingId2Or4(building.getId()) && buildingCalendar.isSaturdayToday()) {
            throw new InvalidDayException();
        }
    }

    private Boolean isBuildingId2Or4(Long buildingId) {
        return buildingId == 2 || buildingId == 4;
    }

}
