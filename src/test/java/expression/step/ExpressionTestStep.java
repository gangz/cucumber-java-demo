package expression.step;

import static org.junit.Assert.assertEquals;

import expression.Expression;
import expression.StackExpression;
import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.那么;

public class ExpressionTestStep {
	private String expression;
	@假如("^表达式是'(.*)'$")
	public void toBeEvaluatedIs(String expression) throws Throwable {
	   this.expression = expression;
	}

	@那么("^结果应该是'(.*)'$")
	public void resultIs(int result) throws Throwable {
	    Expression e = new StackExpression();
	    assertEquals(new Integer(result),e.evaluate(expression));
	}

}
