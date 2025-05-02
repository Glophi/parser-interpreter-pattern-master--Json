package at.haberstroh.parser;

import java.text.ParseException;

public class JsonNumber extends AbstractJsonExpression {

    private double value;

    @Override
    public void parse() throws ParseException {
        // TODO: NUMBER-Token lesen, in double parsen und als value speichern
        value = Double.parseDouble(tokens.get(position).getToken());
    }

    @Override
    public Object interpret() {
        // TODO: return value;
        return value;
    }
}
