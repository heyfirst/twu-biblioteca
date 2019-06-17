package biblioteca.core;

import java.util.Scanner;

public class Library {

    public void run() {
        this.sayWelcome();
        Scanner sc = new Scanner(System.in);
        int numberOfMenu = sc.nextInt();

        if (numberOfMenu == 1) {
            this.showListOfBooks();
        }
    }

    public void sayWelcome() {
        System.out.println("Welcome to Biblioteca. Your one-step-shop for great book titles in Bangalore!");
    }

    public void showListOfBooks() {
        System.out.println(new Book("Clean Code", "2008","Robert C. Martin"));
        System.out.println(new Book("The Refactoring", "1999","Martin Fowler"));
    }
}
