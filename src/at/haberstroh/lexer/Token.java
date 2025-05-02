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
}

