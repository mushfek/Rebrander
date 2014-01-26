package net.therap.rebrander.customexceptions;

/**
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 9/26/13
 * Time: 12:11 PM
 * To change this template use File | Settings | File Templates.
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
