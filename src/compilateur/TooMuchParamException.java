package compilateur;

import exceptions.SemanticException;

public class TooMuchParamException extends SemanticException {
	public TooMuchParamException(String fonc)
	{
		super(fonc +" has too much parameters.");
	}
}
