package la.bean;

import java.io.Serializable;
import java.util.Date;

public class UserBean implements Serializable {

    private int userID;
    private String name;
    private String password;
    private String email;
    private String address;
    private String tel;
    private Date regist_date;
    private Date delete_date;
    private Date birthday;

    public UserBean(int userID, String name, String password, String email, String address, String tel,
	    Date regist_date, Date delete_date, Date birthday) {
	this.userID = userID;
	this.name = name;
	this.password = password;
	this.email = email;
	this.address = address;
	this.tel = tel;
	this.regist_date = regist_date;
	this.delete_date = delete_date;
	this.birthday = birthday;
    }

    public UserBean() {

    }

    public int getUserID() {
	return userID;
    }

    public void setUserID(int userID) {
	this.userID = userID;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public String getTel() {
	return tel;
    }

    public void setTel(String tel) {
	this.tel = tel;
    }

    public Date getBirthday() {
	return birthday;
    }

    public void setBirthday(Date birthday) {
	this.birthday = birthday;
    }

    public Date getRegist_date() {
	return regist_date;
    }

    public void setRegist_date(Date regist_date) {
	this.regist_date = regist_date;
    }

    public Date getDelete_date() {
	return delete_date;
    }

    public void setDelete_date(Date delete_date) {
	this.delete_date = delete_date;
    }

}
