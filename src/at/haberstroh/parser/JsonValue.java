/*
 * Terminal.java
 * (c) 2021-12-17, Harald R. Haberstroh
 */
package at.haberstroh.parser;

import at.haberstroh.lexer.Token;
import at.haberstroh.lexer.Tokentype;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

// JsonValue.java


public class JsonValue extends AbstractJsonExpression {
    private final AbstractJsonExpression inner = null;



    @Override
    public void parse() throws ParseException {

    }

    @Override
    public Object interpret() {
        return inner.interpret();
    }
}
