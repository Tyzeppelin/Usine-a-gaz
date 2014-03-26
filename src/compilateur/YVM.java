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
		progString.append("entete\n");
	}

	@Override
	public void footer() {
		progString.append("queue\n");
	}

	@Override
	public void iconst(int val) {
		progString.append("iconst "+val+"\n");		
	}

	@Override
	public void istore(int offset) {
		progString.append("istore "+offset+"\n");				
	}

	@Override
	public void iload(int offset) {
		progString.append("iload "+offset+"\n");	
	}

	@Override
	public void idiv() {
		progString.append("idiv\n");
	}

	@Override
	public void imul() {
		progString.append("imul\n");
	}

	@Override
	public void iadd() {
		progString.append("iadd\n");
	}

	@Override
	public void isub() {
		progString.append("isub\n");
	}

	@Override
	public void ineg() {
		progString.append("ineg\n");
	}

	@Override
	public void inot() {
		progString.append("inot\n");
	}

	@Override
	public void ior() {
		progString.append("ior\n");
	}

	@Override
	public void iand() {
		progString.append("iand\n");
	}

	@Override
	public void iinf() {
		progString.append("iinf\n");
	}

	@Override
	public void isup() {
		progString.append("isup\n");
	}

	@Override
	public void iinfegal() {
		progString.append("iinfegal\n");
	}

	@Override
	public void isupegal() {
		progString.append("isupegal\n");
	}

	@Override
	public void iegal() {
		progString.append("iegal\n");
	}

	@Override
	public void idiff() {
		progString.append("idiff\n");
	}

	@Override
	public void ecrireInt() {
		progString.append("ecrireInt\n");
	}

	@Override
	public void ecrireBool() {
		progString.append("ecrireBool\n");
	}

	@Override
	public void ecrireString(String s) {
		progString.append("ecrireChaine "+s+"\n");
	}

	@Override
	public void alaligne() {
		progString.append("aLaLigne\n");
	}

	@Override
	public void lire(int offset) {
		progString.append("lireEnt "+offset+"\n");
	}

	@Override
	public void iffauxIter() {
		progString.append("iffaux FAIT"+stackTantQue.peek()+"\n");	
	}
	@Override
	public void jumpIter() {
		progString.append("goto FAIRE"+stackTantQue.peek()+"\n");				
	}
	@Override
	public void iffauxCond() {
		progString.append("iffaux SINON"+stackCond.peek()+"\n");	
	}
	@Override
	public void jumpCond() {
		progString.append("goto FSI"+stackCond.peek()+"\n");				
	}
	@Override
	public void debut() {
				
	}
	@Override
	public void ouvreBloc(String name, int i) {
		progString.append(name+":\n");	
		progString.append("ouvbloc "+i+"\n");		
		
	}
	@Override
	public void fermeBloc(int i) {
		progString.append("fermebloc "+i+"\n");	
		
	}
	@Override
	public void ireturn(int i) {
		progString.append("ireturn "+i+"\n");	
		
	}
	@Override
	public void reserveRetour() {
		progString.append("reserveRetour\n");	
		
	}
	@Override
	public void call(String name) {
		progString.append("call "+name+"\n");	
		
	}
}
