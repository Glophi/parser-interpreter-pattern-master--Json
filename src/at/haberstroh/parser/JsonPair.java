package at.haberstroh.parser;

import java.text.ParseException;
import java.util.AbstractMap;
import java.util.Map;

public class JsonPair extends AbstractJsonExpression {

    private String key;
    private AbstractJsonExpression valueExpr;

    @Override
    public void parse() throws ParseException {
        // TODO: STRING-Token als key lesen
        // TODO: ':' prüfen
        // TODO: value (String | Number | Object) parsen und in valueExpr speichern
    }

    @Override
    public Object interpret() {
        // TODO: return new AbstractMap.SimpleEntry<>(key, valueExpr.interpret());
        return null;
    }

    public String getKey() {
        return key;
    }

    public AbstractJsonExpression getValueExpression() {
        return valueExpr;
    }
}
