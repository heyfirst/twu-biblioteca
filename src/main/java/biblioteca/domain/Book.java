package biblioteca.domain;

import java.util.Objects;

public class Book {
    private String title;
    private String year;
    private String author;
    private Boolean available = true;
    private User ownedBy;

    public Book(String title, String year, String author) {
        this.title = title;
        this.year = year;
        this.author = author;
    }

    public Book(String title, String year, String author, Boolean available) {
        this.title = title;
        this.year = year;
        this.author = author;
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean isAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) &&
                Objects.equals(year, book.year) &&
                Objects.equals(author, book.author) &&
                Objects.equals(available, book.available);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year, author, available);
    }

    @Override
    public String toString() {
        if (available) {
            return this.title + " (" + this.year + ") " + this.author + " [AVAILABLE]";
        } else {
            return this.title + " (" + this.year + ") " + this.author + " [NO AVAILABLE]";
        }

    }

    public void setOwnedBy(User user) {
        this.ownedBy = user;
    }

    public User getOwnedBy() {
        return ownedBy;
    }
}
