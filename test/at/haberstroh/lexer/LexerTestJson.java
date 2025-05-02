package at.haberstroh.lexer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static at.haberstroh.lexer.Tokentype.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LexerTestJson {

    @Test
    void testSimpleObject() {
        String input = "{\"name\":\"John\",\"age\":30}";
        Lexer lexer = new Lexer(input);
        List<Token> tokens = lexer.tokenize();

        assertEquals(List.of(
                new Token(LEFT_BRACE, "{"),
                new Token(STRING, "name"),
                new Token(COLON, ":"),
                new Token(STRING, "John"),
                new Token(COMMA, ","),
                new Token(STRING, "age"),
                new Token(COLON, ":"),
                new Token(NUMBER, "30"),
                new Token(RIGHT_BRACE, "}"),
                new Token(EOF, "")
        ), tokens);
    }

    @Test
    void testNestedObject() {
        String input = "{\"person\":{\"city\":\"Vienna\"}}";
        Lexer lexer = new Lexer(input);
        List<Token> tokens = lexer.tokenize();

        assertEquals(List.of(
                new Token(LEFT_BRACE, "{"),
                new Token(STRING, "person"),
                new Token(COLON, ":"),
                new Token(LEFT_BRACE, "{"),
                new Token(STRING, "city"),
                new Token(COLON, ":"),
                new Token(STRING, "Vienna"),
                new Token(RIGHT_BRACE, "}"),
                new Token(RIGHT_BRACE, "}"),
                new Token(EOF, "")
        ), tokens);
    }

    @Test
    void testStringWithSpaces() {
        String input = "{\"msg\": \"Hello World\"}";
        Lexer lexer = new Lexer(input);
        List<Token> tokens = lexer.tokenize();

        assertEquals(List.of(
                new Token(LEFT_BRACE, "{"),
                new Token(STRING, "msg"),
                new Token(COLON, ":"),
                new Token(STRING, "Hello World"),
                new Token(RIGHT_BRACE, "}"),
                new Token(EOF, "")
        ), tokens);
    }

    @Test
    void testNumberWithMinusAndDot() {
        String input = "{\"value\": -12.5}";
        Lexer lexer = new Lexer(input);
        List<Token> tokens = lexer.tokenize();

        assertEquals(List.of(
                new Token(LEFT_BRACE, "{"),
                new Token(STRING, "value"),
                new Token(COLON, ":"),
                new Token(NUMBER, "-12.5"),
                new Token(RIGHT_BRACE, "}"),
                new Token(EOF, "")
        ), tokens);
    }

    @Test
    void testInvalidInput() {
        String input = "{\"key\"=42}";
        Lexer lexer = new Lexer(input);
        assertThrows(RuntimeException.class, lexer::tokenize);
    }
}