package ir.gam.office;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class OfficeApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OfficeApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(OfficeApplication.class, args);

        LOGGER.info("Simple log statement with inputs {}, {} and {}", 1, 2, 3);
        LOGGER.error("Simple log statement with inputs {}, {} and {}", 1, 2, 3);
        LOGGER.debug("Simple log statement with inputs {}, {} and {}", 1, 2, 3);
        LOGGER.trace("Simple log statement with inputs {}, {} and {}", 1, 2, 3);


    }
}
