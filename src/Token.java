﻿public class Token {

	private static final int KEYWORDS = TokenType.Eof.ordinal();
	private static final String[] reserved = new String[KEYWORDS];
	
	public static final Token eofTok          = new Token(TokenType.Eof,          Emoji.eof.toString(), Emoji.eof.toString());
	public static final Token spaceTok        = new Token(TokenType.Space,        Emoji.space.toString(), Emoji.space.toString());
	public static final Token tabTok          = new Token(TokenType.Tab,          Emoji.tab.toString(), Emoji.tab.toString());
	public static final Token newlineTok      = new Token(TokenType.Newline,      Emoji.newline.toString(), Emoji.newline.toString());
	
	public static final Token assignTok       = new Token(TokenType.Assign,       "=", Emoji.assignEmoji.toString());
	public static final Token ifTok           = new Token(TokenType.If,           "if", Emoji.ifEmoji.toString());
	public static final Token elseTok         = new Token(TokenType.Else,         "else", Emoji.elseEmoji.toString());
	public static final Token whileTok        = new Token(TokenType.While,        "while", Emoji.whileEmoji.toString());
	public static final Token breakTok        = new Token(TokenType.Break,        "break", Emoji.breakEmoji.toString());
	public static final Token continueTok     = new Token(TokenType.Continue,     "continue", Emoji.continueEmoji.toString());

	public static final Token orTok           = new Token(TokenType.Or,           "||", Emoji.orEmoji.toString());
	public static final Token andTok          = new Token(TokenType.And,          "&&", Emoji.andEmoji.toString());
	public static final Token notTok          = new Token(TokenType.Not,          "!", Emoji.notEmoji.toString());
	public static final Token equalsTok       = new Token(TokenType.Equals,       "==", Emoji.equalsEmoji.toString());
	public static final Token notEqualTok     = new Token(TokenType.NotEqual,     "!=", Emoji.notEmoji.toString() + Emoji.equalsEmoji.toString());
	public static final Token lessTok         = new Token(TokenType.Less,         "<", Emoji.lessEmoji.toString());
	public static final Token lessEqualTok    = new Token(TokenType.LessEqual,    "<=", Emoji.lessEmoji.toString() + Emoji.equalsEmoji.toString());
	public static final Token greaterTok      = new Token(TokenType.Greater,      ">", Emoji.greaterEmoji.toString());
	public static final Token greaterEqualTok = new Token(TokenType.GreaterEqual, ">=", Emoji.greaterEmoji.toString() + Emoji.equalsEmoji.toString());
	
	public static final Token trueTok         = new Token(TokenType.True,         "true", Emoji.trueEmoji.toString());
	public static final Token falseTok        = new Token(TokenType.False,        "false", Emoji.falseEmoji.toString());
	
	public static final Token plusTok         = new Token(TokenType.Plus,         "+", Emoji.plusEmoji.toString());
	public static final Token minusTok        = new Token(TokenType.Minus,        "-", Emoji.minusEmoji.toString());
	public static final Token multiplyTok     = new Token(TokenType.Multiply,     "*", Emoji.multiflyEmoji.toString());
	public static final Token divideTok       = new Token(TokenType.Divide,       "/", Emoji.divideEmoji.toString());
	public static final Token remainderTok    = new Token(TokenType.Remainder,    "%", Emoji.remainderEmoji.toString());
	
	public static final Token leftBracketTok  = new Token(TokenType.LeftBracket,  "[", Emoji.leftbracketEmoji.toString());
	public static final Token rightBracketTok = new Token(TokenType.RightBracket, "]", Emoji.rightbracketEmoji.toString());
	public static final Token leftParenTok    = new Token(TokenType.LeftParen,    "(", Emoji.leftparenEmoji.toString());
	public static final Token rightParenTok   = new Token(TokenType.RightParen,   ")", Emoji.rightparenEmoji.toString());
    
	public static final Token printTok        = new Token(TokenType.Print,        "print", Emoji.printEmoji.toString());
	public static final Token inputTok        = new Token(TokenType.Input,        "input", Emoji.inputEmoji.toString());
	public static final Token randomTok       = new Token(TokenType.Random,       "random", Emoji.randomEmoji.toString());
	public static final Token timeTok         = new Token(TokenType.Time,         "time", Emoji.timeEmoji.toString());

	public static final Token intTypeTok      = new Token(TokenType.IntType,      "int()", Emoji.intTypeEmoji.toString());
	public static final Token floatTypeTok    = new Token(TokenType.FloatType,    "float()", Emoji.floatTypeEmoji.toString());
	
	private static EmojiHelper emojiHelper = new EmojiHelper();
	
	private TokenType type;
	private String value = "";	// 출력용(마음대로 바꿔도 됨)
	private String emoji = "";	// 입력용(E-Language 문법에 맞아야 함)
	
	private Token(TokenType t, String v, String e) {
		type = t;
		value = v;
		emoji = e;
		
		if (t.compareTo(TokenType.Eof) < 0) {
			int ti = t.ordinal();
			reserved[ti] = v;
		}
	}

	public TokenType type() { return type; }
	public String value() { return value; }

	public static Token mkIdentTok(String name) {
		return new Token(TokenType.Identifier, emojiHelper.parseString(name), name);
	}

	public static Token mkIntLiteral(String number) {
		return new Token(TokenType.IntLiteral, emojiHelper.parseString(number), number);
	}
	
	public static Token mkFloatLiteral(String number) {
		return new Token(TokenType.FloatLiteral, emojiHelper.parseString(number), number);
	}
	
	public static Token mkCharLiteral(String ch) {
		return new Token(TokenType.CharLiteral, emojiHelper.parseString(ch), ch);
	}
	
	public static Token mkStringLiteral(String str) {
		return new Token (TokenType.StringLiteral, emojiHelper.parseString(str), str);
	}
	
	public String toString() {
		return String.format("\t%-15s\t%s, %s", type, value, emoji);
	}
}
