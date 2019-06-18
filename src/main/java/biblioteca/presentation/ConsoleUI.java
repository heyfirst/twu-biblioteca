package biblioteca.presentation;

import biblioteca.domain.Book;
import biblioteca.domain.Library;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI {
    private int select = 0;
    private Library library = new Library();
    private Scanner sc = new Scanner(System.in);

    public void run() {
        this.welcomeMessage();
        this.menuOptions();

        do {
            this.selectMenuOption();
        } while (this.select != 9);
        System.exit(1);
    }

    public void welcomeMessage() {
        System.out.println("Welcome to Biblioteca.");
    }

    public void menuOptions() {
        System.out.println("------- Menus -------");
        System.out.println("[1] List of Books");
        System.out.println("[2] Checkout Book");

        System.out.println("[9] Exit Program");
    }

    public void selectMenuOption() {
        try {
            System.out.print("Please enter option number: ");
            this.select = this.sc.nextInt();

            if (this.select == 1) {
                this.showListOfBook();
            } else if (this.select == 2) {
                this.checkOutBook();
            }
        } catch(InputMismatchException exception) {
            System.out.println("Please select a valid option!");
        }
    }

    private void checkOutBook() {
        System.out.print("Please enter book number: ");
        this.select = this.sc.nextInt();
    }

    private void showListOfBook() {
        ArrayList<Book> books = this.library.getBooks();
        for(int i = 1; i <= books.size(); i++) {
            System.out.println(i + ". " + books.get(i - 1));
        }
    }
}
