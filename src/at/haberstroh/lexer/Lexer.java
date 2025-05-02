/*
 * Lexer.java
 * 2019-12-05 Harald. R. Haberstroh
 */
package at.haberstroh.lexer;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import static at.haberstroh.lexer.Tokentype.*;
import static java.io.StreamTokenizer.*;
import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private final String input;
    private int pos = 0;

    public Lexer(String input) {
        this.input = input;
    }

    public List<Token> tokenize() {
        List<Token> tokens = new ArrayList<>();
        while (pos < input.length()) {
            char ch = input.charAt(pos);
            switch (ch) {
                case '{':
                    tokens.add(new Token(Tokentype.LEFT_BRACE, "{"));
                    pos++;
                    break;
                case '}':
                    tokens.add(new Token(Tokentype.RIGHT_BRACE, "}"));
                    pos++;
                    break;
                case ':':
                    tokens.add(new Token(Tokentype.COLON, ":"));
                    pos++;
                    break;
                case ',':
                    tokens.add(new Token(Tokentype.COMMA, ","));
                    pos++;
                    break;
                case '"':
                    tokens.add(readString());
                    break;
                default:
                    if (Character.isDigit(ch) || ch == '-') {
                        tokens.add(readNumber());
                    } else if (Character.isWhitespace(ch)) {
                        pos++;
                    } else {
                        throw new RuntimeException("Unexpected character: " + ch);
                    }
            }
        }
        tokens.add(new Token(Tokentype.EOF, ""));
        return tokens;
    }

    private Token readString() {
        int start = ++pos;
        while (pos < input.length() && input.charAt(pos) != '"') {
            pos++;
        }
        String text = input.substring(start, pos);
        pos++; // skip closing quote
        return new Token(Tokentype.STRING, text);
    }

    private Token readNumber() {
        int start = pos;
        while (pos < input.length() &&
                (Character.isDigit(input.charAt(pos)) || input.charAt(pos) == '.' || input.charAt(pos) == '-')) {
            pos++;
        }
        String text = input.substring(start, pos);
        return new Token(Tokentype.NUMBER, text);
    }

    public static void main(String[] args) {
        // Beispiel-Testdaten (verschiedene Fälle)
        String[] examples = {
                "{\"name\":\"Alice\",\"age\":30}",
                "{\"x\": -12.5, \"y\": 3.14}",
                "{\"nested\": {\"key\": \"value\"}}",
                "{\"text\": \"Hello World\"}",
                "{\"invalid\"=42}" // Dieser wird einen Fehler auslösen
        };

        for (int i = 0; i < examples.length; i++) {
            System.out.println("=== Beispiel " + (i + 1) + " ===");
            String input = examples[i];
            System.out.println("Input: " + input);

            try {
                Lexer lexer = new Lexer(input);
                List<Token> tokens = lexer.tokenize();
                for (Token token : tokens) {
                    System.out.println(token);
                }
            } catch (RuntimeException e) {
                System.out.println("❌ Fehler beim Tokenisieren: " + e.getMessage());
            }

            System.out.println();
        }
    }
}