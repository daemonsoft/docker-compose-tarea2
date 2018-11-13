package domain.services;

import domain.entity.Building;
import domain.exception.BaseException;

import java.util.Optional;

public interface BuildingAttendantService {

    Optional<Building> checkIn(Long buildingId, String buildingName, Long tenantId, String tenantName, Integer tenantAge) throws BaseException;

    void checkOut(Long buildingId, Long tenantId);

}
