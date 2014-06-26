package bookstore.dao;

import java.util.List;

import bookstore.model.Book;
import bookstore.model.Category;

/**
 * One DAO class per table or view
 * The method in this interface correspond to the GRUD terms (create, read,
 * update, delete)
 * 
 * @author Xi Chen
 * 
 */
public interface BookDAO {
	
	/*
	 * Listing all books from the database
	 */
	public List<Book> findAllBooks();

	/*
	 * Searching books by keyword in the title of the book or by the first and
	 * last names of the author
	 */
	public List<Book> searchBooksByKeyword(String keyword);

	/*
	 * Providing a categorized listing of books
	 */
	public List<Category> findAllCategories();

	public void isert(Book book);

	public void update(Book book);

	public void delete(Long bookId);
}
