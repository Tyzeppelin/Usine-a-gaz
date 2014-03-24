package compilateur;

import java.util.Stack;

import yaka.Yaka;
import exceptions.ErrTypeExprException;
import exceptions.ExpressionNotBooleanException;
import exceptions.IdentDoesNotExistException;

public class Expression {
	
	protected Type[][] typesOperateurs = {
		//   entier 	booleen
		{Type.ENT, Type.ERR, Type.ERR},		// +,-,*,/
		{Type.BOOL, Type.ERR, Type.ERR},	// <,>,<=,>=
		{Type.BOOL, Type.BOOL, Type.ERR},	// =, !=
		{Type.ERR, Type.BOOL, Type.ERR}		// et, ou
	};
		

	public Stack<Type> stackType;	// pile du type des op�randes lues
	protected Stack<Operateur> stackOp;	// pile des op�rateurs lus
	
	
	public Expression() {
		stackType = new Stack<Type>();
		stackOp = new Stack<Operateur>();
	}
	
	/**
	 * Test si l'expression est booléen
	 * @throws ExpressionNotBooleanException si l'expression n'est pas booléen
	 * @throws ErrTypeExprException
	 */
	public void testExpressionBoolean() throws ExpressionNotBooleanException, ErrTypeExprException
	{
		if (getTypeExpr() != Type.BOOL)
		{
			throw new ExpressionNotBooleanException();
		}
	}
	
	/**
	 * Retourne le type de la dernière expression évalué (doit être utilisé après l'appel de void verifType()
	 * @return le type de l'expression
	 * @throws ErrTypeExprException si le type de l'expression est Type.Err
	 */
	public Type getTypeExpr() throws ErrTypeExprException
	{
		if (stackType.peek()==Type.ERR)
			throw new ErrTypeExprException();
		return stackType.peek();
	}
	
	/**
	 * Retourne l'opérateur de l'expression courante
	 * @return
	 */
	public Operateur getOperateur()
	{
		return stackOp.peek();
	}
	/**
	 * Ajoute l'opérateur à la pile des opérateurs
	 * @param op
	 */
	public void ajouterOp (Operateur op) {
		stackOp.push(op);
	}
	
	/**
	 * Ajoute un type à la pile des types
	 * @param type
	 */
	public void ajouterType(Type type) {
		stackType.push(type);
	}
	
	/**
	 * Ajoute le type de l'identifiant "nom" à l'expression
	 * @param nom le nom de l'identifiant
	 * @throws IdentDoesNotExistException si l'identifiant n'existe pas
	 */
	public void ajouterIdent(String nom) throws IdentDoesNotExistException {
		try
		{
			Ident ident = Yaka.tabIdent.chercheIdentLocal(nom);
			stackType.push(ident.getType());
		}
		catch (IdentDoesNotExistException _)
		{
			try
			{		
				Ident ident = Yaka.tabIdent.chercheIdentGlobal(nom);
				stackType.push(ident.getType());
			}
			catch (IdentDoesNotExistException e)
			{
				stackType.push(Type.ERR);
				throw e;					
			}
		}
	}
	/**
	 * Ajoute le type de l'identifiant à l'expresion
	 * @param ident
	 * @throws IdentDoesNotExistException
	 */
	public void ajouterIdent(Ident ident) throws IdentDoesNotExistException
	{
		ajouterIdent(ident.getNom());
	}

	/**
	 * Procède à la vérification du type de l'expression courante.
	 */
	public void verifType()
	{
		Operateur op = stackOp.pop();
		Type t1 = stackType.pop();
		Type t2;
		
		switch (op) {
		case NEG:
			if (t1 == Type.ENT)
				stackType.push(Type.ENT);
			else
				stackType.push(Type.ERR);
			break;
			
		case NOT:
			if (t1 == Type.BOOL)
				stackType.push(Type.BOOL);
			else
				stackType.push(Type.ERR);
			break;
		case ADD:
		case MUL:
		case SUB:
		case DIV:
			t2 = stackType.pop();
			if (t1==t2)
			{
				stackType.push(typesOperateurs[0][t1.ordinal()]);
			}
			else
			{
				stackType.push(Type.ERR);
			}
			break;
		case INF:
		case INFE:
		case SUP:
		case SUPE:
			t2 = stackType.pop();
			if (t1==t2)
			{
				stackType.push(typesOperateurs[1][t1.ordinal()]);
			}
			else
			{
				stackType.push(Type.ERR);
			}
			break;
		case EQU:
		case DIFF:
			t2 = stackType.pop();
			if (t1==t2)
			{
				stackType.push(typesOperateurs[2][t1.ordinal()]);
			}
			else
			{
				stackType.push(Type.ERR);
			}
			break;
		case AND:
		case OR:
			t2 = stackType.pop();
			if (t1==t2)
			{
				stackType.push(typesOperateurs[3][t1.ordinal()]);
			}
			else
			{
				stackType.push(Type.ERR);
			}
			break;
		default:
				
		}
	}
	
	/**
	 * Enlève de la pile les types des paramètres de la fonction courante pour ne garder que le type de 
	 * la fonction courante en sommet de pile.
	 * @param fonc
	 * @throws IdentDoesNotExistException
	 */
	public void verifTypeFonc(String fonc) throws IdentDoesNotExistException
	{
		IdFonc idF = (IdFonc) Yaka.tabIdent.chercheIdentGlobal(fonc);
		for(int i=0;i<idF.getNbParam();i++)
			stackType.pop();
	}
	/**
	 * Efface la pile de type et d'opérateur
	 */
	public void clear()
	{
		stackType.clear();
		stackOp.clear();
	}	
}
