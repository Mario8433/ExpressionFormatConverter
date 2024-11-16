package loader;

import expression.*;

public class StringParser {
	public Expression readString(String inputString) {
		ShuntingYardStack binaryStack = new ShuntingYardStack();
		
		
		for (int i = 0; i<inputString.length(); i++)	{
			char c = inputString.charAt(i);
			
			if (c == '\\') {
				String text = inputString.substring(i+1);
				String macro = readWord(text);
				i = i + macro.length();
				
				switch(macro) {
					case "frac":
						BracketReader br = new BracketReader('{','}');
						String numeratorString = br.readBrackets(inputString.substring(i+2));
						i = i + 2 + numeratorString.length();
						Expression numerator = readString(numeratorString);
						
						String denominatorString = br.readBrackets(inputString.substring(i+2));
						i = i + 2 + denominatorString.length();
						Expression denominator = readString(denominatorString);
						
						binaryStack.processNewOperand(new Division(numerator,denominator));
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
			
			if (c == '*') {
				binaryStack.processNewOperator(new Multiplication());
				continue;
			}
			
			if (c == '/') {
				binaryStack.processNewOperator(new Division());
				continue;
			}
			
			if (c == '(' || c == '[' || c == '{') {
				BracketReader br = new BracketReader('(',')');
				switch (c) {
					case '[':
						br = new BracketReader('[',']');
						break;
					case '{':
						br = new BracketReader('{','}');
						break;
				}
				String contentString = br.readBrackets(inputString.substring(i+1));
				i = i + contentString.length() + 1;
				Expression content = readString(contentString);
				binaryStack.processNewOperand(content);
				continue;
			}
			
			if (Character.isLetter(c)) {
				String word = readWord(inputString.substring(i));
				
				switch (word) {
					case "sin":
				}
			}
			
			if (Character.isDigit(c)) {
				String number = readNumber(inputString.substring(i));
				i = i + number.length() - 1;
				binaryStack.processNewOperand(new Element(number));
			}
		}
		
		Expression result = binaryStack.evaluate();
		return result;
	}
	
	public String readWord(String inputString) {
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
	
	
