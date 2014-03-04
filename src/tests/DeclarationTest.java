package tests;


import org.junit.Before;
import org.junit.Test;

import compilateur.Declaration;
import compilateur.IdConst;
import compilateur.IdVar;
import compilateur.TabIdent;
import compilateur.Type;
import exceptions.IdentAlreadyDeclaredException;

import junit.framework.TestCase;

public class DeclarationTest extends TestCase {

	Declaration decl;
	TabIdent tabIdent;
	
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		tabIdent = new TabIdent();
		decl = new Declaration(tabIdent);
	}

	@Test
	public void testAddConst() {
		try {
			decl.addConst("test", Type.ENT, 5);
		} catch (IdentAlreadyDeclaredException e) {
			assertTrue(false);
		}
		assertTrue(tabIdent.existeIdent("test"));
		assertEquals(new IdConst("test",Type.ENT,5), tabIdent.chercheIdent("test"));
		
		try {
			decl.addConst("test", Type.ENT, 8);
		} catch (IdentAlreadyDeclaredException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testAddConstIdent() {
		try {
			decl.addConst("aa", Type.ENT, 5);
		} catch (IdentAlreadyDeclaredException e) {
			assertTrue(false);
		}
		
		try {
			decl.addConstIdent("bb", "aa");
		} catch (IdentAlreadyDeclaredException e) {
			assertTrue(false);
		}
		assertTrue(tabIdent.existeIdent("aa"));
		assertTrue(tabIdent.existeIdent("bb"));
		assertEquals(new IdConst("aa",Type.ENT,5), tabIdent.chercheIdent("bb"));
		
		try {
			decl.addConst("bb", Type.ENT, 8);
		} catch (IdentAlreadyDeclaredException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testAddVar() {
		try {
			decl.addVar("test", Type.typeToInt(Type.ENT));
		} catch (IdentAlreadyDeclaredException e) {
			assertTrue(false);
		}
		assertTrue(tabIdent.existeIdent("test"));
		assertEquals(new IdVar("test",Type.ENT), tabIdent.chercheIdent("test"));
		try {
			decl.addVar("test", Type.typeToInt(Type.ENT));
		} catch (IdentAlreadyDeclaredException e) {
			assertTrue(true);
		}
	}

}
