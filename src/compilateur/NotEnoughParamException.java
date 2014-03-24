package compilateur;

import exceptions.SemanticException;

public class NotEnoughParamException extends SemanticException {
	public NotEnoughParamException(String fonc)
	{
		super(fonc+" has not enough parameters.");
	}
}
