package at.haberstroh.lexer;

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
        int start = ++pos; // Skip opening quote
        while (pos < input.length() && input.charAt(pos) != '"') {
            pos++;
        }
        String text = input.substring(start, pos);
        pos++; // Skip closing quote
        return new Token(Tokentype.STRING, text);
    }

    private Token readNumber() {
        int start = pos;
        if (input.charAt(pos) == '-') pos++;
        while (pos < input.length() && Character.isDigit(input.charAt(pos))) {
            pos++;
        }
        if (pos < input.length() && input.charAt(pos) == '.') {
            pos++;
            while (pos < input.length() && Character.isDigit(input.charAt(pos))) {
                pos++;
            }
        }
        String text = input.substring(start, pos);
        return new Token(Tokentype.NUMBER, text);
    }
    public static void main(String[] args) {
        String input = "{\"name\": \"John\", \"age\": 42}";
        Lexer lexer = new Lexer(input);
        List<Token> tokens = lexer.tokenize();
        System.out.println(tokens);
    }

}
