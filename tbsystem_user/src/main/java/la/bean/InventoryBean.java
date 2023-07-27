package la.bean;

import java.io.Serializable;
import java.util.Date;

public class InventoryBean implements Serializable {
	private int inventoryID;
	private String title;
	private String author;
	private int price;

	private int userIDSeller;
	private String userNameSeller;
	private int userIDBuyer;
	private String userNameBuyer;

	private int stateCode;
	private String stateName;
	private int categoryCode;
	private String categoryName;
	private int isinInventoryCode;
	private String isinInventoryName;

	private String note;

	private Date inventoryRegistDate;
	private Date inventoryUpdateDate;
	private Date sellDate;

	//constructor
	public InventoryBean() {

	}

	public InventoryBean(int inventoryID, String title, String author, int price, int userIDSeller,
			String userNameSeller, int userIDBuyer, String userNameBuyer,
			int stateCode, String stateName,
			int categoryCode, String categoryName, int isinInventoryCode, String isinInventoryName, String note,
			Date inventoryRegistDate, Date inventoryUpdateDate, Date sellDate) {
		this.inventoryID = inventoryID;
		this.title = title;
		this.author = author;
		this.price = price;

		this.userIDSeller = userIDSeller;
		this.userNameSeller = userNameSeller;
		this.userIDBuyer = userIDBuyer;
		this.userNameBuyer = userNameBuyer;

		this.stateCode = stateCode;
		this.stateName = stateName;
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
		this.isinInventoryCode = isinInventoryCode;
		this.isinInventoryName = isinInventoryName;

		this.note = note;

		this.inventoryRegistDate = inventoryRegistDate;
		this.inventoryUpdateDate = inventoryUpdateDate;
		this.sellDate = sellDate;
	}

	public InventoryBean(int inventoryID, Date sellDate, String title, String categoryName, String author, int price) {
		this.inventoryID = inventoryID;
		this.sellDate = sellDate;
		this.title = title;
		this.categoryName = categoryName;
		this.author = author;
		this.price = price;
	}

	public InventoryBean(int inventoryID, Date sellDate, String title, String author, int price) {
		this.inventoryID = inventoryID;
		this.sellDate = sellDate;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public InventoryBean(int inventoryID, String title, String author, int stateCode, String stateName, int price,
			String note) {
		this.inventoryID = inventoryID;
		this.title = title;
		this.author = author;
		this.stateCode = stateCode;
		this.stateName = stateName;
		this.price = price;
		this.note = note;
	}

	public InventoryBean(int inventoryID, int isinInventoryCode, Date sellDate, String title, String author,
			int stateCode, int price,
			String note) {
		this.inventoryID = inventoryID;
		this.isinInventoryCode = isinInventoryCode;
		this.sellDate = sellDate;
		this.title = title;
		this.author = author;
		this.stateCode = stateCode;
		this.price = price;
		this.note = note;
	}

	//accessor
	public int getInventoryID() {
		return inventoryID;
	}

	public void setInventoryID(int inventoryID) {
		this.inventoryID = inventoryID;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getUserIDSeller() {
		return userIDSeller;
	}

	public void setUserIDSeller(int userIDSeller) {
		this.userIDSeller = userIDSeller;
	}

	public int getUserIDBuyer() {
		return userIDBuyer;
	}

	public void setUserIDBuyer(int userIDBuyer) {
		this.userIDBuyer = userIDBuyer;
	}

	public int getStateCode() {
		return stateCode;
	}

	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public int getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getIsinInventoryCode() {
		return isinInventoryCode;
	}

	public void setIsinInventoryCode(int isinInventoryCode) {
		this.isinInventoryCode = isinInventoryCode;
	}

	public String getIsinInventoryName() {
		return isinInventoryName;
	}

	public void setIsinInventoryName(String isinInventoryName) {
		this.isinInventoryName = isinInventoryName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getInventoryRegistDate() {
		return inventoryRegistDate;
	}

	public void setInventoryRegistDate(Date inventoryRegistDate) {
		this.inventoryRegistDate = inventoryRegistDate;
	}

	public Date getInventoryUpdateDate() {
		return inventoryUpdateDate;
	}

	public void setInventoryUpdateDate(Date inventoryUpdateDate) {
		this.inventoryUpdateDate = inventoryUpdateDate;
	}

	public Date getSellDate() {
		return sellDate;
	}

	public void setSellDate(Date sellDate) {
		this.sellDate = sellDate;
	}

	public String getUserNameSeller() {
		return userNameSeller;
	}

	public void setUserNameSeller(String userNameSeller) {
		this.userNameSeller = userNameSeller;
	}

	public String getUserNameBuyer() {
		return userNameBuyer;
	}

	public void setUserNameBuyer(String userNameBuyer) {
		this.userNameBuyer = userNameBuyer;
	}

}
