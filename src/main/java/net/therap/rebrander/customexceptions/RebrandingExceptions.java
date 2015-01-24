package net.therap.rebrander.customexceptions;

/**
 * @author mushfekur
 * @since Date: 9/26/13, Time: 9:14 AM
 */
public class RebrandingExceptions extends Exception {
    public RebrandingExceptions() {
    }

    public RebrandingExceptions(String message) {
        super(message);
    }

    public RebrandingExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public RebrandingExceptions(Throwable cause) {
        super(cause);
    }
}
