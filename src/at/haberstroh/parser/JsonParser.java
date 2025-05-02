/*
 * Eval.java
 * (c) 2021-12-17, Harald R. Haberstroh
 */
package at.haberstroh.parser;

import at.haberstroh.lexer.Lexer;
import at.haberstroh.lexer.Token;

import java.awt.*;
import java.text.ParseException;
import java.util.*;


import java.util.List;
import java.util.logging.Logger;

public class JsonParser {
    public final static String LOG_URL = "at.pfaffenlehner.lexer";
    Logger logger = Logger.getLogger(LOG_URL);
    public static Object parse(String input) throws ParseException {
        Lexer lexer = new Lexer(input);
        List<Token> tokens = lexer.tokenize();
        AbstractJsonExpression.init(tokens);

        JsonObject root = new JsonObject();
        root.parse();
        return root.interpret();
    }

    public static void main(String[] args) throws ParseException {
        String json = "{\"name\":\"John\",\"age\":42,\"address\":{\"street\":\"Main Street\",\"number\":42,\"city\":\"Vienna\"}}";

        Object result = JsonParser.parse(json);
        System.out.println(result);
    }
}
