package myjpa.dao;

import myjpa.entity.BoardUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardUserDao extends JpaRepository<BoardUser, Integer> {
	/**
	 * @description login method
	 * @param userName
	 * @param userPassword
	 * @return
	 */
	public BoardUser findByUserNameAndUserPassword(String userName,
			String userPassword);

	/**
	 * @param userName
	 * @return boardUser
	 * @descripe used when register
	 */
	public BoardUser getByUserName(String userName);
}
