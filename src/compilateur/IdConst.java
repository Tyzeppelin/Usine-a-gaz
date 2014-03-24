package compilateur;

public class IdConst extends Ident {
	

	/**
	 * La valeur de la constante
	 */
	private int val;

	public IdConst(String nom)
	{
		super(nom);
	}
	public IdConst(String nom, Type type, int val) {
		super(nom, type);
		this.val = val;
	}

	@Override
	public int getValeur() {
		return val;
	}

	@Override
	public void setValeur(int value)
	{
		val = value; 
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + val;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof IdConst)) {
			return false;
		}
		IdConst other = (IdConst) obj;
		if (val != other.val) {
			return false;
		}
		return true;
	}
	
	@Override
	public void generateIdent(Generation gen) {
		gen.iconst(val);
	}
	
	
	

}
