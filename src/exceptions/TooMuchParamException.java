package exceptions;


public class TooMuchParamException extends SemanticException {
	public TooMuchParamException(String fonc, int nb)
	{
		super(fonc +" has too much parameters. ("+nb+" more).");
	}
}
