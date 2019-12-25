package ir.gam.office.service;

import ir.gam.office.enums.ProviderName;
import ir.gam.office.model.Office;
import ir.gam.office.repository.OfficeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class OfficeServiceTest {


    @Autowired
    OfficeService officeService;

    @MockBean
    OfficeRepository officeRepository;


    @Test
    void registerOffice() {
    }

    @Test
    void findAllOffices() {
        //given
        List<Office> offices = new ArrayList<>();
        Office office1 = new Office("Iraniiiiiiiiiiiiiiiii","12023874376667732462", ProviderName.hami_mymci,true);
        Office office2 = new Office("Tehraniiiiiiiiiiiiii","12145345435354534",ProviderName.huawei,true);
        Office office3 = new Office("Karajiiiiiiiiiiiiiii","1223454354354356435",ProviderName.aban_eshop,false);

        offices.add(office1);
        offices.add(office2);
        offices.add(office3);

        //when
        doReturn(offices).when(officeRepository).findAll();

        //test
        List<Office> officeList = officeService.findAllOffices();

        //then
        assertEquals(3,officeList.size());
        verify(officeRepository,times(1)).findAll();

    }

    @Test
    void findById() {
    }

    @Test
    void deleteById() {
    }
}