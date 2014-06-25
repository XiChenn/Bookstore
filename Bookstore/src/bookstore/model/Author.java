package bookstore.model;

public class Author {
	private Long id;
	private Long bookId;
	private String firstName;
	private String LastName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", bookId=" + bookId + ", firstName="
				+ firstName + ", LastName=" + LastName + "]";
	}

}
