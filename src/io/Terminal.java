package io;

import loader.*;
import expression.*;

public class Terminal {
	public static void main(String[] args) {
		String input = args[0];
		LatexParser loader = new LatexParser();
		Expression result = loader.readString(input);
		System.out.println(result.toString());
	}
}
