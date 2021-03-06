package ir.gam.office.model;


import java.io.Serializable;

public class OfficeDto implements Serializable {


    private Long id;
    private String name;
    private String code;
    private String providerName;
    private boolean inActive;


    public OfficeDto() {
    }

    public OfficeDto(String name, String code, String providerName, boolean inActive) {
        this.name = name;
        this.code = code;
        this.providerName = providerName;
        this.inActive = inActive;
    }

    public OfficeDto(Long id, String name, String code, String providerName, boolean inActive) {
        this.id = id;
        this.name = name;
        this.code = code;
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

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public boolean isInActive() {
        return inActive;
    }

    public void setInActive(boolean inActive) {
        this.inActive = inActive;
    }
}
