class Author {
    private String name;
    private int birthYear;

    public Author(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }
}

class Book {
    private String title;
    private Author author;
    private String isbn;
    private boolean isBorrowed;

    public Book(String title, Author author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public boolean borrow() {
        if (!isBorrowed) {
            isBorrowed = true;
            return true;
        }
        return false;
    }

    public boolean returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            return true;
        }
        return false;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }
}

class Member {
    private String name;
    private String memberId;

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public void borrowBook(Book book) {
        if (book.borrow()) {
            System.out.println(name + " borrowed '" + book.getTitle() + "'");
        } else {
            System.out.println("'" + book.getTitle() + "' is not available.");
        }
    }

    public void returnBook(Book book) {
        if (book.returnBook()) {
            System.out.println(name + " returned '" + book.getTitle() + "'");
        } else {
            System.out.println(name + " doesn't have '" + book.getTitle() + "'");
        }
    }
}

class Library {
    private Book[] books;
    private int count;

    public Library(int size) {
        books = new Book[size];
        count = 0;
    }

    public void addBook(Book book) {
        if (count < books.length) {
            books[count] = book;
            count++;
        }
    }

    public void showBooks() {
        System.out.println("\nLibrary Collection:");
        for (int i = 0; i < count; i++) {
            String status = books[i].isBorrowed() ? "Borrowed" : "Available";
            System.out.println("- " + books[i].getTitle() + " by " + books[i].getAuthor().getName() + " (" + status + ")");
        }
    }
}

public class LibraryApp {
    public static void main(String[] args) {
        Author author1 = new Author("J.K. Rowling", 1965);
        Book book1 = new Book("Harry Potter", author1, "HP001");

        Library library = new Library(10);  // capacity of 10 books
        library.addBook(book1);

        Member member1 = new Member("Shivam", "M001");

        library.showBooks();
        member1.borrowBook(book1);
        library.showBooks();
        member1.returnBook(book1);
        library.showBooks();
    }
}
