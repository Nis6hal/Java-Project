import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LibraryManagementSystem frame = new LibraryManagementSystem();
            frame.setVisible(true);
        });
    }
}
