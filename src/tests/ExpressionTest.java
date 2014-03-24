package tests;


import org.junit.Before;
import org.junit.Test;

import yaka.Yaka;

import compilateur.*;
import exceptions.*;

import junit.framework.TestCase;

public class ExpressionTest extends TestCase {
	
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		Yaka.expr.clear();
		Yaka.tabIdent.clearLocaux();
	}

	@Test
	public void testGetTypeExpr() {
		Yaka.expr.ajouterType(Type.ENT);
		Type type = null;
		try {
			type = Yaka.expr.getTypeExpr();
		} catch (ErrTypeExprException e) {
			assertTrue(false);
		}
		
		assertEquals(Type.ENT, type);
	}

	@Test
	public void testAjouterIdentString() {
		try {
			Yaka.expr.ajouterIdent("test");
		} catch (IdentDoesNotExistException e) {
			assertTrue(true);
		}
		
		Yaka.tabIdent.rangeIdentLocal("test", new IdConst("test"));
		
		try {
			Yaka.expr.ajouterIdent("test");
		} catch (IdentDoesNotExistException e) {
			assertTrue(false);
		}
	}

	@Test
	public void testAjouterIdentIdent() {
		Ident id = new IdVar("test",Type.ENT);
		try {
			Yaka.expr.ajouterIdent(id);
		} catch (IdentDoesNotExistException e) {
			assertTrue(true);
		}
		
		Yaka.tabIdent.rangeIdentLocal("test", id);
		
		try {
			Yaka.expr.ajouterIdent(id);
		} catch (IdentDoesNotExistException e) {
			assertTrue(false);
		}
		
	}
}
