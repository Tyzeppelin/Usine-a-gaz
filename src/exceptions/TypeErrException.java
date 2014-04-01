package exceptions;

import compilateur.Operateur;

public class TypeErrException extends SemanticException {
	public TypeErrException()
	{
		super("The expression is not correct.");
	}
}
