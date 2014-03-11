package compilateur;

public class IdVar extends Ident {
	
	private int offset;


	public IdVar(String nom, Type type) {
		super(nom, type);
		this.offset=-1;
	}
	public IdVar(String nom, Type type, int offset) {
		super(nom, type);
		this.offset = offset;
	}
	@Override
	public int getValeur() {
		return offset;
	}

	@Override
	public void setValeur(int value)
	{
		offset = value; 
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + offset;
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
		if (!(obj instanceof IdVar)) {
			return false;
		}
		IdVar other = (IdVar) obj;
		if (offset != other.offset) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "IdVar [offset=" + offset + "]";
	}
	@Override
	public void generateIdent(Generation gen) {
		gen.iload(offset);
	}
	
	

}
