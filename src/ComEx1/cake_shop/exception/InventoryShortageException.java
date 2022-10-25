package ComEx1.cake_shop.exception;

public class InventoryShortageException extends Exception {
    private static final long serialVersionUID = 101812041;

    public InventoryShortageException(String message) {
        super(message);
    }
}
