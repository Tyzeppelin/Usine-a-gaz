package compilateur;

import yaka.Yaka;

/**
 * Classe de Generation de code en langage Assembleur INTEL 8086 
 * Pour chaque instruction en langage Yaka, on genere un bloc de code ASM INTEL 8086 
 * precede d'un commentaire correspondant a une instruction en langage YVM
 * @author francois
 *
 */

public class ASM  extends AbstractGeneration {
	
	private int numString;
	
	public ASM(String nameFile)
	{
		super(nameFile);
		numString = 0;
	}

	@Override
	/**
	 * Generation du header
	 */
	public void header() {
		progString.append("; entete\n");
		
		progString.append("extrn lirent:proc, ecrent:proc\n"
				+ "extrn ecrbool:proc\n"
				+ "extrn ecrch:proc, ligsuiv:proc\n" +
				".model SMALL\n" +
				".586\n" +
				".CODE\n\n");
	}

	@Override
	/**
	 * Generation du footer
	 */
	public void footer() {
		progString.append("; queue\n");

		progString.append("nop\n" +
				"EXITCODE\n" +
				"end debut\n\n");
	}

	@Override
	/**	
	 * Traduction de l'instruction iconst
	 * @param val : int, la valeur de la constante a stocker
	 */
	public void iconst(Ident ident) {
		progString.append("; iconst "+ident.getValeur()+"\n");

		progString.append("push word ptr "+ident.getValeur()+"\n\n");	
	}
	
	@Override
	/**	
	 * Traduction de l'instruction iconst
	 * @param val : int, la valeur de la constante a stocker
	 */
	public void iconst(int val) {
		progString.append("; iconst "+val+"\n");

		progString.append("push word ptr "+val+"\n\n");	
	}

	@Override
	/**
	 * Traduction de l'instruction istore
	 * @param offset : int, l'offset de la variable a stocker
	 */
	public void istore(Ident ident) {
		int i = ident.getValeur();
		progString.append("; istore "+i+"\n");

		String signe = "";
		if (i >= 0) signe = "+";
		progString.append("pop ax\n" +
				"mov word ptr[bp"+signe+i+"], ax\n\n");	
	}
	/**
	 * Traduction de l'instruction iload
	 * @param offset : int, l'offset de la variable a recuperer
	 */
	@Override
	public void iload(Ident ident) {
		progString.append("; iload "+ident.getValeur()+"\n");

		String signe = "";
		if (ident.getValeur() >= 0) signe = "+";
		progString.append("push word ptr[bp"+signe+ident.getValeur()+"]\n\n");
	}
	/**
	 * Traduction de l'instruction idiv <br>
	 * Divise les  deux premiers elements de la pile
	 */
	@Override
	public void idiv() {
		progString.append("; idiv\n");

		progString.append("pop bx\n" +
				"pop ax\n" +
				"cwd\n" +
				"idiv bx\n" +
				"push ax\n\n");
	}
	/**
	 * Traduction de l'instruction mul <br>
	 * Multiplie les  deux premiers elements de la pile
	 */
	@Override
	public void imul() {
		progString.append("; imul \n");

		progString.append("pop bx\n" +
				"pop ax\n" +
				"imul bx\n" +
				"push ax\n\n");
	}
	/**
	 * Traduction de l'instruction iadd <br>
	 * Additionne les  deux premiers elements de la pile
	 */
	@Override
	public void iadd() {
		progString.append("; iadd \n");

		progString.append("pop bx\n" +
				"pop ax\n" +
				"add ax,bx\n" +
				"push ax\n\n");
	}
	/**
	 * Traduction de l'instruction isub <br>
	 * Soustrait les  deux premiers elements de la pile
	 */
	@Override
	public void isub() {
		progString.append("; isub \n");

		progString.append("pop bx\n" +
				"pop ax\n" +
				"sub ax,bx\n" +
				"push ax\n\n");
	}
	/**
	 * Traduction de l'instruction ineg <br>
	 *  Calcule l'opposé de l'operande (par complement a deux)
	 */
	@Override
	public void ineg() {
		progString.append("; ineg \n");

		progString.append("pop ax\n" +
				"neg ax\n" + // Calcule l'opposé de l'opérande (négation par complément à deux)
				"push ax\n\n");
	}
	/**
	 * Traduction de l'instruction inot <br>
	 * Effectue un non logique
	 */
	@Override
	public void inot() {
		progString.append("; inot \n");

		progString.append("pop ax\n" +
				"not ax\n" + // Effectue un NON logique (négation par complément à un)
				"push ax\n\n");		
	}
	/**
	 * Traduction de l'instruction ior <br>
	 * Effectue un OR entre les  deux premiers elements de la pile
	 */
	@Override
	public void ior() {
		progString.append("; ior \n");
		
		progString.append("pop ax\n" +
				"pop bx\n" +
				"or ax, bx\n" +
				"push ax\n\n");	
	}
	/**
	 * Traduction de l'instruction iand <br>
	 * Effectue un AND entre les  deux premiers elements de la pile
	 */
	@Override
	public void iand() {
		progString.append("; iand \n");
		
		progString.append("pop ax\n" +
				"pop bx\n" +
				"and ax, bx\n" +
				"push ax\n\n");			
	}
	/**
	 * Traduction de l'instruction iinf <br>
	 * Effectue un JL entre les  deux premiers elements de la pile
	 */
	@Override
	public void iinf() {
		progString.append("; iinf \n");
		
		progString.append("pop bx\n" +
				"pop ax\n" +
				"cmp ax, bx\n" +
				"jge $+6\n" +
				"push -1\n" +
				"jmp $+4\n" +
				"push 0\n\n");		
	}

	@Override
	/**
	 * Traduction de l'instruction isup <br>
	 * Effectue un JG entre les  deux premiers elements de la pile
	 */
	public void isup() {
		progString.append("; isup \n");
		
		progString.append("pop bx\n" +
				"pop ax\n" +
				"cmp ax, bx\n" +
				"jle $+6\n" +
				"push -1\n" +
				"jmp $+4\n" +
				"push 0\n\n");		
	}

	@Override
	/**
	 * Traduction de l'instruction iinf <br>
	 * Effectue un JLE entre les  deux premiers elements de la pile
	 */
	public void iinfegal() {
		progString.append("; iinfegal \n");
		
		progString.append("pop bx\n" +
				"pop ax\n" +
				"cmp ax, bx\n" +
				"jg $+6\n" +
				"push -1\n" +
				"jmp $+4\n" +
				"push 0\n\n");
	}

	@Override
	/**
	 * Traduction de l'instruction iinf <br>
	 * Effectue un JGE entre les  deux premiers elements de la pile
	 */
	public void isupegal() {
		progString.append("; isupegal \n");
		
		progString.append("pop bx\n" +
				"pop ax\n" +
				"cmp ax, bx\n" +
				"jl $+6\n" +
				"push -1\n" +
				"jmp $+4\n" +
				"push 0\n\n");
	}

	@Override
	/**
	 * Traduction de l'instruction iegal <br>
	 * Effectue un JE entre les  deux premiers elements de la pile
	 */
	public void iegal() {
		progString.append("; iegal \n");
		
		progString.append("pop bx\n" +
				"pop ax\n" +
				"cmp ax, bx\n" +
				"jne $+6\n" +
				"push -1\n" +
				"jmp $+4\n" +
				"push 0\n\n");
	}

	@Override
	/**
	 * Traduction de l'instruction idiff <br>
	 * Effectue un JNE entre les  deux premiers elements de la pile
	 */
	public void idiff() {
		progString.append("; idiff \n");
		
		progString.append("pop bx\n" +
				"pop ax\n" +
				"cmp ax, bx\n" +
				"je $+6\n" +
				"push -1\n" +
				"jmp $+4\n" +
				"push 0\n\n");		
	}

	@Override
	/**
	 * Traduction de l'instruction i/o ECRIRE() pour les entiers
	 */
	public void ecrireInt() {
		progString.append("; ecrireInt\n");
		
		progString.append("call ecrent\n\n");	
	}

	@Override
	/**
	 * Traduction de l'instruction i/o ECRIRE() pour les booleens
	 */
	public void ecrireBool() {
		progString.append("; ecrireBool \n");
		
		progString.append("call ecrbool\n\n");	
	}

	@Override
	/**
	 * Traduction de l'instruction i/o ECRIRE() pour les chaines de caracteres
	 */
	public void ecrireString(String s) {
		progString.append("; ecrireChaine "+s+"\n");
		
		progString.append(".DATA\n" +
				"mess"+numString+" DB " + s.substring(0, s.length()-1) + "$\"\n" +
				".CODE\n" +
				"lea dx, mess"+numString+"\n" +
				"push dx\n" +
				"call ecrch\n\n");	
		numString++;
	}

	@Override
	/**
	 * Traduction de l'instruction i/o ALALIGNE() (<-suffisement explicite)
	 */
	public void alaligne() {
		progString.append("; aLaLigne\n");
		
		progString.append("call ligsuiv\n\n");		
	}

	@Override
	/**
	 * Traduction de l'instruction i/o LIRE() 
	 * Ne permet de lire que des entiers
	 */
	public void lire(Ident ident) { // lireEnt
		int i=ident.getValeur();
		progString.append("; lireEnt "+i+"\n");
		
		String signe = "";
		if (i >= 0) signe = "+";
		progString.append("lea dx, [bp"+signe+i+"]\n" +
				"push dx\n" +
				"call lirent\n\n");			
	}

	@Override
	/**
	 * Traduction de l'instruction iffaux <br>
	 * Version pour les iterations
	 */
	public void iffauxIter() {
		progString.append("; iffaux FAIT"+stackTantQue.peek()+"\n");

		progString.append("pop ax \n" +
									"cmp ax,0 \n" +
									"je FAIT"+stackTantQue.peek()+"\n\n");	
	}
	
	@Override
	/**
	 * Traduction de l'instruction jump <br>
	 * Version pour les iterations
	 */
	public void jumpIter() {
		progString.append("; goto FAIRE"+stackTantQue.peek()+"\n");
		progString.append("jmp FAIRE"+stackTantQue.peek()+"\n\n");	
				
	}
	
	
	@Override
	/**
	 * Traduction de l'instruction iffaux <br>
	 * Version pour les conditionelles
	 */
	public void iffauxCond() {
		progString.append("; iffaux SINON"+stackCond.peek()+"\n");

		progString.append("pop ax \n" +
									"cmp ax,0 \n" +
									"je SINON"+stackCond.peek()+"\n\n");	
	}

	@Override
	/**
	 * Traduction de l'instruction jump <br>
	 * Version pour les conditionelles
	 */
	public void jumpCond() {
		progString.append("; goto FSI"+stackCond.peek()+"\n");
		progString.append("jmp FSI"+stackCond.peek()+"\n\n");	
				
	}

	@Override
	/**
	 * Generation de l'etiquette debut et  du STARTUPCODE
	 */
	public void debut() {
		progString.append("debut : \n STARTUPCODE\n\n");
	}

	@Override
	/**
	 * Generation des etiquette et du enter pour les blocs de fonctions
	 */
	public void ouvreBloc(IdFonc fonc) {
		
		progString.append(fonc.getNom()+": \n");	
		progString.append("enter "+Yaka.tabIdent.nbVarDeclared()*2+",0 \n\n");
	}

	@Override
	/**
	 * Generation des etiquette et du leave ret pour les blocs de fonctions
	 */
	public void fermeBloc(IdFonc fonc) {
		int i = fonc.getNbParam()*2;
		progString.append("; fermeBloc "+i+"\n");
		progString.append("leave\n");
		progString.append("ret "+i+"\n\n");
	}

	@Override
	/**
	 * Trraduction de l'instruction return
	 */
	public void ireturn(IdFonc fonc) {
		int i = (fonc.getNbParam()*2)+4;
		progString.append("; ireturn "+i+"\n");
		progString.append("pop ax\n");
		progString.append("mov [bp+"+i+"], ax\n\n");
	}

	@Override
	/**
	 * Generation de reservation d'espace pour une fusee
	 */
	public void reserveRetour() {
		progString.append(";reserveRetour \n");
		progString.append("sub sp,2\n\n");
	}

	@Override
	/**
	 * Generation d'une instruction d'appel de fonction
	 */
	public void call(IdFonc fonc) {
		progString.append("call "+fonc.getNom()+"\n\n");
	}

}
