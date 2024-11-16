package io;

import loader.*;
import expression.*;

public class Terminal {
	public static void main(String[] args) {
		String input = args[0];
		StringParser loader = new StringParser();
		Expression result = loader.readString(input);
		System.out.println(result.toString());
	}
}
