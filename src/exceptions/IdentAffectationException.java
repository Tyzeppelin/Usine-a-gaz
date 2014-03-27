package exceptions;

public class IdentAffectationException extends SemanticException {
	public IdentAffectationException(String name)
	{
		super("Identifiant "+name+" cannot be affected.");
	}
}
