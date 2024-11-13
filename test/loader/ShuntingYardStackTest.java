package loader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import expression.*;

class ShuntingYardStackTest {
	ShuntingYardStack stack = new ShuntingYardStack();
	Expression result;
	String goal;

	@Test
	void testSimpleAddition1() {
		Expression element1 = new Element("13");
		BinaryOperator addition1 = new Addition();
		Expression element2 = new Element("12");
		goal = "(13+12)";
		stack.processNewOperand(element1);
		stack.processNewOperator(addition1);
		stack.processNewOperand(element2);
		result = stack.evaluate();
		
		
		assertEquals(goal,result.toString());
	}
	
	@Test
	void testSimpleAddition2() {
		Expression element1 = new Element("13");
		BinaryOperator addition1 = new Addition();
		Expression element2 = new Element("12");
		BinaryOperator addition2 = new Addition();
		Expression element3 = new Element("14");
		goal = "(13+(12+14))";
		stack.processNewOperand(element1);
		stack.processNewOperator(addition1);
		stack.processNewOperand(element2);
		stack.processNewOperator(addition2);
		stack.processNewOperand(element3);
		result = stack.evaluate();
		
		
		assertEquals(goal,result.toString());
	}
	
	@Test
	void testComposite1() {
		Expression element1 = new Element("13");
		BinaryOperator addition1 = new Addition();
		Expression element2 = new Element("12");
		BinaryOperator multiplication1 = new Multiplication();
		Expression element3 = new Element("14");
		goal = "(13+(12*14))";
		stack.processNewOperand(element1);
		stack.processNewOperator(addition1);
		stack.processNewOperand(element2);
		stack.processNewOperator(multiplication1);
		stack.processNewOperand(element3);
		result = stack.evaluate();
		
		
		assertEquals(goal,result.toString());
	}
	
	@Test
	void testComposite2() {
		Expression element1 = new Element("13");
		BinaryOperator multiplication1 = new Multiplication();
		Expression element2 = new Element("12");
		BinaryOperator addition1 = new Addition();
		Expression element3 = new Element("14");
		goal = "((13*12)+14)";
		stack.processNewOperand(element1);
		stack.processNewOperator(multiplication1);
		stack.processNewOperand(element2);
		stack.processNewOperator(addition1);
		stack.processNewOperand(element3);
		result = stack.evaluate();
		
		
		assertEquals(goal,result.toString());
	}
	
	@Test
	void testComposite3() {
		Expression element1 = new Element("13");
		BinaryOperator subtraction1 = new Subtraction();
		Expression element2 = new Element("12");
		BinaryOperator multiplication1 = new Multiplication();
		Expression element3 = new Element("14");
		BinaryOperator subtraction2 = new Subtraction();
		Expression element4 = new Element("16");
		goal = "((13-(12*14))-16)";
		stack.processNewOperand(element1);
		stack.processNewOperator(subtraction1);
		stack.processNewOperand(element2);
		stack.processNewOperator(multiplication1);
		stack.processNewOperand(element3);
		stack.processNewOperator(subtraction2);
		stack.processNewOperand(element4);
		result = stack.evaluate();
		
		
		assertEquals(goal,result.toString());
	}
	
	@Test
	void testComposite4() {
		Expression e1 = new Element("13");
		BinaryOperator m1 = new Multiplication();
		Expression e2 = new Element("12");
		BinaryOperator s1 = new Subtraction();
		Expression e3 = new Element("14");
		BinaryOperator m2 = new Multiplication();
		Expression e4 = new Element("16");
		goal = "((13*12)-(14*16))";
		stack.processNewOperand(e1);
		stack.processNewOperator(m1);
		stack.processNewOperand(e2);
		stack.processNewOperator(s1);
		stack.processNewOperand(e3);
		stack.processNewOperator(m2);
		stack.processNewOperand(e4);
		result = stack.evaluate();
		
		
		assertEquals(goal,result.toString());
	}
	
	@Test
	void testComposite5() {
		goal = "((1+(2*3))-5)";
		stack.processNewOperand(new Element("1"));
		stack.processNewOperator(new Addition());
		stack.processNewOperand(new Element("2"));
		stack.processNewOperator(new Multiplication());
		stack.processNewOperand(new Element("3"));
		stack.processNewOperator(new Subtraction());
		stack.processNewOperand(new Element("5"));
		result = stack.evaluate();
		
		
		assertEquals(goal,result.toString());
	}
	
	@Test
	void singletTest() {
		stack.processNewOperand(new Element("x"));
		result = stack.evaluate();
		
		assertEquals("x",result.toString());
	}

}
