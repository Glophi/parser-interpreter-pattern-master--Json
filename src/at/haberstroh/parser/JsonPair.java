package at.haberstroh.parser;

import at.haberstroh.lexer.Tokentype;

import java.text.ParseException;
import java.util.AbstractMap;
import java.util.Map;
import java.util.logging.Logger;

import static at.haberstroh.parser.JsonParser.LOG_URL;

public class JsonPair extends AbstractJsonExpression {

    private String key;
    private AbstractJsonExpression valueExpr;
    Logger logger = Logger.getLogger(LOG_URL);

    @Override
    public void parse() throws ParseException {

        if(tokens.get(position).getType() != Tokentype.STRING){
            throw new ParseException("No String",position);
        }

        key = tokens.get(position).getToken();
        position ++;

        if(tokens.get(position).getType() != Tokentype.COLON){
            throw new ParseException("No Colon",position);

        }
        position ++;

        logger.info(tokens.get(position).toString());

        if(tokens.get(position).getType() == Tokentype.STRING){
            JsonString jsonString = new JsonString();
            jsonString.parse();
            valueExpr = jsonString;
        }
        if(tokens.get(position).getType() == Tokentype.NUMBER){
            JsonNumber jsonNumber = new JsonNumber();
            jsonNumber.parse();
            valueExpr = jsonNumber;
        }
        if(tokens.get(position).getType() == Tokentype.LEFT_BRACE){
            JsonObject jsonObject = new JsonObject();
            jsonObject.parse();
            valueExpr = jsonObject;
            position ++;
        }


        // TODO: STRING-Token als key lesen
        // TODO: ':' prüfen
        // TODO: value (String | Number | Object) parsen und in valueExpr speichern
    }

    @Override
    public Object interpret() {
        return new AbstractMap.SimpleEntry<>(key, valueExpr.interpret());

    }

    public String getKey() {
        return key;
    }

    public AbstractJsonExpression getValueExpression() {
        return valueExpr;
    }
}
