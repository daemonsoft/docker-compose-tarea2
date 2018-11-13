package infrastructure.database.mysql;

import domain.entity.Building;
import domain.entity.Tenant;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class MapperBuilding implements RowMapper<Building> {

    @Override
    public Building map(ResultSet rs, StatementContext ctx) throws SQLException {
        return Building.builder(rs.getLong("buildingId"))
                .withTenants(Arrays.asList(Tenant.of(rs.getLong("tenantId")))).build();
    }
}
