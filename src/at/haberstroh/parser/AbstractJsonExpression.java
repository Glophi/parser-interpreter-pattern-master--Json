package at.haberstroh.parser;

import at.haberstroh.lexer.Token;

import java.text.ParseException;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;


import java.util.List;

public abstract class AbstractJsonExpression {
    protected static List<Token> tokens;
    protected static int position;

    public static void init(List<Token> tokenList) {
        tokens = tokenList;
        position = 0;
    }

    protected Token current() {
        return tokens.get(position);
    }

    protected Token consume() {
        return tokens.get(position++);
    }

    protected boolean match(String symbol) {
        return current().text.equals(symbol);
    }

    public abstract Object interpret();
}

