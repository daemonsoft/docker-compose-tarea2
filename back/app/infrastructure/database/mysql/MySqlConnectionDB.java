package infrastructure.database.mysql;

import static java.util.stream.Collectors.*;

import javax.inject.Inject;
import javax.inject.Singleton;

import domain.entity.Building;
import domain.entity.Tenant;
import domain.repository.BuildingRepository;
import infrastructure.database.DatabaseExecutionContext;
import infrastructure.database.JdbiFactory;
import play.db.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

@Singleton
public class MySqlConnectionDB implements BuildingRepository {

    private final DatabaseExecutionContext executionContext;
    private final JdbiFactory jdbiFactory;

    @Inject
    public MySqlConnectionDB(DatabaseExecutionContext context, JdbiFactory jdbiFactory) {
        this.executionContext = context;
        this.jdbiFactory = jdbiFactory;
    }

    @Override
    public Optional<Building> save(Building building) {
        if (!findById(building.getId()).isPresent()) {
            jdbiFactory.getJdbi().onDemand(JdbiBuilding.class).save(building);
        }
        jdbiFactory.getJdbi().onDemand(JdbiTenant.class).save(building.getTenants(), building.getId());
        return Optional.ofNullable(building);
    }

    @Override
    public Optional<Building> findById(Long buildingId) {
        List<Long> tenantsId = jdbiFactory.getJdbi().onDemand(JdbiTenant.class).getTenantsByBuildingId(buildingId);
        List<Tenant> tenants = tenantsId.stream().map(Tenant::of).collect(toList());
        Building building = Building.builder(buildingId).withTenants(tenants).build();
        return Optional.of(building);
    }

    @Override
    public void remove(Long tenantId) {
        jdbiFactory.getJdbi().onDemand(JdbiTenant.class).deleteTenant(tenantId);
    }
}
