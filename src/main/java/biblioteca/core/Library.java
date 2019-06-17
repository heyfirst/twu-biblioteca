package biblioteca.core;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Library {
    private Scanner sc = new Scanner(System.in);
    private int currentState = 0;
    private ArrayList<Book> listOfBooks = new ArrayList<Book>();

    public void run() {
        this.sayWelcome();
        do {
            this.showListOfMenus();
            this.selectMenu();
        } while (this.currentState != -1);
        this.exitProgram();
    }

    public void sayWelcome() {
        System.out.println("Welcome to Biblioteca. Your one-step-shop for great book titles in Bangalore!");
    }

    public void showListOfBooks() {
        for(Book book: this.listOfBooks) {
            System.out.println(book);
        }
    }

    public void selectMenu() {
        try {
            System.out.print("Please Select Number: ");
            this.currentState = this.sc.nextInt();

            if (this.currentState == 1) {
                this.showListOfBooks();
            }
        } catch (InputMismatchException exception) {
            System.out.println("\n!Please select a valid option!");
        }
    }

    public void showListOfMenus() {
        System.out.println("------------------- Menu -------------------");
        System.out.println("> 1: List of books");
    }

    private void exitProgram() {
        System.exit(1);
    }

    public void addBook(Book newBook) {
        this.listOfBooks.add(newBook);
    }

    public ArrayList<Book> getListOfBooks() {
        return this.listOfBooks;
    }

    public void checkoutBookByIndex(int index) {
        this.listOfBooks.get(index).setAvailable(false);
    }
}
