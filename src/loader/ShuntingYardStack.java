package loader;

import java.util.*;

import expression.*;

/**
 * It is defined that the precedence is the less prior it is. Such that ^ is 0, * is 1, + is 2.
 * The operands distinguish from each other only in precedence.
 * 
 * This class is designed based on 
 * 
 */
public class ShuntingYardStack {
	private LinkedList<Expression> output;
	private Stack<BinaryOperator> stack;
	
	
	public ShuntingYardStack() {
		output = new LinkedList<Expression>();
		stack = new Stack<BinaryOperator>();
	}
	
	public void processNewOperator(BinaryOperator newOperator) {
		BinaryOperator lastOperator;
		
		if (!stack.isEmpty()) {
			lastOperator = stack.peek();
		} else {
			stack.push(newOperator);
			return;
		}
		
		if (lastOperator.getPrecedence() >= newOperator.getPrecedence()) {
			stack.push(newOperator);
		} else {
			int size = stack.size();
			for (int i = 0; i < size; i++) {
				output.offer(stack.pop());
			}
			stack.push(newOperator);
		}
	}
	
	public void processNewOperand(Expression operand) {
		output.offer(operand);
	}
	
	public Expression evaluate() {
		Stack<Expression> evaluationStack = new Stack<>();
		BinaryOperator lastOperator;
		
		int size = stack.size(); 
		for (int i = 0; i < size; i++) {
			output.offer(stack.pop());
		}
	    
		Expression lastItem; 
		Expression first; 
		Expression second; 
	    while (!output.isEmpty()) {
	    	lastItem = output.poll();
	    	if (lastItem instanceof BinaryOperator) {
	    		lastOperator = (BinaryOperator)lastItem;
	    		if (lastOperator.isOperator()) {
	    			second = evaluationStack.pop();
	    			first = evaluationStack.pop();
	    			lastOperator.fill(first, second);
	    			evaluationStack.push(lastOperator);
	    			continue;
	    		}
	    	}
	    	
	    	evaluationStack.push(lastItem);
	    }
	    
	    return evaluationStack.pop();
	}
	
	@Override
	public String toString() {
		StringBuilder outputString = new StringBuilder();
		StringBuilder stackString = new StringBuilder();
		
		LinkedList<Expression> outputList = (LinkedList<Expression>) output.clone();
		Stack<Expression> stackList = (Stack<Expression>) stack.clone();
		
		int outputSize = output.size();
		for (int i = 0; i<outputSize; i++) {
			Expression item = outputList.poll();
			outputString.append(" " + item.toString());
			
		}
		
		int stackSize = stack.size();
		for (int i = 0; i<stackSize; i++) {
			Expression item = stackList.pop();
			stackString.append(" " + item.toString());
		}
		
		return "[ Shunting Yard Stack\nOperatorStack:"+stackString.toString()+"\nRPN stack:"+ outputString.toString() +"\n]";
		
	}
}
