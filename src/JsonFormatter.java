import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * Created by Potter Hsu on 5/3/17.
 */
public class JsonFormatter {

    private static final int INDENT_SPACE = 2;

    public String format(String text) {
        StringBuilder formattedText = new StringBuilder();
        int indentCount = 0;

        for (char c : text.toCharArray()) {
            if (c == '[' || c == '{') {
                formattedText.append(c);
                formattedText.append('\n');
                indentCount += 1;
                appendIndent(formattedText, indentCount);
            }
            else if (c == ',') {
                formattedText.append(c);
                formattedText.append('\n');
                appendIndent(formattedText, indentCount);
            }
            else if (c == ']' || c == '}') {
                formattedText.append('\n');
                indentCount -= 1;
                appendIndent(formattedText, indentCount);
                formattedText.append(c);
            }
            else {
                formattedText.append(c);
            }
        }

        return formattedText.toString();
    }

    private void appendIndent(StringBuilder text, int indentCount) {
        for (int i = 0; i < indentCount * INDENT_SPACE; ++i) {
            text.append(' ');
        }
    }

}
