package ir.gam.office.enums;


import java.io.Serializable;

public enum ProviderName {
    huawei("huawei"),
    aban_eshop("aban-eshop"),
    hami_mymci("hami-mymci");

    private final String value;

    ProviderName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}

