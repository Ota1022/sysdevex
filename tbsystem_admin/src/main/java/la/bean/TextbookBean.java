package la.bean;

import java.io.Serializable;

public class TextbookBean implements Serializable {
	private String isbn;
	private int categoryCode;
	private String title;
	private String author;
	private String categoryName;

	//constructor
	public TextbookBean() {

	}

	public TextbookBean(String isbn, int categoryCode, String categoryName, String title, String author) {
		this.isbn = isbn;
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
		this.title = title;
		this.author = author;
	}

	//accessor
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
