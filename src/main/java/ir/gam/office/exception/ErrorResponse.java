package ir.gam.office.exception;


public class ErrorResponse {

    //General error message about nature of error
    private String message;

    //Specific errors in API request processing
    private String details;


    public ErrorResponse(String message, String details) {
        super();
        this.message = message;
        this.details = details;
    }
    //Getter and setters


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
