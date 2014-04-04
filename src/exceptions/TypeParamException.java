package exceptions;

import compilateur.IdParam;


public class TypeParamException extends SemanticException {
	public TypeParamException(IdParam param)
	{
		super("The type of the param "+ param.getNom()+" is not correct, "+param.getType()+" expected.");
	}
}
