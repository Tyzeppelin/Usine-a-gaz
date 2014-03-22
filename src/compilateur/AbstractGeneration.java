package compilateur;

import java.io.OutputStream;
import java.util.Stack;
/**
 * 
 * Classe abstraite qui implemente l'interface Generation <br>
 * Permet de ne pas redéfinir deux fois les memes methodes.
 * 
 * @author Francois Boschet
 *
 */


public abstract class AbstractGeneration implements Generation {

	protected OutputStream out;
	
	protected Stack<Integer> stackTantQue; 
	protected Stack<Integer> stackCond; 
	

	protected AbstractGeneration()
	{
		out = System.out;
		stackTantQue = new Stack<Integer>();
		stackTantQue.push(0);
		stackCond = new Stack<Integer>();
		stackCond.push(0);
	}
	protected AbstractGeneration(String nameFile)
	{
		out = Ecriture.ouvrir(nameFile);
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
		Ecriture.ecrireString(out, "SINON"+stackCond.peek()+":\n");		
	}
	/** 
	 * Generation d'un etiquette FSIi, i:int
	 */
	public void fsi()
	{
		Ecriture.ecrireString(out, "FSI"+stackCond.pop()+":\n");
	}
	/**
	 * Generation d'une etiquette SIi, i:int
	 */
	public void si()
	{
		stackCond.push(1);		
	}
	/**
	 * Generation d'une etiquette FAIREi, i:int
	 */
	public void faire()
	{
		stackTantQue.push(stackTantQue.peek()+1);
		Ecriture.ecrireString(out, "FAIRE"+stackTantQue.peek()+":\n");
	}
	/**
	 * Generation d'une etiquette FAITi, i:int
	 */
	public void fait()
	{
		jumpIter();
		Ecriture.ecrireString(out, "FAIT"+stackTantQue.pop()+":\n");		
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
		Ecriture.fermer(out);
	}

}
