package boarduser;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.sql.DataSource;

import myjpa.dao.BoardUserDao;
import myjpa.entity.BoardUser;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BoardUserTest {
	@Before
	public void before() {
		ctx = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
		entityManagerFactory = ctx.getBean(EntityManagerFactory.class);
		entityManager = entityManagerFactory.createEntityManager();
		boardUserDao = ctx.getBean(BoardUserDao.class);
	}

	// @Test
	public void delete() {
		boardUserDao.delete(11);
	}

	// @Test
	public void find() {
		String hql = "from BoardUser b";
		Query query = entityManager.createQuery(hql);
		List<BoardUser> boardUsers = query.getResultList();
		for (BoardUser boardUser : boardUsers) {
			System.out.println(boardUser);
		}
		entityManager.close();
	}

	// @Test
	public void findByUserName() {
		BoardUser user = boardUserDao.getByUserName("QQ");
		System.err.println(user);
	}

	// @Test
	public void findOne() {
		BoardUser user = boardUserDao.findOne(9);
		System.out.println(user);
	}

	// @Test
	public void Login() {
		BoardUser user = boardUserDao.findByUserNameAndUserPassword("QQ",
				"admin");
		System.out.println(user);
	}

	// @Test
	public void save() {
		BoardUser user = new BoardUser(10, "test", "admin", 29,
				"adminadminadminadmin", "ÄÐ", new Date(19, 2, 15),
				"admin@163.com", "adminadminadmin");
		boardUserDao.save(user);
	}

	// @Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}

	// @Test
	public void update() {
		BoardUser user = boardUserDao.findOne(9);
		System.out.println(user.getUserName());
		user.setUserName("youKu");
		System.out.println(user.getUserName());
		boardUserDao.save(user);
	}

	private ApplicationContext ctx = null;
	private EntityManagerFactory entityManagerFactory = null;
	private BoardUserDao boardUserDao;
	private EntityManager entityManager = null;
}
