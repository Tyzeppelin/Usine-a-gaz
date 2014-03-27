package exceptions;

public class ReturnInMainFunctionException extends SemanticException {
	public ReturnInMainFunctionException()
	{
		super("Return instruction is forbidden in main function.");
	}
}
