package exceptions;

public class IdentDoesNotExistException extends SemanticException {
	public IdentDoesNotExistException(String ident)
	{
		super("The ident "+ident+" has not been declared, it does not exist.");
	}
}
