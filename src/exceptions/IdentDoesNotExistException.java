package exceptions;

public class IdentDoesNotExistException extends Exception {
	public IdentDoesNotExistException(String ident)
	{
		super("The ident "+ident+" has not been declared, it does not exist.");
	}
}
