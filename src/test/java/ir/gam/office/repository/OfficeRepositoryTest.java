package ir.gam.office.repository;

import ir.gam.office.enums.ProviderName;
import ir.gam.office.model.Office;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class OfficeRepositoryTest {

    @Autowired
    OfficeRepository officeRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @Before(value = "")
    public void setUp() {
        // given
        Office office = new Office("abcdefghijklmno", "123456789", ProviderName.hami_mymci, true);

        testEntityManager.persist(office);
    }

    @Test
    public void whenFindByName_thenReturnProduct() {
        // when
        Office office = officeRepository.findById(1L).get();

        // then
        assertEquals(1L, office.getId());
    }

    @Test
    public void whenFindAll_thenReturnProductList() {
        // when
        List<Office> officeList = officeRepository.findAll();

        // then
        assertEquals(1, officeList.size());
    }


}