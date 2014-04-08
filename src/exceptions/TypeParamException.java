package exceptions;

import compilateur.IdFonc;
import compilateur.IdParam;


public class TypeParamException extends SemanticException {
	public TypeParamException(IdFonc fonc, IdParam param)
	{
		super("The type of the param \""+ param.getNom()+"\" in the function \""+fonc.getNom()+"\" is not correct, "+param.getType()+" expected.");
	}
}
