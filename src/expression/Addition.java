package expression;

public class Addition extends BinaryOperator{
	
	public Addition() {
		super();
	}
	
	public Addition(Expression first, Expression second) {
		super(first,second);
	}
	
	@Override
	protected void setPrecedence() {
		precedence = 2;
	}
	
	@Override
	protected void setSymbol() {
		symbol = "+";
	}
}
