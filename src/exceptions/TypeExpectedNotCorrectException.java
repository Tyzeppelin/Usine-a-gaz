package exceptions;

import compilateur.Type;

public class TypeExpectedNotCorrectException extends SemanticException {
	public TypeExpectedNotCorrectException(Type typeGiven, Type typeExcepted)
	{
		super("This expression has type "+typeGiven+" but an expression was expected of type "+typeExcepted);
	}
}
