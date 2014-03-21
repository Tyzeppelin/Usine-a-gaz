package exceptions;

public class ExpressionNotBooleanException extends SemanticException {
	
	public ExpressionNotBooleanException()
	{
		super("Expression boolean expected.");
	}

}
