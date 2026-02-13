import java.util.ArrayList;
import java.util.List;

// --- 1. Book Class ---
class Book {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() { return title; }

    @Override
    public String toString() {
        return String.format("Title: %-20s | Author: %-20s | ISBN: %s", title, author, isbn);
    }
}

// --- 2. Library Class ---
class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Successfully added: " + book.getTitle());
    }

    public Book searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void displayAllBooks() {
        System.out.println("\n--- Current Library Inventory ---");
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book b : books) {
                System.out.println(b);
            }
        }
        System.out.println("---------------------------------");
    }
}

// --- 3. Main Class (The Entry Point) ---
public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books to the system
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565"));
        library.addBook(new Book("1984", "George Orwell", "9780451524935"));
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "9780547928227"));

        // Display all books
        library.displayAllBooks();

        // Search for a specific book
        String query = "1984";
        System.out.println("\nSearching for title: '" + query + "'...");
        Book result = library.searchByTitle(query);

        if (result != null) {
            System.out.println("Match found! Details: " + result);
        } else {
            System.out.println("Sorry, that book is not in our collection.");
        }
    }
}