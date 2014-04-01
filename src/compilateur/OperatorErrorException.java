package compilateur;

import exceptions.SemanticException;

public class OperatorErrorException extends SemanticException {

	public OperatorErrorException(String string) {
		super(string);
	}

}
