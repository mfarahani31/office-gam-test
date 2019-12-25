package ir.gam.office.model;

import ir.gam.office.enums.ProviderName;
import ir.gam.office.repository.OfficeRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(uses = Office.class)
public interface OfficeMapper {

    OfficeMapper INSTANCE = Mappers.getMapper(OfficeMapper.class);

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
