package basic.ComEx1.cake_shop.exception;

public class ResourceNotFoundException extends Exception {
    private static final long serialVersionUID = 101812040;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
