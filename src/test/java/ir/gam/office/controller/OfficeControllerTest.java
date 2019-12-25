package ir.gam.office.controller;

import ir.gam.office.model.Office;
import ir.gam.office.model.OfficeDto;
import ir.gam.office.model.OfficeMapper;
import ir.gam.office.service.OfficeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@WebMvcTest
class OfficeControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    OfficeService officeService;

    @MockBean
    OfficeMapper officeMapper;


    @Test
    public void contextLoads() throws Exception {
        //assertNotNull(officeController);
    }

    @Test
    public void whenFindAll_thenReturnProductDTOList() throws Exception {
        // given
        OfficeDto officeDto = new OfficeDto("abcdefghijklmno", "123456789", "hami-mymci", true);

        List<OfficeDto> officeDtos = Arrays.asList(officeDto);

        doReturn(new ArrayList<Office>()).when(officeService).findAllOffices();
        doReturn(officeDtos).when(officeMapper.INSTANCE).officeToOfficeDto(any());

        // when + then
        this.mockMvc.perform(get("/office/getOffices"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("", is(officeDto.getName())));
    }

    @Test
    public void whenFindById_thenReturnProductDTO() throws Exception {
        // given
        OfficeDto officeDto = new OfficeDto("abcdefghijklmno", "123456789", "hami-mymci", true);


        doReturn(Optional.of(new Office())).when(officeService).findById(anyLong());
        doReturn(officeDto).when(officeMapper.INSTANCE).officeToOfficeDto(any(Office.class));

        // when + then
        this.mockMvc.perform(get("/office/getOffices/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("@.name", is(officeDto.getName())));
    }

    @Test
    void register() {

    }

    @Test
    void editOffice() {
    }

    @Test
    void testEditOffice() {
    }

    @Test
    void getOffices() {
//        // given
//        Office office1 = new Office("asdnajdnasndjnadasdjan", "478327434247273247", "huawei", false);
//        Office office2 = new Office("sadslknlnfnjsdcsclkasjdas", "89574575557346755", "aban-eshop", true);
//        List<Office> offices = new ArrayList<>();
//        when(officeRepository.findAll()).thenReturn(offices);
//
//        // when
//        List<Office> result = officeController.getOffices();
//
//        // then
//        assertEquals(10,result.size());
//
//        assertEquals(office1.getName(),result.get(0).getName());
//
//        assertEquals(office2.getName(),result.get(1).getName());

    }
}