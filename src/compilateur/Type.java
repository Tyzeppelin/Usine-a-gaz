package compilateur;

import yaka.YakaConstants;

public enum Type implements YakaConstants {
	ENT, BOOL;
	
	public static Type intToType(int type)
	{
		if (type==BOOLEEN)
			return BOOL;
		else if (type==ENTIER)
			return ENT;
		
		return ENT;
	}
}
