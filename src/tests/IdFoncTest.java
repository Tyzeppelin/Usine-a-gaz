package tests;


import org.junit.Before;
import org.junit.Test;

import compilateur.IdFonc;
import compilateur.IdParam;
import compilateur.Type;

import junit.framework.TestCase;

public class IdFoncTest extends TestCase {

	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void testCanBeAffected() {
		IdFonc fonc = new IdFonc("test");
		assertFalse(fonc.canBeAffected());
	}

	@Test
	public void testSetOffsetParams() {
		IdFonc fonc = new IdFonc("test");
		fonc.addParam(new IdParam("param1",Type.ENT));
		fonc.addParam(new IdParam("param2",Type.ENT));
		fonc.addParam(new IdParam("param3",Type.ENT));
		
		fonc.setOffsetParams();
		
		assertEquals(8, fonc.getParam(0).getValeur());
		assertEquals(6, fonc.getParam(1).getValeur());
		assertEquals(4, fonc.getParam(2).getValeur());
		

		fonc.addParam(new IdParam("param4",Type.ENT));

		fonc.setOffsetParams();

		assertEquals(10, fonc.getParam(0).getValeur());
		assertEquals(8, fonc.getParam(1).getValeur());
		assertEquals(6, fonc.getParam(2).getValeur());
		assertEquals(4, fonc.getParam(3).getValeur());
		
	}

}
