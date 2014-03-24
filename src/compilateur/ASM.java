package compilateur;

/**
 * Classe de Generation de code en langage Assembleur INTEL 8086 
 * Pour chaque instruction en langage Yaka, on genere un bloc de code ASM INTEL 8086 
 * precede d'un commentaire correspondant a une instruction en langage YVM
 * @author francois
 *
 */

public class ASM  extends AbstractGeneration {
	
	private YVM yvm;
	private int numString;
	
	public ASM(String nameFile)
	{
		super(nameFile);
		yvm = new YVM(out);
		numString = 0;
	}

	@Override
	/**
	 * Generation du header
	 */
	public void header() {
		Ecriture.ecrireChar(out, ';');
		yvm.header();
		
		Ecriture.ecrireStringln(out,"extrn lirent:proc, ecrent:proc\n"
				+ "extrn ecrbool:proc\n"
				+ "extrn ecrch:proc, ligsuiv:proc\n" +
				".model SMALL\n" +
				".586\n" +
				".CODE\n");
	}

	@Override
	/**
	 * Generation du footer
	 */
	public void footer() {
		Ecriture.ecrireChar(out, ';');
		yvm.footer();

		Ecriture.ecrireStringln(out,"nop\n" +
				"EXITCODE\n" +
				"end debut\n");
	}

	@Override
	/**	
	 * Traduction de l'instruction iconst
	 * @param val : int, la valeur de la constante a stocker
	 */
	public void iconst(int val) {
		Ecriture.ecrireChar(out, ';');
		yvm.iconst(val);

		Ecriture.ecrireStringln(out,"push word ptr "+val+"\n");	
	}

	@Override
	/**
	 * Traduction de l'instruction istore
	 * @param offset : int, l'offset de la variable a stocker
	 */
	public void istore(int offset) {
		Ecriture.ecrireChar(out, ';');
		yvm.istore(offset);

		String signe = "";
		if (offset >= 0) signe = "+";
		Ecriture.ecrireStringln(out,"pop ax\n" +
				"mov word ptr[bp"+signe+offset+"], ax\n");	
	}
	/**
	 * Traduction de l'instruction iload
	 * @param offset : int, l'offset de la variable a recuperer
	 */
	@Override
	public void iload(int offset) {
		Ecriture.ecrireChar(out, ';');
		yvm.iload(offset);

		String signe = "";
		if (offset >= 0) signe = "+";
		Ecriture.ecrireStringln(out,"push word ptr[bp"+signe+offset+"]\n");
	}
	/**
	 * Traduction de l'instruction idiv <br>
	 * Divise les  deux premiers elements de la pile
	 */
	@Override
	public void idiv() {
		Ecriture.ecrireChar(out, ';');
		yvm.idiv();

		Ecriture.ecrireStringln(out,"pop bx\n" +
				"pop ax\n" +
				"cwd\n" +
				"idiv bx\n" +
				"push ax\n");
	}
	/**
	 * Traduction de l'instruction mul <br>
	 * Multiplie les  deux premiers elements de la pile
	 */
	@Override
	public void imul() {
		Ecriture.ecrireChar(out, ';');
		yvm.imul();

		Ecriture.ecrireStringln(out,"pop bx\n" +
				"pop ax\n" +
				"imul bx\n" +
				"push ax\n");
	}
	/**
	 * Traduction de l'instruction iadd <br>
	 * Additionne les  deux premiers elements de la pile
	 */
	@Override
	public void iadd() {
		Ecriture.ecrireChar(out, ';');
		yvm.iadd();

		Ecriture.ecrireStringln(out,"pop bx\n" +
				"pop ax\n" +
				"add ax,bx\n" +
				"push ax\n");
	}
	/**
	 * Traduction de l'instruction isub <br>
	 * Soustrait les  deux premiers elements de la pile
	 */
	@Override
	public void isub() {
		Ecriture.ecrireChar(out, ';');
		yvm.isub();

		Ecriture.ecrireStringln(out,"pop bx\n" +
				"pop ax\n" +
				"sub ax,bx\n" +
				"push ax\n");
	}
	/**
	 * Traduction de l'instruction ineg <br>
	 *  Calcule l'opposé de l'operande (par complement a deux)
	 */
	@Override
	public void ineg() {
		Ecriture.ecrireChar(out, ';');
		yvm.ineg();

		Ecriture.ecrireStringln(out,"pop ax\n" +
				"neg ax\n" + // Calcule l'opposé de l'opérande (négation par complément à deux)
				"push ax\n");
	}
	/**
	 * Traduction de l'instruction inot <br>
	 * Effectue un non logique
	 */
	@Override
	public void inot() {
		Ecriture.ecrireChar(out, ';');
		yvm.inot();

		Ecriture.ecrireStringln(out,"pop ax\n" +
				"not ax\n" + // Effectue un NON logique (négation par complément à un)
				"push ax\n");		
	}
	/**
	 * Traduction de l'instruction ior <br>
	 * Effectue un OR entre les  deux premiers elements de la pile
	 */
	@Override
	public void ior() {
		Ecriture.ecrireChar(out, ';');
		yvm.ior();
		
		Ecriture.ecrireStringln(out,"pop ax\n" +
				"pop bx\n" +
				"or ax, bx\n" +
				"push ax\n");	
	}
	/**
	 * Traduction de l'instruction iand <br>
	 * Effectue un AND entre les  deux premiers elements de la pile
	 */
	@Override
	public void iand() {
		Ecriture.ecrireChar(out, ';');
		yvm.iand();
		
		Ecriture.ecrireStringln(out,"pop ax\n" +
				"pop bx\n" +
				"and ax, bx\n" +
				"push ax\n");			
	}
	/**
	 * Traduction de l'instruction iinf <br>
	 * Effectue un JL entre les  deux premiers elements de la pile
	 */
	@Override
	public void iinf() {
		Ecriture.ecrireChar(out, ';');
		yvm.iinf();
		
		Ecriture.ecrireStringln(out,"pop bx\n" +
				"pop ax\n" +
				"cmp ax, bx\n" +
				"jge $+6\n" +
				"push -1\n" +
				"jmp $+4\n" +
				"push 0\n");		
	}

	@Override
	/**
	 * Traduction de l'instruction isup <br>
	 * Effectue un JG entre les  deux premiers elements de la pile
	 */
	public void isup() {
		Ecriture.ecrireChar(out, ';');
		yvm.isup();
		
		Ecriture.ecrireStringln(out,"pop bx\n" +
				"pop ax\n" +
				"cmp ax, bx\n" +
				"jle $+6\n" +
				"push -1\n" +
				"jmp $+4\n" +
				"push 0\n");		
	}

	@Override
	/**
	 * Traduction de l'instruction iinf <br>
	 * Effectue un JLE entre les  deux premiers elements de la pile
	 */
	public void iinfegal() {
		Ecriture.ecrireChar(out, ';');
		yvm.iinfegal();
		
		Ecriture.ecrireStringln(out,"pop bx\n" +
				"pop ax\n" +
				"cmp ax, bx\n" +
				"jg $+6\n" +
				"push -1\n" +
				"jmp $+4\n" +
				"push 0\n");
	}

	@Override
	/**
	 * Traduction de l'instruction iinf <br>
	 * Effectue un JGE entre les  deux premiers elements de la pile
	 */
	public void isupegal() {
		Ecriture.ecrireChar(out, ';');
		yvm.isupegal();
		
		Ecriture.ecrireStringln(out,"pop bx\n" +
				"pop ax\n" +
				"cmp ax, bx\n" +
				"jl $+6\n" +
				"push -1\n" +
				"jmp $+4\n" +
				"push 0\n");
	}

	@Override
	/**
	 * Traduction de l'instruction iegal <br>
	 * Effectue un JE entre les  deux premiers elements de la pile
	 */
	public void iegal() {
		Ecriture.ecrireChar(out, ';');
		yvm.iegal();
		
		Ecriture.ecrireStringln(out,"pop bx\n" +
				"pop ax\n" +
				"cmp ax, bx\n" +
				"jne $+6\n" +
				"push -1\n" +
				"jmp $+4\n" +
				"push 0\n");
	}

	@Override
	/**
	 * Traduction de l'instruction idiff <br>
	 * Effectue un JNE entre les  deux premiers elements de la pile
	 */
	public void idiff() {
		Ecriture.ecrireChar(out, ';');
		yvm.idiff();
		
		Ecriture.ecrireStringln(out,"pop bx\n" +
				"pop ax\n" +
				"cmp ax, bx\n" +
				"je $+6\n" +
				"push -1\n" +
				"jmp $+4\n" +
				"push 0\n");		
	}

	@Override
	/**
	 * Traduction de l'instruction i/o ECRIRE() pour les entiers
	 */
	public void ecrireInt() {
		Ecriture.ecrireChar(out, ';');
		yvm.ecrireInt();
		
		Ecriture.ecrireStringln(out,"call ecrent\n");	
	}

	@Override
	/**
	 * Traduction de l'instruction i/o ECRIRE() pour les booleens
	 */
	public void ecrireBool() {
		Ecriture.ecrireChar(out, ';');
		yvm.ecrireBool();
		
		Ecriture.ecrireStringln(out,"call ecrbool\n");	
	}

	@Override
	/**
	 * Traduction de l'instruction i/o ECRIRE() pour les chaines de caracteres
	 */
	public void ecrireString(String s) {
		Ecriture.ecrireChar(out, ';');
		yvm.ecrireString(s);
		
		Ecriture.ecrireStringln(out,".DATA\n" +
				"mess"+numString+" DB " + s.substring(0, s.length()-1) + "$\"\n" +
				".CODE\n" +
				"lea dx, mess"+numString+"\n" +
				"push dx\n" +
				"call ecrch\n");	
		numString++;
	}

	@Override
	/**
	 * Traduction de l'instruction i/o ALALIGNE() (<-suffisement explicite)
	 */
	public void alaligne() {
		Ecriture.ecrireChar(out, ';');
		yvm.alaligne();
		
		Ecriture.ecrireStringln(out,"call ligsuiv\n");		
	}

	@Override
	/**
	 * Traduction de l'instruction i/o LIRE() 
	 * Ne permet de lire que des entiers
	 */
	public void lire(int offset) { // lireEnt
		Ecriture.ecrireChar(out, ';');
		yvm.lire(offset);
		
		String signe = "";
		if (offset >= 0) signe = "+";
		Ecriture.ecrireStringln(out,"lea dx, [bp"+signe+offset+"]\n" +
				"push dx\n" +
				"call lirent\n");			
	}

	@Override
	/**
	 * Traduction de l'instruction iffaux <br>
	 * Version pour les iterations
	 */
	public void iffauxIter() {
		Ecriture.ecrireStringln(out, "; iffaux FAIT"+stackTantQue.peek());

		Ecriture.ecrireStringln(out,"pop ax \n" +
									"cmp ax,0 \n" +
									"je FAIT"+stackTantQue.peek()+"\n");	
	}
	
	@Override
	/**
	 * Traduction de l'instruction jump <br>
	 * Version pour les iterations
	 */
	public void jumpIter() {
		Ecriture.ecrireStringln(out, "; goto FAIRE"+stackTantQue.peek());
		Ecriture.ecrireStringln(out,"jmp FAIRE"+stackTantQue.peek()+"\n");	
				
	}
	
	
	@Override
	/**
	 * Traduction de l'instruction iffaux <br>
	 * Version pour les conditionelles
	 */
	public void iffauxCond() {
		Ecriture.ecrireStringln(out, "; iffaux SINON"+stackCond.peek());

		Ecriture.ecrireStringln(out,"pop ax \n" +
									"cmp ax,0 \n" +
									"je SINON"+stackCond.peek()+"\n");	
	}

	@Override
	/**
	 * Traduction de l'instruction jump <br>
	 * Version pour les conditionelles
	 */
	public void jumpCond() {
		Ecriture.ecrireStringln(out, "; goto FSI"+stackCond.peek());
		Ecriture.ecrireStringln(out,"jmp FSI"+stackCond.peek()+"\n");	
				
	}

	@Override
	public void debut() {
		Ecriture.ecrireStringln(out, "debut : \n STARTUPCODE");
	}

	@Override
	public void ouvreBloc(String name, int i) {
		Ecriture.ecrireStringln(out,name+": ");	
		Ecriture.ecrireStringln(out,"enter "+i+",0");
	}

	@Override
	public void fermeBloc(int i) {
		Ecriture.ecrireChar(out, ';');
		yvm.fermeBloc(i);
		Ecriture.ecrireStringln(out,"leave");
		Ecriture.ecrireStringln(out,"ret "+i);
	}

	@Override
	public void ireturn(int i) {
		Ecriture.ecrireChar(out, ';');
		yvm.ireturn(i);
		Ecriture.ecrireStringln(out,"pop ax");
		Ecriture.ecrireStringln(out,"mov [bp+"+i+"], ax");
	}

	@Override
	public void reserveRetour() {
		Ecriture.ecrireChar(out, ';');
		yvm.reserveRetour();
		Ecriture.ecrireStringln(out,"sub sp,2");
	}

	@Override
	public void call(String name) {
		Ecriture.ecrireStringln(out,"call "+name);
	}

}
