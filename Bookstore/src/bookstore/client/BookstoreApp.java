package bookstore.client;

import java.util.List;

import bookstore.dao.BookDAO;
import bookstore.dao.BookDAOImpl;
import bookstore.model.Book;

public class BookstoreApp {
	private static BookDAO bookDao = new BookDAOImpl();

	public static void main(String[] args) {
		// List all books
		System.out.println("Listing all books:");
		findAllBooks();
		System.out.println();
	}

	private static void findAllBooks() {
		List<Book> books = bookDao.findAllBooks();
		for (Book book : books) {
			System.out.println(book);
		}
		
	}

}
