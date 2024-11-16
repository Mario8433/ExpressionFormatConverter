package loader;

public class BracketReader {
	private char open;
	private char close;
	
	public BracketReader(char open, char close) {
		this.open = open;
		this.close = close;
	}
	
	public String readBrackets(String inputString) {
		int openCount = 1; // Assume this string excludes the first open bracket
		
		for (int i = 0; i<inputString.length(); i++) {
			char c = inputString.charAt(i);
			
			if (c == open) {
				openCount++;
			} else if (c == close) {
				openCount--;
			}
			
			if (openCount == 0) {
				return inputString.substring(0,i);
			}
		}
		
		return inputString;
	}
}
