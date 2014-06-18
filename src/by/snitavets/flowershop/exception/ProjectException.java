package by.snitavets.flowershop.exception;

/**
 *
 * @author Илья
 */
public class ProjectException extends Exception {

    private static final long serialVersionUID = -6606308171056337213L;

    public ProjectException(String er) {
        super(er);
    }

    public ProjectException(String er, Exception e) {
        super(er);
    }

    public ProjectException() {
    }
    
}
