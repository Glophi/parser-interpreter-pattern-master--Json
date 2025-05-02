/*
 * Term.java
 * (c) 2021-12-17, Harald R. Haberstroh
 */
package at.haberstroh.parser;

import at.haberstroh.lexer.Token;
import at.haberstroh.lexer.Tokentype;

import java.text.ParseException;
import java.util.List;
import java.util.Map;



public class JsonNumber extends AbstractJsonExpression {
    private final double value;

    public JsonNumber(String text) {
        this.value = Double.parseDouble(text);
    }

    @Override
    public Object interpret() {
        return value;
    }
}
