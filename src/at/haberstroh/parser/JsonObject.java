/*
 * Expression.java
 * (c) 2021-12-17, Harald R. Haberstroh
 */
package at.haberstroh.parser;

import at.haberstroh.lexer.Token;
import at.haberstroh.lexer.Tokentype;

import java.text.ParseException;
import java.util.List;
import java.util.Map;


import java.util.LinkedHashMap;
import java.util.Map;

public class JsonObject extends AbstractJsonExpression {
    private final Map<String, AbstractJsonExpression> members = new LinkedHashMap<>();

    public void parse() {
        // FIXME: Implement object parsing here
    }

    public void add(String key, AbstractJsonExpression value) {
        members.put(key, value);
    }

    @Override
    public Object interpret() {
        Map<String, Object> result = new LinkedHashMap<>();
        for (Map.Entry<String, AbstractJsonExpression> entry : members.entrySet()) {
            result.put(entry.getKey(), entry.getValue().interpret());
        }
        return result;
    }
}
