package at.haberstroh.parser;

import at.haberstroh.lexer.Tokentype;

import java.text.ParseException;
import java.util.Map;

public class JsonPair extends AbstractJsonExpression {

    private String key;
    private JsonValue value;

    @Override
    public void parse() throws ParseException {

    }

    @Override
    public Object interpret() {
        return Map.entry(key, value.interpret());
    }

    public String getKey() {
        return key;
    }

    public JsonValue getValue() {
        return value;
    }
}
