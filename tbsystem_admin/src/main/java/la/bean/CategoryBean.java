package la.bean;

public class CategoryBean {
	private int categoryID;
	private String categoryName;

	public CategoryBean() {

	}

	public CategoryBean(int categoryID, String categoryName) {
		categoryID = this.categoryID;
		categoryName = this.categoryName;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
