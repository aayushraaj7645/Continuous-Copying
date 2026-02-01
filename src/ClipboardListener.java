import java.awt.*;
import java.util.*;
import java.util.List;

public class ClipboardListener {

    private static List<String> buffer = new ArrayList<>();
    private static String lastText = "";


    public static void startListening() {
        System.out.println("📋 Clipboard Listener Started...");

        while (true) {
            String currentText = ClipboardUtil.readClipboard();

            if (!currentText.isEmpty() && !currentText.equals(lastText)) {
                buffer.add(currentText);
                lastText = currentText;

                System.out.println("Copied: " + preview(currentText));
            }

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static String preview(String text) {
        return text.length() > 40 ? text.substring(0, 40) + "..." : text;
    }

    public static List<String> getBuffer() {
        return buffer;
    }

    public static void clearBuffer() {
        buffer.clear();
    }


}