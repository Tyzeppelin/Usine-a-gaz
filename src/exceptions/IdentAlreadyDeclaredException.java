package exceptions;


public class IdentAlreadyDeclaredException extends SemanticException {
	public IdentAlreadyDeclaredException(String ident)
	{
		super("The ident "+ident+" has already been declared.");
	}
}
