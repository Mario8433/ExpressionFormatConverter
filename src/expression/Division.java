package expression;

public class Division extends BinaryOperator {

	public Division() {
		super();
	}
	
	public Division(Expression numerator, Expression denominator) {
		super(numerator,denominator);
	}

	@Override
	protected void setPrecedence() {
		precedence = 1;
	}
	
	@Override
	protected void setSymbol() {
		symbol = "/";
	}
}

