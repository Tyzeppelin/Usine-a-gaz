package compilateur;

public interface Generation {

	void header();
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
	
	
	
}
