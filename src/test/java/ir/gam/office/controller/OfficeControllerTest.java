package ir.gam.office.controller;

import ir.gam.office.model.Office;
import ir.gam.office.model.OfficeDto;
import ir.gam.office.model.OfficeMapper;
import ir.gam.office.service.OfficeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
//@SpringBootTest
@WebMvcTest(OfficeController.class)
class OfficeControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    OfficeService officeService;

    @MockBean
    OfficeMapper officeMapper;


    @Test
    public void contextLoads() {
        assertNotNull(officeMapper);
        assertNotNull(officeService);
    }

    @Test
    public void whenFindAllOffices_thenReturnOfficeDTOList() throws Exception {
        // given
        OfficeDto officeDto = new OfficeDto("abcdefghijklmno", "1234567890123", "hami-mymci", true);

        List<OfficeDto> officeDtos = Arrays.asList(officeDto);

        doReturn(new ArrayList<Office>()).when(officeService).findAllOffices();
        doReturn(officeDtos).when(officeMapper).officesToOfficesDto(any());

        // when + then
        this.mockMvc.perform(get(OfficeController.OFFICE_URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", is(officeDto.getName())))
                .andExpect(jsonPath("$[0].providerName", is(officeDto.getProviderName())))
                .andExpect(jsonPath("$[0].inActive", is(officeDto.isInActive())))
                .andExpect(jsonPath("$[0].name", is(officeDto.getName())));
    }

    @Test
    public void whenGetOfficeById_thenReturnOfficeDTO() throws Exception {
        // given
        OfficeDto officeDto = new OfficeDto(1L, "abcdefghijklmno", "1234567890123", "hami-mymci", true);


        doReturn(new Office()).when(officeService).findById(anyLong());
        doReturn(officeDto).when(officeMapper).officeToOfficeDto(any(Office.class));

        // when + then
        this.mockMvc.perform(get(OfficeController.OFFICE_URL + anyLong()))
                .andExpect(status().isOk())
                //.andExpect(jsonPath("$.id", is(officeDto.getId())))
                .andExpect(jsonPath("$.code", is(officeDto.getCode())))
                .andExpect(jsonPath("$.providerName", is(officeDto.getProviderName())))
                .andExpect(jsonPath("$.inActive", is(officeDto.isInActive())))
                .andExpect(jsonPath("$.name", is(officeDto.getName())));
    }

//    @Test
//    void whenValidInput_thenReturns200() throws Exception {
//        OfficeDto officeDto = new OfficeDto(1L, "abcdefghijklmno", "1234567890123", "hami-mymci", true);
//
//        this.mockMvc.perform(post("/office/register", 42L)
//                .contentType("application/json")
//                .param("sendWelcomeMail", "true")
//                .content(officeMapper.writeValueAsString(user)))
//                .andExpect(status().isOk());
//    }
}