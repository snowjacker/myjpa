package myjpa.service;

import java.util.List;

import myjpa.dao.BoardUserDao;
import myjpa.entity.BoardUser;

import org.hibernate.type.TrueFalseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardUserService {
	@Autowired
	private BoardUserDao boardUserDao;
	@Transactional
	public void delete(Integer id) {
		boardUserDao.delete(id);
	}

	@Transactional
	public List<BoardUser> findAll() {
		return boardUserDao.findAll();
	}

	@Transactional
	public BoardUser findById(Integer userId) {
		return boardUserDao.findOne(userId);
	}

	@Transactional
	public BoardUser findByUserName(String userName) {
		return boardUserDao.getByUserName(userName);
	}

	@Transactional
	public BoardUser findByUserNameAndUserPassword(String userName,
			String userPassword) {
		return boardUserDao.findByUserNameAndUserPassword(userName,
				userPassword);
	}

	@Transactional
	public BoardUser get(Integer id) {
		return boardUserDao.findOne(id);
	}

	@Transactional
	public Page<BoardUser> getPage(int pageNo, int pageSize) {
		PageRequest pageRequest = new PageRequest(pageNo - 1, pageSize);
		return boardUserDao.findAll(pageRequest);
	}

	@Transactional
	public void save(BoardUser boardUser) {
		boardUserDao.saveAndFlush(boardUser);
	}
	@Transactional(readOnly=true)
	public Page<BoardUser> pageUser(int pageNumber,int pageSize){
		PageRequest pageAblePageRequest=new PageRequest(pageNumber-1, pageSize);
		return boardUserDao.findAll(pageAblePageRequest);
	}
	
	
}
