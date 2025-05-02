package at.haberstroh.parser;

import java.text.ParseException;

public class JsonString extends AbstractJsonExpression {

    private String value;

    @Override
    public void parse() throws ParseException {
        // TODO: STRING-Token lesen und als value speichern
    }

    @Override
    public Object interpret() {
        // TODO: return value;
        return null;
    }
}
