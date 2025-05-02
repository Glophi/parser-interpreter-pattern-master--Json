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




    public abstract void parse() throws ParseException;

    public abstract Object interpret();
}

