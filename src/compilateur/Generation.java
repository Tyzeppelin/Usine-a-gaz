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
	
	void ecrireInt();
	void ecrireBool();
	void ecrireString(String s);
	void alaligne();
	
	void lire(int offset);
	
	void closeFile();
	
	void iffauxIter();
	void faire();
	void jumpIter();
	void fait();
	
	void iffauxCond();
	void jumpCond();
	void sinon();
	void fsi();
	void si();
	
	void debut();
	void ouvreBloc(String name, int i);
	void fermeBloc(int i);
	void ireturn(int i);
	void reserveRetour();
	void call(String name);
	
	
	
	
	
}
