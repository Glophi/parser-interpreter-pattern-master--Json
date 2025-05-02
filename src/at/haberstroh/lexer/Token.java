/*
 * Token.java
 * 2019-12-05 Harald. R. Haberstroh
 */
package at.haberstroh.lexer;

public class Token {
    public final Tokentype type;
    public final String text;

    public Token(Tokentype type, String text) {
        this.type = type;
        this.text = text;
    }

    @Override
    public String toString() {
        return type + "('" + text + "')";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Token)) return false;
        Token token = (Token) o;
        return type == token.type && text.equals(token.text);
    }

    @Override
    public int hashCode() {
        return type.hashCode() * 31 + text.hashCode();
    }

}

