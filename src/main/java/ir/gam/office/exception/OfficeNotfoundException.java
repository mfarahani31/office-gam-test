package ir.gam.office;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OfficeNotfoundException extends RuntimeException {

    public OfficeNotfoundException(String exception) {
        super(exception);
    }

}
