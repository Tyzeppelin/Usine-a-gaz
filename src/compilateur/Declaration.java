package compilateur;

import exceptions.IdentAlreadyDeclaredException;
import exceptions.IdentDoesNotExistException;
import yaka.Yaka;
import yaka.YakaConstants;

public class Declaration implements YakaConstants{
	
	TabIdent tabIdent;
	
	public Declaration(TabIdent tabIdent)
	{
		this.tabIdent=tabIdent;
	}
	
	public void addConst(String name,Type type, int value) throws IdentAlreadyDeclaredException
	{
		if (!tabIdent.existeIdent(name))
		{
			tabIdent.rangeIdent(name, new IdConst(name, type, value));
		}
		else
		{
			throw new IdentAlreadyDeclaredException(name);
		}
	}
	
	public void addConstIdent(String name,String ident) throws IdentAlreadyDeclaredException, IdentDoesNotExistException
	{
		if (!tabIdent.existeIdent(name))
			tabIdent.rangeIdent(name, tabIdent.chercheIdent(ident));
		else
			throw new IdentAlreadyDeclaredException(name);
	}
	
	public void addVar(String name, int type) throws IdentAlreadyDeclaredException
	{
		if (!tabIdent.existeIdent(name))
		{
			tabIdent.rangeIdent(name, new IdVar(name,Type.intToType(type),(tabIdent.nbVarDeclared()+1)*(-2)));
		}
		else
		{
			throw new IdentAlreadyDeclaredException(name);
		}
	}

}
