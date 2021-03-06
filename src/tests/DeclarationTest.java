package tests;


import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import yaka.Yaka;
import compilateur.IdConst;
import compilateur.IdFonc;
import compilateur.IdVar;
import compilateur.Type;
import exceptions.IdentAlreadyDeclaredException;
import exceptions.IdentDoesNotExistException;

public class DeclarationTest extends TestCase {

	
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		Yaka.tabIdent.clear();
	}

	@Test
	public void testAddConst() {
		try {
			Yaka.decl.addConst("test", Type.ENT, 5);
		} catch (IdentAlreadyDeclaredException e) {
			assertTrue(false);
		}
		assertTrue(Yaka.tabIdent.existeIdentLocal("test"));
		
		
		try {
			assertEquals(new IdConst("test",Type.ENT,5), Yaka.tabIdent.chercheIdent("test"));
		} catch (IdentDoesNotExistException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			Yaka.decl.addConst("test", Type.ENT, 8);
		} catch (IdentAlreadyDeclaredException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testAddConstIdent() {
		try {
			Yaka.decl.addConst("aa", Type.ENT, 5);
		} catch (IdentAlreadyDeclaredException e) {
			assertTrue(false);
		}
		
		try {
			Yaka.decl.addConstIdent("bb", "aa");
		} catch (IdentAlreadyDeclaredException e) {
			assertTrue(false);
		} catch (IdentDoesNotExistException e) {
			assertTrue(false);
		}
		assertTrue(Yaka.tabIdent.existeIdentLocal("aa"));
		assertTrue(Yaka.tabIdent.existeIdentLocal("bb"));
		try {
			assertEquals(new IdConst("aa",Type.ENT,5), Yaka.tabIdent.chercheIdent("bb"));
		} catch (IdentDoesNotExistException e1) {
			assertTrue(false);
		}
		
		try {
			Yaka.decl.addConst("bb", Type.ENT, 8);
		} catch (IdentAlreadyDeclaredException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testAddVar() {
		try {
			Yaka.decl.addVar("test", Type.typeToInt(Type.ENT));
		} catch (IdentAlreadyDeclaredException e) {
			assertTrue(false);
		}
		assertTrue(Yaka.tabIdent.existeIdentLocal("test"));
		
		try {
			assertEquals(new IdVar("test",Type.ENT,-2), Yaka.tabIdent.chercheIdent("test"));
		} catch (IdentDoesNotExistException e1) {
			assertTrue(false);
		}
		
		try {
			Yaka.decl.addVar("test", Type.typeToInt(Type.ENT));
		} catch (IdentAlreadyDeclaredException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testAddFonction()
	{
		try {
			Yaka.decl.addFonction("test", Type.ENT);
		} catch (IdentAlreadyDeclaredException e) {
			assertTrue(false);
		}
		assertTrue(Yaka.tabIdent.existeIdentGlobal("test"));
		
		try {
			assertEquals(new IdFonc("test",Type.ENT), Yaka.tabIdent.chercheIdent("test"));
			assertEquals(new IdFonc("test",Type.ENT), Yaka.tabIdent.chercheIdentGlobal("test"));
		} catch (IdentDoesNotExistException e1) {
			assertTrue(false);
		}
		
		try {
			Yaka.decl.addFonction("test", Type.ENT);
		} catch (IdentAlreadyDeclaredException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testCurrentFonc()
	{
		try {
			Yaka.decl.addFonction("test", Type.ENT);
		} catch (IdentAlreadyDeclaredException e) {
			assertTrue(false);
		}
		
		assertEquals(new IdFonc("test",Type.ENT), Yaka.decl.getCurrentFonc());
		
		try {
			Yaka.decl.addFonction("test2", Type.ENT);
		} catch (IdentAlreadyDeclaredException e) {
			assertTrue(false);
		}
		
		assertEquals(new IdFonc("test2",Type.ENT), Yaka.decl.getCurrentFonc());
	}
	
	@Test
	public void testAddParam()
	{
		try {
			Yaka.decl.addFonction("test", Type.ENT);
		} catch (IdentAlreadyDeclaredException e) {
			assertTrue(false);
		}
		
		try {
			Yaka.decl.addParam("testParam", Type.ENT);
		} catch (IdentAlreadyDeclaredException e) {
			assertTrue(false);
		}
		
		try {
			Yaka.decl.addParam("testParam", Type.ENT);
		} catch (IdentAlreadyDeclaredException e) {
			assertTrue(true);
		}
	}
	

}
