package at.haberstroh.parser;

import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;

public class JsonPairList extends AbstractJsonExpression {

    /** sammelt die Paare zwischen '{' und '}' */
    private final Map<String, AbstractJsonExpression> members = new LinkedHashMap<>();

    @Override
    public void parse() throws ParseException {
        // TODO: mindestens ein JsonPair einlesen
        // TODO: Komma-getrennte Paare fortlaufend einlesen
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
