package expression;

public class Multiplication extends BinaryOperator{
	
	public Multiplication() {
		super();
	}
	
	public Multiplication(Expression first, Expression second) {
		super(first,second);
	}
	
	@Override
	protected void setPrecedence() {
		precedence = 1;
	}
	
	@Override
	protected void setSymbol() {
		symbol = "*";
	}
}
