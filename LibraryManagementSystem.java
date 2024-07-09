import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem extends JFrame {
    private JTextField titleField;
    private JTextField authorField;
    private JCheckBox availableCheckbox;
    private JButton addButton;

    private Library library;

    public LibraryManagementSystem() {
        setTitle("Library Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        library = new Library();

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Title:"));
        titleField = new JTextField();
        panel.add(titleField);

        panel.add(new JLabel("Author:"));
        authorField = new JTextField();
        panel.add(authorField);

        panel.add(new JLabel("Available:"));
        availableCheckbox = new JCheckBox();
        panel.add(availableCheckbox);

        addButton = new JButton("Add Book");
        addButton.addActionListener(e -> addBook());
        panel.add(addButton);

        add(panel, BorderLayout.CENTER);
    }

    private void addBook() {
        String title = titleField.getText();
        String author = authorField.getText();
        boolean available = availableCheckbox.isSelected();

        Book book = new Book(library.getNextId(), title, author, available);
        library.addBook(book);

        titleField.setText("");
        authorField.setText("");
        availableCheckbox.setSelected(false);

        JOptionPane.showMessageDialog(this, "Book added successfully!");
    }

    private static class Book {
        private int id;
        private String title;
        private String author;
        private boolean available;

        public Book(int id, String title, String author, boolean available) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.available = available;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public boolean isAvailable() {
            return available;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }
    }

    private static class Library {
        private List<Book> books;
        private int nextId;

        public Library() {
            this.books = new ArrayList<>();
            this.nextId = 1;
        }

        public void addBook(Book book) {
            books.add(book);
            nextId++;
        }

        public int getNextId() {
            return nextId;
        }
    }
}

