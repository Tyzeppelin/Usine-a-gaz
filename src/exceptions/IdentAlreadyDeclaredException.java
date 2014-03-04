package exceptions;

import compilateur.Ident;

public class IdentAlreadyDeclaredException extends Exception {
	public IdentAlreadyDeclaredException(Ident ident)
	{
		super("The ident "+ident.getNom()+" has already been declared.");
	}
}
