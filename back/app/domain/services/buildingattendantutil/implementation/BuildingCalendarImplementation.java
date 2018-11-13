package domain.services.buildingattendantutil.implementation;

import domain.services.buildingattendantutil.BuildingCalendar;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class BuildingCalendarImplementation implements BuildingCalendar {

    public Boolean isSaturdayToday() {
        DayOfWeek dayOfWeek = getCurrentDate().getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY;
    }

    public LocalDate getCurrentDate() {
        return LocalDate.now();
    }
}
