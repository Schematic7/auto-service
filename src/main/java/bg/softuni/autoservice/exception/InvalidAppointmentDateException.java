package bg.softuni.autoservice.exception;

public class InvalidAppointmentDateException extends RuntimeException {
    public InvalidAppointmentDateException(String message) {
        super(message);
    }
}