package expression;

public abstract class BinaryOperator extends Expression {
	protected Expression first;
	protected Expression second;
	protected String symbol;
	
	protected int precedence;
	
	public BinaryOperator() {
		first = null;
		second = null;
		setPrecedence();
		setSymbol();
	}
	
	public BinaryOperator(Expression first, Expression second) {
		this.first = first;
		this.second = second;
		setPrecedence();
		setSymbol();
	}
	
	public void fill(Expression first, Expression second) {
		this.first = first;
		this.second = second;
	}
	
	public boolean isOperator() {
		return first == null && second == null;
	}
	
	public int getPrecedence() {
		return precedence;
	}
	
	@Override
	public String toString() {
		if (isOperator()) return symbol;
		return "(" + first + symbol + second + ")";
	}
	
	protected abstract void setPrecedence();	
	protected abstract void setSymbol();
	
}
