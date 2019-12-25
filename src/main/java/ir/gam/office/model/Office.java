package ir.gam.office.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import ir.gam.office.enums.ProviderName;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity
@Table(name = "office")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Office implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 6, max = 29)
    @Pattern(regexp = "^[a-zA-Z]+")
    @Column(name = "office_name", unique = true, updatable = true)
    private String name;

    @Size(min = 11)
    @Pattern(regexp = "[0-9]+")
    @Column(name = "office_code", unique = true, updatable = false)
    private String code;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "provider",updatable = true)
    private ProviderName providerName;

    @Column(name = "inActive",updatable = true)
    private boolean inActive;

    public Office() {
    }

    public Office(String name, String code,ProviderName providerName, boolean inActive) {
        this.code = code;
        this.name = name;
        this.providerName = providerName;
        this.inActive = inActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ProviderName getProviderName() {
        return providerName;
    }

    public void setProviderName(ProviderName providerName) {
        this.providerName = providerName;
    }

    public boolean isInActive() {
        return inActive;
    }

    public void setInActive(boolean inActive) {
        this.inActive = inActive;
    }

}
