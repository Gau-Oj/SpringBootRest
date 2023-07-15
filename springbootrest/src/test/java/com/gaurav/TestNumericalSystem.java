package com.gaurav;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestNumericalSystem {
	NumericalSystem ns=new NumericalSystem();
	Number obj;
	Number obj1;
	@Test
	void test1() {
		obj=new Number("Indian","-1");
		obj1=new Number("Indian","wrong input");
		assertEquals(obj1.getNo(),ns.getValue(obj).getNo());
	}
	@Test
	void test2() {
		obj=new Number("Indian","one");
		obj1=new Number("Indian","wrong input");
		assertEquals(obj1.getNo(),ns.getValue(obj).getNo());
	}
	@Test
	void test3() {
		obj=new Number("Indian","000");
		obj1=new Number("Indian","zero");
		assertEquals(obj1.getNo(),ns.getValue(obj).getNo());
	}
	@Test
	void test4() {
		obj=new Number("Indian","001");
		obj1=new Number("Indian","one ");
		assertEquals(obj1.getNo(),ns.getValue(obj).getNo());
	}
	@Test
	void test5() {
		obj=new Number("Indian","1.2");
		obj1=new Number("Indian","wrong input");
		assertEquals(obj1.getNo(),ns.getValue(obj).getNo());
	}
	@Test
	void test6() {
		obj=new Number("Indian","987693");
		obj1=new Number("Indian","nine lakh eighty seven thousand six hundred and ninety three ");
		assertEquals(obj1.getNo(),ns.getValue(obj).getNo());
	}
	
	@Test
	void test7() {
		obj=new Number("International","-1");
		obj1=new Number("International","wrong input");
		assertEquals(obj1.getNo(),ns.getValue(obj).getNo());
	}
	@Test
	void test8() {
		obj=new Number("International","one");
		obj1=new Number("International","wrong input");
		assertEquals(obj1.getNo(),ns.getValue(obj).getNo());
	}
	@Test
	void test9() {
		obj=new Number("International","000");
		obj1=new Number("International","zero");
		assertEquals(obj1.getNo(),ns.getValue(obj).getNo());
	}
	@Test
	void test10() {
		obj=new Number("International","001");
		obj1=new Number("International","one ");
		assertEquals(obj1.getNo(),ns.getValue(obj).getNo());
	}
	@Test
	void test11() {
		obj=new Number("International","1.2");
		obj1=new Number("International","wrong input");
		assertEquals(obj1.getNo(),ns.getValue(obj).getNo());
	}
	@Test
	void test12() {
		obj=new Number("International","987693");
		obj1=new Number("International","nine hundred eighty seven thousand six hundred ninety three ");
		assertEquals(obj1.getNo(),ns.getValue(obj).getNo());
	}
}
