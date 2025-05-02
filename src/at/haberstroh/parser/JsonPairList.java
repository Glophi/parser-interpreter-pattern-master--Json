package at.haberstroh.parser;

import at.haberstroh.lexer.Tokentype;

import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;

public class JsonPairList extends AbstractJsonExpression {

    /** sammelt die Paare zwischen '{' und '}' */
    private final Map<String, AbstractJsonExpression> members = new LinkedHashMap<>();

    @Override
    public void parse() throws ParseException {

        while (position < tokens.size()){
            JsonPair jsonPair = new JsonPair();
            jsonPair.parse();
            members.put(jsonPair.getKey(),jsonPair.getValueExpression());

            position ++;
            if(position < tokens.size() && tokens.get(position).getType() == Tokentype.COMMA){
                position ++;
            }else {

                break;
            }

        }
    }

    /** Liefert die gesammelten Paare an JsonObject */
    public Map<String, AbstractJsonExpression> getMembers() {
        return members;
    }

    @Override
    public Object interpret() {
        // nicht benötigt, JsonObject übernimmt members direkt
        return null;
    }
}
