package exceptions;

public class ErrTypeExprException extends SemanticException {
	public ErrTypeExprException()
	{
		super("The expression is not correct.");
	}
}
