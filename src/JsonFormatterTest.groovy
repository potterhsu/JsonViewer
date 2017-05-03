/**
 * Created by Potter Hsu on 5/3/17.
 */
class JsonFormatterTest extends GroovyTestCase {

    private JsonFormatter jsonFormatter;

    void setUp() {
        super.setUp()
        jsonFormatter = new JsonFormatter();
    }

    void tearDown() {

    }

    void testFormat() {
        String text = "{\"version\":\"1.0\",\"data\":{\"sampleArray\":[\"string value\",5,{\"name\":\"sub object\"}]}}";

        String formattedText = jsonFormatter.format(text);
        println(formattedText);

        String formattedFormattedText = jsonFormatter.format(formattedText);
        println(formattedFormattedText);
    }

}
