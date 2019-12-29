package ir.gam.office.controller;

import ir.gam.office.exception.RecordNotFoundException;
import ir.gam.office.model.Office;
import ir.gam.office.model.OfficeDto;
import ir.gam.office.model.OfficeMapper;
import ir.gam.office.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(OfficeController.OFFICE_URL)
public class OfficeController {
    public static final String OFFICE_URL = "/office";

    private OfficeService officeService;
    private OfficeMapper officeMapper;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Office> registerOffice(@RequestBody OfficeDto officeDto) {
        Office office = officeService.registerOffice(officeMapper.INSTANCE.officeDtoToOffice(officeDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(office);
    }

    @RequestMapping(value = "/getOffices", method = RequestMethod.GET)
    public ResponseEntity<List<OfficeDto>> findAllOffices() {
        return ResponseEntity.ok(officeMapper.INSTANCE.officesToOfficesDto(officeService.findAllOffices()));
    }

    @RequestMapping(value = "/getOffices/{id}", method = RequestMethod.GET)
    public ResponseEntity<OfficeDto> getOfficeById(@PathVariable Long id) {
        OfficeDto officeDto = officeMapper.INSTANCE.officeToOfficeDto(officeService.findById(id));
        if (officeDto == null) {
            throw new RecordNotFoundException("Invalid office id : " + id);
        }
        return new ResponseEntity<>(officeDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ResponseEntity<OfficeDto> editOffice(@PathVariable Long id, @RequestBody OfficeDto officeDto) {
        Office office = officeMapper.INSTANCE.officeDtoToOffice(officeDto);
        office.setId(id);
        officeService.registerOffice(office);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(officeDto);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ResponseEntity deleteOffice(@PathVariable Long id) {
        officeService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
