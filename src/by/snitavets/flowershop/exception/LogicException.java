package by.snitavets.flowershop.exception;

/**
 *
 * @author Илья
 */
public class LogicException extends ProjectException {

    private static final long serialVersionUID = 1541273901588191403L;

    private Exception exception;

    public LogicException() {
    }

    public LogicException(String er) {
        super(er);
    }

    public LogicException(String er, Exception e) {
        super(er);
        exception = e;
    }

    public Exception getTOException() {
        return exception;
    }

}
