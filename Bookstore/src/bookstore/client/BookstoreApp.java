package bookstore.client;

import java.util.List;

import bookstore.dao.BookDAO;
import bookstore.dao.BookDAOImpl;
import bookstore.model.Book;
import bookstore.model.Database;

public class BookstoreApp {
	private static BookDAO bookDao = new BookDAOImpl();

	public static void main(String[] args) {
		// List all books
		System.out.println("Listing all books:");
		findAllBooks();
		System.out.println();

		// Search book by keyword
		System.out.println("Search book by keyword in book title: Groovy:");
		searchBooks("Groovy");
		System.out.println();

		System.out.println("Search book by keyword in author's name: Josh:");
		searchBooks("Josh");
		System.out.println();
		
		Database.getInstance().disconnect();
	}

	private static void findAllBooks() {
		List<Book> books = bookDao.findAllBooks();
		for (Book book : books) {
			System.out.println(book);
		}
	}

	private static void searchBooks(String keyword) {
		List<Book> books = bookDao.searchBooksByKeyword(keyword);
		for (Book book : books) {
			System.out.println(book);
		}
	}
}
