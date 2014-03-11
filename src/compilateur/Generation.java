package compilateur;

public interface Generation {

	void header();
	void ouvrePrinc(int i);
	void footer();
	
	void iconst(int val);
	void istore(int offset);
	void iload(int offset);
	
	void idiv();
	void imul();
	void iadd();
	void isub();
	
	void ineg();
	void inot();
	
	void ior();
	void iand();
	
	void iinf();
	void isup();
	void iinfegal();
	void isupegal();
	void iegal();
	void idiff();
	
	void ecrireInt();
	void ecrireBool();
	void ecrireString(String s);
	void alaligne();
	
	void lire(int offset);
	
	
	
	
}
