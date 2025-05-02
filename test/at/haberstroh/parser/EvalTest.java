package at.haberstroh.parser;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JsonEvalTest {

    @Test
    void testSimpleObject() {
        String input = "{\"name\":\"Alice\",\"age\":30}";
        Object result = JsonParser.parse(input);

        assertTrue(result instanceof Map);
        Map<?, ?> obj = (Map<?, ?>) result;
        assertEquals("Alice", obj.get("name"));
        assertEquals(30.0, obj.get("age")); // Zahl wird als Double interpretiert
    }

    @Test
    void testNestedObject() {
        String input = "{\"person\":{\"name\":\"Bob\",\"age\":22}}";
        Object result = JsonParser.parse(input);

        assertTrue(result instanceof Map);
        Map<?, ?> root = (Map<?, ?>) result;
        Map<?, ?> person = (Map<?, ?>) root.get("person");

        assertEquals("Bob", person.get("name"));
        assertEquals(22.0, person.get("age"));
    }

    @Test
    void testWhitespaceAndFormatting() {
        String input = " { \"x\" : 1 , \"y\" : \"ok\" } ";
        Object result = JsonParser.parse(input);

        Map<?, ?> map = (Map<?, ?>) result;
        assertEquals(1.0, map.get("x"));
        assertEquals("ok", map.get("y"));
    }

    @Test
    void testSyntaxError() {
        String input = "{\"name\": \"Unclosed}";
        try {
            JsonParser.parse(input);
            fail("ParseException should be thrown");
        } catch (RuntimeException e) {
            // expected
        }
    }

    @Test
    void testMultipleObjectsFails() {
        String input = "{\"a\": 1}{\"b\": 2}";
        try {
            JsonParser.parse(input);
            fail("Should not parse two root objects");
        } catch (RuntimeException e) {
            // expected
        }
    }
}
