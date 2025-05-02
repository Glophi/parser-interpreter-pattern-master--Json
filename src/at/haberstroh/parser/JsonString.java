/*
 * Factor.java
 * (c) 2021-12-17, Harald R. Haberstroh
 */
package at.haberstroh.parser;

import at.haberstroh.lexer.Token;
import at.haberstroh.lexer.Tokentype;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class JsonString extends AbstractJsonExpression {
    private final String value = null;



    @Override
    public void parse() throws ParseException {

    }

    @Override
    public Object interpret() {
        return value;
    }
}