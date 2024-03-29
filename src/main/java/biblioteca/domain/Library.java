package biblioteca.domain;

import java.util.ArrayList;

public class Library {
    private static final String CHECKOUT_SUCCESS_MESSAGE = "Thank you! Enjoy your book!";
    private static final String CHECKOUT_NOT_AVAILABLE_MESSAGE = "The book is not available.";

    private static final String RETURN_SUCCESS_MESSAGE = "Thank you for returning the book!";
    private static final String RETURN_NOT_AVAILABLE_MESSAGE = "This is not a valid book to return.";

    private static final String BOOK_NOT_APPEAR_MESSAGE = "The book is not appear in the shelf.";
    private static final String RETURN_NOT_YOURS_OWN_BOOK_MESSAGE = "This is not your own book for return.";

    private ArrayList<Book> books = new ArrayList<Book>() {{
        add(new Book("Clean Code", "2008", "Uncle Bob"));
        add(new Book("The Refactoring", "1999", "Martin Fowler"));
    }};

    private ArrayList<Movie> movies = new ArrayList<Movie>() {{
        add(new Movie("Avengers: End game", "2019", "Brothers of Russo", 10, true));
        add(new Movie("Need for speed", "2014", "Scott Waugh", 9, true));
    }};

    private ArrayList<User> users = new ArrayList<User>() {{
        add(new User(
                "XYZ-1234",
                "ThoughtWorks",
                "Kanisorn Sutham",
                "kanisorn.sutham@thoughtWorks.com",
                "+66 (0) 88 252 9594"
        ));
    }};

    public ArrayList<Book> getBooks() {
        return this.books;
    }

    public Book getBook(int index) {
        return this.books.get(index);
    }

    public String checkOut(int index, User user) {
        if (index < 0 || index > this.books.size() - 1) {
            return BOOK_NOT_APPEAR_MESSAGE;
        }

        if (!this.books.get(index).isAvailable()) {
            return CHECKOUT_NOT_AVAILABLE_MESSAGE;
        }

        this.books.get(index).setAvailable(false);
        this.books.get(index).setOwnedBy(user);

        return CHECKOUT_SUCCESS_MESSAGE;
    }

    public String returnBook(int index, User user) {
        if (index < 0 || index > this.books.size() - 1) {
            return BOOK_NOT_APPEAR_MESSAGE;
        }

        if (this.books.get(index).isAvailable()) {
            return RETURN_NOT_AVAILABLE_MESSAGE;
        }

        if (this.books.get(index).getOwnedBy() != user) {
            return RETURN_NOT_YOURS_OWN_BOOK_MESSAGE;
        }

        this.books.get(index).setAvailable(true);
        this.books.get(index).setOwnedBy(null);
        return RETURN_SUCCESS_MESSAGE;
    }

    public ArrayList<Movie> getMovies() {
        return this.movies;
    }

    public void checkOutMovie(int index) {
        this.movies.get(index).setAvailable(false);
    }

    public Movie getMovie(int index) {
        return this.movies.get(index);
    }

    public Boolean login(String username, String password) {
        User user = this.findUserByUsername(username);
        return user.getPassword().equals(password);
    }

    public User findUserByUsername(String username) {
        return this.users.stream().filter(user -> user.getUsername().equals(username)).findFirst().orElse(null);
    }
}
