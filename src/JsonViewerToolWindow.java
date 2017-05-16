import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * Created by Potter Hsu on 5/3/17.
 */
public class JsonViewerToolWindow implements ToolWindowFactory {

    private JPanel toolWindowContent;
    private JButton buttonFormat;
    private JTextArea textArea;
    private JLabel labelMessage;

    private JsonFormatter jsonFormatter = new JsonFormatter();

    public JsonViewerToolWindow() {
        buttonFormat.addActionListener(e -> {
            labelMessage.setText("");
            String text = textArea.getText();
            text = text.replaceAll("(\\n)", "");
            try {
                text = new JSONObject(text).toString();
            } catch (JSONException ee) {
                labelMessage.setText("Invalid JSON text");
            }
            String formattedText = jsonFormatter.format(text);
            textArea.setText(formattedText);
        });
    }

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(toolWindowContent, "", false);
        toolWindow.getContentManager().addContent(content);
    }
}
