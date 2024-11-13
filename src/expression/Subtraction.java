package expression;

public class Subtraction extends BinaryOperator{
	
	@Override
	protected void setPrecedence() {
		precedence = 2;
	}
	
	@Override
	public String toString() {
		if (asOperator) return "-";
		return "(" + first + "-" + second + ")";
	}
}
