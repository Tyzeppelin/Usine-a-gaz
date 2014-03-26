package exceptions;

public class ReturnForbiddenInMainFunction extends SemanticException {
	public ReturnForbiddenInMainFunction()
	{
		super("Return instruction is forbidden in main function.");
	}
}
