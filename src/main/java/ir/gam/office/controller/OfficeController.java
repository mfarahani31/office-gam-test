package ir.gam.office.controller;

import ir.gam.office.model.Office;
import ir.gam.office.model.OfficeDto;
import ir.gam.office.model.OfficeMapper;
import ir.gam.office.service.OfficeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Slf4j
@Controller
@RequestMapping(value = "/office")
public class OfficeController {

    private OfficeService officeService;
    private OfficeMapper officeMapper;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Office> create(@RequestBody OfficeDto officeDto) {
        Office office = officeService.registerOffice(officeMapper.INSTANCE.officeDtoToOffice(officeDto));

        return ResponseEntity.status(HttpStatus.CREATED).body(office);
    }

//    @RequestMapping(value = "/getOffices", method = RequestMethod.GET)
//    public @ResponseBody
//    List<OfficeDto> getAllOffices() {
//        List<Office> offices = officeService.findAllOffices();
//        if (offices.isEmpty())
//            throw new OfficeNotfoundException("ids-" + offices);
//        return OfficeMapper.INSTANCE.officesToOfficesDto(offices);
//    }


    @RequestMapping(value = "/getOffices", method = RequestMethod.GET)
    public ResponseEntity<List<OfficeDto>> findAllOffices() {
        return ResponseEntity.ok(officeMapper.INSTANCE.officesToOfficesDto(officeService.findAllOffices()));
    }

    //    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
//    public OfficeDto editOffice(OfficeDto officeDto,@PathVariable("id") Long id) {
//        Office office = officeService.findById(id);
//        office.setName(officeDto.getName());
//        office.setProviderName(officeDto.getProviderName());
//        return ;
//    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ResponseEntity<OfficeDto> update(@PathVariable Long id, @RequestBody OfficeDto officeDto) {
        Office office = officeMapper.INSTANCE.officeDtoToOffice(officeDto);
        office.setId(id);

        officeService.registerOffice(office);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(officeDto);
    }

//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//    public @ResponseBody
//    List<OfficeDto> deleteOffice(@PathVariable("id") Long id) {
//        officeService.deleteById(id);
//        List<Office> offices = officeService.findAllOffices();
//        if (offices.isEmpty())
//            throw new OfficeNotfoundException("ids-" + offices);
//        return officeMapper.INSTANCE.officesToOfficesDto(offices);
//    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ResponseEntity delete(@PathVariable Long id) {
        officeService.deleteById(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }




}
