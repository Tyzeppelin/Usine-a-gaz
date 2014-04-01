package exceptions;

import compilateur.Type;

public class ReturnTypeNotCorrectException extends SemanticException {
	public ReturnTypeNotCorrectException(Type expected)
	{
		super("Return type of the function is not correct, "+expected+" was expected.");
	}
}
