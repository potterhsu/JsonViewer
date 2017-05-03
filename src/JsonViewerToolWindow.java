import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * Created by Potter Hsu on 5/3/17.
 */
public class JsonViewerToolWindow implements ToolWindowFactory {

    private JPanel toolWindowContent;
    private JButton buttonFormat;
    private JTextArea textArea;

    private JsonFormatter jsonFormatter = new JsonFormatter();

    public JsonViewerToolWindow() {
        buttonFormat.addActionListener(e -> {
            String text = textArea.getText();
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
