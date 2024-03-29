package biblioteca.presentation;

import biblioteca.domain.Book;
import biblioteca.domain.Library;
import biblioteca.domain.User;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI {
    private int select = 0;
    private Library library = new Library();
    private Scanner sc = new Scanner(System.in);
    private User currentUser;

    public void run() {
        this.welcomeMessage();
        if (this.login()) {
            this.menuOptions();
            do {
                this.selectMenuOption();
            } while (this.select != 9);
        } else {
            System.out.println("### Wrong Username or Password! ###");
        }
        System.exit(1);
    }

    private boolean login() {
        System.out.println("Enter username: ");
        String username = sc.nextLine();
        System.out.println("Enter password: ");
        String password = sc.nextLine();

        if (this.library.login(username,password)) {
            this.currentUser = this.library.findUserByUsername(username);
            return true;
        } else {
            return false;
        }
    }

    public void welcomeMessage() {
        System.out.println("Welcome to Biblioteca.");
    }

    public void menuOptions() {
        System.out.println("------- Menus -------");
        System.out.println("[1] List of Books");
        System.out.println("[2] Checkout Book");
        System.out.println("[3] Return Book");
        System.out.println("[4] User Information");

        System.out.println("[9] Exit Program");
    }

    public void selectMenuOption() {
        try {
            System.out.println("\nSelect Menu Option [1, 2, 3, 4, 9]:  ");
            this.select = this.sc.nextInt();

            if (this.select == 1) {
                System.out.println("\n--------------- LIST OF BOOKS ---------------\n");
                this.showListOfBook();
            } else if (this.select == 2) {
                System.out.println("\n--------------- CHECKOUT BOOK ---------------\n");
                this.checkOutBook();
            } else if (this.select == 3) {
                System.out.println("\n--------------- RETURN BOOK ---------------\n");
                this.returnBook();
            } else if (this.select == 4) {
                System.out.println("\n--------------- USER INFO ---------------\n");
                System.out.println(this.currentUser);
            }

        } catch (InputMismatchException exception) {
            System.out.println("Please select a valid option!");
        }
    }

    private void checkOutBook() {
        this.showListOfBook();
        System.out.println("Please enter book number to checkout: ");
        int bookIndex = this.sc.nextInt();

        String message = this.library.checkOut(bookIndex - 1, null);
        System.out.println(message);
    }

    private void returnBook() {
        this.showListOfBook();
        System.out.println("Please enter book number to return: ");
        int bookIndex = this.sc.nextInt();

        String message = this.library.returnBook(bookIndex - 1, null);
        System.out.println(message);
    }

    private void showListOfBook() {
        ArrayList<Book> books = this.library.getBooks();

        for (int i = 1; i <= books.size(); i++) {
            System.out.println(i + ". " + books.get(i - 1));
        }
    }
}
