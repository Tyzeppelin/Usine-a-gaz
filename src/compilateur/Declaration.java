package compilateur;

import yaka.YakaConstants;



public class Declaration implements YakaConstants{
	
	TabIdent tabIdent;
	
	public Declaration(TabIdent tabIdent)
	{
		this.tabIdent=tabIdent;
	}
	
	public void addConst(String name,Type type, int value)
	{
		if (!tabIdent.existeIdent(name))
		{
			tabIdent.rangeIdent(name, new IdConst(name, type, value));
		}
		else
		{
			//erreur
		}
	}
	
	public void addConstIdent(String name,String ident)
	{
		if (!tabIdent.existeIdent(name) && tabIdent.existeIdent(ident))
		{
			tabIdent.rangeIdent(name, tabIdent.chercheIdent(ident));
		}
		else
		{
			//erreur
		}
	}
	
	public void addVar(String name, int type)
	{
		if (!tabIdent.existeIdent(name))
		{
			tabIdent.rangeIdent(name, new IdVar(name,Type.intToType(type)));
		}
		else
		{
			//erreur
		}
	}

}
