package infrastructure.database.mysql;

import domain.entity.Building;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import java.util.Optional;

@RegisterRowMapper(MapperBuilding.class)
public interface JdbiBuilding {

    @SqlUpdate("insert into building (id, name) values (:id, :name)")
    void save(@BindBean Building building);

    @SqlQuery("select building.id as buildingId, tenant.id as tenantId from building left join tenant on tenant.buildingid = building.id where building.id = :buildingId")
    Optional<Building> getByBuildingId(@Bind("buildingId") Long buildingId);

}
