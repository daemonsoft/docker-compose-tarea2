package domain.entity;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class Building {
    private Long id;
    private String name;
    private List<Tenant> tenants;

    private Building(Long id, String name, List<Tenant> tenants) {
        this.id = id;
        this.name = name;
        this.tenants = tenants;
    }

    public static Builder builder(Long id) {
        return new Builder(id);
    }

    public static Builder builder(Long id, String name) {
        return new Builder(id, name);
    }

    public static class Builder {
        private Long id;
        private String name;
        private List<Tenant> tenants = new ArrayList<>();

        private Builder(Long id) {
            this.id = id;
        }

        private Builder(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder withTenants(List<Tenant> tenants) {
            checkNotNull(tenants);
            this.tenants = tenants;
            return this;
        }

        public Building build() {
            checkNotNull(id);
            return new Building(id, name, tenants);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Tenant> getTenants() {
        return ImmutableList.copyOf(tenants);
    }

    public void addTenant(Tenant tenant) {
        this.tenants.add(tenant);
    }

    public Boolean evictTenant(Long tenantId) {
        return this.tenants.removeIf(idTenant -> idTenant.getId().equals(tenantId));
    }
}
