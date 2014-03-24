package compilateur;

import java.io.OutputStream;

public class YVM extends AbstractGeneration {
	
	public YVM(OutputStream out)
	{
		this.out=out;
	}
	public YVM(String nameFile)
	{
		super(nameFile);
	}

	@Override
	public void header() {
		Ecriture.ecrireStringln(out,"entete");
	}

	@Override
	public void footer() {
		Ecriture.ecrireStringln(out,"queue");
	}

	@Override
	public void iconst(int val) {
		Ecriture.ecrireStringln(out,"iconst "+val);		
	}

	@Override
	public void istore(int offset) {
		Ecriture.ecrireStringln(out,"istore "+offset);				
	}

	@Override
	public void iload(int offset) {
		Ecriture.ecrireStringln(out,"iload "+offset);	
	}

	@Override
	public void idiv() {
		Ecriture.ecrireStringln(out,"idiv");
	}

	@Override
	public void imul() {
		Ecriture.ecrireStringln(out,"imul");
	}

	@Override
	public void iadd() {
		Ecriture.ecrireStringln(out,"iadd");
	}

	@Override
	public void isub() {
		Ecriture.ecrireStringln(out,"isub");
	}

	@Override
	public void ineg() {
		Ecriture.ecrireStringln(out,"ineg");
	}

	@Override
	public void inot() {
		Ecriture.ecrireStringln(out,"inot");
	}

	@Override
	public void ior() {
		Ecriture.ecrireStringln(out,"ior");
	}

	@Override
	public void iand() {
		Ecriture.ecrireStringln(out,"iand");
	}

	@Override
	public void iinf() {
		Ecriture.ecrireStringln(out,"iinf");
	}

	@Override
	public void isup() {
		Ecriture.ecrireStringln(out,"isup");
	}

	@Override
	public void iinfegal() {
		Ecriture.ecrireStringln(out,"iinfegal");
	}

	@Override
	public void isupegal() {
		Ecriture.ecrireStringln(out,"isupegal");
	}

	@Override
	public void iegal() {
		Ecriture.ecrireStringln(out,"iegal");
	}

	@Override
	public void idiff() {
		Ecriture.ecrireStringln(out,"idiff");
	}

	@Override
	public void ecrireInt() {
		Ecriture.ecrireStringln(out,"ecrireInt");
	}

	@Override
	public void ecrireBool() {
		Ecriture.ecrireStringln(out,"ecrireBool");
	}

	@Override
	public void ecrireString(String s) {
		Ecriture.ecrireStringln(out,"ecrireChaine "+s+" ");
	}

	@Override
	public void alaligne() {
		Ecriture.ecrireStringln(out,"aLaLigne");
	}

	@Override
	public void lire(int offset) {
		Ecriture.ecrireStringln(out,"lireEnt "+offset);
	}

	@Override
	public void iffauxIter() {
		Ecriture.ecrireStringln(out,"iffaux FAIT"+stackTantQue.peek());	
	}
	@Override
	public void jumpIter() {
		Ecriture.ecrireStringln(out,"goto FAIRE"+stackTantQue.peek());				
	}
	@Override
	public void iffauxCond() {
		Ecriture.ecrireStringln(out,"iffaux SINON"+stackCond.peek());	
	}
	@Override
	public void jumpCond() {
		Ecriture.ecrireStringln(out,"goto FSI"+stackCond.peek());				
	}
	@Override
	public void debut() {
				
	}
	@Override
	public void ouvreBloc(String name, int i) {
		Ecriture.ecrireStringln(out,name+":");	
		Ecriture.ecrireStringln(out,"ouvbloc "+i);		
		
	}
	@Override
	public void fermeBloc(int i) {
		Ecriture.ecrireStringln(out,"fermebloc "+i);	
		
	}
	@Override
	public void ireturn(int i) {
		Ecriture.ecrireStringln(out,"ireturn "+i);	
		
	}
	@Override
	public void reserveRetour() {
		Ecriture.ecrireStringln(out,"reserveRetour");	
		
	}
	@Override
	public void call(String name) {
		Ecriture.ecrireStringln(out,"call "+name);	
		
	}
}
