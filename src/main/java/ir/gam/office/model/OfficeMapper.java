package ir.gam.office.model;

import ir.gam.office.enums.ProviderName;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = Office.class)
public interface OfficeMapper {


    @Mapping(qualifiedByName = "map", source = "providerName.value.", target = "providerName")
    OfficeDto officeToOfficeDto(Office office);


    @Mapping(qualifiedByName = "map", source = "officeDto.providerName", target = "providerName")
    Office officeDtoToOffice(OfficeDto officeDto);

    List<OfficeDto> officesToOfficesDto(List<Office> offices);
    List<Office> officesDtoToOffices(List<OfficeDto> officeDtos);

    @Named("map")
    default ProviderName map(String value) {
        ProviderName providerName = null;

        switch (value) {
            case "aban-eshop":
                providerName = ProviderName.aban_eshop;
                break;
            case "huawei":
                providerName = ProviderName.huawei;
                break;
            case "hami-mymci":
                providerName = ProviderName.hami_mymci;
                break;
        }
        return providerName;
    }


}
