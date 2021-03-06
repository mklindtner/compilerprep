// Generated from impl.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class implLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, ID=23, FLOAT=24, ALPHA=25, 
		NUM=26, OP1=27, OP2=28, WHITESPACE=29, COMMENT=30, COMMENT2=31;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "ID", "FLOAT", "ALPHA", 
			"NUM", "OP1", "OP2", "WHITESPACE", "COMMENT", "COMMENT2"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'declare'", "'['", "']'", "'{'", "'}'", "';'", "'output'", "'while'", 
			"'('", "')'", "'for'", "'='", "'..'", "'if'", "'.'", "','", "'!='", "'=='", 
			"'<'", "'||'", "'&&'", "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "ID", 
			"FLOAT", "ALPHA", "NUM", "OP1", "OP2", "WHITESPACE", "COMMENT", "COMMENT2"
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


	public implLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "impl.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2!\u00c3\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3"+
		"\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3"+
		"\26\3\27\3\27\3\30\3\30\3\30\7\30\u0088\n\30\f\30\16\30\u008b\13\30\3"+
		"\31\6\31\u008e\n\31\r\31\16\31\u008f\3\31\3\31\6\31\u0094\n\31\r\31\16"+
		"\31\u0095\5\31\u0098\n\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36"+
		"\6\36\u00a3\n\36\r\36\16\36\u00a4\3\36\3\36\3\37\3\37\3\37\3\37\7\37\u00ad"+
		"\n\37\f\37\16\37\u00b0\13\37\3\37\3\37\3 \3 \3 \3 \3 \3 \7 \u00ba\n \f"+
		" \16 \u00bd\13 \3 \3 \3 \3 \3 \2\2!\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!\3\2\n\t\2C\\aac|\u00c7\u00c8"+
		"\u00da\u00da\u00e7\u00e8\u00fa\u00fa\3\2\62;\4\2--//\4\2,,\61\61\5\2\13"+
		"\f\17\17\"\"\3\2\f\f\3\2,,\3\2\61\61\2\u00cb\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\3A\3\2\2\2\5I\3\2\2\2\7K\3\2\2\2\tM\3\2\2\2\13O\3\2\2\2\rQ\3\2\2\2"+
		"\17S\3\2\2\2\21Z\3\2\2\2\23`\3\2\2\2\25b\3\2\2\2\27d\3\2\2\2\31h\3\2\2"+
		"\2\33j\3\2\2\2\35m\3\2\2\2\37p\3\2\2\2!r\3\2\2\2#t\3\2\2\2%w\3\2\2\2\'"+
		"z\3\2\2\2)|\3\2\2\2+\177\3\2\2\2-\u0082\3\2\2\2/\u0084\3\2\2\2\61\u008d"+
		"\3\2\2\2\63\u0099\3\2\2\2\65\u009b\3\2\2\2\67\u009d\3\2\2\29\u009f\3\2"+
		"\2\2;\u00a2\3\2\2\2=\u00a8\3\2\2\2?\u00b3\3\2\2\2AB\7f\2\2BC\7g\2\2CD"+
		"\7e\2\2DE\7n\2\2EF\7c\2\2FG\7t\2\2GH\7g\2\2H\4\3\2\2\2IJ\7]\2\2J\6\3\2"+
		"\2\2KL\7_\2\2L\b\3\2\2\2MN\7}\2\2N\n\3\2\2\2OP\7\177\2\2P\f\3\2\2\2QR"+
		"\7=\2\2R\16\3\2\2\2ST\7q\2\2TU\7w\2\2UV\7v\2\2VW\7r\2\2WX\7w\2\2XY\7v"+
		"\2\2Y\20\3\2\2\2Z[\7y\2\2[\\\7j\2\2\\]\7k\2\2]^\7n\2\2^_\7g\2\2_\22\3"+
		"\2\2\2`a\7*\2\2a\24\3\2\2\2bc\7+\2\2c\26\3\2\2\2de\7h\2\2ef\7q\2\2fg\7"+
		"t\2\2g\30\3\2\2\2hi\7?\2\2i\32\3\2\2\2jk\7\60\2\2kl\7\60\2\2l\34\3\2\2"+
		"\2mn\7k\2\2no\7h\2\2o\36\3\2\2\2pq\7\60\2\2q \3\2\2\2rs\7.\2\2s\"\3\2"+
		"\2\2tu\7#\2\2uv\7?\2\2v$\3\2\2\2wx\7?\2\2xy\7?\2\2y&\3\2\2\2z{\7>\2\2"+
		"{(\3\2\2\2|}\7~\2\2}~\7~\2\2~*\3\2\2\2\177\u0080\7(\2\2\u0080\u0081\7"+
		"(\2\2\u0081,\3\2\2\2\u0082\u0083\7#\2\2\u0083.\3\2\2\2\u0084\u0089\5\63"+
		"\32\2\u0085\u0088\5\63\32\2\u0086\u0088\5\65\33\2\u0087\u0085\3\2\2\2"+
		"\u0087\u0086\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a"+
		"\3\2\2\2\u008a\60\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008e\5\65\33\2\u008d"+
		"\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2"+
		"\2\2\u0090\u0097\3\2\2\2\u0091\u0093\7\60\2\2\u0092\u0094\5\65\33\2\u0093"+
		"\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2"+
		"\2\2\u0096\u0098\3\2\2\2\u0097\u0091\3\2\2\2\u0097\u0098\3\2\2\2\u0098"+
		"\62\3\2\2\2\u0099\u009a\t\2\2\2\u009a\64\3\2\2\2\u009b\u009c\t\3\2\2\u009c"+
		"\66\3\2\2\2\u009d\u009e\t\4\2\2\u009e8\3\2\2\2\u009f\u00a0\t\5\2\2\u00a0"+
		":\3\2\2\2\u00a1\u00a3\t\6\2\2\u00a2\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2"+
		"\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7"+
		"\b\36\2\2\u00a7<\3\2\2\2\u00a8\u00a9\7\61\2\2\u00a9\u00aa\7\61\2\2\u00aa"+
		"\u00ae\3\2\2\2\u00ab\u00ad\n\7\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00b0\3\2"+
		"\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0"+
		"\u00ae\3\2\2\2\u00b1\u00b2\b\37\2\2\u00b2>\3\2\2\2\u00b3\u00b4\7\61\2"+
		"\2\u00b4\u00b5\7,\2\2\u00b5\u00bb\3\2\2\2\u00b6\u00ba\n\b\2\2\u00b7\u00b8"+
		"\7,\2\2\u00b8\u00ba\n\t\2\2\u00b9\u00b6\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba"+
		"\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00be\3\2"+
		"\2\2\u00bd\u00bb\3\2\2\2\u00be\u00bf\7,\2\2\u00bf\u00c0\7\61\2\2\u00c0"+
		"\u00c1\3\2\2\2\u00c1\u00c2\b \2\2\u00c2@\3\2\2\2\f\2\u0087\u0089\u008f"+
		"\u0095\u0097\u00a4\u00ae\u00b9\u00bb\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}