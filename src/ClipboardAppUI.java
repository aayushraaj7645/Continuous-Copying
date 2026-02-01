import javax.swing.*;
import java.awt.*;

public class ClipboardAppUI {

    public static void main(String[] args) {

        PasteAll.resetClipboard();

        new Thread(ClipboardListener::startListening).start();

        // 2️⃣ Create window
        JFrame frame = new JFrame("Continuous Clipboard");

        frame.setAlwaysOnTop(true);
       // frame.setUndecorated(true);// stays on desktop
        frame.setSize(400, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // 3️⃣ Status label
        JLabel statusLabel = new JLabel(
                " Clipboard listener running...",
                SwingConstants.CENTER
        );
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 16));


        // 4️⃣ Paste All button
        JButton pasteButton = new JButton("To Paste all copied at once");
        pasteButton.setFont(new Font("Arial", Font.BOLD, 16));

        pasteButton.addActionListener(e -> {

            PasteAll.pasteAll();
            flashButton(pasteButton);


        });

        JButton resetButton = new JButton("Reset the Clipboard");
        resetButton.setFont(new Font("Arial", Font.BOLD, 14));

        resetButton.addActionListener(e -> {
            PasteAll.resetClipboard();
            ClipboardListener.clearBuffer();
           flashButton(resetButton);

        });


        // 5️⃣ Add components
        frame.add(statusLabel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        buttonPanel.add(pasteButton);
        buttonPanel.add(resetButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);


        // 6️⃣ Show window
        frame.setLocationRelativeTo(null); // center
        frame.setVisible(true);
    }


    private static void flashButton(JButton button) {
        Color original = button.getBackground();
        button.setBackground(Color.GREEN);
        Timer timer = new Timer(500, e -> button.setBackground(original));
        timer.setRepeats(false);
        timer.start();
    }


}
