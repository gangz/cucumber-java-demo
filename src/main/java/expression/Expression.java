package expression;

/**
 * Expression: 提供四则运算能力
 */
public interface Expression {

	/**
	 * 计算四则运算表达式的结果
	 * @param expression  四则运算表达式
	 * @return 计算结果
	 * @throws ExpressionError 运算错误
	 */
	Integer evaluate(String expression) throws ExpressionError;
}
