package biblioteca.domain;

import java.util.Objects;

public class Book {
    private String title;
    private String year;
    private String author;

    public Book(String title, String year, String author) {
        this.title = title;
        this.year = year;
        this.author = author;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) &&
                Objects.equals(year, book.year) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year, author);
    }

    @Override
    public String toString() {
        return this.title + " (" + this.year + ") " + this.author;
    }
}
