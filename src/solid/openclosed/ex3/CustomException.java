package solid.openclosed.ex3;

public class CustomException extends RuntimeException {

    /**
     * Open Close principle
     * RuntimeException CLOSE for changes but OPEN for expand
     * but better way use Composition
     */

    public String my_message;

    public CustomException(String message, String my_message) {
        super(message);
        this.my_message = my_message;
    }
}
