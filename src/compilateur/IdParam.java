package compilateur;

public class IdParam extends Ident {

	private int offset;
	
	
	public IdParam(String nom,Type type) {
		super(nom,type);
	}
	public IdParam(String nom,int type) {
		super(nom,Type.intToType(type));
	}
	@Override
	public String toString() {
		return "IdParam nom="+nom+" type="+type+" [offset=" + offset + "]";
	}
	@Override
	public int getValeur() {
		return offset;
	}
	@Override
	public void setValeur(int value) {
		offset = value;		
	}
	@Override
	public void generateIdent(Generation gen) {
		gen.iload(offset);
		
	}
	
	

}
