import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
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

public class LibraryManagementSystem {
    private List<Book> books;
    private Scanner scanner;

    public LibraryManagementSystem() {
        this.books = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addBook() {
        System.out.print("Enter book ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter book title: ");
        String title = scanner.next();
        System.out.print("Enter book author: ");
        String author = scanner.next();
        System.out.print("Is the book available? (true/false): ");
        boolean available = scanner.nextBoolean();

        Book book = new Book(id, title, author, available);
        books.add(book);
    }

    public void listBooks() {
        for (Book book : books) {
            System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Available: " + book.isAvailable());
        }
    }

    public void run() {
        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Add book");
            System.out.println("2. List books");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    addBook();
                    break;
                case 2:
                    listBooks();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        library.run();
    }
}