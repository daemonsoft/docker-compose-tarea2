package domain.services.buildingattendantutil;

import java.time.LocalDate;

public interface BuildingCalendar {

    Boolean isSaturdayToday();

    LocalDate getCurrentDate();

}
