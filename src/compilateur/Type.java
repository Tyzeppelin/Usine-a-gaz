package compilateur;

import exceptions.ErrTypeExprException;
import yaka.YakaConstants;

public enum Type implements YakaConstants {
	ENT, BOOL, ERR;
	
	public static Type intToType(int type)
	{
		if (type==BOOLEEN)
			return BOOL;
		else if (type==ENTIER)
			return ENT;
		return ERR;
	}
	
	public static int typeToInt(Type type)
	{
		if (type==ENT)
			return ENTIER;
		else if (type==BOOL)
			return BOOLEEN;
		else
			return -1;
	}
	
	public static void generateEcrireType(Type type, AbstractGeneration gen) throws ErrTypeExprException
	{
		  if (type==ENT)
		  	gen.ecrireInt();
		  else if (type==BOOL)
		  	gen.ecrireBool();
		  else
			  throw new ErrTypeExprException();
	}
}
