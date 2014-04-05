package compilateur;

import java.io.OutputStream;

import yaka.Yaka;

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
	public void iconst(Ident ident) {
		progString.append("iconst "+ident.getValeur()+"\n");
		
	}
	@Override
	public void iconst(int val) {
		progString.append("iconst "+val+"\n");
		
	}
	@Override
	public void istore(Ident ident) {
		progString.append("istore "+ident.getValeur()+"\n");
		
	}
	@Override
	public void iload(Ident ident) {
		progString.append("iload "+ident.getValeur()+"\n");
		
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
	public void lire(Ident ident) {
		progString.append("lireEnt "+ident.getValeur()+"\n");		
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
	public void ouvreBloc(IdFonc fonc) {
		progString.append(fonc.getNom()+":\n");	
		progString.append("ouvbloc "+Yaka.tabIdent.nbVarDeclared()*2+"\n");	
		
	}
	@Override
	public void fermeBloc(IdFonc fonc) {
		progString.append("fermebloc "+fonc.getNbParam()*2+"\n");	
		
	}
	@Override
	public void ireturn(IdFonc fonc) {
		progString.append("ireturn "+((fonc.getNbParam()*2)+4)+"\n");	
		
	}

	@Override
	public void reserveRetour() {
		progString.append("reserveRetour\n");	
		
	}

	@Override
	public void call(IdFonc fonc) {
		progString.append("call "+fonc.getNom()+"\n");	
		
	}

}
