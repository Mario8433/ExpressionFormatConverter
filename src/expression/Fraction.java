package expression;

public class Fraction extends Expression {
	
	private Expression numerator;
	private Expression denominator;
	
	public Fraction(Expression numerator, Expression denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public String toString() {
		return "(" + numerator.toString() + "/" + denominator.toString() + ")";
	}
}
