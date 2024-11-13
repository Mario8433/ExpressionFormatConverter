package expression;

public abstract class BinaryOperator extends Expression {
	protected Expression first;
	protected Expression second;
	protected int precedence;
	
	protected boolean asOperator;
	
	public BinaryOperator() {
		first = null;
		second = null;
		setPrecedence();
		asOperator = true;
	}
	
	public BinaryOperator(Expression first, Expression second) {
		this.first = first;
		this.second = second;
		setPrecedence();
		asOperator = false;
	}
	
	public void fill(Expression first, Expression second) {
		this.first = first;
		this.second = second;
		asOperator = false;
	}
	
	public boolean isOperator() {
		return asOperator;
	}
	
	public int getPrecedence() {
		return precedence;
	}
	
	protected abstract void setPrecedence();	
	
	@Override
	public abstract String toString();
}
