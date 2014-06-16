package by.snitavets.flowershop.exception;

/**
 *
 * @author Илья
 */
public class TOException extends ProjectException {

    private static final long serialVersionUID = -8211615519409530923L;

    private Exception exception;

    public TOException(String er) {
        super(er);
    }

    public TOException(String er, Exception e) {
        super(er);
        exception = e;
    }

    public Exception getTOException() {
        return exception;
    }

}
