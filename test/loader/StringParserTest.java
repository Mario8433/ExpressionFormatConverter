package loader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import expression.*;

class StringParserTest {
	String input;
	StringParser parser = new StringParser();
	Expression result;
	Fraction goal;

	@Test
	void testSimpleFraction1() {
		input = "\\frac{1}{2}";
		result = parser.readString(input);
		Fraction goal = new Fraction(new Element("1"), new Element("2"));
		assertEquals(goal.toString(),result.toString());
	}
	
	@Test
	void testCompoundFraction2() {
		input = "\\frac{\\frac{1}{27}}{2}";
		result = parser.readString(input);
		Fraction goal = new Fraction(new Fraction(new Element("1"),new Element("27")), new Element("2"));
		assertEquals(goal.toString(),result.toString());
		assertEquals("((1/27)/2)",result.toString());
	}

	
	@Test
	void testSYalgorithm1() {
		input = "1+2\\cdot3-5";
		result = parser.readString(input);
		assertEquals("((1+(2*3))-5)",result.toString());
	}
	
	@Test
	void testParenthesis1() {
		input = "(1+2)*3*[1+2]";
		result = parser.readString(input);
		assertEquals("((1+2)*(3*(1+2)))",result.toString());
	}
}
