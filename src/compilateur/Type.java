package compilateur;

import exceptions.TypeErrException;
import yaka.YakaConstants;

public enum Type implements YakaConstants {
	ENT, BOOL, ERR;
	/**
	 * Convertie un entier en Type
	 * @param type
	 * @return
	 */
	public static Type intToType(int type)
	{
		if (type==BOOLEEN)
			return BOOL;
		else if (type==ENTIER)
			return ENT;
		return ERR;
	}
	/**
	 * Convertie un Type en entier
	 * @param type
	 * @return
	 */
	public static int typeToInt(Type type)
	{
		if (type==ENT)
			return ENTIER;
		else if (type==BOOL)
			return BOOLEEN;
		else
			return -1;
	}
	/**
	 * Genere la fonction ecrire en fonction du type
	 * @param type
	 * @param gen
	 * @throws TypeErrException
	 */
	public static void generateEcrireType(Type type, Generation gen) throws TypeErrException
	{
		  if (type==ENT)
		  	gen.ecrireInt();
		  else if (type==BOOL)
		  	gen.ecrireBool();
		  else
			  throw new TypeErrException();
	}
}
