package com.revature.service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.pojos.ErsReimbursement;
import com.revature.pojos.ErsUsers;

public class unitTest {
	static UserService u;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before class");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After class");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		u = new UserService();
		System.out.println("Setting up instance before test");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		u = new UserService();
		System.out.println("In tear down method");
	}
	
	@Test
	public void test1() {
		ErsUsers u1 = u.validateUser("sean", "password");
		assertEquals(u1 , u.validateUser("sean", "password"));
	}
	
		
	

	@Test
	public void test(){
		ErsUsers e = u.getByUsername("test");
		assertEquals(e, u.getByUsername("test"));
	}
}
