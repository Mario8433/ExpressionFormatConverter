package loader;

import expression.*;

public class LatexParser {
	public Expression readString(String inputString) {
		ShuntingYardStack binaryStack = new ShuntingYardStack();
		
		
		for (int i = 0; i<inputString.length(); i++)	{
			char c = inputString.charAt(i);
			
			if (c == '\\') {
				String text = inputString.substring(i+1);
				String macro = readMacro(text);
				i = i + macro.length();
				
				switch(macro) {
					case "frac":
						BracketReader br = new BracketReader('{','}');
						String numeratorString = br.parseString(inputString.substring(i+2));
						i = i + 2 + numeratorString.length();
						Expression numerator = readString(numeratorString);
						
						String denominatorString = br.parseString(inputString.substring(i+2));
						i = i + 2 + denominatorString.length();
						Expression denominator = readString(denominatorString);
						
						binaryStack.processNewOperand(new Fraction(numerator, denominator));
						continue;
						
					case "cdot":
						binaryStack.processNewOperator(new Multiplication());
						continue;
					
					case "times":
						binaryStack.processNewOperator(new Multiplication());
						continue;
						
				}
			}
			
			if (c == '+') {
				binaryStack.processNewOperator(new Addition());
				continue;
			}
			
			if (c == '-') {
				binaryStack.processNewOperator(new Subtraction());
				continue;
			}
			
			if (Character.isDigit(c)) {
				String number = readNumber(inputString.substring(i));
				i = i + number.length()-1;
				binaryStack.processNewOperand(new Element(number));
			}
		}
		
		Expression result = binaryStack.evaluate();
		return result;
	}
	
	public String readMacro(String inputString) {
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i<inputString.length();i++) {
			char c = inputString.charAt(i);
			if (Character.isLetter(c)) {
				result.append(c);
			} else {
				break;
			}
		}
		
		return result.toString();
	}
	
	public String readNumber(String inputString) {
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i<inputString.length();i++) {
			char c = inputString.charAt(i);
			if (Character.isDigit(c)) {
				result.append(c);
			} else {
				break;
			}
		}
		
		return result.toString();
	}
	
	public static void main(String[] args) {
		;
	}
}
	
	
