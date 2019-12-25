package ir.gam.office.controller;

import ir.gam.office.model.Office;
import ir.gam.office.repository.OfficeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest
class OfficeControllerTest {

    @Autowired
    OfficeController officeController;


    @MockBean
    OfficeRepository officeRepository;


    @Test
    public void contextLoads() throws Exception {
        assertNotNull(officeController);
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