package tests;


import org.junit.Before;
import org.junit.Test;

import compilateur.*;
import exceptions.*;

import junit.framework.TestCase;

public class ExpressionTest extends TestCase {
	
	Expression expr;
	TabIdent tabIdent;

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		tabIdent = new TabIdent();
		expr = new Expression(tabIdent);
	}

	@Test
	public void testGetTypeExpr() {
		expr.ajouterType(Type.ENT);
		Type type = null;
		try {
			type = expr.getTypeExpr();
		} catch (ErrTypeExprException e) {
			assertTrue(false);
		}
		
		assertEquals(Type.ENT, type);
	}

	@Test
	public void testAjouterIdentString() {
		try {
			expr.ajouterIdent("test");
		} catch (IdentDoesNotExistException e) {
			assertTrue(true);
		}
		
		tabIdent.rangeIdent("test", new IdConst("test"));
		
		try {
			expr.ajouterIdent("test");
		} catch (IdentDoesNotExistException e) {
			assertTrue(false);
		}
	}

	@Test
	public void testAjouterIdentIdent() {
		Ident id = new IdVar("test",Type.ENT);
		try {
			expr.ajouterIdent(id);
		} catch (IdentDoesNotExistException e) {
			assertTrue(true);
		}
		
		tabIdent.rangeIdent("test", id);
		
		try {
			expr.ajouterIdent(id);
		} catch (IdentDoesNotExistException e) {
			assertTrue(false);
		}
		
	}

	@Test
	public void testVerifType() {
		fail("Not yet implemented");
	}

}
