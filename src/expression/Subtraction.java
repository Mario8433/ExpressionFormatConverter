package expression;

public class Subtraction extends BinaryOperator{
	
	public Subtraction() {
		super();
	}
	
	public Subtraction(Expression first, Expression second) {
		super(first,second);
	}
	
	@Override
	protected void setPrecedence() {
		precedence = 2;
	}
	
	@Override
	protected void setSymbol() {
		symbol = "-";
	}
}
