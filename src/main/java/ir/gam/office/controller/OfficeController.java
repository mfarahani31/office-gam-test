package ir.gam.office.controller;

import ir.gam.office.model.Office;
import ir.gam.office.model.OfficeDto;
import ir.gam.office.model.OfficeMapper;
import ir.gam.office.service.OfficeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@Controller
@RequestMapping(OfficeController.OFFICE_URL)
public class OfficeController {
    public static final String OFFICE_URL = "/office-management/offices/";

    private OfficeService officeService;
    private OfficeMapper officeMapper;

    public OfficeController(OfficeService officeService, OfficeMapper officeMapper) {
        this.officeService = officeService;
        this.officeMapper = officeMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<Office> newOffice(@RequestBody OfficeDto officeDto) {
        Office office = officeService.registerOffice(officeMapper.officeDtoToOffice(officeDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(office);
    }

    @GetMapping("")
    public ResponseEntity<List<OfficeDto>> all() {
        return ResponseEntity.ok(officeMapper.officesToOfficesDto(officeService.findAllOffices()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfficeDto> One(@PathVariable Long id) {
        OfficeDto officeDto = officeMapper.officeToOfficeDto(officeService.findById(id));
        return new ResponseEntity<>(officeDto, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<OfficeDto> replaceOffice(@PathVariable Long id, @RequestBody OfficeDto officeDto) throws URISyntaxException {
        Office office = officeMapper.officeDtoToOffice(officeDto);
        office.setId(id);
        officeService.registerOffice(office);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(officeDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOffice(@PathVariable Long id) {
        officeService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
