/*
 * Expression.java
 * (c) 2021-12-17, Harald R. Haberstroh
 */
package at.haberstroh.parser;

import at.haberstroh.lexer.Token;
import at.haberstroh.lexer.Tokentype;

import java.text.ParseException;
import java.util.*;


import java.util.Map;
import java.util.logging.Logger;

import static at.haberstroh.parser.JsonParser.LOG_URL;

public class JsonObject extends AbstractJsonExpression {
    Logger logger = Logger.getLogger(LOG_URL);
    private final Map<String, AbstractJsonExpression> members = new LinkedHashMap<>();

    /*
    <JSON> ::= <Object>
    <Object> ::= '{' <pairList> '}'
    <pairList> ::= <pair> | <pair> ',' <pairList>
    <pair> ::= string ':' value
    <value> ::= string | number | object
     */
    public void parse() throws ParseException {
        if(position <= tokens.size()){
           logger.info(String.valueOf(tokens.get(position)));
           if(tokens.get(position).getType() != Tokentype.LEFT_BRACE){
               logger.severe("Wrong Syntax! No left Brace at beginning");
               throw new ParseException("unexpected end", position);

           }
           position ++;
           JsonPairList jsonPairList = new JsonPairList();
           jsonPairList.parse();
           members.putAll(jsonPairList.getMembers());



           if( position < tokens.size() && tokens.get(position).getType() != Tokentype.RIGHT_BRACE){
               logger.severe("Wrong Syntax! No right Brace");
               throw new ParseException("unexpected end", position);
           }
           position++;

        }
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
