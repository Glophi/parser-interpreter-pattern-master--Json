/*
 * Eval.java
 * (c) 2021-12-17, Harald R. Haberstroh
 */
package at.haberstroh.parser;

import at.haberstroh.lexer.Lexer;
import at.haberstroh.lexer.Token;

import java.awt.*;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import java.util.List;

public class JsonParser {
    public static Object parse(String input) {
        Lexer lexer = new Lexer(input);
        List<Token> tokens = lexer.tokenize();
        AbstractJsonExpression.init(tokens);

        JsonObject root = new JsonObject();
        root.parse(); // TODO: du implementierst die Logik selbst
        return root.interpret();
    }

    public static void main(String[] args) {
        String json = "{\"name\":\"John\",\"age\":42}";
        Object result = JsonParser.parse(json);
        System.out.println(result);
    }
}
