/**
 * 
 */
package cn.jxufe.onlinesubmit.dao;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.jxufe.onlinesubmit.dao.bean.SystemUserBean;

/**
 * 系统用户DAO层接口
 * @author Frank
 *
 */
@Repository
@Configuration
public interface SystemUserDao extends JpaRepository<SystemUserBean, String> {
	
	/**
	 * 通过用户名查找用户
	 * @param username 要查询的用户名
	 * @return 查询到的用户名
	 */
	public SystemUserBean findByUsername(String username);
	
}
