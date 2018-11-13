package domain.services.implementation;

import static com.google.common.base.Preconditions.checkNotNull;
import com.google.inject.Inject;
import domain.entity.Building;
import domain.entity.Tenant;
import domain.exception.BaseException;
import domain.repository.BuildingRepository;
import domain.services.BuildingAttendantService;
import domain.services.buildingattendantutil.BuildingCalendar;
import domain.services.buildingattendantvalidation.BuildingAttendantValidation;
import domain.services.buildingattendantvalidation.implementation.InvalidDayValidation;
import domain.services.buildingattendantvalidation.implementation.LegalAgeValidation;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class BuildingAttendantServiceImplementation implements BuildingAttendantService {

    private final BuildingRepository buildingRepository;
    private final BuildingCalendar buildingCalendar;
    //private final List<BuildingAttendantValidation> entryValidations;
    private final InvalidDayValidation invalidDayValidation;
    private final LegalAgeValidation legalAgeValidation;

    @Inject
    public BuildingAttendantServiceImplementation(BuildingRepository buildingRepository,
                                                  BuildingCalendar buildingCalendar,
                                                  //List<BuildingAttendantValidation> entryValidations,
                                                  InvalidDayValidation invalidDayValidation,
                                                  LegalAgeValidation legalAgeValidation) {
        this.buildingRepository = buildingRepository;
        this.buildingCalendar = buildingCalendar;
        this.invalidDayValidation = invalidDayValidation;
        this.legalAgeValidation = legalAgeValidation;
        //this.entryValidations = entryValidations;
    }

    public Optional<Building> checkIn(Long buildingId, String buildingName, Long tenantId, String tenantName, Integer tenantAge) throws BaseException {
        validateBuildingAndTenantId(buildingId, tenantId);
        Building building = Building.builder(buildingId, buildingName).build();
        Tenant tenant = Tenant.of(tenantId, tenantName, tenantAge, buildingCalendar.getCurrentDate());
        building.addTenant(tenant);
        invalidDayValidation.execute(building);
        legalAgeValidation.execute(building);
        /*for (BuildingAttendantValidation validation : entryValidations) {
            validation.execute(building.get());
        }*/
        return buildingRepository.save(building);
    }

    public void checkOut(Long buildingId, Long tenantId) {
        validateBuildingAndTenantId(buildingId, tenantId);
        buildingRepository.remove(tenantId);
    }

    private void validateBuildingAndTenantId(Long buildingId, Long tenantId) {
        checkNotNull(buildingId);
        checkNotNull(tenantId);
    }
}
