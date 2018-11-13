package infrastructure.database.mysql;

import domain.entity.Building;
import domain.entity.Tenant;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.BatchChunkSize;
import org.jdbi.v3.sqlobject.statement.SqlBatch;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;

public interface JdbiTenant {

    @SqlBatch("insert into tenant (id, name, age, entryDate, buildingId) values (:id, :name, :age, :entryDate, :buildingId)")
    @BatchChunkSize(100)
    void save(@BindBean List<Tenant> tenant, @Bind("buildingId") Long buildingId);

    @SqlQuery("select id from tenant where buildingid = :buildingId")
    List<Long> getTenantsByBuildingId(@Bind("buildingId") Long buildingId);

    @SqlUpdate("delete from tenant where id = :tenantId")
    void deleteTenant(@Bind("tenantId") Long tenantId);

}
