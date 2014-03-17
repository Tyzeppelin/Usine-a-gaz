package compilateur;

import java.util.Stack;

import exceptions.ErrTypeExprException;
import exceptions.IdentDoesNotExistException;

public class Expression {
	
	protected Type[][] typesOperateurs = {
		//   entier 	booleen
		{Type.ENT, Type.ERR, Type.ERR},	// +,-,*,/
		{Type.BOOL, Type.ERR, Type.ERR},	// <,>,<=,>=
		{Type.BOOL, Type.BOOL, Type.ERR},	// =, !=
		{Type.ERR, Type.BOOL, Type.ERR}	// et, ou
	};
		

	public Stack<Type> stackType;	// pile du type des op�randes lues
	protected Stack<Operateur> stackOp;	// pile des op�rateurs lus
	
	// Table des identifiants
	protected TabIdent tabIdent;
	
	public Expression(TabIdent tab) {
		stackType = new Stack<Type>();
		stackOp = new Stack<Operateur>();
		tabIdent = tab;
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
	
	public void ajouterOp (Operateur op) {
		stackOp.push(op);
	}
	
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
			Ident ident = tabIdent.chercheIdent(nom);
			stackType.push(ident.getType());
		}
		catch (IdentDoesNotExistException e)
		{
			stackType.push(Type.ERR);
			throw e;			
		}
	}
	
	public void ajouterIdent(Ident id) throws IdentDoesNotExistException
	{
		try
		{
			tabIdent.chercheIdent(id.getNom());
			stackType.push(id.getType());
		}
		catch (IdentDoesNotExistException e)
		{
			stackType.push(Type.ERR);
			throw e;			
		}		
	}

	/**
	 * Procède à la vérification du type de l'expression courante.
	 */
	public void verifType()
	{
		while (!stackOp.isEmpty())
		{
			testFirstExpression();
		}
	}
	
	/**
	 * Procède à la vérification du type de la 1er opération de l'expression
	 */
	private void testFirstExpression() {
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
	
	public void clear()
	{
		stackType.clear();
		stackOp.clear();
	}
	
}
