package application.requestmodel;

import com.google.common.base.Objects;

import javax.annotation.concurrent.Immutable;

import static com.google.common.base.Preconditions.checkNotNull;

@Immutable
public class EvictTenantRequest {

    private Long buildingId;
    private Long tenantId;

    public EvictTenantRequest() {
    }

    private EvictTenantRequest(Long buildingId, Long tenantId) {
        this.buildingId = buildingId;
        this.tenantId = tenantId;
    }

    public static EvictTenantRequest of(Long buildingId, Long tenantId) {
        checkNotNull(buildingId);
        checkNotNull(tenantId);
        return new EvictTenantRequest(buildingId, tenantId);
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public Long getTenantId() {
        return tenantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EvictTenantRequest that = (EvictTenantRequest) o;
        return Objects.equal(buildingId, that.buildingId) &&
                Objects.equal(tenantId, that.tenantId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(buildingId, tenantId);
    }
}
