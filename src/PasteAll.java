import java.awt.*;
import java.awt.datatransfer.*;

public class PasteAll {

    public static void pasteAll() {
        StringBuilder finalText = new StringBuilder();

        for (String item : ClipboardListener.getBuffer()) {
            finalText.append(item).append("\n");
        }

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(new StringSelection(finalText.toString()), null);

        System.out.println("✅ All copied data moved to clipboard!");
    }
}
