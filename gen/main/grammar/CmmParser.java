// Generated from E:/UT/S5/Compiler/CA/Phase 1/src/main/grammar\Cmm.g4 by ANTLR 4.9.1
package main.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		MAIN=1, BEGIN=2, END=3, RETURN=4, IF=5, ELSE=6, WHILE=7, DO=8, GET=9, 
		SET=10, DISPLAY=11, APPEND=12, SIZE=13, PRIMITIVE_TYPE=14, FPTR=15, STRUCT=16, 
		LIST=17, VOID=18, LPAR=19, RPAR=20, LBRACK=21, RBRACK=22, LBRACE=23, RBRACE=24, 
		SHARP=25, COMMA=26, DOT=27, SEMICOLON=28, ARROW=29, PLUS=30, MINUS=31, 
		MULT=32, DIV=33, EQUAL=34, GREATER_THAN=35, LESS_THAN=36, AND=37, OR=38, 
		NOT=39, ASSIGN=40, BOOL_VALUE=41, INTEGER=42, IDENTIFIER=43, DIGIT=44, 
		NONZERODIGIT=45, LETTER=46, UNDERSCORE=47, COMMENT=48, WS=49, NEWLINE=50;
	public static final int
		RULE_cmm = 0, RULE_statement = 1, RULE_display_expression = 2, RULE_size_expression = 3, 
		RULE_append_expression = 4, RULE_conditional_statement = 5, RULE_condition = 6, 
		RULE_else_statement = 7, RULE_loop_statement = 8, RULE_do_while_loop = 9, 
		RULE_while_loop = 10, RULE_expression_statement = 11, RULE_declare_statement = 12, 
		RULE_var_init = 13, RULE_return_statement = 14, RULE_function_call_statement = 15, 
		RULE_main = 16, RULE_function_decleration = 17, RULE_arguments = 18, RULE_func_body = 19, 
		RULE_comma_expression = 20, RULE_assign_expression = 21, RULE_or_expression = 22, 
		RULE_and_expression = 23, RULE_equal_expression = 24, RULE_relation_expression = 25, 
		RULE_add_sub_expression = 26, RULE_mult_div_expression = 27, RULE_not_expression = 28, 
		RULE_high_expression = 29, RULE_final_expression = 30, RULE_value = 31, 
		RULE_parameters = 32, RULE_fptr_type = 33, RULE_function_type = 34, RULE_struct_decleration = 35, 
		RULE_struct_type = 36, RULE_struct_init = 37, RULE_struct_statement = 38, 
		RULE_set_get = 39, RULE_setter = 40, RULE_getter = 41, RULE_list_decleration = 42, 
		RULE_list_type = 43, RULE_type = 44, RULE_initable_type = 45, RULE_non_initable_type = 46, 
		RULE_eol = 47;
	private static String[] makeRuleNames() {
		return new String[] {
			"cmm", "statement", "display_expression", "size_expression", "append_expression", 
			"conditional_statement", "condition", "else_statement", "loop_statement", 
			"do_while_loop", "while_loop", "expression_statement", "declare_statement", 
			"var_init", "return_statement", "function_call_statement", "main", "function_decleration", 
			"arguments", "func_body", "comma_expression", "assign_expression", "or_expression", 
			"and_expression", "equal_expression", "relation_expression", "add_sub_expression", 
			"mult_div_expression", "not_expression", "high_expression", "final_expression", 
			"value", "parameters", "fptr_type", "function_type", "struct_decleration", 
			"struct_type", "struct_init", "struct_statement", "set_get", "setter", 
			"getter", "list_decleration", "list_type", "type", "initable_type", "non_initable_type", 
			"eol"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'main'", null, "'end'", "'return'", "'if'", "'else'", "'while'", 
			"'do'", "'get'", "'set'", "'display'", "'append'", "'size'", null, "'fptr'", 
			"'struct'", "'list'", "'void'", "'('", "')'", "'['", "']'", "'{'", "'}'", 
			"'#'", "','", "'.'", "';'", "'->'", "'+'", "'-'", "'*'", "'/'", "'=='", 
			"'>'", "'<'", "'&'", "'|'", "'~'", "'='", null, null, null, null, null, 
			null, "'_'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "MAIN", "BEGIN", "END", "RETURN", "IF", "ELSE", "WHILE", "DO", 
			"GET", "SET", "DISPLAY", "APPEND", "SIZE", "PRIMITIVE_TYPE", "FPTR", 
			"STRUCT", "LIST", "VOID", "LPAR", "RPAR", "LBRACK", "RBRACK", "LBRACE", 
			"RBRACE", "SHARP", "COMMA", "DOT", "SEMICOLON", "ARROW", "PLUS", "MINUS", 
			"MULT", "DIV", "EQUAL", "GREATER_THAN", "LESS_THAN", "AND", "OR", "NOT", 
			"ASSIGN", "BOOL_VALUE", "INTEGER", "IDENTIFIER", "DIGIT", "NONZERODIGIT", 
			"LETTER", "UNDERSCORE", "COMMENT", "WS", "NEWLINE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Cmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CmmContext extends ParserRuleContext {
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public List<Struct_declerationContext> struct_decleration() {
			return getRuleContexts(Struct_declerationContext.class);
		}
		public Struct_declerationContext struct_decleration(int i) {
			return getRuleContext(Struct_declerationContext.class,i);
		}
		public List<Function_declerationContext> function_decleration() {
			return getRuleContexts(Function_declerationContext.class);
		}
		public Function_declerationContext function_decleration(int i) {
			return getRuleContext(Function_declerationContext.class,i);
		}
		public CmmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterCmm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitCmm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitCmm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmmContext cmm() throws RecognitionException {
		CmmContext _localctx = new CmmContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_cmm);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(96);
					match(NEWLINE);
					}
					} 
				}
				setState(101);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(105);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(102);
					struct_decleration();
					}
					} 
				}
				setState(107);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(111);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(108);
					match(NEWLINE);
					}
					} 
				}
				setState(113);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRIMITIVE_TYPE) | (1L << FPTR) | (1L << STRUCT) | (1L << LIST) | (1L << VOID))) != 0)) {
				{
				{
				setState(114);
				function_decleration();
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(120);
				match(NEWLINE);
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(126);
			main();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public Conditional_statementContext conditional_statement() {
			return getRuleContext(Conditional_statementContext.class,0);
		}
		public Loop_statementContext loop_statement() {
			return getRuleContext(Loop_statementContext.class,0);
		}
		public Function_call_statementContext function_call_statement() {
			return getRuleContext(Function_call_statementContext.class,0);
		}
		public Declare_statementContext declare_statement() {
			return getRuleContext(Declare_statementContext.class,0);
		}
		public Return_statementContext return_statement() {
			return getRuleContext(Return_statementContext.class,0);
		}
		public Assign_expressionContext assign_expression() {
			return getRuleContext(Assign_expressionContext.class,0);
		}
		public Display_expressionContext display_expression() {
			return getRuleContext(Display_expressionContext.class,0);
		}
		public Size_expressionContext size_expression() {
			return getRuleContext(Size_expressionContext.class,0);
		}
		public Append_expressionContext append_expression() {
			return getRuleContext(Append_expressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				conditional_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				loop_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(130);
				function_call_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(131);
				declare_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(132);
				return_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(133);
				assign_expression(0);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(134);
				display_expression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(135);
				size_expression();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(136);
				append_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Display_expressionContext extends ParserRuleContext {
		public TerminalNode DISPLAY() { return getToken(CmmParser.DISPLAY, 0); }
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public Expression_statementContext expression_statement() {
			return getRuleContext(Expression_statementContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public Display_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_display_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterDisplay_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitDisplay_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitDisplay_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Display_expressionContext display_expression() throws RecognitionException {
		Display_expressionContext _localctx = new Display_expressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_display_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(DISPLAY);
			System.out.println("Built-in : display");
			setState(141);
			match(LPAR);
			setState(142);
			expression_statement();
			setState(143);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Size_expressionContext extends ParserRuleContext {
		public TerminalNode SIZE() { return getToken(CmmParser.SIZE, 0); }
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public Expression_statementContext expression_statement() {
			return getRuleContext(Expression_statementContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public Size_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_size_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterSize_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitSize_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitSize_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Size_expressionContext size_expression() throws RecognitionException {
		Size_expressionContext _localctx = new Size_expressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_size_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(SIZE);
			System.out.println("Size");
			setState(147);
			match(LPAR);
			setState(148);
			expression_statement();
			setState(149);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Append_expressionContext extends ParserRuleContext {
		public TerminalNode APPEND() { return getToken(CmmParser.APPEND, 0); }
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public List<Expression_statementContext> expression_statement() {
			return getRuleContexts(Expression_statementContext.class);
		}
		public Expression_statementContext expression_statement(int i) {
			return getRuleContext(Expression_statementContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(CmmParser.COMMA, 0); }
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public Append_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_append_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterAppend_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitAppend_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitAppend_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Append_expressionContext append_expression() throws RecognitionException {
		Append_expressionContext _localctx = new Append_expressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_append_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(APPEND);
			System.out.println("Append");
			setState(153);
			match(LPAR);
			setState(154);
			expression_statement();
			setState(155);
			match(COMMA);
			setState(156);
			expression_statement();
			setState(157);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Conditional_statementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(CmmParser.IF, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public Else_statementContext else_statement() {
			return getRuleContext(Else_statementContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(CmmParser.BEGIN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<EolContext> eol() {
			return getRuleContexts(EolContext.class);
		}
		public EolContext eol(int i) {
			return getRuleContext(EolContext.class,i);
		}
		public TerminalNode END() { return getToken(CmmParser.END, 0); }
		public TerminalNode NEWLINE() { return getToken(CmmParser.NEWLINE, 0); }
		public Conditional_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterConditional_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitConditional_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitConditional_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Conditional_statementContext conditional_statement() throws RecognitionException {
		Conditional_statementContext _localctx = new Conditional_statementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_conditional_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(IF);
			System.out.println("Conditional : if");
			setState(161);
			condition();
			setState(177);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BEGIN:
				{
				{
				setState(162);
				match(BEGIN);
				setState(163);
				statement();
				setState(164);
				eol();
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << IF) | (1L << WHILE) | (1L << DO) | (1L << DISPLAY) | (1L << APPEND) | (1L << SIZE) | (1L << PRIMITIVE_TYPE) | (1L << FPTR) | (1L << STRUCT) | (1L << LIST) | (1L << LPAR) | (1L << MINUS) | (1L << NOT) | (1L << BOOL_VALUE) | (1L << INTEGER) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(165);
					statement();
					setState(166);
					eol();
					}
					}
					setState(172);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(173);
				match(END);
				}
				}
				break;
			case NEWLINE:
				{
				{
				setState(175);
				match(NEWLINE);
				setState(176);
				statement();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(183);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON || _la==NEWLINE) {
					{
					setState(179);
					eol();
					}
				}

				setState(182);
				else_statement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public Comma_expressionContext comma_expression() {
			return getRuleContext(Comma_expressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_condition);
		try {
			setState(190);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(185);
				match(LPAR);
				setState(186);
				comma_expression(0);
				setState(187);
				match(RPAR);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				comma_expression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Else_statementContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(CmmParser.ELSE, 0); }
		public TerminalNode BEGIN() { return getToken(CmmParser.BEGIN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<EolContext> eol() {
			return getRuleContexts(EolContext.class);
		}
		public EolContext eol(int i) {
			return getRuleContext(EolContext.class,i);
		}
		public TerminalNode END() { return getToken(CmmParser.END, 0); }
		public TerminalNode NEWLINE() { return getToken(CmmParser.NEWLINE, 0); }
		public Else_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterElse_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitElse_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitElse_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_statementContext else_statement() throws RecognitionException {
		Else_statementContext _localctx = new Else_statementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_else_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(ELSE);
			System.out.println("Conditional : else");
			setState(209);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BEGIN:
				{
				{
				setState(194);
				match(BEGIN);
				setState(195);
				statement();
				setState(196);
				eol();
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << IF) | (1L << WHILE) | (1L << DO) | (1L << DISPLAY) | (1L << APPEND) | (1L << SIZE) | (1L << PRIMITIVE_TYPE) | (1L << FPTR) | (1L << STRUCT) | (1L << LIST) | (1L << LPAR) | (1L << MINUS) | (1L << NOT) | (1L << BOOL_VALUE) | (1L << INTEGER) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(197);
					statement();
					setState(198);
					eol();
					}
					}
					setState(204);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(205);
				match(END);
				}
				}
				break;
			case NEWLINE:
				{
				{
				setState(207);
				match(NEWLINE);
				setState(208);
				statement();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Loop_statementContext extends ParserRuleContext {
		public While_loopContext while_loop() {
			return getRuleContext(While_loopContext.class,0);
		}
		public Do_while_loopContext do_while_loop() {
			return getRuleContext(Do_while_loopContext.class,0);
		}
		public Loop_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterLoop_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitLoop_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitLoop_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Loop_statementContext loop_statement() throws RecognitionException {
		Loop_statementContext _localctx = new Loop_statementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_loop_statement);
		try {
			setState(213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHILE:
				enterOuterAlt(_localctx, 1);
				{
				setState(211);
				while_loop();
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 2);
				{
				setState(212);
				do_while_loop();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Do_while_loopContext extends ParserRuleContext {
		public TerminalNode DO() { return getToken(CmmParser.DO, 0); }
		public TerminalNode WHILE() { return getToken(CmmParser.WHILE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(CmmParser.BEGIN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<EolContext> eol() {
			return getRuleContexts(EolContext.class);
		}
		public EolContext eol(int i) {
			return getRuleContext(EolContext.class,i);
		}
		public TerminalNode END() { return getToken(CmmParser.END, 0); }
		public TerminalNode NEWLINE() { return getToken(CmmParser.NEWLINE, 0); }
		public Do_while_loopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_do_while_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterDo_while_loop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitDo_while_loop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitDo_while_loop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Do_while_loopContext do_while_loop() throws RecognitionException {
		Do_while_loopContext _localctx = new Do_while_loopContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_do_while_loop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(DO);
			System.out.println("Loop : do...while");
			setState(237);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BEGIN:
				{
				{
				setState(217);
				match(BEGIN);
				setState(218);
				statement();
				setState(219);
				eol();
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << IF) | (1L << WHILE) | (1L << DO) | (1L << DISPLAY) | (1L << APPEND) | (1L << SIZE) | (1L << PRIMITIVE_TYPE) | (1L << FPTR) | (1L << STRUCT) | (1L << LIST) | (1L << LPAR) | (1L << MINUS) | (1L << NOT) | (1L << BOOL_VALUE) | (1L << INTEGER) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(220);
					statement();
					setState(221);
					eol();
					}
					}
					setState(227);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(228);
				match(END);
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON || _la==NEWLINE) {
					{
					setState(229);
					eol();
					}
				}

				}
				}
				break;
			case NEWLINE:
				{
				{
				setState(232);
				match(NEWLINE);
				setState(233);
				statement();
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON || _la==NEWLINE) {
					{
					setState(234);
					eol();
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(239);
			match(WHILE);
			setState(240);
			condition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class While_loopContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(CmmParser.WHILE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(CmmParser.BEGIN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<EolContext> eol() {
			return getRuleContexts(EolContext.class);
		}
		public EolContext eol(int i) {
			return getRuleContext(EolContext.class,i);
		}
		public TerminalNode END() { return getToken(CmmParser.END, 0); }
		public TerminalNode NEWLINE() { return getToken(CmmParser.NEWLINE, 0); }
		public While_loopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterWhile_loop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitWhile_loop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitWhile_loop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_loopContext while_loop() throws RecognitionException {
		While_loopContext _localctx = new While_loopContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_while_loop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(WHILE);
			System.out.println("Loop : while");
			setState(244);
			condition();
			setState(260);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BEGIN:
				{
				{
				setState(245);
				match(BEGIN);
				setState(246);
				statement();
				setState(247);
				eol();
				setState(253);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << IF) | (1L << WHILE) | (1L << DO) | (1L << DISPLAY) | (1L << APPEND) | (1L << SIZE) | (1L << PRIMITIVE_TYPE) | (1L << FPTR) | (1L << STRUCT) | (1L << LIST) | (1L << LPAR) | (1L << MINUS) | (1L << NOT) | (1L << BOOL_VALUE) | (1L << INTEGER) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(248);
					statement();
					setState(249);
					eol();
					}
					}
					setState(255);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(256);
				match(END);
				}
				}
				break;
			case NEWLINE:
				{
				{
				setState(258);
				match(NEWLINE);
				setState(259);
				statement();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expression_statementContext extends ParserRuleContext {
		public Comma_expressionContext comma_expression() {
			return getRuleContext(Comma_expressionContext.class,0);
		}
		public Expression_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterExpression_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitExpression_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitExpression_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expression_statementContext expression_statement() throws RecognitionException {
		Expression_statementContext _localctx = new Expression_statementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expression_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			comma_expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Declare_statementContext extends ParserRuleContext {
		public Token IDENTIFIER;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CmmParser.COMMA, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(CmmParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(CmmParser.IDENTIFIER, i);
		}
		public List<Var_initContext> var_init() {
			return getRuleContexts(Var_initContext.class);
		}
		public Var_initContext var_init(int i) {
			return getRuleContext(Var_initContext.class,i);
		}
		public Declare_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declare_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterDeclare_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitDeclare_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitDeclare_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declare_statementContext declare_statement() throws RecognitionException {
		Declare_statementContext _localctx = new Declare_statementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_declare_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(264);
			type();
			setState(268);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(265);
				((Declare_statementContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				System.out.println("VarDec : " + ((Declare_statementContext)_localctx).IDENTIFIER.getText());
				}
				break;
			case 2:
				{
				setState(267);
				var_init();
				}
				break;
			}
			}
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(270);
				match(COMMA);
				setState(274);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(271);
					var_init();
					}
					break;
				case 2:
					{
					setState(272);
					((Declare_statementContext)_localctx).IDENTIFIER = match(IDENTIFIER);
					System.out.println("VarDec : " + ((Declare_statementContext)_localctx).IDENTIFIER.getText());
					}
					break;
				}
				}
				}
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_initContext extends ParserRuleContext {
		public Token IDENTIFIER;
		public TerminalNode IDENTIFIER() { return getToken(CmmParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(CmmParser.ASSIGN, 0); }
		public Comma_expressionContext comma_expression() {
			return getRuleContext(Comma_expressionContext.class,0);
		}
		public Var_initContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_init; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterVar_init(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitVar_init(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitVar_init(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_initContext var_init() throws RecognitionException {
		Var_initContext _localctx = new Var_initContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_var_init);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			((Var_initContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			System.out.println("VarDec : " + ((Var_initContext)_localctx).IDENTIFIER.getText());
			setState(283);
			match(ASSIGN);
			setState(284);
			comma_expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Return_statementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(CmmParser.RETURN, 0); }
		public Comma_expressionContext comma_expression() {
			return getRuleContext(Comma_expressionContext.class,0);
		}
		public Return_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterReturn_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitReturn_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitReturn_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_statementContext return_statement() throws RecognitionException {
		Return_statementContext _localctx = new Return_statementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_return_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			match(RETURN);
			System.out.println("Return");
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DISPLAY) | (1L << APPEND) | (1L << SIZE) | (1L << LPAR) | (1L << MINUS) | (1L << NOT) | (1L << BOOL_VALUE) | (1L << INTEGER) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(288);
				comma_expression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_call_statementContext extends ParserRuleContext {
		public Expression_statementContext expression_statement() {
			return getRuleContext(Expression_statementContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public Function_call_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterFunction_call_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitFunction_call_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitFunction_call_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_call_statementContext function_call_statement() throws RecognitionException {
		Function_call_statementContext _localctx = new Function_call_statementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_function_call_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			expression_statement();
			setState(292);
			match(LPAR);
			setState(293);
			parameters();
			setState(294);
			match(RPAR);
			System.out.println("FunctionCall");
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainContext extends ParserRuleContext {
		public TerminalNode MAIN() { return getToken(CmmParser.MAIN, 0); }
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public Func_bodyContext func_body() {
			return getRuleContext(Func_bodyContext.class,0);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			match(MAIN);
			System.out.println("Main");
			setState(299);
			match(LPAR);
			setState(300);
			match(RPAR);
			setState(301);
			func_body();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_declerationContext extends ParserRuleContext {
		public Token IDENTIFIER;
		public TerminalNode IDENTIFIER() { return getToken(CmmParser.IDENTIFIER, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public Func_bodyContext func_body() {
			return getRuleContext(Func_bodyContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(CmmParser.VOID, 0); }
		public Function_declerationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_decleration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterFunction_decleration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitFunction_decleration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitFunction_decleration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_declerationContext function_decleration() throws RecognitionException {
		Function_declerationContext _localctx = new Function_declerationContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_function_decleration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRIMITIVE_TYPE:
			case FPTR:
			case STRUCT:
			case LIST:
				{
				setState(303);
				type();
				}
				break;
			case VOID:
				{
				setState(304);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(307);
			((Function_declerationContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			System.out.println("FunctionDec : " + ((Function_declerationContext)_localctx).IDENTIFIER.getText());
			setState(309);
			arguments();
			setState(310);
			func_body();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentsContext extends ParserRuleContext {
		public Token IDENTIFIER;
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(CmmParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(CmmParser.IDENTIFIER, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CmmParser.COMMA, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			match(LPAR);
			setState(327);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RPAR:
				{
				}
				break;
			case PRIMITIVE_TYPE:
			case FPTR:
			case STRUCT:
			case LIST:
				{
				setState(314);
				type();
				setState(315);
				((ArgumentsContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				System.out.println("ArgumentDec : " + ((ArgumentsContext)_localctx).IDENTIFIER.getText());
				setState(324);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(317);
					match(COMMA);
					setState(318);
					type();
					setState(319);
					((ArgumentsContext)_localctx).IDENTIFIER = match(IDENTIFIER);
					System.out.println("ArgumentDec : " + ((ArgumentsContext)_localctx).IDENTIFIER.getText());
					}
					}
					setState(326);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(329);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_bodyContext extends ParserRuleContext {
		public TerminalNode BEGIN() { return getToken(CmmParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(CmmParser.END, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<EolContext> eol() {
			return getRuleContexts(EolContext.class);
		}
		public EolContext eol(int i) {
			return getRuleContext(EolContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public Func_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterFunc_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitFunc_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitFunc_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_bodyContext func_body() throws RecognitionException {
		Func_bodyContext _localctx = new Func_bodyContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_func_body);
		int _la;
		try {
			int _alt;
			setState(350);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BEGIN:
				enterOuterAlt(_localctx, 1);
				{
				setState(331);
				match(BEGIN);
				setState(335); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(332);
					statement();
					setState(333);
					eol();
					}
					}
					setState(337); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << IF) | (1L << WHILE) | (1L << DO) | (1L << DISPLAY) | (1L << APPEND) | (1L << SIZE) | (1L << PRIMITIVE_TYPE) | (1L << FPTR) | (1L << STRUCT) | (1L << LIST) | (1L << LPAR) | (1L << MINUS) | (1L << NOT) | (1L << BOOL_VALUE) | (1L << INTEGER) | (1L << IDENTIFIER))) != 0) );
				setState(339);
				match(END);
				setState(343);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(340);
						match(NEWLINE);
						}
						} 
					}
					setState(345);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				}
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(346);
				match(NEWLINE);
				setState(347);
				statement();
				setState(348);
				eol();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Comma_expressionContext extends ParserRuleContext {
		public Assign_expressionContext assign_expression() {
			return getRuleContext(Assign_expressionContext.class,0);
		}
		public Comma_expressionContext comma_expression() {
			return getRuleContext(Comma_expressionContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(CmmParser.COMMA, 0); }
		public Comma_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comma_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterComma_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitComma_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitComma_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comma_expressionContext comma_expression() throws RecognitionException {
		return comma_expression(0);
	}

	private Comma_expressionContext comma_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Comma_expressionContext _localctx = new Comma_expressionContext(_ctx, _parentState);
		Comma_expressionContext _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_comma_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(353);
			assign_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(362);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Comma_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_comma_expression);
					setState(355);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(356);
					match(COMMA);
					setState(357);
					assign_expression(0);
					System.out.println("Operator : ,");
					}
					} 
				}
				setState(364);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Assign_expressionContext extends ParserRuleContext {
		public Or_expressionContext or_expression() {
			return getRuleContext(Or_expressionContext.class,0);
		}
		public Assign_expressionContext assign_expression() {
			return getRuleContext(Assign_expressionContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(CmmParser.ASSIGN, 0); }
		public Assign_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterAssign_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitAssign_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitAssign_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_expressionContext assign_expression() throws RecognitionException {
		return assign_expression(0);
	}

	private Assign_expressionContext assign_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Assign_expressionContext _localctx = new Assign_expressionContext(_ctx, _parentState);
		Assign_expressionContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_assign_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(366);
			or_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(373);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Assign_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_assign_expression);
					setState(368);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(369);
					match(ASSIGN);
					setState(370);
					or_expression(0);
					}
					} 
				}
				setState(375);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Or_expressionContext extends ParserRuleContext {
		public And_expressionContext and_expression() {
			return getRuleContext(And_expressionContext.class,0);
		}
		public Or_expressionContext or_expression() {
			return getRuleContext(Or_expressionContext.class,0);
		}
		public TerminalNode OR() { return getToken(CmmParser.OR, 0); }
		public Or_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterOr_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitOr_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitOr_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Or_expressionContext or_expression() throws RecognitionException {
		return or_expression(0);
	}

	private Or_expressionContext or_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Or_expressionContext _localctx = new Or_expressionContext(_ctx, _parentState);
		Or_expressionContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_or_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(377);
			and_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(386);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Or_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_or_expression);
					setState(379);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(380);
					match(OR);
					setState(381);
					and_expression(0);
					System.out.println("Operator : |");
					}
					} 
				}
				setState(388);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class And_expressionContext extends ParserRuleContext {
		public Equal_expressionContext equal_expression() {
			return getRuleContext(Equal_expressionContext.class,0);
		}
		public And_expressionContext and_expression() {
			return getRuleContext(And_expressionContext.class,0);
		}
		public TerminalNode AND() { return getToken(CmmParser.AND, 0); }
		public And_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterAnd_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitAnd_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitAnd_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final And_expressionContext and_expression() throws RecognitionException {
		return and_expression(0);
	}

	private And_expressionContext and_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		And_expressionContext _localctx = new And_expressionContext(_ctx, _parentState);
		And_expressionContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_and_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(390);
			equal_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(399);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new And_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_and_expression);
					setState(392);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(393);
					match(AND);
					setState(394);
					equal_expression(0);
					System.out.println("Operator : &");
					}
					} 
				}
				setState(401);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Equal_expressionContext extends ParserRuleContext {
		public Relation_expressionContext relation_expression() {
			return getRuleContext(Relation_expressionContext.class,0);
		}
		public Equal_expressionContext equal_expression() {
			return getRuleContext(Equal_expressionContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(CmmParser.EQUAL, 0); }
		public Equal_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equal_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterEqual_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitEqual_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitEqual_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Equal_expressionContext equal_expression() throws RecognitionException {
		return equal_expression(0);
	}

	private Equal_expressionContext equal_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Equal_expressionContext _localctx = new Equal_expressionContext(_ctx, _parentState);
		Equal_expressionContext _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_equal_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(403);
			relation_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(412);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Equal_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_equal_expression);
					setState(405);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(406);
					match(EQUAL);
					setState(407);
					relation_expression(0);
					System.out.println("Operator : ==");
					}
					} 
				}
				setState(414);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Relation_expressionContext extends ParserRuleContext {
		public Token Z;
		public Add_sub_expressionContext add_sub_expression() {
			return getRuleContext(Add_sub_expressionContext.class,0);
		}
		public Relation_expressionContext relation_expression() {
			return getRuleContext(Relation_expressionContext.class,0);
		}
		public TerminalNode GREATER_THAN() { return getToken(CmmParser.GREATER_THAN, 0); }
		public TerminalNode LESS_THAN() { return getToken(CmmParser.LESS_THAN, 0); }
		public Relation_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterRelation_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitRelation_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitRelation_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Relation_expressionContext relation_expression() throws RecognitionException {
		return relation_expression(0);
	}

	private Relation_expressionContext relation_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Relation_expressionContext _localctx = new Relation_expressionContext(_ctx, _parentState);
		Relation_expressionContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_relation_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(416);
			add_sub_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(425);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Relation_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_relation_expression);
					setState(418);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(419);
					((Relation_expressionContext)_localctx).Z = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==GREATER_THAN || _la==LESS_THAN) ) {
						((Relation_expressionContext)_localctx).Z = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(420);
					add_sub_expression(0);
					System.out.println("Operator : " + ((Relation_expressionContext)_localctx).Z.getText());
					}
					} 
				}
				setState(427);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Add_sub_expressionContext extends ParserRuleContext {
		public Token Y;
		public Mult_div_expressionContext mult_div_expression() {
			return getRuleContext(Mult_div_expressionContext.class,0);
		}
		public Add_sub_expressionContext add_sub_expression() {
			return getRuleContext(Add_sub_expressionContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(CmmParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(CmmParser.MINUS, 0); }
		public Add_sub_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add_sub_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterAdd_sub_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitAdd_sub_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitAdd_sub_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Add_sub_expressionContext add_sub_expression() throws RecognitionException {
		return add_sub_expression(0);
	}

	private Add_sub_expressionContext add_sub_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Add_sub_expressionContext _localctx = new Add_sub_expressionContext(_ctx, _parentState);
		Add_sub_expressionContext _prevctx = _localctx;
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_add_sub_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(429);
			mult_div_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(438);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Add_sub_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_add_sub_expression);
					setState(431);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(432);
					((Add_sub_expressionContext)_localctx).Y = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
						((Add_sub_expressionContext)_localctx).Y = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(433);
					mult_div_expression(0);
					System.out.println("Operator : " + ((Add_sub_expressionContext)_localctx).Y.getText());
					}
					} 
				}
				setState(440);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Mult_div_expressionContext extends ParserRuleContext {
		public Token X;
		public Not_expressionContext not_expression() {
			return getRuleContext(Not_expressionContext.class,0);
		}
		public Mult_div_expressionContext mult_div_expression() {
			return getRuleContext(Mult_div_expressionContext.class,0);
		}
		public TerminalNode DIV() { return getToken(CmmParser.DIV, 0); }
		public TerminalNode MULT() { return getToken(CmmParser.MULT, 0); }
		public Mult_div_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mult_div_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterMult_div_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitMult_div_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitMult_div_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mult_div_expressionContext mult_div_expression() throws RecognitionException {
		return mult_div_expression(0);
	}

	private Mult_div_expressionContext mult_div_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Mult_div_expressionContext _localctx = new Mult_div_expressionContext(_ctx, _parentState);
		Mult_div_expressionContext _prevctx = _localctx;
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_mult_div_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(442);
			not_expression();
			}
			_ctx.stop = _input.LT(-1);
			setState(451);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Mult_div_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_mult_div_expression);
					setState(444);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(445);
					((Mult_div_expressionContext)_localctx).X = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==MULT || _la==DIV) ) {
						((Mult_div_expressionContext)_localctx).X = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(446);
					not_expression();
					System.out.println("Operator : " + ((Mult_div_expressionContext)_localctx).X.getText());
					}
					} 
				}
				setState(453);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Not_expressionContext extends ParserRuleContext {
		public Token M;
		public High_expressionContext high_expression() {
			return getRuleContext(High_expressionContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(CmmParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(CmmParser.NOT, 0); }
		public Not_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_not_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterNot_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitNot_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitNot_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Not_expressionContext not_expression() throws RecognitionException {
		Not_expressionContext _localctx = new Not_expressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_not_expression);
		int _la;
		try {
			setState(459);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(454);
				((Not_expressionContext)_localctx).M = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==MINUS || _la==NOT) ) {
					((Not_expressionContext)_localctx).M = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(455);
				high_expression(0);
				System.out.println("Operator : " + ((Not_expressionContext)_localctx).M.getText());
				}
				break;
			case DISPLAY:
			case APPEND:
			case SIZE:
			case LPAR:
			case BOOL_VALUE:
			case INTEGER:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(458);
				high_expression(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class High_expressionContext extends ParserRuleContext {
		public Final_expressionContext final_expression() {
			return getRuleContext(Final_expressionContext.class,0);
		}
		public High_expressionContext high_expression() {
			return getRuleContext(High_expressionContext.class,0);
		}
		public TerminalNode DOT() { return getToken(CmmParser.DOT, 0); }
		public TerminalNode LBRACK() { return getToken(CmmParser.LBRACK, 0); }
		public Comma_expressionContext comma_expression() {
			return getRuleContext(Comma_expressionContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(CmmParser.RBRACK, 0); }
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public High_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_high_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterHigh_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitHigh_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitHigh_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final High_expressionContext high_expression() throws RecognitionException {
		return high_expression(0);
	}

	private High_expressionContext high_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		High_expressionContext _localctx = new High_expressionContext(_ctx, _parentState);
		High_expressionContext _prevctx = _localctx;
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_high_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(462);
			final_expression();
			}
			_ctx.stop = _input.LT(-1);
			setState(479);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(477);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
					case 1:
						{
						_localctx = new High_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_high_expression);
						setState(464);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(465);
						match(DOT);
						setState(466);
						final_expression();
						}
						break;
					case 2:
						{
						_localctx = new High_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_high_expression);
						setState(467);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(468);
						match(LBRACK);
						setState(469);
						comma_expression(0);
						setState(470);
						match(RBRACK);
						}
						break;
					case 3:
						{
						_localctx = new High_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_high_expression);
						setState(472);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(473);
						match(LPAR);
						setState(474);
						parameters();
						setState(475);
						match(RPAR);
						}
						break;
					}
					} 
				}
				setState(481);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Final_expressionContext extends ParserRuleContext {
		public Display_expressionContext display_expression() {
			return getRuleContext(Display_expressionContext.class,0);
		}
		public Size_expressionContext size_expression() {
			return getRuleContext(Size_expressionContext.class,0);
		}
		public Append_expressionContext append_expression() {
			return getRuleContext(Append_expressionContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public Final_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_final_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterFinal_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitFinal_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitFinal_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Final_expressionContext final_expression() throws RecognitionException {
		Final_expressionContext _localctx = new Final_expressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_final_expression);
		try {
			setState(486);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DISPLAY:
				enterOuterAlt(_localctx, 1);
				{
				setState(482);
				display_expression();
				}
				break;
			case SIZE:
				enterOuterAlt(_localctx, 2);
				{
				setState(483);
				size_expression();
				}
				break;
			case APPEND:
				enterOuterAlt(_localctx, 3);
				{
				setState(484);
				append_expression();
				}
				break;
			case LPAR:
			case BOOL_VALUE:
			case INTEGER:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 4);
				{
				setState(485);
				value();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(CmmParser.INTEGER, 0); }
		public TerminalNode BOOL_VALUE() { return getToken(CmmParser.BOOL_VALUE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(CmmParser.IDENTIFIER, 0); }
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public Comma_expressionContext comma_expression() {
			return getRuleContext(Comma_expressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_value);
		try {
			setState(495);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(488);
				match(INTEGER);
				}
				break;
			case BOOL_VALUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(489);
				match(BOOL_VALUE);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(490);
				match(IDENTIFIER);
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 4);
				{
				setState(491);
				match(LPAR);
				setState(492);
				comma_expression(0);
				setState(493);
				match(RPAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametersContext extends ParserRuleContext {
		public List<Or_expressionContext> or_expression() {
			return getRuleContexts(Or_expressionContext.class);
		}
		public Or_expressionContext or_expression(int i) {
			return getRuleContext(Or_expressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CmmParser.COMMA, i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DISPLAY) | (1L << APPEND) | (1L << SIZE) | (1L << LPAR) | (1L << MINUS) | (1L << NOT) | (1L << BOOL_VALUE) | (1L << INTEGER) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(497);
				or_expression(0);
				setState(502);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(498);
					match(COMMA);
					setState(499);
					or_expression(0);
					}
					}
					setState(504);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Fptr_typeContext extends ParserRuleContext {
		public TerminalNode FPTR() { return getToken(CmmParser.FPTR, 0); }
		public TerminalNode LESS_THAN() { return getToken(CmmParser.LESS_THAN, 0); }
		public List<Function_typeContext> function_type() {
			return getRuleContexts(Function_typeContext.class);
		}
		public Function_typeContext function_type(int i) {
			return getRuleContext(Function_typeContext.class,i);
		}
		public TerminalNode ARROW() { return getToken(CmmParser.ARROW, 0); }
		public TerminalNode GREATER_THAN() { return getToken(CmmParser.GREATER_THAN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CmmParser.COMMA, i);
		}
		public Fptr_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fptr_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterFptr_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitFptr_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitFptr_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fptr_typeContext fptr_type() throws RecognitionException {
		Fptr_typeContext _localctx = new Fptr_typeContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_fptr_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(507);
			match(FPTR);
			setState(508);
			match(LESS_THAN);
			setState(509);
			function_type();
			setState(514);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(510);
				match(COMMA);
				setState(511);
				function_type();
				}
				}
				setState(516);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(517);
			match(ARROW);
			setState(518);
			function_type();
			setState(519);
			match(GREATER_THAN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_typeContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(CmmParser.VOID, 0); }
		public Function_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterFunction_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitFunction_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitFunction_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_typeContext function_type() throws RecognitionException {
		Function_typeContext _localctx = new Function_typeContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_function_type);
		try {
			setState(523);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRIMITIVE_TYPE:
			case FPTR:
			case STRUCT:
			case LIST:
				enterOuterAlt(_localctx, 1);
				{
				setState(521);
				type();
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(522);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Struct_declerationContext extends ParserRuleContext {
		public Token IDENTIFIER;
		public TerminalNode STRUCT() { return getToken(CmmParser.STRUCT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(CmmParser.IDENTIFIER, 0); }
		public TerminalNode NEWLINE() { return getToken(CmmParser.NEWLINE, 0); }
		public Struct_statementContext struct_statement() {
			return getRuleContext(Struct_statementContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(CmmParser.BEGIN, 0); }
		public Struct_initContext struct_init() {
			return getRuleContext(Struct_initContext.class,0);
		}
		public TerminalNode END() { return getToken(CmmParser.END, 0); }
		public Struct_declerationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_decleration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterStruct_decleration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitStruct_decleration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitStruct_decleration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_declerationContext struct_decleration() throws RecognitionException {
		Struct_declerationContext _localctx = new Struct_declerationContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_struct_decleration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(525);
			match(STRUCT);
			setState(526);
			((Struct_declerationContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			System.out.println("StructDec : " + ((Struct_declerationContext)_localctx).IDENTIFIER.getText());
			setState(535);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BEGIN:
				{
				{
				setState(528);
				match(BEGIN);
				setState(529);
				struct_init();
				setState(530);
				match(END);
				setState(531);
				match(NEWLINE);
				}
				}
				break;
			case NEWLINE:
				{
				setState(533);
				match(NEWLINE);
				setState(534);
				struct_statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Struct_typeContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(CmmParser.STRUCT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(CmmParser.IDENTIFIER, 0); }
		public Struct_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterStruct_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitStruct_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitStruct_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_typeContext struct_type() throws RecognitionException {
		Struct_typeContext _localctx = new Struct_typeContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_struct_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(537);
			match(STRUCT);
			setState(538);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Struct_initContext extends ParserRuleContext {
		public List<Struct_statementContext> struct_statement() {
			return getRuleContexts(Struct_statementContext.class);
		}
		public Struct_statementContext struct_statement(int i) {
			return getRuleContext(Struct_statementContext.class,i);
		}
		public Struct_initContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_init; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterStruct_init(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitStruct_init(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitStruct_init(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_initContext struct_init() throws RecognitionException {
		Struct_initContext _localctx = new Struct_initContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_struct_init);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(541); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(540);
				struct_statement();
				}
				}
				setState(543); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRIMITIVE_TYPE) | (1L << FPTR) | (1L << STRUCT) | (1L << LIST))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Struct_statementContext extends ParserRuleContext {
		public Declare_statementContext declare_statement() {
			return getRuleContext(Declare_statementContext.class,0);
		}
		public EolContext eol() {
			return getRuleContext(EolContext.class,0);
		}
		public Set_getContext set_get() {
			return getRuleContext(Set_getContext.class,0);
		}
		public Struct_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterStruct_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitStruct_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitStruct_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_statementContext struct_statement() throws RecognitionException {
		Struct_statementContext _localctx = new Struct_statementContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_struct_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(549);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				{
				setState(545);
				declare_statement();
				setState(546);
				eol();
				}
				break;
			case 2:
				{
				setState(548);
				set_get();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Set_getContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(CmmParser.IDENTIFIER, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(CmmParser.BEGIN, 0); }
		public SetterContext setter() {
			return getRuleContext(SetterContext.class,0);
		}
		public GetterContext getter() {
			return getRuleContext(GetterContext.class,0);
		}
		public TerminalNode END() { return getToken(CmmParser.END, 0); }
		public EolContext eol() {
			return getRuleContext(EolContext.class,0);
		}
		public Set_getContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_get; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterSet_get(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitSet_get(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitSet_get(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Set_getContext set_get() throws RecognitionException {
		Set_getContext _localctx = new Set_getContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_set_get);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(551);
			type();
			setState(552);
			match(IDENTIFIER);
			setState(553);
			arguments();
			setState(554);
			match(BEGIN);
			setState(555);
			setter();
			setState(556);
			getter();
			setState(557);
			match(END);
			setState(558);
			eol();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetterContext extends ParserRuleContext {
		public TerminalNode SET() { return getToken(CmmParser.SET, 0); }
		public TerminalNode NEWLINE() { return getToken(CmmParser.NEWLINE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<EolContext> eol() {
			return getRuleContexts(EolContext.class);
		}
		public EolContext eol(int i) {
			return getRuleContext(EolContext.class,i);
		}
		public TerminalNode BEGIN() { return getToken(CmmParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(CmmParser.END, 0); }
		public SetterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterSetter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitSetter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitSetter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetterContext setter() throws RecognitionException {
		SetterContext _localctx = new SetterContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_setter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(560);
			match(SET);
			System.out.println("Setter");
			setState(577);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEWLINE:
				{
				{
				setState(562);
				match(NEWLINE);
				setState(563);
				statement();
				setState(564);
				eol();
				}
				}
				break;
			case BEGIN:
				{
				{
				setState(566);
				match(BEGIN);
				setState(570); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(567);
					statement();
					setState(568);
					eol();
					}
					}
					setState(572); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << IF) | (1L << WHILE) | (1L << DO) | (1L << DISPLAY) | (1L << APPEND) | (1L << SIZE) | (1L << PRIMITIVE_TYPE) | (1L << FPTR) | (1L << STRUCT) | (1L << LIST) | (1L << LPAR) | (1L << MINUS) | (1L << NOT) | (1L << BOOL_VALUE) | (1L << INTEGER) | (1L << IDENTIFIER))) != 0) );
				setState(574);
				match(END);
				setState(575);
				eol();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GetterContext extends ParserRuleContext {
		public TerminalNode GET() { return getToken(CmmParser.GET, 0); }
		public TerminalNode NEWLINE() { return getToken(CmmParser.NEWLINE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<EolContext> eol() {
			return getRuleContexts(EolContext.class);
		}
		public EolContext eol(int i) {
			return getRuleContext(EolContext.class,i);
		}
		public TerminalNode BEGIN() { return getToken(CmmParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(CmmParser.END, 0); }
		public GetterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_getter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterGetter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitGetter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitGetter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GetterContext getter() throws RecognitionException {
		GetterContext _localctx = new GetterContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_getter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(579);
			match(GET);
			System.out.println("Getter");
			setState(596);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEWLINE:
				{
				{
				setState(581);
				match(NEWLINE);
				setState(582);
				statement();
				setState(583);
				eol();
				}
				}
				break;
			case BEGIN:
				{
				{
				setState(585);
				match(BEGIN);
				setState(589); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(586);
					statement();
					setState(587);
					eol();
					}
					}
					setState(591); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << IF) | (1L << WHILE) | (1L << DO) | (1L << DISPLAY) | (1L << APPEND) | (1L << SIZE) | (1L << PRIMITIVE_TYPE) | (1L << FPTR) | (1L << STRUCT) | (1L << LIST) | (1L << LPAR) | (1L << MINUS) | (1L << NOT) | (1L << BOOL_VALUE) | (1L << INTEGER) | (1L << IDENTIFIER))) != 0) );
				setState(593);
				match(END);
				setState(594);
				eol();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_declerationContext extends ParserRuleContext {
		public List_typeContext list_type() {
			return getRuleContext(List_typeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(CmmParser.IDENTIFIER, 0); }
		public List_declerationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_decleration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterList_decleration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitList_decleration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitList_decleration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_declerationContext list_decleration() throws RecognitionException {
		List_declerationContext _localctx = new List_declerationContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_list_decleration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(598);
			list_type();
			setState(599);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_typeContext extends ParserRuleContext {
		public TerminalNode LIST() { return getToken(CmmParser.LIST, 0); }
		public TerminalNode SHARP() { return getToken(CmmParser.SHARP, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterList_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitList_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitList_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_typeContext list_type() throws RecognitionException {
		List_typeContext _localctx = new List_typeContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_list_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(601);
			match(LIST);
			setState(602);
			match(SHARP);
			setState(603);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Initable_typeContext initable_type() {
			return getRuleContext(Initable_typeContext.class,0);
		}
		public Non_initable_typeContext non_initable_type() {
			return getRuleContext(Non_initable_typeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_type);
		try {
			setState(607);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRIMITIVE_TYPE:
			case FPTR:
				enterOuterAlt(_localctx, 1);
				{
				setState(605);
				initable_type();
				}
				break;
			case STRUCT:
			case LIST:
				enterOuterAlt(_localctx, 2);
				{
				setState(606);
				non_initable_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Initable_typeContext extends ParserRuleContext {
		public TerminalNode PRIMITIVE_TYPE() { return getToken(CmmParser.PRIMITIVE_TYPE, 0); }
		public Fptr_typeContext fptr_type() {
			return getRuleContext(Fptr_typeContext.class,0);
		}
		public Initable_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initable_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterInitable_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitInitable_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitInitable_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Initable_typeContext initable_type() throws RecognitionException {
		Initable_typeContext _localctx = new Initable_typeContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_initable_type);
		try {
			setState(611);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRIMITIVE_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(609);
				match(PRIMITIVE_TYPE);
				}
				break;
			case FPTR:
				enterOuterAlt(_localctx, 2);
				{
				setState(610);
				fptr_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Non_initable_typeContext extends ParserRuleContext {
		public List_typeContext list_type() {
			return getRuleContext(List_typeContext.class,0);
		}
		public Struct_typeContext struct_type() {
			return getRuleContext(Struct_typeContext.class,0);
		}
		public Non_initable_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non_initable_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterNon_initable_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitNon_initable_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitNon_initable_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Non_initable_typeContext non_initable_type() throws RecognitionException {
		Non_initable_typeContext _localctx = new Non_initable_typeContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_non_initable_type);
		try {
			setState(615);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LIST:
				enterOuterAlt(_localctx, 1);
				{
				setState(613);
				list_type();
				}
				break;
			case STRUCT:
				enterOuterAlt(_localctx, 2);
				{
				setState(614);
				struct_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EolContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(CmmParser.SEMICOLON, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public EolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterEol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitEol(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitEol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EolContext eol() throws RecognitionException {
		EolContext _localctx = new EolContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_eol);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(625);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEMICOLON:
				{
				setState(617);
				match(SEMICOLON);
				setState(621);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(618);
						match(NEWLINE);
						}
						} 
					}
					setState(623);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
				}
				}
				break;
			case NEWLINE:
				{
				setState(624);
				match(NEWLINE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 20:
			return comma_expression_sempred((Comma_expressionContext)_localctx, predIndex);
		case 21:
			return assign_expression_sempred((Assign_expressionContext)_localctx, predIndex);
		case 22:
			return or_expression_sempred((Or_expressionContext)_localctx, predIndex);
		case 23:
			return and_expression_sempred((And_expressionContext)_localctx, predIndex);
		case 24:
			return equal_expression_sempred((Equal_expressionContext)_localctx, predIndex);
		case 25:
			return relation_expression_sempred((Relation_expressionContext)_localctx, predIndex);
		case 26:
			return add_sub_expression_sempred((Add_sub_expressionContext)_localctx, predIndex);
		case 27:
			return mult_div_expression_sempred((Mult_div_expressionContext)_localctx, predIndex);
		case 29:
			return high_expression_sempred((High_expressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean comma_expression_sempred(Comma_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean assign_expression_sempred(Assign_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean or_expression_sempred(Or_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean and_expression_sempred(And_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean equal_expression_sempred(Equal_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean relation_expression_sempred(Relation_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean add_sub_expression_sempred(Add_sub_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean mult_div_expression_sempred(Mult_div_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean high_expression_sempred(High_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 4);
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\64\u0276\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\7\2d\n\2\f\2\16\2g\13\2"+
		"\3\2\7\2j\n\2\f\2\16\2m\13\2\3\2\7\2p\n\2\f\2\16\2s\13\2\3\2\7\2v\n\2"+
		"\f\2\16\2y\13\2\3\2\7\2|\n\2\f\2\16\2\177\13\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\5\3\u008c\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\7\7\u00ab\n\7\f\7\16\7\u00ae\13\7\3\7\3\7\3\7\3\7\5\7\u00b4"+
		"\n\7\3\7\5\7\u00b7\n\7\3\7\5\7\u00ba\n\7\3\b\3\b\3\b\3\b\3\b\5\b\u00c1"+
		"\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00cb\n\t\f\t\16\t\u00ce\13\t"+
		"\3\t\3\t\3\t\3\t\5\t\u00d4\n\t\3\n\3\n\5\n\u00d8\n\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\7\13\u00e2\n\13\f\13\16\13\u00e5\13\13\3\13\3"+
		"\13\5\13\u00e9\n\13\3\13\3\13\3\13\5\13\u00ee\n\13\5\13\u00f0\n\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00fe\n\f\f\f\16\f"+
		"\u0101\13\f\3\f\3\f\3\f\3\f\5\f\u0107\n\f\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\5\16\u010f\n\16\3\16\3\16\3\16\3\16\5\16\u0115\n\16\7\16\u0117\n\16\f"+
		"\16\16\16\u011a\13\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\5\20\u0124"+
		"\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\5\23\u0134\n\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\7\24\u0145\n\24\f\24\16\24\u0148\13\24\5\24"+
		"\u014a\n\24\3\24\3\24\3\25\3\25\3\25\3\25\6\25\u0152\n\25\r\25\16\25\u0153"+
		"\3\25\3\25\7\25\u0158\n\25\f\25\16\25\u015b\13\25\3\25\3\25\3\25\3\25"+
		"\5\25\u0161\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u016b\n"+
		"\26\f\26\16\26\u016e\13\26\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u0176\n"+
		"\27\f\27\16\27\u0179\13\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30"+
		"\u0183\n\30\f\30\16\30\u0186\13\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\7\31\u0190\n\31\f\31\16\31\u0193\13\31\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\7\32\u019d\n\32\f\32\16\32\u01a0\13\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\7\33\u01aa\n\33\f\33\16\33\u01ad\13\33\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\7\34\u01b7\n\34\f\34\16\34\u01ba\13"+
		"\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\7\35\u01c4\n\35\f\35\16\35"+
		"\u01c7\13\35\3\36\3\36\3\36\3\36\3\36\5\36\u01ce\n\36\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\7\37\u01e0"+
		"\n\37\f\37\16\37\u01e3\13\37\3 \3 \3 \3 \5 \u01e9\n \3!\3!\3!\3!\3!\3"+
		"!\3!\5!\u01f2\n!\3\"\3\"\3\"\7\"\u01f7\n\"\f\"\16\"\u01fa\13\"\5\"\u01fc"+
		"\n\"\3#\3#\3#\3#\3#\7#\u0203\n#\f#\16#\u0206\13#\3#\3#\3#\3#\3$\3$\5$"+
		"\u020e\n$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u021a\n%\3&\3&\3&\3\'\6\'\u0220"+
		"\n\'\r\'\16\'\u0221\3(\3(\3(\3(\5(\u0228\n(\3)\3)\3)\3)\3)\3)\3)\3)\3"+
		")\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\6*\u023d\n*\r*\16*\u023e\3*\3*\3*\5*\u0244"+
		"\n*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\6+\u0250\n+\r+\16+\u0251\3+\3+\3+\5"+
		"+\u0257\n+\3,\3,\3,\3-\3-\3-\3-\3.\3.\5.\u0262\n.\3/\3/\5/\u0266\n/\3"+
		"\60\3\60\5\60\u026a\n\60\3\61\3\61\7\61\u026e\n\61\f\61\16\61\u0271\13"+
		"\61\3\61\5\61\u0274\n\61\3\61\2\13*,.\60\62\64\668<\62\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`\2"+
		"\6\3\2%&\3\2 !\3\2\"#\4\2!!))\2\u028c\2e\3\2\2\2\4\u008b\3\2\2\2\6\u008d"+
		"\3\2\2\2\b\u0093\3\2\2\2\n\u0099\3\2\2\2\f\u00a1\3\2\2\2\16\u00c0\3\2"+
		"\2\2\20\u00c2\3\2\2\2\22\u00d7\3\2\2\2\24\u00d9\3\2\2\2\26\u00f4\3\2\2"+
		"\2\30\u0108\3\2\2\2\32\u010a\3\2\2\2\34\u011b\3\2\2\2\36\u0120\3\2\2\2"+
		" \u0125\3\2\2\2\"\u012b\3\2\2\2$\u0133\3\2\2\2&\u013a\3\2\2\2(\u0160\3"+
		"\2\2\2*\u0162\3\2\2\2,\u016f\3\2\2\2.\u017a\3\2\2\2\60\u0187\3\2\2\2\62"+
		"\u0194\3\2\2\2\64\u01a1\3\2\2\2\66\u01ae\3\2\2\28\u01bb\3\2\2\2:\u01cd"+
		"\3\2\2\2<\u01cf\3\2\2\2>\u01e8\3\2\2\2@\u01f1\3\2\2\2B\u01fb\3\2\2\2D"+
		"\u01fd\3\2\2\2F\u020d\3\2\2\2H\u020f\3\2\2\2J\u021b\3\2\2\2L\u021f\3\2"+
		"\2\2N\u0227\3\2\2\2P\u0229\3\2\2\2R\u0232\3\2\2\2T\u0245\3\2\2\2V\u0258"+
		"\3\2\2\2X\u025b\3\2\2\2Z\u0261\3\2\2\2\\\u0265\3\2\2\2^\u0269\3\2\2\2"+
		"`\u0273\3\2\2\2bd\7\64\2\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fk\3"+
		"\2\2\2ge\3\2\2\2hj\5H%\2ih\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2lq\3\2"+
		"\2\2mk\3\2\2\2np\7\64\2\2on\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2rw\3"+
		"\2\2\2sq\3\2\2\2tv\5$\23\2ut\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x}\3"+
		"\2\2\2yw\3\2\2\2z|\7\64\2\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2"+
		"~\u0080\3\2\2\2\177}\3\2\2\2\u0080\u0081\5\"\22\2\u0081\3\3\2\2\2\u0082"+
		"\u008c\5\f\7\2\u0083\u008c\5\22\n\2\u0084\u008c\5 \21\2\u0085\u008c\5"+
		"\32\16\2\u0086\u008c\5\36\20\2\u0087\u008c\5,\27\2\u0088\u008c\5\6\4\2"+
		"\u0089\u008c\5\b\5\2\u008a\u008c\5\n\6\2\u008b\u0082\3\2\2\2\u008b\u0083"+
		"\3\2\2\2\u008b\u0084\3\2\2\2\u008b\u0085\3\2\2\2\u008b\u0086\3\2\2\2\u008b"+
		"\u0087\3\2\2\2\u008b\u0088\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008a\3\2"+
		"\2\2\u008c\5\3\2\2\2\u008d\u008e\7\r\2\2\u008e\u008f\b\4\1\2\u008f\u0090"+
		"\7\25\2\2\u0090\u0091\5\30\r\2\u0091\u0092\7\26\2\2\u0092\7\3\2\2\2\u0093"+
		"\u0094\7\17\2\2\u0094\u0095\b\5\1\2\u0095\u0096\7\25\2\2\u0096\u0097\5"+
		"\30\r\2\u0097\u0098\7\26\2\2\u0098\t\3\2\2\2\u0099\u009a\7\16\2\2\u009a"+
		"\u009b\b\6\1\2\u009b\u009c\7\25\2\2\u009c\u009d\5\30\r\2\u009d\u009e\7"+
		"\34\2\2\u009e\u009f\5\30\r\2\u009f\u00a0\7\26\2\2\u00a0\13\3\2\2\2\u00a1"+
		"\u00a2\7\7\2\2\u00a2\u00a3\b\7\1\2\u00a3\u00b3\5\16\b\2\u00a4\u00a5\7"+
		"\4\2\2\u00a5\u00a6\5\4\3\2\u00a6\u00ac\5`\61\2\u00a7\u00a8\5\4\3\2\u00a8"+
		"\u00a9\5`\61\2\u00a9\u00ab\3\2\2\2\u00aa\u00a7\3\2\2\2\u00ab\u00ae\3\2"+
		"\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00af\3\2\2\2\u00ae"+
		"\u00ac\3\2\2\2\u00af\u00b0\7\5\2\2\u00b0\u00b4\3\2\2\2\u00b1\u00b2\7\64"+
		"\2\2\u00b2\u00b4\5\4\3\2\u00b3\u00a4\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4"+
		"\u00b9\3\2\2\2\u00b5\u00b7\5`\61\2\u00b6\u00b5\3\2\2\2\u00b6\u00b7\3\2"+
		"\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00ba\5\20\t\2\u00b9\u00b6\3\2\2\2\u00b9"+
		"\u00ba\3\2\2\2\u00ba\r\3\2\2\2\u00bb\u00bc\7\25\2\2\u00bc\u00bd\5*\26"+
		"\2\u00bd\u00be\7\26\2\2\u00be\u00c1\3\2\2\2\u00bf\u00c1\5*\26\2\u00c0"+
		"\u00bb\3\2\2\2\u00c0\u00bf\3\2\2\2\u00c1\17\3\2\2\2\u00c2\u00c3\7\b\2"+
		"\2\u00c3\u00d3\b\t\1\2\u00c4\u00c5\7\4\2\2\u00c5\u00c6\5\4\3\2\u00c6\u00cc"+
		"\5`\61\2\u00c7\u00c8\5\4\3\2\u00c8\u00c9\5`\61\2\u00c9\u00cb\3\2\2\2\u00ca"+
		"\u00c7\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2"+
		"\2\2\u00cd\u00cf\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d0\7\5\2\2\u00d0"+
		"\u00d4\3\2\2\2\u00d1\u00d2\7\64\2\2\u00d2\u00d4\5\4\3\2\u00d3\u00c4\3"+
		"\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\21\3\2\2\2\u00d5\u00d8\5\26\f\2\u00d6"+
		"\u00d8\5\24\13\2\u00d7\u00d5\3\2\2\2\u00d7\u00d6\3\2\2\2\u00d8\23\3\2"+
		"\2\2\u00d9\u00da\7\n\2\2\u00da\u00ef\b\13\1\2\u00db\u00dc\7\4\2\2\u00dc"+
		"\u00dd\5\4\3\2\u00dd\u00e3\5`\61\2\u00de\u00df\5\4\3\2\u00df\u00e0\5`"+
		"\61\2\u00e0\u00e2\3\2\2\2\u00e1\u00de\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3"+
		"\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e6\3\2\2\2\u00e5\u00e3\3\2"+
		"\2\2\u00e6\u00e8\7\5\2\2\u00e7\u00e9\5`\61\2\u00e8\u00e7\3\2\2\2\u00e8"+
		"\u00e9\3\2\2\2\u00e9\u00f0\3\2\2\2\u00ea\u00eb\7\64\2\2\u00eb\u00ed\5"+
		"\4\3\2\u00ec\u00ee\5`\61\2\u00ed\u00ec\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee"+
		"\u00f0\3\2\2\2\u00ef\u00db\3\2\2\2\u00ef\u00ea\3\2\2\2\u00f0\u00f1\3\2"+
		"\2\2\u00f1\u00f2\7\t\2\2\u00f2\u00f3\5\16\b\2\u00f3\25\3\2\2\2\u00f4\u00f5"+
		"\7\t\2\2\u00f5\u00f6\b\f\1\2\u00f6\u0106\5\16\b\2\u00f7\u00f8\7\4\2\2"+
		"\u00f8\u00f9\5\4\3\2\u00f9\u00ff\5`\61\2\u00fa\u00fb\5\4\3\2\u00fb\u00fc"+
		"\5`\61\2\u00fc\u00fe\3\2\2\2\u00fd\u00fa\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff"+
		"\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0102\3\2\2\2\u0101\u00ff\3\2"+
		"\2\2\u0102\u0103\7\5\2\2\u0103\u0107\3\2\2\2\u0104\u0105\7\64\2\2\u0105"+
		"\u0107\5\4\3\2\u0106\u00f7\3\2\2\2\u0106\u0104\3\2\2\2\u0107\27\3\2\2"+
		"\2\u0108\u0109\5*\26\2\u0109\31\3\2\2\2\u010a\u010e\5Z.\2\u010b\u010c"+
		"\7-\2\2\u010c\u010f\b\16\1\2\u010d\u010f\5\34\17\2\u010e\u010b\3\2\2\2"+
		"\u010e\u010d\3\2\2\2\u010f\u0118\3\2\2\2\u0110\u0114\7\34\2\2\u0111\u0115"+
		"\5\34\17\2\u0112\u0113\7-\2\2\u0113\u0115\b\16\1\2\u0114\u0111\3\2\2\2"+
		"\u0114\u0112\3\2\2\2\u0115\u0117\3\2\2\2\u0116\u0110\3\2\2\2\u0117\u011a"+
		"\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\33\3\2\2\2\u011a"+
		"\u0118\3\2\2\2\u011b\u011c\7-\2\2\u011c\u011d\b\17\1\2\u011d\u011e\7*"+
		"\2\2\u011e\u011f\5*\26\2\u011f\35\3\2\2\2\u0120\u0121\7\6\2\2\u0121\u0123"+
		"\b\20\1\2\u0122\u0124\5*\26\2\u0123\u0122\3\2\2\2\u0123\u0124\3\2\2\2"+
		"\u0124\37\3\2\2\2\u0125\u0126\5\30\r\2\u0126\u0127\7\25\2\2\u0127\u0128"+
		"\5B\"\2\u0128\u0129\7\26\2\2\u0129\u012a\b\21\1\2\u012a!\3\2\2\2\u012b"+
		"\u012c\7\3\2\2\u012c\u012d\b\22\1\2\u012d\u012e\7\25\2\2\u012e\u012f\7"+
		"\26\2\2\u012f\u0130\5(\25\2\u0130#\3\2\2\2\u0131\u0134\5Z.\2\u0132\u0134"+
		"\7\24\2\2\u0133\u0131\3\2\2\2\u0133\u0132\3\2\2\2\u0134\u0135\3\2\2\2"+
		"\u0135\u0136\7-\2\2\u0136\u0137\b\23\1\2\u0137\u0138\5&\24\2\u0138\u0139"+
		"\5(\25\2\u0139%\3\2\2\2\u013a\u0149\7\25\2\2\u013b\u014a\3\2\2\2\u013c"+
		"\u013d\5Z.\2\u013d\u013e\7-\2\2\u013e\u0146\b\24\1\2\u013f\u0140\7\34"+
		"\2\2\u0140\u0141\5Z.\2\u0141\u0142\7-\2\2\u0142\u0143\b\24\1\2\u0143\u0145"+
		"\3\2\2\2\u0144\u013f\3\2\2\2\u0145\u0148\3\2\2\2\u0146\u0144\3\2\2\2\u0146"+
		"\u0147\3\2\2\2\u0147\u014a\3\2\2\2\u0148\u0146\3\2\2\2\u0149\u013b\3\2"+
		"\2\2\u0149\u013c\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014c\7\26\2\2\u014c"+
		"\'\3\2\2\2\u014d\u0151\7\4\2\2\u014e\u014f\5\4\3\2\u014f\u0150\5`\61\2"+
		"\u0150\u0152\3\2\2\2\u0151\u014e\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0151"+
		"\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0159\7\5\2\2\u0156"+
		"\u0158\7\64\2\2\u0157\u0156\3\2\2\2\u0158\u015b\3\2\2\2\u0159\u0157\3"+
		"\2\2\2\u0159\u015a\3\2\2\2\u015a\u0161\3\2\2\2\u015b\u0159\3\2\2\2\u015c"+
		"\u015d\7\64\2\2\u015d\u015e\5\4\3\2\u015e\u015f\5`\61\2\u015f\u0161\3"+
		"\2\2\2\u0160\u014d\3\2\2\2\u0160\u015c\3\2\2\2\u0161)\3\2\2\2\u0162\u0163"+
		"\b\26\1\2\u0163\u0164\5,\27\2\u0164\u016c\3\2\2\2\u0165\u0166\f\4\2\2"+
		"\u0166\u0167\7\34\2\2\u0167\u0168\5,\27\2\u0168\u0169\b\26\1\2\u0169\u016b"+
		"\3\2\2\2\u016a\u0165\3\2\2\2\u016b\u016e\3\2\2\2\u016c\u016a\3\2\2\2\u016c"+
		"\u016d\3\2\2\2\u016d+\3\2\2\2\u016e\u016c\3\2\2\2\u016f\u0170\b\27\1\2"+
		"\u0170\u0171\5.\30\2\u0171\u0177\3\2\2\2\u0172\u0173\f\4\2\2\u0173\u0174"+
		"\7*\2\2\u0174\u0176\5.\30\2\u0175\u0172\3\2\2\2\u0176\u0179\3\2\2\2\u0177"+
		"\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178-\3\2\2\2\u0179\u0177\3\2\2\2"+
		"\u017a\u017b\b\30\1\2\u017b\u017c\5\60\31\2\u017c\u0184\3\2\2\2\u017d"+
		"\u017e\f\4\2\2\u017e\u017f\7(\2\2\u017f\u0180\5\60\31\2\u0180\u0181\b"+
		"\30\1\2\u0181\u0183\3\2\2\2\u0182\u017d\3\2\2\2\u0183\u0186\3\2\2\2\u0184"+
		"\u0182\3\2\2\2\u0184\u0185\3\2\2\2\u0185/\3\2\2\2\u0186\u0184\3\2\2\2"+
		"\u0187\u0188\b\31\1\2\u0188\u0189\5\62\32\2\u0189\u0191\3\2\2\2\u018a"+
		"\u018b\f\4\2\2\u018b\u018c\7\'\2\2\u018c\u018d\5\62\32\2\u018d\u018e\b"+
		"\31\1\2\u018e\u0190\3\2\2\2\u018f\u018a\3\2\2\2\u0190\u0193\3\2\2\2\u0191"+
		"\u018f\3\2\2\2\u0191\u0192\3\2\2\2\u0192\61\3\2\2\2\u0193\u0191\3\2\2"+
		"\2\u0194\u0195\b\32\1\2\u0195\u0196\5\64\33\2\u0196\u019e\3\2\2\2\u0197"+
		"\u0198\f\4\2\2\u0198\u0199\7$\2\2\u0199\u019a\5\64\33\2\u019a\u019b\b"+
		"\32\1\2\u019b\u019d\3\2\2\2\u019c\u0197\3\2\2\2\u019d\u01a0\3\2\2\2\u019e"+
		"\u019c\3\2\2\2\u019e\u019f\3\2\2\2\u019f\63\3\2\2\2\u01a0\u019e\3\2\2"+
		"\2\u01a1\u01a2\b\33\1\2\u01a2\u01a3\5\66\34\2\u01a3\u01ab\3\2\2\2\u01a4"+
		"\u01a5\f\4\2\2\u01a5\u01a6\t\2\2\2\u01a6\u01a7\5\66\34\2\u01a7\u01a8\b"+
		"\33\1\2\u01a8\u01aa\3\2\2\2\u01a9\u01a4\3\2\2\2\u01aa\u01ad\3\2\2\2\u01ab"+
		"\u01a9\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\65\3\2\2\2\u01ad\u01ab\3\2\2"+
		"\2\u01ae\u01af\b\34\1\2\u01af\u01b0\58\35\2\u01b0\u01b8\3\2\2\2\u01b1"+
		"\u01b2\f\4\2\2\u01b2\u01b3\t\3\2\2\u01b3\u01b4\58\35\2\u01b4\u01b5\b\34"+
		"\1\2\u01b5\u01b7\3\2\2\2\u01b6\u01b1\3\2\2\2\u01b7\u01ba\3\2\2\2\u01b8"+
		"\u01b6\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9\67\3\2\2\2\u01ba\u01b8\3\2\2"+
		"\2\u01bb\u01bc\b\35\1\2\u01bc\u01bd\5:\36\2\u01bd\u01c5\3\2\2\2\u01be"+
		"\u01bf\f\4\2\2\u01bf\u01c0\t\4\2\2\u01c0\u01c1\5:\36\2\u01c1\u01c2\b\35"+
		"\1\2\u01c2\u01c4\3\2\2\2\u01c3\u01be\3\2\2\2\u01c4\u01c7\3\2\2\2\u01c5"+
		"\u01c3\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c69\3\2\2\2\u01c7\u01c5\3\2\2\2"+
		"\u01c8\u01c9\t\5\2\2\u01c9\u01ca\5<\37\2\u01ca\u01cb\b\36\1\2\u01cb\u01ce"+
		"\3\2\2\2\u01cc\u01ce\5<\37\2\u01cd\u01c8\3\2\2\2\u01cd\u01cc\3\2\2\2\u01ce"+
		";\3\2\2\2\u01cf\u01d0\b\37\1\2\u01d0\u01d1\5> \2\u01d1\u01e1\3\2\2\2\u01d2"+
		"\u01d3\f\6\2\2\u01d3\u01d4\7\35\2\2\u01d4\u01e0\5> \2\u01d5\u01d6\f\5"+
		"\2\2\u01d6\u01d7\7\27\2\2\u01d7\u01d8\5*\26\2\u01d8\u01d9\7\30\2\2\u01d9"+
		"\u01e0\3\2\2\2\u01da\u01db\f\4\2\2\u01db\u01dc\7\25\2\2\u01dc\u01dd\5"+
		"B\"\2\u01dd\u01de\7\26\2\2\u01de\u01e0\3\2\2\2\u01df\u01d2\3\2\2\2\u01df"+
		"\u01d5\3\2\2\2\u01df\u01da\3\2\2\2\u01e0\u01e3\3\2\2\2\u01e1\u01df\3\2"+
		"\2\2\u01e1\u01e2\3\2\2\2\u01e2=\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e4\u01e9"+
		"\5\6\4\2\u01e5\u01e9\5\b\5\2\u01e6\u01e9\5\n\6\2\u01e7\u01e9\5@!\2\u01e8"+
		"\u01e4\3\2\2\2\u01e8\u01e5\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e8\u01e7\3\2"+
		"\2\2\u01e9?\3\2\2\2\u01ea\u01f2\7,\2\2\u01eb\u01f2\7+\2\2\u01ec\u01f2"+
		"\7-\2\2\u01ed\u01ee\7\25\2\2\u01ee\u01ef\5*\26\2\u01ef\u01f0\7\26\2\2"+
		"\u01f0\u01f2\3\2\2\2\u01f1\u01ea\3\2\2\2\u01f1\u01eb\3\2\2\2\u01f1\u01ec"+
		"\3\2\2\2\u01f1\u01ed\3\2\2\2\u01f2A\3\2\2\2\u01f3\u01f8\5.\30\2\u01f4"+
		"\u01f5\7\34\2\2\u01f5\u01f7\5.\30\2\u01f6\u01f4\3\2\2\2\u01f7\u01fa\3"+
		"\2\2\2\u01f8\u01f6\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9\u01fc\3\2\2\2\u01fa"+
		"\u01f8\3\2\2\2\u01fb\u01f3\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fcC\3\2\2\2"+
		"\u01fd\u01fe\7\21\2\2\u01fe\u01ff\7&\2\2\u01ff\u0204\5F$\2\u0200\u0201"+
		"\7\34\2\2\u0201\u0203\5F$\2\u0202\u0200\3\2\2\2\u0203\u0206\3\2\2\2\u0204"+
		"\u0202\3\2\2\2\u0204\u0205\3\2\2\2\u0205\u0207\3\2\2\2\u0206\u0204\3\2"+
		"\2\2\u0207\u0208\7\37\2\2\u0208\u0209\5F$\2\u0209\u020a\7%\2\2\u020aE"+
		"\3\2\2\2\u020b\u020e\5Z.\2\u020c\u020e\7\24\2\2\u020d\u020b\3\2\2\2\u020d"+
		"\u020c\3\2\2\2\u020eG\3\2\2\2\u020f\u0210\7\22\2\2\u0210\u0211\7-\2\2"+
		"\u0211\u0219\b%\1\2\u0212\u0213\7\4\2\2\u0213\u0214\5L\'\2\u0214\u0215"+
		"\7\5\2\2\u0215\u0216\7\64\2\2\u0216\u021a\3\2\2\2\u0217\u0218\7\64\2\2"+
		"\u0218\u021a\5N(\2\u0219\u0212\3\2\2\2\u0219\u0217\3\2\2\2\u021aI\3\2"+
		"\2\2\u021b\u021c\7\22\2\2\u021c\u021d\7-\2\2\u021dK\3\2\2\2\u021e\u0220"+
		"\5N(\2\u021f\u021e\3\2\2\2\u0220\u0221\3\2\2\2\u0221\u021f\3\2\2\2\u0221"+
		"\u0222\3\2\2\2\u0222M\3\2\2\2\u0223\u0224\5\32\16\2\u0224\u0225\5`\61"+
		"\2\u0225\u0228\3\2\2\2\u0226\u0228\5P)\2\u0227\u0223\3\2\2\2\u0227\u0226"+
		"\3\2\2\2\u0228O\3\2\2\2\u0229\u022a\5Z.\2\u022a\u022b\7-\2\2\u022b\u022c"+
		"\5&\24\2\u022c\u022d\7\4\2\2\u022d\u022e\5R*\2\u022e\u022f\5T+\2\u022f"+
		"\u0230\7\5\2\2\u0230\u0231\5`\61\2\u0231Q\3\2\2\2\u0232\u0233\7\f\2\2"+
		"\u0233\u0243\b*\1\2\u0234\u0235\7\64\2\2\u0235\u0236\5\4\3\2\u0236\u0237"+
		"\5`\61\2\u0237\u0244\3\2\2\2\u0238\u023c\7\4\2\2\u0239\u023a\5\4\3\2\u023a"+
		"\u023b\5`\61\2\u023b\u023d\3\2\2\2\u023c\u0239\3\2\2\2\u023d\u023e\3\2"+
		"\2\2\u023e\u023c\3\2\2\2\u023e\u023f\3\2\2\2\u023f\u0240\3\2\2\2\u0240"+
		"\u0241\7\5\2\2\u0241\u0242\5`\61\2\u0242\u0244\3\2\2\2\u0243\u0234\3\2"+
		"\2\2\u0243\u0238\3\2\2\2\u0244S\3\2\2\2\u0245\u0246\7\13\2\2\u0246\u0256"+
		"\b+\1\2\u0247\u0248\7\64\2\2\u0248\u0249\5\4\3\2\u0249\u024a\5`\61\2\u024a"+
		"\u0257\3\2\2\2\u024b\u024f\7\4\2\2\u024c\u024d\5\4\3\2\u024d\u024e\5`"+
		"\61\2\u024e\u0250\3\2\2\2\u024f\u024c\3\2\2\2\u0250\u0251\3\2\2\2\u0251"+
		"\u024f\3\2\2\2\u0251\u0252\3\2\2\2\u0252\u0253\3\2\2\2\u0253\u0254\7\5"+
		"\2\2\u0254\u0255\5`\61\2\u0255\u0257\3\2\2\2\u0256\u0247\3\2\2\2\u0256"+
		"\u024b\3\2\2\2\u0257U\3\2\2\2\u0258\u0259\5X-\2\u0259\u025a\7-\2\2\u025a"+
		"W\3\2\2\2\u025b\u025c\7\23\2\2\u025c\u025d\7\33\2\2\u025d\u025e\5Z.\2"+
		"\u025eY\3\2\2\2\u025f\u0262\5\\/\2\u0260\u0262\5^\60\2\u0261\u025f\3\2"+
		"\2\2\u0261\u0260\3\2\2\2\u0262[\3\2\2\2\u0263\u0266\7\20\2\2\u0264\u0266"+
		"\5D#\2\u0265\u0263\3\2\2\2\u0265\u0264\3\2\2\2\u0266]\3\2\2\2\u0267\u026a"+
		"\5X-\2\u0268\u026a\5J&\2\u0269\u0267\3\2\2\2\u0269\u0268\3\2\2\2\u026a"+
		"_\3\2\2\2\u026b\u026f\7\36\2\2\u026c\u026e\7\64\2\2\u026d\u026c\3\2\2"+
		"\2\u026e\u0271\3\2\2\2\u026f\u026d\3\2\2\2\u026f\u0270\3\2\2\2\u0270\u0274"+
		"\3\2\2\2\u0271\u026f\3\2\2\2\u0272\u0274\7\64\2\2\u0273\u026b\3\2\2\2"+
		"\u0273\u0272\3\2\2\2\u0274a\3\2\2\2=ekqw}\u008b\u00ac\u00b3\u00b6\u00b9"+
		"\u00c0\u00cc\u00d3\u00d7\u00e3\u00e8\u00ed\u00ef\u00ff\u0106\u010e\u0114"+
		"\u0118\u0123\u0133\u0146\u0149\u0153\u0159\u0160\u016c\u0177\u0184\u0191"+
		"\u019e\u01ab\u01b8\u01c5\u01cd\u01df\u01e1\u01e8\u01f1\u01f8\u01fb\u0204"+
		"\u020d\u0219\u0221\u0227\u023e\u0243\u0251\u0256\u0261\u0265\u0269\u026f"+
		"\u0273";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}