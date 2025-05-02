package at.haberstroh.lexer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static at.haberstroh.lexer.Tokentype.*;

import static org.junit.jupiter.api.Assertions.*;

class LexerTest {

    Lexer lexer;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getTokensWithWhitespace() {
        String input = "( 2.3 + 2 ^ 3 ) * xv * -1 =\n" +
                       "xv * -10.3";
        Token[] expectedTokens = new Token[]{
                new Token(OPEN_BRACKET, "("),
                new Token(NUMBER, "2.3"),
                new Token(PLUSMINUS, "+"),
                new Token(NUMBER, "2.0"),
                new Token(RAISED, "^"),
                new Token(NUMBER, "3.0"),
                new Token(CLOSE_BRACKET, ")"),
                new Token(MULTDIV, "*"),
                new Token(VARIABLE, "xv"),
                new Token(MULTDIV, "*"),
                new Token(PLUSMINUS, "-"),
                new Token(NUMBER, "1.0"),
                new Token(OTHER, "="),
                new Token(VARIABLE, "xv"),
                new Token(MULTDIV, "*"),
                new Token(PLUSMINUS, "-"),
                new Token(NUMBER, "10.3"),
                new Token(EOF, "EOF"),
        };
        List<Token> expected = List.of(expectedTokens);
        lexer = new Lexer(input);
        assertEquals(expected, lexer.getTokens());
    }

    @Test
    void getTokensNoWhitespace() {
        String input = "(2.3+2^3)*xv*-1=\n" +
                "xv*-10.3";
        Token[] expectedTokens = new Token[]{
                new Token(OPEN_BRACKET, "("),
                new Token(NUMBER, "2.3"),
                new Token(PLUSMINUS, "+"),
                new Token(NUMBER, "2.0"),
                new Token(RAISED, "^"),
                new Token(NUMBER, "3.0"),
                new Token(CLOSE_BRACKET, ")"),
                new Token(MULTDIV, "*"),
                new Token(VARIABLE, "xv"),
                new Token(MULTDIV, "*"),
                new Token(PLUSMINUS, "-"),
                new Token(NUMBER, "1.0"),
                new Token(OTHER, "="),
                new Token(VARIABLE, "xv"),
                new Token(MULTDIV, "*"),
                new Token(PLUSMINUS, "-"),
                new Token(NUMBER, "10.3"),
                new Token(EOF, "EOF"),
        };
        List<Token> expected = List.of(expectedTokens);
        lexer = new Lexer(input);
        assertEquals(expected, lexer.getTokens());
    }

    @Test
    void getTokensWithDivide() {
        String input = "(2.3+2^3)/xv*-1=\n" +
                "xv/-10.3";
        Token[] expectedTokens = new Token[]{
                new Token(OPEN_BRACKET, "("),
                new Token(NUMBER, "2.3"),
                new Token(PLUSMINUS, "+"),
                new Token(NUMBER, "2.0"),
                new Token(RAISED, "^"),
                new Token(NUMBER, "3.0"),
                new Token(CLOSE_BRACKET, ")"),
                new Token(MULTDIV, "/"),
                new Token(VARIABLE, "xv"),
                new Token(MULTDIV, "*"),
                new Token(PLUSMINUS, "-"),
                new Token(NUMBER, "1.0"),
                new Token(OTHER, "="),
                new Token(VARIABLE, "xv"),
                new Token(MULTDIV, "/"),
                new Token(PLUSMINUS, "-"),
                new Token(NUMBER, "10.3"),
                new Token(EOF, "EOF"),
        };
        List<Token> expected = List.of(expectedTokens);
        lexer = new Lexer(input);
        assertEquals(expected, lexer.getTokens());
    }

    @Test
    void getTokensWithFunction() {
        String input = "sqrt(4)-2.0";
        Token[] expectedTokens = new Token[]{
                new Token(VARIABLE, "sqrt"),
                new Token(OPEN_BRACKET, "("),
                new Token(NUMBER, "4.0"),
                new Token(CLOSE_BRACKET, ")"),
                new Token(PLUSMINUS, "-"),
                new Token(NUMBER, "2.0"),
                new Token(EOF, "EOF"),
        };
        List<Token> expected = List.of(expectedTokens);
        lexer = new Lexer(input);
        assertEquals(expected, lexer.getTokens());
    }


}