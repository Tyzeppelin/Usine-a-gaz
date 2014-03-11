package exceptions;

import compilateur.Ident;

public class IdentAlreadyDeclaredException extends Exception {
	public IdentAlreadyDeclaredException(String ident)
	{
		super("The ident "+ident+" has already been declared.");
	}
}
