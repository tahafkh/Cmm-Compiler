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
		RULE_cmm = 0, RULE_statement = 1, RULE_display_statement = 2, RULE_size_statement = 3, 
		RULE_append_statement = 4, RULE_conditional_statement = 5, RULE_condition = 6, 
		RULE_else_statement = 7, RULE_loop_statement = 8, RULE_do_while_loop = 9, 
		RULE_while_loop = 10, RULE_function_call_statement = 11, RULE_expression_statement = 12, 
		RULE_declare_statement = 13, RULE_return_statement = 14, RULE_main = 15, 
		RULE_function_decleration = 16, RULE_arguments = 17, RULE_func_body = 18, 
		RULE_expression = 19, RULE_value = 20, RULE_variable = 21, RULE_extra_parantheses = 22, 
		RULE_list_refrence = 23, RULE_method_call = 24, RULE_parameters = 25, 
		RULE_dot_refrence = 26, RULE_bracket_indexing = 27, RULE_fptr_decleration = 28, 
		RULE_fptr_type = 29, RULE_function_type = 30, RULE_struct_decleration = 31, 
		RULE_struct_type = 32, RULE_struct_init = 33, RULE_set_get = 34, RULE_setter = 35, 
		RULE_getter = 36, RULE_list_decleration = 37, RULE_list_type = 38, RULE_type = 39, 
		RULE_initable_type = 40, RULE_non_initable_type = 41, RULE_eol = 42;
	private static String[] makeRuleNames() {
		return new String[] {
			"cmm", "statement", "display_statement", "size_statement", "append_statement", 
			"conditional_statement", "condition", "else_statement", "loop_statement", 
			"do_while_loop", "while_loop", "function_call_statement", "expression_statement", 
			"declare_statement", "return_statement", "main", "function_decleration", 
			"arguments", "func_body", "expression", "value", "variable", "extra_parantheses", 
			"list_refrence", "method_call", "parameters", "dot_refrence", "bracket_indexing", 
			"fptr_decleration", "fptr_type", "function_type", "struct_decleration", 
			"struct_type", "struct_init", "set_get", "setter", "getter", "list_decleration", 
			"list_type", "type", "initable_type", "non_initable_type", "eol"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'main'", null, null, "'return'", "'if'", "'else'", "'while'", 
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
			setState(89);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(86);
					match(NEWLINE);
					}
					} 
				}
				setState(91);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(95);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(92);
					struct_decleration();
					}
					} 
				}
				setState(97);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(101);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(98);
					match(NEWLINE);
					}
					} 
				}
				setState(103);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRIMITIVE_TYPE) | (1L << FPTR) | (1L << STRUCT) | (1L << LIST) | (1L << VOID))) != 0)) {
				{
				{
				setState(104);
				function_decleration();
				}
				}
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(110);
				match(NEWLINE);
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(116);
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
		public Expression_statementContext expression_statement() {
			return getRuleContext(Expression_statementContext.class,0);
		}
		public Display_statementContext display_statement() {
			return getRuleContext(Display_statementContext.class,0);
		}
		public Size_statementContext size_statement() {
			return getRuleContext(Size_statementContext.class,0);
		}
		public Append_statementContext append_statement() {
			return getRuleContext(Append_statementContext.class,0);
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
			setState(127);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				conditional_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(119);
				loop_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(120);
				function_call_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(121);
				declare_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(122);
				return_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(123);
				expression_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(124);
				display_statement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(125);
				size_statement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(126);
				append_statement();
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

	public static class Display_statementContext extends ParserRuleContext {
		public TerminalNode DISPLAY() { return getToken(CmmParser.DISPLAY, 0); }
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public EolContext eol() {
			return getRuleContext(EolContext.class,0);
		}
		public Display_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_display_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterDisplay_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitDisplay_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitDisplay_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Display_statementContext display_statement() throws RecognitionException {
		Display_statementContext _localctx = new Display_statementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_display_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(DISPLAY);
			System.out.println("Built-in : display");
			setState(131);
			match(LPAR);
			setState(132);
			expression(0);
			setState(133);
			match(RPAR);
			setState(134);
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

	public static class Size_statementContext extends ParserRuleContext {
		public TerminalNode SIZE() { return getToken(CmmParser.SIZE, 0); }
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(CmmParser.IDENTIFIER, 0); }
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public EolContext eol() {
			return getRuleContext(EolContext.class,0);
		}
		public Size_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_size_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterSize_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitSize_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitSize_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Size_statementContext size_statement() throws RecognitionException {
		Size_statementContext _localctx = new Size_statementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_size_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(SIZE);
			System.out.println("Size");
			setState(138);
			match(LPAR);
			setState(139);
			match(IDENTIFIER);
			setState(140);
			match(RPAR);
			setState(141);
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

	public static class Append_statementContext extends ParserRuleContext {
		public TerminalNode APPEND() { return getToken(CmmParser.APPEND, 0); }
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(CmmParser.IDENTIFIER, 0); }
		public TerminalNode COMMA() { return getToken(CmmParser.COMMA, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public EolContext eol() {
			return getRuleContext(EolContext.class,0);
		}
		public Append_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_append_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterAppend_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitAppend_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitAppend_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Append_statementContext append_statement() throws RecognitionException {
		Append_statementContext _localctx = new Append_statementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_append_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(APPEND);
			System.out.println("Append");
			setState(145);
			match(LPAR);
			setState(146);
			match(IDENTIFIER);
			setState(147);
			match(COMMA);
			setState(148);
			expression(0);
			setState(149);
			match(RPAR);
			setState(150);
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

	public static class Conditional_statementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(CmmParser.IF, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(CmmParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(CmmParser.END, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Else_statementContext else_statement() {
			return getRuleContext(Else_statementContext.class,0);
		}
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
			setState(152);
			match(IF);
			System.out.println("Conditional : if");
			setState(154);
			condition();
			setState(155);
			match(BEGIN);
			setState(157); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(156);
				statement();
				}
				}
				setState(159); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << IF) | (1L << WHILE) | (1L << DO) | (1L << DISPLAY) | (1L << APPEND) | (1L << SIZE) | (1L << PRIMITIVE_TYPE) | (1L << FPTR) | (1L << STRUCT) | (1L << LIST) | (1L << LPAR) | (1L << MINUS) | (1L << NOT) | (1L << BOOL_VALUE) | (1L << INTEGER) | (1L << IDENTIFIER))) != 0) );
			setState(161);
			match(END);
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(162);
				else_statement();
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

	public static class ConditionContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(165);
				match(LPAR);
				setState(166);
				expression(0);
				setState(167);
				match(RPAR);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				expression(0);
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
		public TerminalNode END() { return getToken(CmmParser.END, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
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
			setState(172);
			match(ELSE);
			setState(173);
			match(BEGIN);
			System.out.println("Conditional:else");
			setState(176); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(175);
				statement();
				}
				}
				setState(178); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << IF) | (1L << WHILE) | (1L << DO) | (1L << DISPLAY) | (1L << APPEND) | (1L << SIZE) | (1L << PRIMITIVE_TYPE) | (1L << FPTR) | (1L << STRUCT) | (1L << LIST) | (1L << LPAR) | (1L << MINUS) | (1L << NOT) | (1L << BOOL_VALUE) | (1L << INTEGER) | (1L << IDENTIFIER))) != 0) );
			setState(180);
			match(END);
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
			setState(184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHILE:
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				while_loop();
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
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
		public EolContext eol() {
			return getRuleContext(EolContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode BEGIN() { return getToken(CmmParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(CmmParser.END, 0); }
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
			setState(186);
			match(DO);
			System.out.println("Loop : do...while");
			setState(197);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BEGIN:
				{
				{
				setState(188);
				match(BEGIN);
				setState(190); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(189);
					statement();
					}
					}
					setState(192); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << IF) | (1L << WHILE) | (1L << DO) | (1L << DISPLAY) | (1L << APPEND) | (1L << SIZE) | (1L << PRIMITIVE_TYPE) | (1L << FPTR) | (1L << STRUCT) | (1L << LIST) | (1L << LPAR) | (1L << MINUS) | (1L << NOT) | (1L << BOOL_VALUE) | (1L << INTEGER) | (1L << IDENTIFIER))) != 0) );
				setState(194);
				match(END);
				}
				}
				break;
			case RETURN:
			case IF:
			case WHILE:
			case DO:
			case DISPLAY:
			case APPEND:
			case SIZE:
			case PRIMITIVE_TYPE:
			case FPTR:
			case STRUCT:
			case LIST:
			case LPAR:
			case MINUS:
			case NOT:
			case BOOL_VALUE:
			case INTEGER:
			case IDENTIFIER:
				{
				setState(196);
				statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(199);
			match(WHILE);
			setState(200);
			condition();
			setState(201);
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

	public static class While_loopContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(CmmParser.WHILE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode BEGIN() { return getToken(CmmParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(CmmParser.END, 0); }
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
			setState(203);
			match(WHILE);
			setState(204);
			condition();
			System.out.println("Loop : while");
			setState(215);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BEGIN:
				{
				{
				setState(206);
				match(BEGIN);
				setState(208); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(207);
					statement();
					}
					}
					setState(210); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << IF) | (1L << WHILE) | (1L << DO) | (1L << DISPLAY) | (1L << APPEND) | (1L << SIZE) | (1L << PRIMITIVE_TYPE) | (1L << FPTR) | (1L << STRUCT) | (1L << LIST) | (1L << LPAR) | (1L << MINUS) | (1L << NOT) | (1L << BOOL_VALUE) | (1L << INTEGER) | (1L << IDENTIFIER))) != 0) );
				setState(212);
				match(END);
				}
				}
				break;
			case RETURN:
			case IF:
			case WHILE:
			case DO:
			case DISPLAY:
			case APPEND:
			case SIZE:
			case PRIMITIVE_TYPE:
			case FPTR:
			case STRUCT:
			case LIST:
			case LPAR:
			case MINUS:
			case NOT:
			case BOOL_VALUE:
			case INTEGER:
			case IDENTIFIER:
				{
				setState(214);
				statement();
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

	public static class Function_call_statementContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public EolContext eol() {
			return getRuleContext(EolContext.class,0);
		}
		public List<Extra_paranthesesContext> extra_parantheses() {
			return getRuleContexts(Extra_paranthesesContext.class);
		}
		public Extra_paranthesesContext extra_parantheses(int i) {
			return getRuleContext(Extra_paranthesesContext.class,i);
		}
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
		enterRule(_localctx, 22, RULE_function_call_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			variable();
			System.out.println("FunctionCall");
			setState(220); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(219);
				extra_parantheses();
				}
				}
				setState(222); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LPAR );
			setState(224);
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

	public static class Expression_statementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public EolContext eol() {
			return getRuleContext(EolContext.class,0);
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
		enterRule(_localctx, 24, RULE_expression_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			expression(0);
			setState(227);
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

	public static class Declare_statementContext extends ParserRuleContext {
		public Token IDENTIFIER;
		public EolContext eol() {
			return getRuleContext(EolContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(CmmParser.IDENTIFIER, 0); }
		public Initable_typeContext initable_type() {
			return getRuleContext(Initable_typeContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(CmmParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		enterRule(_localctx, 26, RULE_declare_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				{
				setState(229);
				type();
				setState(230);
				((Declare_statementContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				}
				}
				break;
			case 2:
				{
				{
				setState(232);
				initable_type();
				setState(233);
				((Declare_statementContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				setState(234);
				match(ASSIGN);
				setState(235);
				expression(0);
				}
				}
				break;
			}
			setState(239);
			eol();
			System.out.println("VarDec:" + ((Declare_statementContext)_localctx).IDENTIFIER.getText());
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public EolContext eol() {
			return getRuleContext(EolContext.class,0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(RETURN);
			System.out.println("Return");
			setState(244);
			expression(0);
			setState(245);
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
		enterRule(_localctx, 30, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(MAIN);
			setState(248);
			match(LPAR);
			setState(249);
			match(RPAR);
			setState(250);
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
		enterRule(_localctx, 32, RULE_function_decleration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRIMITIVE_TYPE:
			case FPTR:
			case STRUCT:
			case LIST:
				{
				setState(252);
				type();
				}
				break;
			case VOID:
				{
				setState(253);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(256);
			match(IDENTIFIER);
			setState(257);
			arguments();
			setState(258);
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
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
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
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
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
		enterRule(_localctx, 34, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(LPAR);
			setState(261);
			type();
			setState(262);
			match(IDENTIFIER);
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(263);
				match(COMMA);
				setState(264);
				type();
				setState(265);
				match(IDENTIFIER);
				}
				}
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(272);
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
		public TerminalNode NEWLINE() { return getToken(CmmParser.NEWLINE, 0); }
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
		enterRule(_localctx, 36, RULE_func_body);
		int _la;
		try {
			setState(284);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BEGIN:
				enterOuterAlt(_localctx, 1);
				{
				setState(274);
				match(BEGIN);
				setState(276); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(275);
					statement();
					}
					}
					setState(278); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << IF) | (1L << WHILE) | (1L << DO) | (1L << DISPLAY) | (1L << APPEND) | (1L << SIZE) | (1L << PRIMITIVE_TYPE) | (1L << FPTR) | (1L << STRUCT) | (1L << LIST) | (1L << LPAR) | (1L << MINUS) | (1L << NOT) | (1L << BOOL_VALUE) | (1L << INTEGER) | (1L << IDENTIFIER))) != 0) );
				setState(280);
				match(END);
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(282);
				match(NEWLINE);
				setState(283);
				statement();
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

	public static class ExpressionContext extends ParserRuleContext {
		public Token M;
		public Token X;
		public Token Y;
		public Token Z;
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public TerminalNode MINUS() { return getToken(CmmParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(CmmParser.NOT, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode DIV() { return getToken(CmmParser.DIV, 0); }
		public TerminalNode MULT() { return getToken(CmmParser.MULT, 0); }
		public TerminalNode PLUS() { return getToken(CmmParser.PLUS, 0); }
		public TerminalNode GREATER_THAN() { return getToken(CmmParser.GREATER_THAN, 0); }
		public TerminalNode LESS_THAN() { return getToken(CmmParser.LESS_THAN, 0); }
		public TerminalNode EQUAL() { return getToken(CmmParser.EQUAL, 0); }
		public TerminalNode AND() { return getToken(CmmParser.AND, 0); }
		public TerminalNode OR() { return getToken(CmmParser.OR, 0); }
		public TerminalNode ASSIGN() { return getToken(CmmParser.ASSIGN, 0); }
		public TerminalNode COMMA() { return getToken(CmmParser.COMMA, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAR:
				{
				setState(287);
				match(LPAR);
				setState(288);
				expression(0);
				setState(289);
				match(RPAR);
				System.out.println("Operator:()";
				}
				break;
			case MINUS:
			case NOT:
				{
				setState(292);
				((ExpressionContext)_localctx).M = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==MINUS || _la==NOT) ) {
					((ExpressionContext)_localctx).M = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(293);
				expression(10);
				System.out.println("Operator:" + ((ExpressionContext)_localctx).M.getText());
				}
				break;
			case BOOL_VALUE:
			case INTEGER:
			case IDENTIFIER:
				{
				setState(296);
				value();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(341);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(339);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(299);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(300);
						((ExpressionContext)_localctx).X = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MULT || _la==DIV) ) {
							((ExpressionContext)_localctx).X = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(301);
						expression(10);
						System.out.println("Operator:" + ((ExpressionContext)_localctx).X.getText());
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(304);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(305);
						((ExpressionContext)_localctx).Y = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((ExpressionContext)_localctx).Y = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(306);
						expression(9);
						System.out.println("Operator:" + ((ExpressionContext)_localctx).Y.getText());
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(309);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(310);
						((ExpressionContext)_localctx).Z = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==GREATER_THAN || _la==LESS_THAN) ) {
							((ExpressionContext)_localctx).Z = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(311);
						expression(8);
						System.out.println("Operator:" + ((ExpressionContext)_localctx).Z.getText());
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(314);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(315);
						match(EQUAL);
						setState(316);
						expression(7);
						System.out.println("Operator:==";
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(319);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(320);
						match(AND);
						setState(321);
						expression(6);
						System.out.println("Operator:&");
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(324);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(325);
						match(OR);
						setState(326);
						expression(5);
						System.out.println("Operator:|");
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(329);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(330);
						match(ASSIGN);
						setState(331);
						expression(4);
						System.out.println("Operator:=");
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(334);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(335);
						match(COMMA);
						setState(336);
						expression(3);
						System.out.println("Operator:,");
						}
						break;
					}
					} 
				}
				setState(343);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(CmmParser.INTEGER, 0); }
		public TerminalNode BOOL_VALUE() { return getToken(CmmParser.BOOL_VALUE, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
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
		enterRule(_localctx, 40, RULE_value);
		try {
			setState(347);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(344);
				match(INTEGER);
				}
				break;
			case BOOL_VALUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(345);
				match(BOOL_VALUE);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(346);
				variable();
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

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(CmmParser.IDENTIFIER, 0); }
		public List_refrenceContext list_refrence() {
			return getRuleContext(List_refrenceContext.class,0);
		}
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public List<Dot_refrenceContext> dot_refrence() {
			return getRuleContexts(Dot_refrenceContext.class);
		}
		public Dot_refrenceContext dot_refrence(int i) {
			return getRuleContext(Dot_refrenceContext.class,i);
		}
		public List<Bracket_indexingContext> bracket_indexing() {
			return getRuleContexts(Bracket_indexingContext.class);
		}
		public Bracket_indexingContext bracket_indexing(int i) {
			return getRuleContext(Bracket_indexingContext.class,i);
		}
		public List<Extra_paranthesesContext> extra_parantheses() {
			return getRuleContexts(Extra_paranthesesContext.class);
		}
		public Extra_paranthesesContext extra_parantheses(int i) {
			return getRuleContext(Extra_paranthesesContext.class,i);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_variable);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(349);
				match(IDENTIFIER);
				}
				break;
			case 2:
				{
				setState(350);
				list_refrence();
				}
				break;
			case 3:
				{
				setState(351);
				method_call();
				}
				break;
			}
			setState(359);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(357);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case DOT:
						{
						setState(354);
						dot_refrence();
						}
						break;
					case LBRACK:
						{
						setState(355);
						bracket_indexing();
						}
						break;
					case LPAR:
						{
						setState(356);
						extra_parantheses();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(361);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
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

	public static class Extra_paranthesesContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public Extra_paranthesesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extra_parantheses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterExtra_parantheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitExtra_parantheses(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitExtra_parantheses(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Extra_paranthesesContext extra_parantheses() throws RecognitionException {
		Extra_paranthesesContext _localctx = new Extra_paranthesesContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_extra_parantheses);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			match(LPAR);
			setState(363);
			parameters();
			setState(364);
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

	public static class List_refrenceContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(CmmParser.IDENTIFIER, 0); }
		public Bracket_indexingContext bracket_indexing() {
			return getRuleContext(Bracket_indexingContext.class,0);
		}
		public List_refrenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_refrence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterList_refrence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitList_refrence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitList_refrence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_refrenceContext list_refrence() throws RecognitionException {
		List_refrenceContext _localctx = new List_refrenceContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_list_refrence);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			match(IDENTIFIER);
			setState(367);
			bracket_indexing();
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

	public static class Method_callContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(CmmParser.IDENTIFIER, 0); }
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public Method_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterMethod_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitMethod_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitMethod_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_callContext method_call() throws RecognitionException {
		Method_callContext _localctx = new Method_callContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_method_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			match(IDENTIFIER);
			setState(370);
			match(LPAR);
			setState(371);
			parameters();
			setState(372);
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

	public static class ParametersContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
		enterRule(_localctx, 50, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAR) | (1L << MINUS) | (1L << NOT) | (1L << BOOL_VALUE) | (1L << INTEGER) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(374);
				expression(0);
				setState(379);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(375);
					match(COMMA);
					setState(376);
					expression(0);
					}
					}
					setState(381);
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

	public static class Dot_refrenceContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(CmmParser.DOT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(CmmParser.IDENTIFIER, 0); }
		public List_refrenceContext list_refrence() {
			return getRuleContext(List_refrenceContext.class,0);
		}
		public Dot_refrenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dot_refrence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterDot_refrence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitDot_refrence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitDot_refrence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dot_refrenceContext dot_refrence() throws RecognitionException {
		Dot_refrenceContext _localctx = new Dot_refrenceContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_dot_refrence);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			match(DOT);
			setState(387);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(385);
				match(IDENTIFIER);
				}
				break;
			case 2:
				{
				setState(386);
				list_refrence();
				}
				break;
			}
			System.out.println("Operator:.";
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

	public static class Bracket_indexingContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(CmmParser.LBRACK, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(CmmParser.RBRACK, 0); }
		public Bracket_indexingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bracket_indexing; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterBracket_indexing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitBracket_indexing(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitBracket_indexing(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bracket_indexingContext bracket_indexing() throws RecognitionException {
		Bracket_indexingContext _localctx = new Bracket_indexingContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_bracket_indexing);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
			match(LBRACK);
			setState(392);
			expression(0);
			setState(393);
			match(RBRACK);
			System.out.println("Operator:[]";
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

	public static class Fptr_declerationContext extends ParserRuleContext {
		public Fptr_typeContext fptr_type() {
			return getRuleContext(Fptr_typeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(CmmParser.IDENTIFIER, 0); }
		public EolContext eol() {
			return getRuleContext(EolContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(CmmParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Fptr_declerationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fptr_decleration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterFptr_decleration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitFptr_decleration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitFptr_decleration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fptr_declerationContext fptr_decleration() throws RecognitionException {
		Fptr_declerationContext _localctx = new Fptr_declerationContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_fptr_decleration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
			fptr_type();
			setState(397);
			match(IDENTIFIER);
			setState(401);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASSIGN:
				{
				setState(398);
				match(ASSIGN);
				setState(399);
				expression(0);
				}
				break;
			case SEMICOLON:
			case NEWLINE:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(403);
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
		enterRule(_localctx, 58, RULE_fptr_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(405);
			match(FPTR);
			setState(406);
			match(LESS_THAN);
			setState(407);
			function_type();
			setState(412);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(408);
				match(COMMA);
				setState(409);
				function_type();
				}
				}
				setState(414);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(415);
			match(ARROW);
			setState(416);
			function_type();
			setState(417);
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
		enterRule(_localctx, 60, RULE_function_type);
		try {
			setState(421);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRIMITIVE_TYPE:
			case FPTR:
			case STRUCT:
			case LIST:
				enterOuterAlt(_localctx, 1);
				{
				setState(419);
				type();
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(420);
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
		public Struct_typeContext struct_type() {
			return getRuleContext(Struct_typeContext.class,0);
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
		enterRule(_localctx, 62, RULE_struct_decleration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
			struct_type();
			setState(424);
			match(BEGIN);
			setState(425);
			struct_init();
			setState(426);
			match(END);
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
		enterRule(_localctx, 64, RULE_struct_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			match(STRUCT);
			setState(429);
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
		public List<Declare_statementContext> declare_statement() {
			return getRuleContexts(Declare_statementContext.class);
		}
		public Declare_statementContext declare_statement(int i) {
			return getRuleContext(Declare_statementContext.class,i);
		}
		public List<Set_getContext> set_get() {
			return getRuleContexts(Set_getContext.class);
		}
		public Set_getContext set_get(int i) {
			return getRuleContext(Set_getContext.class,i);
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
		enterRule(_localctx, 66, RULE_struct_init);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(433); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(433);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
				case 1:
					{
					setState(431);
					declare_statement();
					}
					break;
				case 2:
					{
					setState(432);
					set_get();
					}
					break;
				}
				}
				setState(435); 
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
		enterRule(_localctx, 68, RULE_set_get);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(437);
			type();
			setState(438);
			match(IDENTIFIER);
			setState(439);
			arguments();
			setState(440);
			match(BEGIN);
			setState(441);
			setter();
			setState(442);
			getter();
			setState(443);
			match(END);
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
		enterRule(_localctx, 70, RULE_setter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(445);
			match(SET);
			setState(460);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEWLINE:
				{
				{
				setState(446);
				match(NEWLINE);
				setState(447);
				expression(0);
				setState(448);
				eol();
				}
				}
				break;
			case BEGIN:
				{
				{
				setState(450);
				match(BEGIN);
				setState(454); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(451);
					expression(0);
					setState(452);
					eol();
					}
					}
					setState(456); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAR) | (1L << MINUS) | (1L << NOT) | (1L << BOOL_VALUE) | (1L << INTEGER) | (1L << IDENTIFIER))) != 0) );
				setState(458);
				match(END);
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
		public Return_statementContext return_statement() {
			return getRuleContext(Return_statementContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(CmmParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(CmmParser.END, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
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
		enterRule(_localctx, 72, RULE_getter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(462);
			match(GET);
			setState(474);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEWLINE:
				{
				setState(463);
				match(NEWLINE);
				setState(464);
				return_statement();
				}
				break;
			case BEGIN:
				{
				setState(465);
				match(BEGIN);
				setState(467); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(466);
					expression(0);
					}
					}
					setState(469); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAR) | (1L << MINUS) | (1L << NOT) | (1L << BOOL_VALUE) | (1L << INTEGER) | (1L << IDENTIFIER))) != 0) );
				setState(471);
				return_statement();
				setState(472);
				match(END);
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
		enterRule(_localctx, 74, RULE_list_decleration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(476);
			list_type();
			setState(477);
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
		enterRule(_localctx, 76, RULE_list_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(479);
			match(LIST);
			setState(480);
			match(SHARP);
			setState(481);
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
		enterRule(_localctx, 78, RULE_type);
		try {
			setState(485);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRIMITIVE_TYPE:
			case FPTR:
				enterOuterAlt(_localctx, 1);
				{
				setState(483);
				initable_type();
				}
				break;
			case STRUCT:
			case LIST:
				enterOuterAlt(_localctx, 2);
				{
				setState(484);
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
		enterRule(_localctx, 80, RULE_initable_type);
		try {
			setState(489);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRIMITIVE_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(487);
				match(PRIMITIVE_TYPE);
				}
				break;
			case FPTR:
				enterOuterAlt(_localctx, 2);
				{
				setState(488);
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
		enterRule(_localctx, 82, RULE_non_initable_type);
		try {
			setState(493);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LIST:
				enterOuterAlt(_localctx, 1);
				{
				setState(491);
				list_type();
				}
				break;
			case STRUCT:
				enterOuterAlt(_localctx, 2);
				{
				setState(492);
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
		public TerminalNode NEWLINE() { return getToken(CmmParser.NEWLINE, 0); }
		public TerminalNode SEMICOLON() { return getToken(CmmParser.SEMICOLON, 0); }
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
		enterRule(_localctx, 84, RULE_eol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(497);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEMICOLON:
				{
				setState(495);
				match(SEMICOLON);
				}
				break;
			case NEWLINE:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(499);
			match(NEWLINE);
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
		case 19:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\64\u01f8\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\7\2Z\n\2\f\2\16\2]\13\2\3\2\7\2`\n\2\f\2\16\2c\13\2\3\2\7\2f"+
		"\n\2\f\2\16\2i\13\2\3\2\7\2l\n\2\f\2\16\2o\13\2\3\2\7\2r\n\2\f\2\16\2"+
		"u\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u0082\n\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\6\7\u00a0\n\7\r\7\16\7\u00a1\3\7"+
		"\3\7\5\7\u00a6\n\7\3\b\3\b\3\b\3\b\3\b\5\b\u00ad\n\b\3\t\3\t\3\t\3\t\6"+
		"\t\u00b3\n\t\r\t\16\t\u00b4\3\t\3\t\3\n\3\n\5\n\u00bb\n\n\3\13\3\13\3"+
		"\13\3\13\6\13\u00c1\n\13\r\13\16\13\u00c2\3\13\3\13\3\13\5\13\u00c8\n"+
		"\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\6\f\u00d3\n\f\r\f\16\f\u00d4"+
		"\3\f\3\f\3\f\5\f\u00da\n\f\3\r\3\r\3\r\6\r\u00df\n\r\r\r\16\r\u00e0\3"+
		"\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00f0"+
		"\n\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\5\22\u0101\n\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\7\23\u010e\n\23\f\23\16\23\u0111\13\23\3\23\3\23\3\24\3\24"+
		"\6\24\u0117\n\24\r\24\16\24\u0118\3\24\3\24\3\24\3\24\5\24\u011f\n\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u012c\n\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u0156"+
		"\n\25\f\25\16\25\u0159\13\25\3\26\3\26\3\26\5\26\u015e\n\26\3\27\3\27"+
		"\3\27\5\27\u0163\n\27\3\27\3\27\3\27\7\27\u0168\n\27\f\27\16\27\u016b"+
		"\13\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33"+
		"\3\33\3\33\7\33\u017c\n\33\f\33\16\33\u017f\13\33\5\33\u0181\n\33\3\34"+
		"\3\34\3\34\5\34\u0186\n\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36"+
		"\3\36\3\36\3\36\5\36\u0194\n\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\7\37"+
		"\u019d\n\37\f\37\16\37\u01a0\13\37\3\37\3\37\3\37\3\37\3 \3 \5 \u01a8"+
		"\n \3!\3!\3!\3!\3!\3\"\3\"\3\"\3#\3#\6#\u01b4\n#\r#\16#\u01b5\3$\3$\3"+
		"$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\6%\u01c9\n%\r%\16%\u01ca\3"+
		"%\3%\5%\u01cf\n%\3&\3&\3&\3&\3&\6&\u01d6\n&\r&\16&\u01d7\3&\3&\3&\5&\u01dd"+
		"\n&\3\'\3\'\3\'\3(\3(\3(\3(\3)\3)\5)\u01e8\n)\3*\3*\5*\u01ec\n*\3+\3+"+
		"\5+\u01f0\n+\3,\3,\5,\u01f4\n,\3,\3,\3,\2\3(-\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTV\2\6\4\2!!))\3\2\""+
		"#\3\2 !\3\2%&\2\u0209\2[\3\2\2\2\4\u0081\3\2\2\2\6\u0083\3\2\2\2\b\u008a"+
		"\3\2\2\2\n\u0091\3\2\2\2\f\u009a\3\2\2\2\16\u00ac\3\2\2\2\20\u00ae\3\2"+
		"\2\2\22\u00ba\3\2\2\2\24\u00bc\3\2\2\2\26\u00cd\3\2\2\2\30\u00db\3\2\2"+
		"\2\32\u00e4\3\2\2\2\34\u00ef\3\2\2\2\36\u00f4\3\2\2\2 \u00f9\3\2\2\2\""+
		"\u0100\3\2\2\2$\u0106\3\2\2\2&\u011e\3\2\2\2(\u012b\3\2\2\2*\u015d\3\2"+
		"\2\2,\u0162\3\2\2\2.\u016c\3\2\2\2\60\u0170\3\2\2\2\62\u0173\3\2\2\2\64"+
		"\u0180\3\2\2\2\66\u0182\3\2\2\28\u0189\3\2\2\2:\u018e\3\2\2\2<\u0197\3"+
		"\2\2\2>\u01a7\3\2\2\2@\u01a9\3\2\2\2B\u01ae\3\2\2\2D\u01b3\3\2\2\2F\u01b7"+
		"\3\2\2\2H\u01bf\3\2\2\2J\u01d0\3\2\2\2L\u01de\3\2\2\2N\u01e1\3\2\2\2P"+
		"\u01e7\3\2\2\2R\u01eb\3\2\2\2T\u01ef\3\2\2\2V\u01f3\3\2\2\2XZ\7\64\2\2"+
		"YX\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\a\3\2\2\2][\3\2\2\2^`\5@!\2"+
		"_^\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2bg\3\2\2\2ca\3\2\2\2df\7\64\2"+
		"\2ed\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2hm\3\2\2\2ig\3\2\2\2jl\5\"\22"+
		"\2kj\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2ns\3\2\2\2om\3\2\2\2pr\7\64"+
		"\2\2qp\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2tv\3\2\2\2us\3\2\2\2vw\5 "+
		"\21\2w\3\3\2\2\2x\u0082\5\f\7\2y\u0082\5\22\n\2z\u0082\5\30\r\2{\u0082"+
		"\5\34\17\2|\u0082\5\36\20\2}\u0082\5\32\16\2~\u0082\5\6\4\2\177\u0082"+
		"\5\b\5\2\u0080\u0082\5\n\6\2\u0081x\3\2\2\2\u0081y\3\2\2\2\u0081z\3\2"+
		"\2\2\u0081{\3\2\2\2\u0081|\3\2\2\2\u0081}\3\2\2\2\u0081~\3\2\2\2\u0081"+
		"\177\3\2\2\2\u0081\u0080\3\2\2\2\u0082\5\3\2\2\2\u0083\u0084\7\r\2\2\u0084"+
		"\u0085\b\4\1\2\u0085\u0086\7\25\2\2\u0086\u0087\5(\25\2\u0087\u0088\7"+
		"\26\2\2\u0088\u0089\5V,\2\u0089\7\3\2\2\2\u008a\u008b\7\17\2\2\u008b\u008c"+
		"\b\5\1\2\u008c\u008d\7\25\2\2\u008d\u008e\7-\2\2\u008e\u008f\7\26\2\2"+
		"\u008f\u0090\5V,\2\u0090\t\3\2\2\2\u0091\u0092\7\16\2\2\u0092\u0093\b"+
		"\6\1\2\u0093\u0094\7\25\2\2\u0094\u0095\7-\2\2\u0095\u0096\7\34\2\2\u0096"+
		"\u0097\5(\25\2\u0097\u0098\7\26\2\2\u0098\u0099\5V,\2\u0099\13\3\2\2\2"+
		"\u009a\u009b\7\7\2\2\u009b\u009c\b\7\1\2\u009c\u009d\5\16\b\2\u009d\u009f"+
		"\7\4\2\2\u009e\u00a0\5\4\3\2\u009f\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1"+
		"\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a5\7\5"+
		"\2\2\u00a4\u00a6\5\20\t\2\u00a5\u00a4\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6"+
		"\r\3\2\2\2\u00a7\u00a8\7\25\2\2\u00a8\u00a9\5(\25\2\u00a9\u00aa\7\26\2"+
		"\2\u00aa\u00ad\3\2\2\2\u00ab\u00ad\5(\25\2\u00ac\u00a7\3\2\2\2\u00ac\u00ab"+
		"\3\2\2\2\u00ad\17\3\2\2\2\u00ae\u00af\7\b\2\2\u00af\u00b0\7\4\2\2\u00b0"+
		"\u00b2\b\t\1\2\u00b1\u00b3\5\4\3\2\u00b2\u00b1\3\2\2\2\u00b3\u00b4\3\2"+
		"\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6"+
		"\u00b7\7\5\2\2\u00b7\21\3\2\2\2\u00b8\u00bb\5\26\f\2\u00b9\u00bb\5\24"+
		"\13\2\u00ba\u00b8\3\2\2\2\u00ba\u00b9\3\2\2\2\u00bb\23\3\2\2\2\u00bc\u00bd"+
		"\7\n\2\2\u00bd\u00c7\b\13\1\2\u00be\u00c0\7\4\2\2\u00bf\u00c1\5\4\3\2"+
		"\u00c0\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3"+
		"\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\7\5\2\2\u00c5\u00c8\3\2\2\2\u00c6"+
		"\u00c8\5\4\3\2\u00c7\u00be\3\2\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00c9\3\2"+
		"\2\2\u00c9\u00ca\7\t\2\2\u00ca\u00cb\5\16\b\2\u00cb\u00cc\5V,\2\u00cc"+
		"\25\3\2\2\2\u00cd\u00ce\7\t\2\2\u00ce\u00cf\5\16\b\2\u00cf\u00d9\b\f\1"+
		"\2\u00d0\u00d2\7\4\2\2\u00d1\u00d3\5\4\3\2\u00d2\u00d1\3\2\2\2\u00d3\u00d4"+
		"\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6"+
		"\u00d7\7\5\2\2\u00d7\u00da\3\2\2\2\u00d8\u00da\5\4\3\2\u00d9\u00d0\3\2"+
		"\2\2\u00d9\u00d8\3\2\2\2\u00da\27\3\2\2\2\u00db\u00dc\5,\27\2\u00dc\u00de"+
		"\b\r\1\2\u00dd\u00df\5.\30\2\u00de\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0"+
		"\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\5V"+
		",\2\u00e3\31\3\2\2\2\u00e4\u00e5\5(\25\2\u00e5\u00e6\5V,\2\u00e6\33\3"+
		"\2\2\2\u00e7\u00e8\5P)\2\u00e8\u00e9\7-\2\2\u00e9\u00f0\3\2\2\2\u00ea"+
		"\u00eb\5R*\2\u00eb\u00ec\7-\2\2\u00ec\u00ed\7*\2\2\u00ed\u00ee\5(\25\2"+
		"\u00ee\u00f0\3\2\2\2\u00ef\u00e7\3\2\2\2\u00ef\u00ea\3\2\2\2\u00f0\u00f1"+
		"\3\2\2\2\u00f1\u00f2\5V,\2\u00f2\u00f3\b\17\1\2\u00f3\35\3\2\2\2\u00f4"+
		"\u00f5\7\6\2\2\u00f5\u00f6\b\20\1\2\u00f6\u00f7\5(\25\2\u00f7\u00f8\5"+
		"V,\2\u00f8\37\3\2\2\2\u00f9\u00fa\7\3\2\2\u00fa\u00fb\7\25\2\2\u00fb\u00fc"+
		"\7\26\2\2\u00fc\u00fd\5&\24\2\u00fd!\3\2\2\2\u00fe\u0101\5P)\2\u00ff\u0101"+
		"\7\24\2\2\u0100\u00fe\3\2\2\2\u0100\u00ff\3\2\2\2\u0101\u0102\3\2\2\2"+
		"\u0102\u0103\7-\2\2\u0103\u0104\5$\23\2\u0104\u0105\5&\24\2\u0105#\3\2"+
		"\2\2\u0106\u0107\7\25\2\2\u0107\u0108\5P)\2\u0108\u010f\7-\2\2\u0109\u010a"+
		"\7\34\2\2\u010a\u010b\5P)\2\u010b\u010c\7-\2\2\u010c\u010e\3\2\2\2\u010d"+
		"\u0109\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2"+
		"\2\2\u0110\u0112\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u0113\7\26\2\2\u0113"+
		"%\3\2\2\2\u0114\u0116\7\4\2\2\u0115\u0117\5\4\3\2\u0116\u0115\3\2\2\2"+
		"\u0117\u0118\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011a"+
		"\3\2\2\2\u011a\u011b\7\5\2\2\u011b\u011f\3\2\2\2\u011c\u011d\7\64\2\2"+
		"\u011d\u011f\5\4\3\2\u011e\u0114\3\2\2\2\u011e\u011c\3\2\2\2\u011f\'\3"+
		"\2\2\2\u0120\u0121\b\25\1\2\u0121\u0122\7\25\2\2\u0122\u0123\5(\25\2\u0123"+
		"\u0124\7\26\2\2\u0124\u0125\b\25\1\2\u0125\u012c\3\2\2\2\u0126\u0127\t"+
		"\2\2\2\u0127\u0128\5(\25\f\u0128\u0129\b\25\1\2\u0129\u012c\3\2\2\2\u012a"+
		"\u012c\5*\26\2\u012b\u0120\3\2\2\2\u012b\u0126\3\2\2\2\u012b\u012a\3\2"+
		"\2\2\u012c\u0157\3\2\2\2\u012d\u012e\f\13\2\2\u012e\u012f\t\3\2\2\u012f"+
		"\u0130\5(\25\f\u0130\u0131\b\25\1\2\u0131\u0156\3\2\2\2\u0132\u0133\f"+
		"\n\2\2\u0133\u0134\t\4\2\2\u0134\u0135\5(\25\13\u0135\u0136\b\25\1\2\u0136"+
		"\u0156\3\2\2\2\u0137\u0138\f\t\2\2\u0138\u0139\t\5\2\2\u0139\u013a\5("+
		"\25\n\u013a\u013b\b\25\1\2\u013b\u0156\3\2\2\2\u013c\u013d\f\b\2\2\u013d"+
		"\u013e\7$\2\2\u013e\u013f\5(\25\t\u013f\u0140\b\25\1\2\u0140\u0156\3\2"+
		"\2\2\u0141\u0142\f\7\2\2\u0142\u0143\7\'\2\2\u0143\u0144\5(\25\b\u0144"+
		"\u0145\b\25\1\2\u0145\u0156\3\2\2\2\u0146\u0147\f\6\2\2\u0147\u0148\7"+
		"(\2\2\u0148\u0149\5(\25\7\u0149\u014a\b\25\1\2\u014a\u0156\3\2\2\2\u014b"+
		"\u014c\f\5\2\2\u014c\u014d\7*\2\2\u014d\u014e\5(\25\6\u014e\u014f\b\25"+
		"\1\2\u014f\u0156\3\2\2\2\u0150\u0151\f\4\2\2\u0151\u0152\7\34\2\2\u0152"+
		"\u0153\5(\25\5\u0153\u0154\b\25\1\2\u0154\u0156\3\2\2\2\u0155\u012d\3"+
		"\2\2\2\u0155\u0132\3\2\2\2\u0155\u0137\3\2\2\2\u0155\u013c\3\2\2\2\u0155"+
		"\u0141\3\2\2\2\u0155\u0146\3\2\2\2\u0155\u014b\3\2\2\2\u0155\u0150\3\2"+
		"\2\2\u0156\u0159\3\2\2\2\u0157\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158"+
		")\3\2\2\2\u0159\u0157\3\2\2\2\u015a\u015e\7,\2\2\u015b\u015e\7+\2\2\u015c"+
		"\u015e\5,\27\2\u015d\u015a\3\2\2\2\u015d\u015b\3\2\2\2\u015d\u015c\3\2"+
		"\2\2\u015e+\3\2\2\2\u015f\u0163\7-\2\2\u0160\u0163\5\60\31\2\u0161\u0163"+
		"\5\62\32\2\u0162\u015f\3\2\2\2\u0162\u0160\3\2\2\2\u0162\u0161\3\2\2\2"+
		"\u0163\u0169\3\2\2\2\u0164\u0168\5\66\34\2\u0165\u0168\58\35\2\u0166\u0168"+
		"\5.\30\2\u0167\u0164\3\2\2\2\u0167\u0165\3\2\2\2\u0167\u0166\3\2\2\2\u0168"+
		"\u016b\3\2\2\2\u0169\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a-\3\2\2\2"+
		"\u016b\u0169\3\2\2\2\u016c\u016d\7\25\2\2\u016d\u016e\5\64\33\2\u016e"+
		"\u016f\7\26\2\2\u016f/\3\2\2\2\u0170\u0171\7-\2\2\u0171\u0172\58\35\2"+
		"\u0172\61\3\2\2\2\u0173\u0174\7-\2\2\u0174\u0175\7\25\2\2\u0175\u0176"+
		"\5\64\33\2\u0176\u0177\7\26\2\2\u0177\63\3\2\2\2\u0178\u017d\5(\25\2\u0179"+
		"\u017a\7\34\2\2\u017a\u017c\5(\25\2\u017b\u0179\3\2\2\2\u017c\u017f\3"+
		"\2\2\2\u017d\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u0181\3\2\2\2\u017f"+
		"\u017d\3\2\2\2\u0180\u0178\3\2\2\2\u0180\u0181\3\2\2\2\u0181\65\3\2\2"+
		"\2\u0182\u0185\7\35\2\2\u0183\u0186\7-\2\2\u0184\u0186\5\60\31\2\u0185"+
		"\u0183\3\2\2\2\u0185\u0184\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0188\b\34"+
		"\1\2\u0188\67\3\2\2\2\u0189\u018a\7\27\2\2\u018a\u018b\5(\25\2\u018b\u018c"+
		"\7\30\2\2\u018c\u018d\b\35\1\2\u018d9\3\2\2\2\u018e\u018f\5<\37\2\u018f"+
		"\u0193\7-\2\2\u0190\u0191\7*\2\2\u0191\u0194\5(\25\2\u0192\u0194\3\2\2"+
		"\2\u0193\u0190\3\2\2\2\u0193\u0192\3\2\2\2\u0194\u0195\3\2\2\2\u0195\u0196"+
		"\5V,\2\u0196;\3\2\2\2\u0197\u0198\7\21\2\2\u0198\u0199\7&\2\2\u0199\u019e"+
		"\5> \2\u019a\u019b\7\34\2\2\u019b\u019d\5> \2\u019c\u019a\3\2\2\2\u019d"+
		"\u01a0\3\2\2\2\u019e\u019c\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a1\3\2"+
		"\2\2\u01a0\u019e\3\2\2\2\u01a1\u01a2\7\37\2\2\u01a2\u01a3\5> \2\u01a3"+
		"\u01a4\7%\2\2\u01a4=\3\2\2\2\u01a5\u01a8\5P)\2\u01a6\u01a8\7\24\2\2\u01a7"+
		"\u01a5\3\2\2\2\u01a7\u01a6\3\2\2\2\u01a8?\3\2\2\2\u01a9\u01aa\5B\"\2\u01aa"+
		"\u01ab\7\4\2\2\u01ab\u01ac\5D#\2\u01ac\u01ad\7\5\2\2\u01adA\3\2\2\2\u01ae"+
		"\u01af\7\22\2\2\u01af\u01b0\7-\2\2\u01b0C\3\2\2\2\u01b1\u01b4\5\34\17"+
		"\2\u01b2\u01b4\5F$\2\u01b3\u01b1\3\2\2\2\u01b3\u01b2\3\2\2\2\u01b4\u01b5"+
		"\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6E\3\2\2\2\u01b7"+
		"\u01b8\5P)\2\u01b8\u01b9\7-\2\2\u01b9\u01ba\5$\23\2\u01ba\u01bb\7\4\2"+
		"\2\u01bb\u01bc\5H%\2\u01bc\u01bd\5J&\2\u01bd\u01be\7\5\2\2\u01beG\3\2"+
		"\2\2\u01bf\u01ce\7\f\2\2\u01c0\u01c1\7\64\2\2\u01c1\u01c2\5(\25\2\u01c2"+
		"\u01c3\5V,\2\u01c3\u01cf\3\2\2\2\u01c4\u01c8\7\4\2\2\u01c5\u01c6\5(\25"+
		"\2\u01c6\u01c7\5V,\2\u01c7\u01c9\3\2\2\2\u01c8\u01c5\3\2\2\2\u01c9\u01ca"+
		"\3\2\2\2\u01ca\u01c8\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cc"+
		"\u01cd\7\5\2\2\u01cd\u01cf\3\2\2\2\u01ce\u01c0\3\2\2\2\u01ce\u01c4\3\2"+
		"\2\2\u01cfI\3\2\2\2\u01d0\u01dc\7\13\2\2\u01d1\u01d2\7\64\2\2\u01d2\u01dd"+
		"\5\36\20\2\u01d3\u01d5\7\4\2\2\u01d4\u01d6\5(\25\2\u01d5\u01d4\3\2\2\2"+
		"\u01d6\u01d7\3\2\2\2\u01d7\u01d5\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\u01d9"+
		"\3\2\2\2\u01d9\u01da\5\36\20\2\u01da\u01db\7\5\2\2\u01db\u01dd\3\2\2\2"+
		"\u01dc\u01d1\3\2\2\2\u01dc\u01d3\3\2\2\2\u01ddK\3\2\2\2\u01de\u01df\5"+
		"N(\2\u01df\u01e0\7-\2\2\u01e0M\3\2\2\2\u01e1\u01e2\7\23\2\2\u01e2\u01e3"+
		"\7\33\2\2\u01e3\u01e4\5P)\2\u01e4O\3\2\2\2\u01e5\u01e8\5R*\2\u01e6\u01e8"+
		"\5T+\2\u01e7\u01e5\3\2\2\2\u01e7\u01e6\3\2\2\2\u01e8Q\3\2\2\2\u01e9\u01ec"+
		"\7\20\2\2\u01ea\u01ec\5<\37\2\u01eb\u01e9\3\2\2\2\u01eb\u01ea\3\2\2\2"+
		"\u01ecS\3\2\2\2\u01ed\u01f0\5N(\2\u01ee\u01f0\5B\"\2\u01ef\u01ed\3\2\2"+
		"\2\u01ef\u01ee\3\2\2\2\u01f0U\3\2\2\2\u01f1\u01f4\7\36\2\2\u01f2\u01f4"+
		"\3\2\2\2\u01f3\u01f1\3\2\2\2\u01f3\u01f2\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5"+
		"\u01f6\7\64\2\2\u01f6W\3\2\2\2.[agms\u0081\u00a1\u00a5\u00ac\u00b4\u00ba"+
		"\u00c2\u00c7\u00d4\u00d9\u00e0\u00ef\u0100\u010f\u0118\u011e\u012b\u0155"+
		"\u0157\u015d\u0162\u0167\u0169\u017d\u0180\u0185\u0193\u019e\u01a7\u01b3"+
		"\u01b5\u01ca\u01ce\u01d7\u01dc\u01e7\u01eb\u01ef\u01f3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}