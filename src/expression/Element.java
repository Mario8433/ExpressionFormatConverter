package expression;

public class Element extends Expression {
	private String content;
	
	public Element(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return content;
	}
}
