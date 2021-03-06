/*
 * Copyright 2005-2013 Axel Kramer (axelclk@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.matheclipse.parser.client;

import java.util.ArrayList;
import java.util.List;

import org.matheclipse.parser.client.ast.ASTNode;
import org.matheclipse.parser.client.ast.FunctionNode;
import org.matheclipse.parser.client.ast.IConstantOperators;
import org.matheclipse.parser.client.ast.IParserFactory;
import org.matheclipse.parser.client.ast.IntegerNode;
import org.matheclipse.parser.client.ast.NumberNode;
import org.matheclipse.parser.client.ast.SymbolNode;
import org.matheclipse.parser.client.operator.ASTNodeFactory;
import org.matheclipse.parser.client.operator.InfixOperator;
import org.matheclipse.parser.client.operator.Operator;
import org.matheclipse.parser.client.operator.PostfixOperator;
import org.matheclipse.parser.client.operator.PrefixOperator;

/**
 * <p>
 * Create an expression of the <code>ASTNode</code> class-hierarchy from a math
 * formulas string representation
 * </p>
 * <p>
 * See
 * <a href="http://en.wikipedia.org/wiki/Operator-precedence_parser">Operator
 * -precedence parser</a> for the idea, how to parse the operators depending on
 * their precedence.
 * </p>
 */
public class Parser extends Scanner {
	/**
	 * SymbolNode for <code>Derivative</code> corresponding to
	 * <code>F#Derivative</code>
	 */
	public final static SymbolNode DERIVATIVE = new SymbolNode("Derivative");

	/**
	 * Use '('...')' as brackets for function arguments
	 */
	private final boolean fRelaxedSyntax;

	/**
	 * List of ASTNodes used for parsing packages
	 */
	private List<ASTNode> fNodeList = null;

	public Parser() {
		this(ASTNodeFactory.MMA_STYLE_FACTORY, false, false);
	}

	/**
	 * <p>
	 * Create an expression of the <code>ASTNode</code> class-hierarchy from a
	 * math formulas string representation
	 * </p>
	 * <p>
	 * See <a href="http://en.wikipedia.org/wiki/Operator-precedence_parser">
	 * Operator -precedence parser</a> for the idea, how to parse the operators
	 * depending on their precedence.
	 * </p>
	 * 
	 * @param relaxedSyntax
	 *            if <code>true</code>, use '('...')' as brackets for function
	 *            arguments
	 */
	public Parser(final boolean relaxedSyntax) {
		this(ASTNodeFactory.MMA_STYLE_FACTORY, relaxedSyntax);
	}

	/**
	 * <p>
	 * Create an expression of the <code>ASTNode</code> class-hierarchy from a
	 * math formulas string representation
	 * </p>
	 * <p>
	 * See <a href="http://en.wikipedia.org/wiki/Operator-precedence_parser">
	 * Operator -precedence parser</a> for the idea, how to parse the operators
	 * depending on their precedence.
	 * </p>
	 * 
	 * @param relaxedSyntax
	 *            if <code>true</code>, use '('...')' as brackets for function
	 *            arguments
	 * @param packageMode
	 *            parse in &quot;package mode&quot; and initialize an internal
	 *            list of ASTNodes
	 */
	public Parser(final boolean relaxedSyntax, boolean packageMode) {
		this(ASTNodeFactory.MMA_STYLE_FACTORY, relaxedSyntax, packageMode);
	}

	/**
	 * <p>
	 * Create an expression of the <code>ASTNode</code> class-hierarchy from a
	 * math formulas string representation
	 * </p>
	 * <p>
	 * See <a href="http://en.wikipedia.org/wiki/Operator-precedence_parser">
	 * Operator -precedence parser</a> for the idea, how to parse the operators
	 * depending on their precedence.
	 * </p>
	 * 
	 * @param factory
	 *            a parser factory
	 * @param relaxedSyntax
	 *            if <code>true</code>, use '('...')' as brackets for function
	 *            arguments
	 */
	public Parser(IParserFactory factory, final boolean relaxedSyntax) {
		this(factory, relaxedSyntax, false);
	}

	/**
	 * <p>
	 * Create an expression of the <code>ASTNode</code> class-hierarchy from a
	 * math formulas string representation
	 * </p>
	 * <p>
	 * See <a href="http://en.wikipedia.org/wiki/Operator-precedence_parser">
	 * Operator -precedence parser</a> for the idea, how to parse the operators
	 * depending on their precedence.
	 * </p>
	 * 
	 * @param factory
	 *            a parser factory
	 * @param relaxedSyntax
	 *            if <code>true</code>, use '('...')' as brackets for function
	 *            arguments
	 * @param packageMode
	 *            parse in &quot;package mode&quot; and initialize an internal
	 *            list of ASTNodes
	 */
	public Parser(IParserFactory factory, final boolean relaxedSyntax, boolean packageMode) {
		super(packageMode);
		this.fRelaxedSyntax = relaxedSyntax;
		this.fFactory = factory;
		if (packageMode) {
			fNodeList = new ArrayList<ASTNode>(256);
		}
	}

	public void setFactory(final IParserFactory factory) {
		this.fFactory = factory;
	}

	public IParserFactory getFactory() {
		return fFactory;
	}

	/**
	 * construct the arguments for an expression
	 * 
	 */
	private void getArguments(final FunctionNode function) throws SyntaxError {
		do {
			function.add(parseOperators(parsePrimary(), 0));

			if (fToken != TT_COMMA) {
				break;
			}

			getNextToken();
		} while (true);
	}

	/**
	 * Determine the current PrefixOperator
	 * 
	 * @return <code>null</code> if no prefix operator could be determined
	 */
	private PrefixOperator determinePrefixOperator() {
		Operator oper = null;
		for (int i = 0; i < fOperList.size(); i++) {
			oper = fOperList.get(i);
			if (oper instanceof PrefixOperator) {
				return (PrefixOperator) oper;
			}
		}
		return null;
	}

	/**
	 * Determine the current PostfixOperator
	 * 
	 * @return <code>null</code> if no postfix operator could be determined
	 */
	private PostfixOperator determinePostfixOperator() {
		Operator oper = null;
		for (int i = 0; i < fOperList.size(); i++) {
			oper = fOperList.get(i);
			if (oper instanceof PostfixOperator) {
				return (PostfixOperator) oper;
			}
		}
		return null;
	}

	/**
	 * Determine the current BinaryOperator
	 * 
	 * @return <code>null</code> if no binary operator could be determined
	 */
	private InfixOperator determineBinaryOperator() {
		Operator oper = null;
		for (int i = 0; i < fOperList.size(); i++) {
			oper = fOperList.get(i);
			if (oper instanceof InfixOperator) {
				return (InfixOperator) oper;
			}
		}
		return null;
	}

	private ASTNode parseArguments(ASTNode lhs) {
		if (fRelaxedSyntax) {
			if (fToken == TT_ARGUMENTS_OPEN) {
				lhs = getFunctionArguments(lhs);
			} else if (fToken == TT_PRECEDENCE_OPEN) {
				lhs = getFunction(lhs);
			}
		} else {
			if (fToken == TT_ARGUMENTS_OPEN) {
				lhs = getFunctionArguments(lhs);
			}
		}
		return lhs;
	}

	private ASTNode parsePrimary() {
		if (fToken == TT_OPERATOR) {
			if (fOperatorString.equals(".")) {
				fCurrentChar = '.';
				// fToken = TT_DIGIT;
				// return getPart();
				return getNumber(false);
			}
			final PrefixOperator prefixOperator = determinePrefixOperator();
			if (prefixOperator != null) {
				getNextToken();
				final ASTNode temp = parseLookaheadOperator(prefixOperator.getPrecedence());
				if (prefixOperator.getFunctionName().equals("PreMinus")) {
					// special cases for negative numbers
					if (temp instanceof NumberNode) {
						((NumberNode) temp).toggleSign();
						return temp;
					}
				}
				return prefixOperator.createFunction(fFactory, temp);
			}
			throwSyntaxError("Operator: " + fOperatorString + " is no prefix operator.");

		}
		return getPart();
	}

	private ASTNode parseLookaheadOperator(final int min_precedence) {
		ASTNode rhs = parsePrimary();

		while (true) {
			final int lookahead = fToken;
			if (fToken == TT_NEWLINE) {
				return rhs;
			}
			if ((fToken == TT_LIST_OPEN) || (fToken == TT_PRECEDENCE_OPEN) || (fToken == TT_IDENTIFIER)
					|| (fToken == TT_STRING) || (fToken == TT_DIGIT)) {
				// if (fPackageMode && fRecursionDepth < 1) {
				// return rhs;
				// }
				// lazy evaluation of multiplication
				InfixOperator timesOperator = (InfixOperator) fFactory.get("Times");
				if (timesOperator.getPrecedence() > min_precedence) {
					rhs = parseOperators(rhs, timesOperator.getPrecedence());
					continue;
				} else if ((timesOperator.getPrecedence() == min_precedence)
						&& (timesOperator.getGrouping() == InfixOperator.RIGHT_ASSOCIATIVE)) {
					rhs = parseOperators(rhs, timesOperator.getPrecedence());
					continue;
				}
			} else {
				if (lookahead != TT_OPERATOR) {
					break;
				}
				InfixOperator infixOperator = determineBinaryOperator();
				if (infixOperator != null) {
					if (infixOperator.getPrecedence() > min_precedence
							|| ((infixOperator.getPrecedence() == min_precedence)
									&& (infixOperator.getGrouping() == InfixOperator.RIGHT_ASSOCIATIVE))) {
						if (infixOperator.getOperatorString().equals(";")) {
							if (fPackageMode && fRecursionDepth < 1) {
								return infixOperator.createFunction(fFactory, rhs, fFactory.createSymbol("Null"));
							}
						}
						rhs = parseOperators(rhs, infixOperator.getPrecedence());
						continue;
					}

					// if (infixOperator.getPrecedence() > min_precedence) {
					// ASTNode compoundExpressionNull =
					// parseCompoundExpressionNull(infixOperator, rhs);
					// if (compoundExpressionNull != null) {
					// return compoundExpressionNull;
					// }
					// rhs = parseOperators(rhs, infixOperator.getPrecedence());
					// continue;
					// } else if ((infixOperator.getPrecedence() ==
					// min_precedence)
					// && (infixOperator.getGrouping() ==
					// InfixOperator.RIGHT_ASSOCIATIVE)) {
					// rhs = parseOperators(rhs, infixOperator.getPrecedence());
					// continue;
					// }
				} else {
					PostfixOperator postfixOperator = determinePostfixOperator();
					if (postfixOperator != null) {
						if (postfixOperator.getPrecedence() > min_precedence) {
							getNextToken();
							rhs = postfixOperator.createFunction(fFactory, rhs);
							continue;
						}
					}
				}
			}
			break;
		}
		return rhs;

	}

	private ASTNode parseCompoundExpressionNull(InfixOperator infixOperator, ASTNode rhs) {
		if (infixOperator.getOperatorString().equals(";")) {
			if (fToken == TT_ARGUMENTS_CLOSE || fToken == TT_LIST_CLOSE || fToken == TT_PRECEDENCE_CLOSE) {
				return infixOperator.createFunction(fFactory, rhs, fFactory.createSymbol("Null"));
			}
			if (fPackageMode && fRecursionDepth < 1) {
				return infixOperator.createFunction(fFactory, rhs, fFactory.createSymbol("Null"));
			}
		}
		return null;
	}

	/**
	 * See <a href="http://en.wikipedia.org/wiki/Operator-precedence_parser">
	 * Operator -precedence parser</a> for the idea, how to parse the operators
	 * depending on their precedence.
	 * 
	 * @param lhs
	 *            the already parsed left-hand-side of the operator
	 * @param min_precedence
	 * @return
	 */
	private ASTNode parseOperators(ASTNode lhs, final int min_precedence) {
		ASTNode rhs = null;
		Operator oper;
		InfixOperator infixOperator;
		PostfixOperator postfixOperator;
		while (true) {
			if (fToken == TT_NEWLINE) {
				return lhs;
			}
			if ((fToken == TT_LIST_OPEN) || (fToken == TT_PRECEDENCE_OPEN) || (fToken == TT_IDENTIFIER)
					|| (fToken == TT_STRING) || (fToken == TT_DIGIT) || (fToken == TT_SLOT)
					|| (fToken == TT_SLOTSEQUENCE)) {
				// if (fPackageMode && fRecursionDepth < 1) {
				// return lhs;
				// }
				// if (fPackageMode && fToken == TT_IDENTIFIER && fLastChar ==
				// '\n') {
				// return lhs;
				// }
				// lazy evaluation of multiplication
				oper = fFactory.get("Times");
				if (oper.getPrecedence() >= min_precedence) {
					rhs = parseLookaheadOperator(oper.getPrecedence());
					lhs = fFactory.createFunction(fFactory.createSymbol(oper.getFunctionName()), lhs, rhs);
					// lhs = parseArguments(lhs);
					continue;
				}
			} else {
				if (fToken != TT_OPERATOR) {
					if (fToken == TT_DERIVATIVE) {
						int derivativeCounter = 1;
						getNextToken();
						while (fToken == TT_DERIVATIVE) {
							derivativeCounter++;
							getNextToken();
						}
						FunctionNode head = fFactory.createFunction(DERIVATIVE, new IntegerNode(derivativeCounter));
						FunctionNode deriv = fFactory.createAST(head);
						deriv.add(lhs);
						// lhs = postfixOperator.createFunction(fFactory, lhs);
						lhs = parseArguments(deriv);
						continue;
					}
					break;
				}
				infixOperator = determineBinaryOperator();

				if (infixOperator != null) {
					if (infixOperator.getPrecedence() >= min_precedence) {
						getNextToken();
						ASTNode compoundExpressionNull = parseCompoundExpressionNull(infixOperator, lhs);
						if (compoundExpressionNull != null) {
							return compoundExpressionNull;
						}

						while (fToken == TT_NEWLINE) {
							getNextToken();
						}
						rhs = parseLookaheadOperator(infixOperator.getPrecedence());
						lhs = infixOperator.createFunction(fFactory, lhs, rhs);

						continue;
					}
				} else {
					postfixOperator = determinePostfixOperator();

					if (postfixOperator != null) {
						if (postfixOperator.getPrecedence() >= min_precedence) {
							getNextToken();
							lhs = postfixOperator.createFunction(fFactory, lhs);
							lhs = parseArguments(lhs);
							continue;
						}
					} else {
						throwSyntaxError("Operator: " + fOperatorString + " is no infix or postfix operator.");
					}
				}
			}
			break;
		}
		return lhs;
	}

	/**
	 * Parse the given <code>expression</code> String into an ASTNode.
	 * 
	 * @param expression
	 *            a formula string which should be parsed.
	 * @return the parsed ASTNode representation of the given formula string
	 * @throws SyntaxError
	 */
	public ASTNode parse(final String expression) throws SyntaxError {
		initialize(expression);
		final ASTNode temp = parseOperators(parsePrimary(), 0);
		if (fToken != TT_EOF) {
			if (fToken == TT_PRECEDENCE_CLOSE) {
				throwSyntaxError("Too many closing ')'; End-of-file not reached.");
			}
			if (fToken == TT_LIST_CLOSE) {
				throwSyntaxError("Too many closing '}'; End-of-file not reached.");
			}
			if (fToken == TT_ARGUMENTS_CLOSE) {
				throwSyntaxError("Too many closing ']'; End-of-file not reached.");
			}

			throwSyntaxError("End-of-file not reached.");
		}

		return temp;
	}

	/**
	 * Parse a package.
	 * 
	 * @param expression
	 * @return
	 * @throws SyntaxError
	 */
	public List<ASTNode> parsePackage(final String expression) throws SyntaxError {
		initialize(expression);
		while (fToken == TT_NEWLINE) {
			getNextToken();
		}
		ASTNode temp = parseOperators(parsePrimary(), 0);
		fNodeList.add(temp);
		while (fToken != TT_EOF) {
			if (fToken == TT_PRECEDENCE_CLOSE) {
				throwSyntaxError("Too many closing ')'; End-of-file not reached.");
			}
			if (fToken == TT_LIST_CLOSE) {
				throwSyntaxError("Too many closing '}'; End-of-file not reached.");
			}
			if (fToken == TT_ARGUMENTS_CLOSE) {
				throwSyntaxError("Too many closing ']'; End-of-file not reached.");
			}
			while (fToken == TT_NEWLINE) {
				getNextToken();
			}
			if (fToken == TT_EOF) {
				return fNodeList;
			}
			temp = parseOperators(parsePrimary(), 0);
			fNodeList.add(temp);
			// throwSyntaxError("End-of-file not reached.");
		}

		return fNodeList;
	}

	/**
	 * Method Declaration.
	 * 
	 * @return
	 * @see
	 */
	private ASTNode getNumber(final boolean negative) throws SyntaxError {
		ASTNode temp = null;
		final Object[] result = getNumberString();
		String number = (String) result[0];
		final int numFormat = ((Integer) result[1]).intValue();
		try {
			if (negative) {
				number = '-' + number;
			}
			if (numFormat < 0) {
				temp = fFactory.createDouble(number);
			} else {
				temp = fFactory.createInteger(number, numFormat);
			}
		} catch (final Throwable e) {
			throwSyntaxError("Number format error: " + number, number.length());
		}
		getNextToken();
		// if (fToken == TT_PRECEDENCE_OPEN) {
		// return getTimes(temp);
		// }
		return temp;
	}

	private int getIntegerNumber() throws SyntaxError {
		final Object[] result = getNumberString();
		final String number = (String) result[0];
		final int numFormat = ((Integer) result[1]).intValue();
		int intValue = 0;
		try {
			intValue = Integer.parseInt(number, numFormat);
		} catch (final NumberFormatException e) {
			throwSyntaxError("Number format error (not an int type): " + number, number.length());
		}
		getNextToken();
		return intValue;
	}

	/**
	 * Read the current identifier from the expression factories table
	 * 
	 * @return
	 * @see
	 */
	private SymbolNode getSymbol() throws SyntaxError {
		String identifier = getIdentifier();
		if (!fFactory.isValidIdentifier(identifier)) {
			throwSyntaxError("Invalid identifier: " + identifier + " detected.");
		}

		final SymbolNode symbol = fFactory.createSymbol(identifier);
		getNextToken();
		return symbol;
	}

	private ASTNode getString() throws SyntaxError {
		final StringBuffer ident = getStringBuffer();

		getNextToken();

		return fFactory.createString(ident);
	}

	/**
	 * Get a list {...}
	 * 
	 */
	private ASTNode getList() throws SyntaxError {
		final FunctionNode function = fFactory.createFunction(fFactory.createSymbol(IConstantOperators.List));

		getNextToken();

		if (fToken == TT_LIST_CLOSE) {
			getNextToken();

			return function;
		}

		fRecursionDepth++;
		try {
			getArguments(function);
		} finally {
			fRecursionDepth--;
		}
		if (fToken == TT_LIST_CLOSE) {
			getNextToken();

			return function;
		}

		throwSyntaxError("'}' expected.");
		return null;
	}

	/**
	 * Get a function f[...][...]
	 * 
	 */
	FunctionNode getFunction(final ASTNode head) throws SyntaxError {
		final FunctionNode function = fFactory.createAST(head);

		getNextToken();

		if (fRelaxedSyntax) {
			if (fToken == TT_PRECEDENCE_CLOSE) {
				getNextToken();
				if (fToken == TT_PRECEDENCE_OPEN) {
					return function;
				}
				if (fToken == TT_ARGUMENTS_OPEN) {
					return getFunctionArguments(function);
				}
				return function;
			}
		} else {
			if (fToken == TT_ARGUMENTS_CLOSE) {
				getNextToken();
				if (fToken == TT_ARGUMENTS_OPEN) {
					return getFunctionArguments(function);
				}
				return function;
			}
		}
		fRecursionDepth++;
		try {
			getArguments(function);
		} finally {
			fRecursionDepth--;
		}
		if (fRelaxedSyntax) {
			if (fToken == TT_PRECEDENCE_CLOSE) {
				getNextToken();
				if (fToken == TT_PRECEDENCE_OPEN) {
					return function;
				}
				if (fToken == TT_ARGUMENTS_OPEN) {
					return getFunctionArguments(function);
				}
				return function;
			}
		} else {
			if (fToken == TT_ARGUMENTS_CLOSE) {
				getNextToken();
				if (fToken == TT_ARGUMENTS_OPEN) {
					return getFunctionArguments(function);
				}
				return function;
			}
		}

		if (fRelaxedSyntax) {
			throwSyntaxError("')' expected.");
		} else {
			throwSyntaxError("']' expected.");
		}
		return null;

	}

	/**
	 * Get a function f[...][...]
	 * 
	 */
	FunctionNode getFunctionArguments(final ASTNode head) throws SyntaxError {

		final FunctionNode function = fFactory.createAST(head);
		fRecursionDepth++;
		try {
			getNextToken();

			if (fToken == TT_ARGUMENTS_CLOSE) {
				getNextToken();
				if (fToken == TT_ARGUMENTS_OPEN) {
					return getFunctionArguments(function);
				}
				return function;
			}

			getArguments(function);
		} finally {
			fRecursionDepth--;
		}
		if (fToken == TT_ARGUMENTS_CLOSE) {
			getNextToken();
			if (fToken == TT_ARGUMENTS_OPEN) {
				return getFunctionArguments(function);
			}
			return function;
		}

		throwSyntaxError("']' expected.");
		return null;

	}

	private ASTNode getFactor() throws SyntaxError {
		ASTNode temp;

		if (fToken == TT_IDENTIFIER) {
			final SymbolNode symbol = getSymbol();

			if (fToken == TT_BLANK) {
				// read '_'
				if (isWhitespace()) {
					temp = fFactory.createPattern(symbol, null);
					getNextToken();
				} else {
					getNextToken();
					if (fToken == TT_IDENTIFIER) {
						final ASTNode check = getSymbol();
						temp = fFactory.createPattern(symbol, check);
					} else {
						temp = fFactory.createPattern(symbol, null);
					}
				}
			} else if (fToken == TT_BLANK_BLANK) {
				// read '__'
				if (isWhitespace()) {
					temp = fFactory.createPattern2(symbol, null);
					getNextToken();
				} else {
					getNextToken();
					if (fToken == TT_IDENTIFIER) {
						final ASTNode check = getSymbol();
						temp = fFactory.createPattern2(symbol, check);
					} else {
						temp = fFactory.createPattern2(symbol, null);
					}
				}
			} else if (fToken == TT_BLANK_BLANK_BLANK) {
				// read '___'
				if (isWhitespace()) {
					temp = fFactory.createPattern3(symbol, null);
					getNextToken();
				} else {
					getNextToken();
					if (fToken == TT_IDENTIFIER) {
						final ASTNode check = getSymbol();
						temp = fFactory.createPattern3(symbol, check);
					} else {
						temp = fFactory.createPattern3(symbol, null);
					}
				}
			} else if (fToken == TT_BLANK_OPTIONAL) {
				// read '_.'
				if (isWhitespace()) {
					temp = fFactory.createPattern(symbol, null, true);
					getNextToken();
				} else {
					getNextToken();
					if (fToken == TT_IDENTIFIER) {
						final ASTNode check = getSymbol();
						temp = fFactory.createPattern(symbol, check, true);
					} else {
						temp = fFactory.createPattern(symbol, null, true);
					}
				}
			} else {
				temp = symbol;
			}

			return parseArguments(temp);
		} else if (fToken == TT_BLANK) {
			if (isWhitespace()) {
				getNextToken();
				temp = fFactory.createPattern(null, null);
			} else {
				getNextToken();
				if (fToken == TT_IDENTIFIER) {
					final ASTNode check = getSymbol();
					temp = fFactory.createPattern(null, check);
				} else {
					temp = fFactory.createPattern(null, null);
				}
			}
			return parseArguments(temp);
		} else if (fToken == TT_BLANK_BLANK) {
			// read '__'
			if (isWhitespace()) {
				getNextToken();
				temp = fFactory.createPattern2(null, null);
			} else {
				getNextToken();
				if (fToken == TT_IDENTIFIER) {
					final ASTNode check = getSymbol();
					temp = fFactory.createPattern2(null, check);
				} else {
					temp = fFactory.createPattern2(null, null);
				}
			}
			return parseArguments(temp);
		} else if (fToken == TT_BLANK_BLANK_BLANK) {
			// read '___'
			if (isWhitespace()) {
				getNextToken();
				temp = fFactory.createPattern3(null, null);
			} else {
				getNextToken();
				if (fToken == TT_IDENTIFIER) {
					final ASTNode check = getSymbol();
					temp = fFactory.createPattern3(null, check);
				} else {
					temp = fFactory.createPattern3(null, null);
				}
			}
			return parseArguments(temp);
		} else if (fToken == TT_BLANK_OPTIONAL) {
			// read '_.'
			if (isWhitespace()) {
				getNextToken();
				temp = fFactory.createPattern(null, null, true);
			} else {
				getNextToken();
				if (fToken == TT_IDENTIFIER) {
					final ASTNode check = getSymbol();
					temp = fFactory.createPattern(null, check, true);
				} else {
					temp = fFactory.createPattern(null, null, true);
				}
			}
			return parseArguments(temp);
		} else if (fToken == TT_DIGIT) {
			return getNumber(false);
		} else if (fToken == TT_PRECEDENCE_OPEN) {
			fRecursionDepth++;
			try {
				getNextToken();

				temp = parseOperators(parsePrimary(), 0);

				if (fToken != TT_PRECEDENCE_CLOSE) {
					throwSyntaxError("\')\' expected.");
				}
			} finally {
				fRecursionDepth--;
			}
			getNextToken();
			if (fToken == TT_PRECEDENCE_OPEN) {
				return getTimes(temp);
			}
			return temp;

		} else if (fToken == TT_LIST_OPEN) {
			return getList();
		} else if (fToken == TT_STRING) {
			return getString();
		} else if (fToken == TT_PERCENT) {

			final FunctionNode out = fFactory.createFunction(fFactory.createSymbol(IConstantOperators.Out));

			int countPercent = 1;
			getNextToken();
			if (fToken == TT_DIGIT) {
				countPercent = getIntegerNumber();
				out.add(fFactory.createInteger(countPercent));
				return out;
			}

			while (fToken == TT_PERCENT) {
				countPercent++;
				getNextToken();
			}

			out.add(fFactory.createInteger(-countPercent));
			return parseArguments(out);
		} else if (fToken == TT_SLOT) {

			getNextToken();
			final FunctionNode slot = fFactory.createFunction(fFactory.createSymbol(IConstantOperators.Slot));
			if (fToken == TT_DIGIT) {
				slot.add(getNumber(false));
			} else {
				slot.add(fFactory.createInteger(1));
			}
			return parseArguments(slot);
		} else if (fToken == TT_SLOTSEQUENCE) {

			getNextToken();
			final FunctionNode slotSequencce = fFactory
					.createFunction(fFactory.createSymbol(IConstantOperators.SlotSequence));
			if (fToken == TT_DIGIT) {
				slotSequencce.add(getNumber(false));
			} else {
				slotSequencce.add(fFactory.createInteger(1));
			}
			return parseArguments(slotSequencce);
		}
		switch (fToken) {

		case TT_PRECEDENCE_CLOSE:
			throwSyntaxError("Too much closing ) in factor.");
			break;
		case TT_LIST_CLOSE:
			throwSyntaxError("Too much closing } in factor.");
			break;
		case TT_ARGUMENTS_CLOSE:
			throwSyntaxError("Too much closing ] in factor.");
			break;
		}

		throwSyntaxError("Error in factor at character: '" + fCurrentChar + "' (" + fToken + ")");
		return null;
	}

	private ASTNode getTimes(ASTNode temp) throws SyntaxError {
		FunctionNode func = fFactory.createAST(new SymbolNode("Times"));
		func.add(temp);
		do {
			getNextToken();

			temp = parseOperators(parsePrimary(), 0);
			func.add(temp);
			if (fToken != TT_PRECEDENCE_CLOSE) {
				throwSyntaxError("\')\' expected.");
			}
			getNextToken();
		} while (fToken == TT_PRECEDENCE_OPEN);
		return func;
	}

	/**
	 * Get a <i>part [[..]]</i> of an expression <code>{a,b,c}[[2]]</code>
	 * &rarr; <code>b</code>
	 * 
	 */
	private ASTNode getPart() throws SyntaxError {
		ASTNode temp = getFactor();

		if (fToken != TT_PARTOPEN) {
			return temp;
		}

		FunctionNode function = null;
		do {
			if (function == null) {
				function = fFactory.createFunction(fFactory.createSymbol(IConstantOperators.Part), temp);
			} else {
				function = fFactory.createFunction(fFactory.createSymbol(IConstantOperators.Part), function);
			}

			fRecursionDepth++;
			try {
				do {
					getNextToken();

					if (fToken == TT_ARGUMENTS_CLOSE) {
						if (fInputString.length() > fCurrentPosition && fInputString.charAt(fCurrentPosition) == ']') {
							throwSyntaxError("Statement (i.e. index) expected in [[ ]].");
						}
					}

					function.add(parseOperators(parsePrimary(), 0));
				} while (fToken == TT_COMMA);

				if (fToken == TT_ARGUMENTS_CLOSE) {
					// scanner-step begin: (instead of getNextToken() call):
					if (fInputString.length() > fCurrentPosition) {
						if (fInputString.charAt(fCurrentPosition) == ']') {
							fCurrentPosition++;
							fToken = TT_PARTCLOSE;
						}
					}
					// scanner-step end
				}
				if (fToken != TT_PARTCLOSE) {
					throwSyntaxError("']]' expected.");
				}
				// }
			} finally {
				fRecursionDepth--;
			}
			getNextToken();
		} while (fToken == TT_PARTOPEN);

		return parseArguments(function);

	}
}