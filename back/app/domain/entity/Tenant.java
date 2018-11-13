package domain.entity;

import java.time.LocalDate;

import static com.google.common.base.Preconditions.checkNotNull;

public class Tenant {
    private Long id;
    private String name;
    private Integer age;
    private LocalDate entryDate;

    private Tenant(Long id) {
        this.id = id;
    }

    private Tenant(Long id, String name, Integer age, LocalDate entryDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.entryDate = entryDate;
    }

    public static Tenant of(Long id, String name, Integer age, LocalDate entryDate) {
        checkNotNull(id); // IllegalStateException
        checkNotNull(name);
        checkNotNull(age);
        checkNotNull(entryDate);
        return new Tenant(id, name, age, entryDate);
    }

    public static Tenant of(Long id) {
        return new Tenant(id);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }
}
