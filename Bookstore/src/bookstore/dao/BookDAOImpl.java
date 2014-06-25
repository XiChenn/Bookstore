package bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookstore.model.Author;
import bookstore.model.Book;
import bookstore.model.Category;
import bookstore.model.Database;

public class BookDAOImpl implements BookDAO {
	public BookDAOImpl() {
		Database.getInstance().connect();
	}
	
	@Override
	public List<Book> findAllBooks() {
		String sql = "select * from book, author where book.id = author.book_id";

		List<Author> authorList = new ArrayList<Author>();
		List<Book> result = new ArrayList<Book>();
	
		Connection connection = null;
		try {
			connection = Database.getInstance().getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Book book = new Book();
				book.setId(resultSet.getLong("id"));
				book.setBookTitle(resultSet.getString("book_title"));
				book.setCategoryId(resultSet.getLong("category_id"));
				book.setPublisherName(resultSet.getString("publisher"));

				Author author = new Author();
				author.setBookId(resultSet.getLong("book_id"));
				author.setFirstName(resultSet.getString("first_name"));
				author.setLastName(resultSet.getString("Last_name"));
				authorList.add(author);

				book.setAuthors(authorList);

				result.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Book> searchBooksByKeyword(String keyword) {
		List<Book> result = new ArrayList<Book>();
		List<Author> authorList = new ArrayList<Author>();

		String sql = "select * from book inner join author on book.id=author.book_id"
				+ " where book_title like '%"
				+ keyword.trim()
				+ "%'"
				+ " or first_name like '%"
				+ keyword.trim()
				+ "%'"
				+ " or last_name like '%" + keyword.trim() + "%'";

		Connection connection = null;
		try {
			connection = Database.getInstance().getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Book book = new Book();
				book.setId(resultSet.getLong("id"));
				book.setBookTitle(resultSet.getString("book_title"));
				book.setCategoryId(resultSet.getLong("category_id"));
				book.setPublisherName(resultSet.getString("publisher"));

				Author author = new Author();
				author.setBookId(resultSet.getLong("book_id"));
				author.setFirstName(resultSet.getString("first_name"));
				author.setLastName(resultSet.getString("Last_name"));
				authorList.add(author);

				book.setAuthors(authorList);

				result.add(book);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Category> findAllCategories() {
		List<Category> result = new ArrayList<Category>();
		String sql = "select * from category";

		Connection connection = null;
		try {
			connection = Database.getInstance().getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Category category = new Category();
				category.setId(resultSet.getLong("id"));
				category.setCategoryDescription(resultSet
						.getString("category_description"));
				result.add(category);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void isert(Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long bookId) {
		// TODO Auto-generated method stub

	}

}
