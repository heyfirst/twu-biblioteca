package biblioteca.presentation;

import biblioteca.domain.Book;
import biblioteca.domain.Library;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUI {
    public static void run() {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        int select = 0;

        System.out.println("Welcome to Biblioteca.");
        System.out.println("------- Menus -------");
        System.out.println("[1] List of Books");
        select = sc.nextInt();
        if (select == 1) {
            ArrayList<Book> books = library.getBooks();
            for(int i = 1; i <= books.size(); i++) {
                System.out.println(i + ". " + books.get(i - 1));
            }
        }
    }
}
