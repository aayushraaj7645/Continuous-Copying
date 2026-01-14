import javax.swing.*;
import java.awt.*;

public class ClipboardAppUI {

    public static void main(String[] args) {

        // 1️⃣ Start clipboard listener in background
        new Thread(() -> ClipboardListener.startListening()).start();

        // 2️⃣ Create window
        JFrame frame = new JFrame("Continuous Clipboard");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // 3️⃣ Status label
        JLabel statusLabel = new JLabel(
                "📋 Clipboard listener running...",
                SwingConstants.CENTER
        );
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        // 4️⃣ Paste All button
        JButton pasteButton = new JButton("Paste All");
        pasteButton.setFont(new Font("Arial", Font.BOLD, 16));

        pasteButton.addActionListener(e -> {
            PasteAll.pasteAll();
            JOptionPane.showMessageDialog(frame,
                    "All copied text moved to clipboard!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        // 5️⃣ Add components
        frame.add(statusLabel, BorderLayout.CENTER);
        frame.add(pasteButton, BorderLayout.SOUTH);

        // 6️⃣ Show window
        frame.setLocationRelativeTo(null); // center
        frame.setVisible(true);
    }
}
