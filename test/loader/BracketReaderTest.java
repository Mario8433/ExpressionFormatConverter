package loader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BracketReaderTest {
	String input;

	@Test
	void testBracket1() {
		BracketReader obj1 = new BracketReader('(',')');
		
		input = "www()+()+()+)w(w)(1212)";
		assertEquals("www()+()+()+",obj1.readBrackets(input));
	}
	
	@Test
	void testBracket2() {
		BracketReader obj1 = new BracketReader('(',')');
		
		input = "((()(()))(()(()))))(()()(()))";
		assertEquals("((()(()))(()(())))",obj1.readBrackets(input));
	}
	
	@Test
	void testBracket3() {
		BracketReader obj1 = new BracketReader('(',')');
		
		input = ")))))))))))))";
		assertEquals("",obj1.readBrackets(input));
	}


}
