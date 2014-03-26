package compilateur;

import java.io.OutputStream;
import java.util.Stack;
/**
 * 
 * Classe abstraite qui implemente l'interface Generation <br>
 * Permet de ne pas red�finir deux fois les memes methodes.
 * 
 * @author Francois Boschet
 *
 */


public abstract class AbstractGeneration implements Generation {

	protected OutputStream out;
	private String nameFile;
	protected StringBuilder progString;
	
	protected Stack<Integer> stackTantQue; 
	protected int nbIter = 1;
	
	protected Stack<Integer> stackCond; 
	protected int nbCond = 1;

	protected AbstractGeneration()
	{
		out = System.out;
		progString = new StringBuilder();
		stackTantQue = new Stack<Integer>();
		stackTantQue.push(0);
		stackCond = new Stack<Integer>();
		stackCond.push(0);
	}
	protected AbstractGeneration(String nameFile)
	{
		this.nameFile=nameFile;
		progString = new StringBuilder();
		stackTantQue = new Stack<Integer>();
		stackTantQue.push(0);
		stackCond = new Stack<Integer>();
		stackCond.push(0);
	}

	/**
	 * Generation d'une etiquette SINONi, i:int
	 */
	public void sinon()
	{
		jumpCond();
		progString.append("SINON"+stackCond.peek()+":\n");		
	}
	/** 
	 * Generation d'un etiquette FSIi, i:int
	 */
	public void fsi()
	{
		progString.append( "FSI"+stackCond.pop()+":\n");
	}
	/**
	 * Generation d'une etiquette SIi, i:int
	 */
	public void si()
	{
		stackCond.push(nbCond++);		
	}
	/**
	 * Generation d'une etiquette FAIREi, i:int
	 */
	public void faire()
	{
		stackTantQue.push(nbIter++);
		progString.append( "FAIRE"+stackTantQue.peek()+":\n");
	}
	/**
	 * Generation d'une etiquette FAITi, i:int
	 */
	public void fait()
	{
		jumpIter();
		progString.append( "FAIT"+stackTantQue.pop()+":\n");		
	}
	/**
	 * Generation du code associe à l'operateur passe en parametre 
	 * en utilisant les appels aux fonctions de generations de l'interface
	 * @param op: Operateur
	 */
	public void operation(Operateur op) {
		switch (op)
		{
		case ADD:
			iadd();
			break;
		case SUB:
			isub();
			break;
		case MUL:
			imul();
			break;
		case DIV:
			idiv();	
			break;
		case INF:
			iinf();
			break;
		case SUP:
			isup();
			break;
		case INFE:
			iinfegal();
			break;
		case SUPE:
			isupegal();
			break;
		case EQU:
			iegal();
			break;
		case DIFF:
			idiff();
			break;
		case AND:
			iand();
			break;
		case OR:
			ior();
			break;
		case NEG:
			ineg();
			break;
		case NOT:
			inot();
			break;
		}
	}

	@Override
	public void closeFile() {
		out = Ecriture.ouvrir(nameFile);
		Ecriture.ecrireStringln(out, progString.toString());
		Ecriture.fermer(out);
	}

}
