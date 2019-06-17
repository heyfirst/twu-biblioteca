package biblioteca.core;

public class Library {
    public void sayWelcome() {
        System.out.println("Welcome to Biblioteca. Your one-step-shop for great book titles in Bangalore!");
    }

    public void showListOfBooks() {
        System.out.println(new Book("Clean Code", "2008","Robert C. Martin"));
        System.out.println(new Book("The Refactoring", "1999","Martin Fowler"));
    }
}
