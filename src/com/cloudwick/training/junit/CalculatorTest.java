package com.cloudwick.training.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	private Calculator obj;
	@Before
	public void setUp() throws Exception {
		obj = new Calculator();
		
	}

	@After
	public void tearDown() throws Exception {
		obj = null;
	}

	@Test
	public void testCalculateNumberlessThan10() {
		int result = obj.calculate(5, 100);
		assertEquals(result, 105);
	}

	@Test
	public void testCalculateNumbergreaterThan10() {
		int result = obj.calculate(12, 100);
		assertEquals(result, 1200);
	}
	
	@Test
	public void testCalculateNumberelse() {
		int result = obj.calculate(101, 100);
		assertEquals(result, 1);
	}
}
