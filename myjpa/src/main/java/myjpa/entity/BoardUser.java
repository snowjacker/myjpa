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
	@NotEmpty(message = "�û����ǿ�")
	private String userName;
	private String userRole;
	@Max(value = 130, message = "���泤��,ǧ�����������ı�!")
	@Min(value = 18, message = "�������ϱ���û�ٸ�ȱ���¶���")
	private int userAge;
	@NotEmpty(message = "��ַ�����٣������ˮ��")
	@Size(min = 6, max = 50, message = "�̲���16��������50,�Լ��Ա��ſ���")
	private String userAddress;
	@NotEmpty(message = "������Ů���ð���Ȩ�޹�Ǳ���򣡣���")
	private String userSex;
	@Past(message = "����δ��������ˡ���Ӵ�������")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date userBirthday;
	@NotEmpty(message = "���������أ�û������ô�����㣿��")
	@Email(message = "����������ã�˭����ϢҲ���ղ���������")
	private String userEmail;
	@NotEmpty(message = "�����Ҫ�����")
	@Size(min = 8, max = 20, message = "����8λ������20λ��������Χ�����������")
	private String userPassword;

}
