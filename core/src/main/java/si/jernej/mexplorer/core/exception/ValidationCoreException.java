package si.jernej.mexplorer.core.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class ValidationCoreException extends RuntimeException
{
    public ValidationCoreException(String message)
    {
        super(message);
    }
}
