// Generated from E:/UT/S5/Compiler/CA/Phase 1/src/main/grammar\Cmm.g4 by ANTLR 4.9.1
package main.grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CmmLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"MAIN", "BEGIN", "END", "RETURN", "IF", "ELSE", "WHILE", "DO", "GET", 
			"SET", "DISPLAY", "APPEND", "SIZE", "PRIMITIVE_TYPE", "FPTR", "STRUCT", 
			"LIST", "VOID", "LPAR", "RPAR", "LBRACK", "RBRACK", "LBRACE", "RBRACE", 
			"SHARP", "COMMA", "DOT", "SEMICOLON", "ARROW", "PLUS", "MINUS", "MULT", 
			"DIV", "EQUAL", "GREATER_THAN", "LESS_THAN", "AND", "OR", "NOT", "ASSIGN", 
			"BOOL_VALUE", "INTEGER", "IDENTIFIER", "DIGIT", "NONZERODIGIT", "LETTER", 
			"UNDERSCORE", "COMMENT", "WS", "NEWLINE"
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


	public CmmLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Cmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\64\u0145\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\3\2"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3t\n\3\f\3\16\3w\13\3\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u00ba\n\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34"+
		"\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3#\3$\3"+
		"$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u0109"+
		"\n*\3+\3+\7+\u010d\n+\f+\16+\u0110\13+\3+\5+\u0113\n+\3,\3,\5,\u0117\n"+
		",\3,\3,\3,\7,\u011c\n,\f,\16,\u011f\13,\3-\3-\3.\3.\3/\3/\3\60\3\60\3"+
		"\61\3\61\3\61\3\61\7\61\u012d\n\61\f\61\16\61\u0130\13\61\3\61\3\61\3"+
		"\61\3\61\7\61\u0136\n\61\f\61\16\61\u0139\13\61\3\61\3\61\3\62\3\62\3"+
		"\62\3\62\3\63\6\63\u0142\n\63\r\63\16\63\u0143\3\u012e\2\64\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64\3\2\b\3\2\62\62\3\2\62"+
		";\3\2\63;\4\2C\\c|\5\2\13\13\17\17\"\"\4\2\f\f\17\17\2\u0150\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2"+
		"\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3"+
		"\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2"+
		"\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2"+
		"W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3"+
		"\2\2\2\2e\3\2\2\2\3g\3\2\2\2\5l\3\2\2\2\7z\3\2\2\2\t~\3\2\2\2\13\u0085"+
		"\3\2\2\2\r\u0088\3\2\2\2\17\u008d\3\2\2\2\21\u0093\3\2\2\2\23\u0096\3"+
		"\2\2\2\25\u009a\3\2\2\2\27\u009e\3\2\2\2\31\u00a6\3\2\2\2\33\u00ad\3\2"+
		"\2\2\35\u00b9\3\2\2\2\37\u00bb\3\2\2\2!\u00c0\3\2\2\2#\u00c7\3\2\2\2%"+
		"\u00cc\3\2\2\2\'\u00d1\3\2\2\2)\u00d3\3\2\2\2+\u00d5\3\2\2\2-\u00d7\3"+
		"\2\2\2/\u00d9\3\2\2\2\61\u00db\3\2\2\2\63\u00dd\3\2\2\2\65\u00df\3\2\2"+
		"\2\67\u00e1\3\2\2\29\u00e3\3\2\2\2;\u00e5\3\2\2\2=\u00e8\3\2\2\2?\u00ea"+
		"\3\2\2\2A\u00ec\3\2\2\2C\u00ee\3\2\2\2E\u00f0\3\2\2\2G\u00f3\3\2\2\2I"+
		"\u00f5\3\2\2\2K\u00f7\3\2\2\2M\u00f9\3\2\2\2O\u00fb\3\2\2\2Q\u00fd\3\2"+
		"\2\2S\u0108\3\2\2\2U\u0112\3\2\2\2W\u0116\3\2\2\2Y\u0120\3\2\2\2[\u0122"+
		"\3\2\2\2]\u0124\3\2\2\2_\u0126\3\2\2\2a\u0128\3\2\2\2c\u013c\3\2\2\2e"+
		"\u0141\3\2\2\2gh\7o\2\2hi\7c\2\2ij\7k\2\2jk\7p\2\2k\4\3\2\2\2lm\7d\2\2"+
		"mn\7g\2\2no\7i\2\2op\7k\2\2pq\7p\2\2qu\3\2\2\2rt\5c\62\2sr\3\2\2\2tw\3"+
		"\2\2\2us\3\2\2\2uv\3\2\2\2vx\3\2\2\2wu\3\2\2\2xy\5e\63\2y\6\3\2\2\2z{"+
		"\7g\2\2{|\7p\2\2|}\7f\2\2}\b\3\2\2\2~\177\7t\2\2\177\u0080\7g\2\2\u0080"+
		"\u0081\7v\2\2\u0081\u0082\7w\2\2\u0082\u0083\7t\2\2\u0083\u0084\7p\2\2"+
		"\u0084\n\3\2\2\2\u0085\u0086\7k\2\2\u0086\u0087\7h\2\2\u0087\f\3\2\2\2"+
		"\u0088\u0089\7g\2\2\u0089\u008a\7n\2\2\u008a\u008b\7u\2\2\u008b\u008c"+
		"\7g\2\2\u008c\16\3\2\2\2\u008d\u008e\7y\2\2\u008e\u008f\7j\2\2\u008f\u0090"+
		"\7k\2\2\u0090\u0091\7n\2\2\u0091\u0092\7g\2\2\u0092\20\3\2\2\2\u0093\u0094"+
		"\7f\2\2\u0094\u0095\7q\2\2\u0095\22\3\2\2\2\u0096\u0097\7i\2\2\u0097\u0098"+
		"\7g\2\2\u0098\u0099\7v\2\2\u0099\24\3\2\2\2\u009a\u009b\7u\2\2\u009b\u009c"+
		"\7g\2\2\u009c\u009d\7v\2\2\u009d\26\3\2\2\2\u009e\u009f\7f\2\2\u009f\u00a0"+
		"\7k\2\2\u00a0\u00a1\7u\2\2\u00a1\u00a2\7r\2\2\u00a2\u00a3\7n\2\2\u00a3"+
		"\u00a4\7c\2\2\u00a4\u00a5\7{\2\2\u00a5\30\3\2\2\2\u00a6\u00a7\7c\2\2\u00a7"+
		"\u00a8\7r\2\2\u00a8\u00a9\7r\2\2\u00a9\u00aa\7g\2\2\u00aa\u00ab\7p\2\2"+
		"\u00ab\u00ac\7f\2\2\u00ac\32\3\2\2\2\u00ad\u00ae\7u\2\2\u00ae\u00af\7"+
		"k\2\2\u00af\u00b0\7|\2\2\u00b0\u00b1\7g\2\2\u00b1\34\3\2\2\2\u00b2\u00b3"+
		"\7k\2\2\u00b3\u00b4\7p\2\2\u00b4\u00ba\7v\2\2\u00b5\u00b6\7d\2\2\u00b6"+
		"\u00b7\7q\2\2\u00b7\u00b8\7q\2\2\u00b8\u00ba\7n\2\2\u00b9\u00b2\3\2\2"+
		"\2\u00b9\u00b5\3\2\2\2\u00ba\36\3\2\2\2\u00bb\u00bc\7h\2\2\u00bc\u00bd"+
		"\7r\2\2\u00bd\u00be\7v\2\2\u00be\u00bf\7t\2\2\u00bf \3\2\2\2\u00c0\u00c1"+
		"\7u\2\2\u00c1\u00c2\7v\2\2\u00c2\u00c3\7t\2\2\u00c3\u00c4\7w\2\2\u00c4"+
		"\u00c5\7e\2\2\u00c5\u00c6\7v\2\2\u00c6\"\3\2\2\2\u00c7\u00c8\7n\2\2\u00c8"+
		"\u00c9\7k\2\2\u00c9\u00ca\7u\2\2\u00ca\u00cb\7v\2\2\u00cb$\3\2\2\2\u00cc"+
		"\u00cd\7x\2\2\u00cd\u00ce\7q\2\2\u00ce\u00cf\7k\2\2\u00cf\u00d0\7f\2\2"+
		"\u00d0&\3\2\2\2\u00d1\u00d2\7*\2\2\u00d2(\3\2\2\2\u00d3\u00d4\7+\2\2\u00d4"+
		"*\3\2\2\2\u00d5\u00d6\7]\2\2\u00d6,\3\2\2\2\u00d7\u00d8\7_\2\2\u00d8."+
		"\3\2\2\2\u00d9\u00da\7}\2\2\u00da\60\3\2\2\2\u00db\u00dc\7\177\2\2\u00dc"+
		"\62\3\2\2\2\u00dd\u00de\7%\2\2\u00de\64\3\2\2\2\u00df\u00e0\7.\2\2\u00e0"+
		"\66\3\2\2\2\u00e1\u00e2\7\60\2\2\u00e28\3\2\2\2\u00e3\u00e4\7=\2\2\u00e4"+
		":\3\2\2\2\u00e5\u00e6\7/\2\2\u00e6\u00e7\7@\2\2\u00e7<\3\2\2\2\u00e8\u00e9"+
		"\7-\2\2\u00e9>\3\2\2\2\u00ea\u00eb\7/\2\2\u00eb@\3\2\2\2\u00ec\u00ed\7"+
		",\2\2\u00edB\3\2\2\2\u00ee\u00ef\7\61\2\2\u00efD\3\2\2\2\u00f0\u00f1\7"+
		"?\2\2\u00f1\u00f2\7?\2\2\u00f2F\3\2\2\2\u00f3\u00f4\7@\2\2\u00f4H\3\2"+
		"\2\2\u00f5\u00f6\7>\2\2\u00f6J\3\2\2\2\u00f7\u00f8\7(\2\2\u00f8L\3\2\2"+
		"\2\u00f9\u00fa\7~\2\2\u00faN\3\2\2\2\u00fb\u00fc\7\u0080\2\2\u00fcP\3"+
		"\2\2\2\u00fd\u00fe\7?\2\2\u00feR\3\2\2\2\u00ff\u0100\7v\2\2\u0100\u0101"+
		"\7t\2\2\u0101\u0102\7w\2\2\u0102\u0109\7g\2\2\u0103\u0104\7h\2\2\u0104"+
		"\u0105\7c\2\2\u0105\u0106\7n\2\2\u0106\u0107\7u\2\2\u0107\u0109\7g\2\2"+
		"\u0108\u00ff\3\2\2\2\u0108\u0103\3\2\2\2\u0109T\3\2\2\2\u010a\u010e\5"+
		"[.\2\u010b\u010d\5Y-\2\u010c\u010b\3\2\2\2\u010d\u0110\3\2\2\2\u010e\u010c"+
		"\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0113\3\2\2\2\u0110\u010e\3\2\2\2\u0111"+
		"\u0113\t\2\2\2\u0112\u010a\3\2\2\2\u0112\u0111\3\2\2\2\u0113V\3\2\2\2"+
		"\u0114\u0117\5]/\2\u0115\u0117\5_\60\2\u0116\u0114\3\2\2\2\u0116\u0115"+
		"\3\2\2\2\u0117\u011d\3\2\2\2\u0118\u011c\5]/\2\u0119\u011c\5_\60\2\u011a"+
		"\u011c\5Y-\2\u011b\u0118\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011a\3\2\2"+
		"\2\u011c\u011f\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011eX"+
		"\3\2\2\2\u011f\u011d\3\2\2\2\u0120\u0121\t\3\2\2\u0121Z\3\2\2\2\u0122"+
		"\u0123\t\4\2\2\u0123\\\3\2\2\2\u0124\u0125\t\5\2\2\u0125^\3\2\2\2\u0126"+
		"\u0127\7a\2\2\u0127`\3\2\2\2\u0128\u0129\7\61\2\2\u0129\u012a\7,\2\2\u012a"+
		"\u012e\3\2\2\2\u012b\u012d\13\2\2\2\u012c\u012b\3\2\2\2\u012d\u0130\3"+
		"\2\2\2\u012e\u012f\3\2\2\2\u012e\u012c\3\2\2\2\u012f\u0131\3\2\2\2\u0130"+
		"\u012e\3\2\2\2\u0131\u0132\7,\2\2\u0132\u0133\7\61\2\2\u0133\u0137\3\2"+
		"\2\2\u0134\u0136\5e\63\2\u0135\u0134\3\2\2\2\u0136\u0139\3\2\2\2\u0137"+
		"\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u013a\3\2\2\2\u0139\u0137\3\2"+
		"\2\2\u013a\u013b\b\61\2\2\u013bb\3\2\2\2\u013c\u013d\t\6\2\2\u013d\u013e"+
		"\3\2\2\2\u013e\u013f\b\62\2\2\u013fd\3\2\2\2\u0140\u0142\t\7\2\2\u0141"+
		"\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0141\3\2\2\2\u0143\u0144\3\2"+
		"\2\2\u0144f\3\2\2\2\16\2u\u00b9\u0108\u010e\u0112\u0116\u011b\u011d\u012e"+
		"\u0137\u0143\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}