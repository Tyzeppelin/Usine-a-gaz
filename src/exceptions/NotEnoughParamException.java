package exceptions;


public class NotEnoughParamException extends SemanticException {
	public NotEnoughParamException(String fonc, int diff)
	{
		super(fonc+" has not enough parameters, it misses "+diff+" parameters.");
	}
}
