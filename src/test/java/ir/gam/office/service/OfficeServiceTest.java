package ir.gam.office.service;

import ir.gam.office.enums.ProviderName;
import ir.gam.office.model.Office;
import ir.gam.office.repository.OfficeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
class OfficeServiceTest {

    @Autowired
    OfficeService officeService;

    @MockBean
    OfficeRepository officeRepository;

    @Test
    void testContext() {
        assertNotNull(officeRepository);
        assertNotNull(officeService);
    }

    @Test
    public void givenOffice_whenCreateOfficeCalled_thenReturnNewOffice() {
        Office office = new Office();

        doReturn(new Office()).when(officeRepository).save(any(Office.class));

        assertNotNull(officeService.registerOffice(office));
    }


    @Test
    void givenIdLong_whenDeleteByIDCalled_thenDeleteOffice() {

        Office office = new Office(1L, "abcdefghijklmno", "123456789", ProviderName.hami_mymci, true);

        doNothing().when(officeRepository).deleteById(anyLong());

        officeService.deleteById(office.getId());

        verify(officeRepository, times(1)).deleteById(office.getId());


//        doThrow(new Exception("Database connection issue"))
//                .when(officeRepository).deleteById(anyLong());
//        officeService.deleteById(office.getId());
    }

//    @Test
//    void whenRegisterOfficeWithoutName_thenReturnNullPointerException() {
//        Office office = new Office();
//        office.setCode("1234567890123");
//        office.setProviderName(ProviderName.huawei);
//        office.setInActive(true);
//
//        officeService.registerOffice(office);
//        //assertThrows(NullPointerException.class);
//    }

    @Test
    public void whenFindAllOfficesCalled_thenReturnsListOfOffices() {
        // given
        Office office = new Office("abcdefghijklmno", "123456789", ProviderName.hami_mymci, true);
        List<Office> expectedOffices = Arrays.asList(office);

        doReturn(expectedOffices).when(officeRepository).findAll();

        // when
        List<Office> actualOffices = officeService.findAllOffices();

        //then
        assertEquals(expectedOffices, actualOffices);
    }

    @Test
    void givenListOfOffices_whenFindAllOffices_thenReturnOfficesListSize() {
        //given
        List<Office> offices = new ArrayList<>();
        Office office1 = new Office("Iraniiiiiiiiiiiiiiiii", "12023874376667732462", ProviderName.hami_mymci, true);
        Office office2 = new Office("Tehraniiiiiiiiiiiiii", "12145345435354534", ProviderName.huawei, true);
        Office office3 = new Office("Karajiiiiiiiiiiiiiii", "1223454354354356435", ProviderName.aban_eshop, false);

        offices.add(office1);
        offices.add(office2);
        offices.add(office3);

        //when
        doReturn(offices).when(officeRepository).findAll();

        //test
        List<Office> officeList = officeService.findAllOffices();

        //then
        assertEquals(3, officeList.size());
        verify(officeRepository, times(1)).findAll();
    }

    @Test
    public void givenIdLong_whenFindByID_thenReturnsOffice() {

        //given
        Office expectedOffice = new Office(1L, "abcdefghijklmno", "123456789000", ProviderName.huawei, true);

        //when
        doReturn(expectedOffice).when(officeRepository).getOne(anyLong());

        //test
        Office actualOffice = officeService.findById(anyLong());

        //then
        assertEquals(expectedOffice.getName(), actualOffice.getName());
        assertEquals(expectedOffice.getCode(), actualOffice.getCode());
        assertEquals(expectedOffice.getProviderName(), actualOffice.getProviderName());

        verify(officeRepository, times(1)).getOne(anyLong());
    }
}