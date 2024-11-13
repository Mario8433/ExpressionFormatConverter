package expression;

public class Multiplication extends BinaryOperator{
	
	@Override
	protected void setPrecedence() {
		precedence = 1;
	}
	
	@Override
	public String toString() {
		if (asOperator) return "*";
		return "(" + first + "*" + second + ")";
	}
}
