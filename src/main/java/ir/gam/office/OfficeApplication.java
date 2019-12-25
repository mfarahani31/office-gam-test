package ir.gam.office;

import ir.gam.office.controller.OfficeController;
import ir.gam.office.enums.ProviderName;
import ir.gam.office.model.Office;
import ir.gam.office.repository.OfficeRepository;
import ir.gam.office.service.OfficeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.Provider;

@SpringBootApplication
public class OfficeApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfficeApplication.class, args);

    }
}
