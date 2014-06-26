package bookstore.client;

import java.util.List;

import bookstore.dao.BookDAO;
import bookstore.dao.BookDAOImpl;
import bookstore.model.Book;
import bookstore.model.Database;

public class BookstoreApp {
	

	public static void main(String[] args) {
		BookDAO bookDao = new BookDAOImpl();
		
		// List all books
		System.out.println("Listing all books:");
		findAllBooks(bookDao);
		System.out.println();

		// Search book by keyword
		System.out.println("Search book by keyword in book title: Groovy:");
		searchBooks(bookDao, "Groovy");
		System.out.println();

		System.out.println("Search book by keyword in author's name: Josh:");
		searchBooks(bookDao, "Josh");
		System.out.println();
		
		BookDAO bookDao2 = new BookDAOImpl();
		System.out.println("Listing all books2:");
		findAllBooks(bookDao2);
		System.out.println();
	}

	private static void findAllBooks(BookDAO bookDao) {
		List<Book> books = bookDao.findAllBooks();
		for (Book book : books) {
			System.out.println(book);
		}
	}

	private static void searchBooks(BookDAO bookDao, String keyword) {
		List<Book> books = bookDao.searchBooksByKeyword(keyword);
		for (Book book : books) {
			System.out.println(book);
		}
	}
}
