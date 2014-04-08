package tests;


import org.junit.Before;
import org.junit.Test;

import yaka.Yaka;

import compilateur.ControlTypeFonction;
import compilateur.Type;
import exceptions.IdentAlreadyDeclaredException;
import exceptions.IdentDoesNotExistException;

import junit.framework.TestCase;

public class ControlTypeFonctionTest extends TestCase {

	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void testInitTest() {
		ControlTypeFonction control = new ControlTypeFonction();
		try {
			control.initTest("test");
		} catch (IdentDoesNotExistException e) {
			assertTrue(true);
		} catch (IdentAlreadyDeclaredException e) {
			assertTrue(false);
		}
		
		try {
			Yaka.decl.addFonction("test2");
			Yaka.decl.addParam("param1", Type.ENT);
			Yaka.decl.addParam("param2", Type.BOOL);
			Yaka.decl.addParam("param3", Type.ENT);
			Yaka.decl.addParam("param4", Type.BOOL);
		} catch (IdentAlreadyDeclaredException e) {
			assertTrue(false);
		}
		
		try {
			control.initTest("test2");
		} catch (IdentDoesNotExistException e) {
			assertTrue(false);
		} catch (IdentAlreadyDeclaredException e) {
			assertTrue(false);
		}
		
		
	}

	@Test
	public void testTestTypeParam() {
		fail("Not yet implemented");
	}

	@Test
	public void testTestNbParam() {
		fail("Not yet implemented");
	}

}
