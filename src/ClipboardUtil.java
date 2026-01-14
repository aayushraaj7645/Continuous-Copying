import java.awt.*;
import java.awt.datatransfer.*;

public class ClipboardUtil {

    public static String readClipboard() {
        try {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

          //  clipboard.setContents(new StringSelection(""), null);
            Transferable data = clipboard.getContents(null);

            if (data != null && data.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                return (String) data.getTransferData(DataFlavor.stringFlavor);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
