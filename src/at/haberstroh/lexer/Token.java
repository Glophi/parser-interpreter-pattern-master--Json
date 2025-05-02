package at.haberstroh.lexer;

import java.util.Objects;

public class Token {
    public final Tokentype type;
    public final String text;

    public Token(Tokentype type, String text) {
        this.type = type;
        this.text = text;
    }

    @Override
    public String toString() {
        return "[" + type + ", " + text + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Token)) return false;
        Token other = (Token) obj;
        return this.type == other.type && this.text.equals(other.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, text);
    }
}
