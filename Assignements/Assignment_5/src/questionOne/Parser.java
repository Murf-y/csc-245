/* ****************************************************
 *
 * Author: Charbel Fayad
 * Id: 202102394
 *
 * Date: Mar 27, 2022
 * LastModified: Mar 27, 2022
 * FileName: Parser.java
 *****************************************************
 */
package questionOne;

public class Parser {

	public static boolean isBalanced(String expression) {
		Stack<String> stack = new Stack<>();
		String openings = "([{";
		String closing = ")]}";
		for (int i = 0; i < expression.length(); i++) {
			String c = String.valueOf(expression.charAt(i));

			// Ingore spaces and non pranthesis characters
			if (c.equals("") || !(openings.contains(c) || closing.contains(c)))
				continue;
			if (openings.contains(c)) {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				if (c.equals(")") && !stack.pop().equals("(")) {
					return false;
				} else if (c.equals("]") && !stack.pop().equals("[")) {
					return false;
				} else if (c.equals("}") && !stack.pop().equals("{")) {
					return false;
				}
			}
		}
		return stack.isEmpty();

	}
	public static boolean isMathExpression(String expression) {
		String operators ="+-/%(){}[]";
		for(int i = 0 ; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			String c = String.valueOf(ch);
			if(!operators.contains(c) && (ch < 48 || ch > 57)) {
				return false;
			}
		}
		return true;
	}
	public static boolean isDigit(String c) {
		try {
			Integer.parseInt(c);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static int parseFullyParenthesized(String expression) throws IllegalArgumentException {
		expression = removeSpaces(expression);
		
		
		// Throws IllegalArgumentException if the expression if not a fully
		// parenthesized expression
		if (!isBalanced(expression) 
				|| !isMathExpression(expression)
				|| expression.charAt(expression.length() - 1) != ')'
				|| expression.charAt(0) != '(') {
			throw new IllegalArgumentException("Expression is not valid!");
		}

		Stack<String> stack = new Stack<>();
		String operators = "+*/-%";
		// Base case : (a + b) => only two operand , i.e number of opening paranthesize
		// = 1
		if (!expression.substring(1).contains("(")) {
			// length - 1 because we dont need the last paranthesise
			for (int i = 1; i < expression.length() - 1; i++) {
				String c = String.valueOf(expression.charAt(i));

				// If it is blank ignore
				if (c.isBlank())
					continue;

				// If it is an operator, push it directly
				if (operators.contains(c))
					stack.push(c);

				else {
					// Get the whole number not only one digit
					String res = "";
					while (i < expression.length() - 1 && isDigit(c)) {
						res += c;
						i++;
						c = String.valueOf(expression.charAt(i));
					}
					stack.push(res);
					i--;
				}
			}
		}
		// Recursive step
		else {
			for (int i = 1; i < expression.length() - 1; i++) {
				String c = String.valueOf(expression.charAt(i));
				// Ignore white spaces
				if (c.isBlank())
					continue;

				// It is an operator, push it
				if (operators.contains(c))
					stack.push(c);

				// It is an expression, evaluate it then push it
				else if (c.equals("(")) {
					int count = 0;
					String res = "";
					do {
						String chr = String.valueOf(expression.charAt(i));
						res += chr;
						i++;
						if (chr.equals("("))
							count++;
						else if (chr.equals(")"))
							count--;
					} while (count != 0 && i < expression.length() - 1);
					i--;
					int value = parseFullyParenthesized(res);
					stack.push(value + "");
				}
				// It is a number
				else {

					String res = "";
					while (i < expression.length() - 1 && isDigit(c)) {
						res += c;
						i++;
						c = String.valueOf(expression.charAt(i));
					}
					stack.push(res);
					i--;
				}
			}
		}
		// Calculate the result

		int right = 0;
		int left = 0;
		String operator = "+";
		if (!stack.isEmpty()) {
			right = Integer.parseInt(stack.pop());
		}
		if (!stack.isEmpty()) {
			operator = stack.pop();
		}
		if (!stack.isEmpty()) {
			left = Integer.parseInt(stack.pop());
		}
		return calculateSimpleExpression(left,operator,right);
	}
	
	public static int calculateSimpleExpression(int left, String operator, int right) {
		int result = 0;
		switch (operator) {
		case "+": {
			result = left + right;
			break;
		}
		case "-": {
			result = left - right;
			break;
		}
		case "*": {
			result = left * right;
			break;
		}
		case "/": {
			result = left / right;
			break;
		}
		case "%": {
			result = left % right;
			break;
		}
		}
		return result;
	}
	public static String removeSpaces(String exp) {
		if (exp.length() < 1)
			return exp;
		else {
			if (exp.charAt(0) == ' ') {
				return removeSpaces(exp.substring(1));
			} else {
				return String.valueOf(exp.charAt(0)) + removeSpaces(exp.substring(1));
			}
		}
	}
}
