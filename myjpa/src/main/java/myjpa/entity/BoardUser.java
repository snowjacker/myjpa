package myjpa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "boarduser")
public class BoardUser {
	public BoardUser() {
	}

	public BoardUser(int userId, String userName, String userRole, int userAge,
			String userAddress, String userSex, Date userBirthday,
			String userEmail, String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userRole = userRole;
		this.userAge = userAge;
		this.userAddress = userAddress;
		this.userSex = userSex;
		this.userBirthday = userBirthday;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public int getUserAge() {
		return userAge;
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public String getUserEmail() {
		return userEmail;
	}

	@GeneratedValue
	@Id
	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public String getUserRole() {
		return userRole;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	@Override
	public String toString() {
		return "BoardUser [userId=" + userId + ", userName=" + userName
				+ ", userRole=" + userRole + ", userAge=" + userAge
				+ ", userAddress=" + userAddress + ", userSex=" + userSex
				+ ", userBirthday=" + userBirthday + ", userEmail=" + userEmail
				+ ", userPassword=" + userPassword + "]";
	}

	private int userId;
	@NotEmpty(message = "用户名非空")
	private String userName;
	private String userRole;
	@Max(value = 130, message = "你真长寿,千年的王八万年的鳖!")
	@Min(value = 18, message = "短命鬼，上辈子没少干缺德事儿！")
	private int userAge;
	@NotEmpty(message = "地址不能少，方便查水表！")
	@Size(min = 6, max = 50, message = "短不过16，长不过50,自己对比着看！")
	private String userAddress;
	@NotEmpty(message = "是男是女？好安排权限狗潜规则！！！")
	private String userSex;
	@Past(message = "来自未来的您，恕不接待！！！")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date userBirthday;
	@NotEmpty(message = "您的邮箱呢？没邮箱怎么安利你？！")
	@Email(message = "您的邮箱真好，谁的信息也接收不到！！！")
	private String userEmail;
	@NotEmpty(message = "这很重要！必填！")
	@Size(min = 8, max = 20, message = "短了8位，长了20位，超出范围不跟你玩儿！")
	private String userPassword;

}
