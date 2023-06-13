package Giuseppe.Canzoneri.BEU2W3.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }

}