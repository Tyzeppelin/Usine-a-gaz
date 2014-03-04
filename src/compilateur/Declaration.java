package compilateur;

import exceptions.IdentAlreadyDeclaredException;
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
			throw new IdentAlreadyDeclaredException(tabIdent.chercheIdent(name));
		}
	}
	
	public void addConstIdent(String name,String ident) throws IdentAlreadyDeclaredException
	{
		if (!tabIdent.existeIdent(name) && tabIdent.existeIdent(ident))
		{
			tabIdent.rangeIdent(name, tabIdent.chercheIdent(ident));
		}
		else
		{
			throw new IdentAlreadyDeclaredException(tabIdent.chercheIdent(name));
		}
	}
	
	public void addVar(String name, int type) throws IdentAlreadyDeclaredException
	{
		if (!tabIdent.existeIdent(name))
		{
			tabIdent.rangeIdent(name, new IdVar(name,Type.intToType(type)));
		}
		else
		{
			throw new IdentAlreadyDeclaredException(tabIdent.chercheIdent(name));
		}
	}

}
