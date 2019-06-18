package biblioteca.presentation;

import biblioteca.domain.Book;
import biblioteca.domain.Library;

import java.util.ArrayList;

public class ConsoleUI {
    public static void run() {
        Library library = new Library();
        System.out.println("Welcome to Biblioteca.");

        ArrayList<Book> books = library.getBooks();
        for(int i = 1; i <= books.size(); i++) {
            System.out.println(i + ". " + books.get(i - 1));
        }
    }
}
