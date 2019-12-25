package ir.gam.office.service;

import ir.gam.office.model.Office;
import ir.gam.office.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeService {

    private OfficeRepository officeRepository;

    @Autowired
    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public Office registerOffice(Office office) {
        return this.officeRepository.save(office);
    }

    public List<Office> findAllOffices() {
        return officeRepository.findAll();
    }

    public Office findById(Long id) {
        return this.officeRepository.getOne(id);
    }

    public void deleteById(Long id) {
        officeRepository.deleteById(id);
    }

}
