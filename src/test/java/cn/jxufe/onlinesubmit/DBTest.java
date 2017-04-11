package cn.jxufe.onlinesubmit;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.jxufe.onlinesubmit.dao.SystemUserDao;
import cn.jxufe.onlinesubmit.dao.bean.SystemUserBean;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DBTest {
	
	@Autowired
	private SystemUserDao userDao;
	
	@Test
	public void testInsert() {
		
		
		SystemUserBean user = new SystemUserBean();
		user.setUsername("admin");
		user.setPassword("zouzhipeng123A");
		
		userDao.saveAndFlush(user);
		
//		userDao.save(user);
		
	}
	
	@Test
	public void testFindUser() {
		SystemUserBean user = userDao.findByUsername("admin");
		assertNotNull(user);
		System.err.println(user);
	}
	
}
