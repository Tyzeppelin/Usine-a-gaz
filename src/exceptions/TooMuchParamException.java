package exceptions;


public class TooMuchParamException extends SemanticException {
	public TooMuchParamException(String fonc)
	{
		super(fonc +" has too much parameters.");
	}
}
