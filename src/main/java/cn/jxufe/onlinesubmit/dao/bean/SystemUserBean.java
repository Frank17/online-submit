/**
 * 
 */
package cn.jxufe.onlinesubmit.dao.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 系统用户实体
 * @author Frank
 *
 */
@Entity
@Table(name = "SYSTEMUSER")
public class SystemUserBean {

	private String username; // 用户名
	private String password; // 密码
	private Set<AuthorityBean> authorities = new HashSet<AuthorityBean>(0); // 权限集合
	private Set<HomeworkBean> homeworks = new HashSet<HomeworkBean>(0);
	
	@Id
	@Column(name = "USERNAME", unique = true, nullable = false, length = 11, columnDefinition = "CHAR(11)")
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name = "PASSWORD", nullable = false, length = 33, columnDefinition = "CHAR(33)")
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the authorities
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "REGISTERAUTHORITY", joinColumns = {
			@JoinColumn(name = "USERNAME", nullable = false, updatable = false, columnDefinition = "CHAR(11)") }, inverseJoinColumns = {
					@JoinColumn(name = "AUTHORITYID", nullable = false, updatable = false) })
	public Set<AuthorityBean> getAuthorities() {
		return authorities;
	}
	/**
	 * @param authorities the authorities to set
	 */
	public void setAuthorities(Set<AuthorityBean> authorities) {
		this.authorities = authorities;
	}
	/**
	 * @return the homeworks
	 */
	
	@OneToMany(mappedBy = "holdUser", fetch = FetchType.EAGER)
	public Set<HomeworkBean> getHomeworks() {
		return homeworks;
	}
	/**
	 * @param homeworks the homeworks to set
	 */
	public void setHomeworks(Set<HomeworkBean> homeworks) {
		this.homeworks = homeworks;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SystemUserBean [username=" + username + ", password=" + password + ", authorities=" + authorities
				+ ", homeworks=" + homeworks + "]";
	}
	public SystemUserBean(String username, String password, Set<AuthorityBean> authorities,
			Set<HomeworkBean> homeworks) {
		super();
		this.username = username;
		this.password = password;
		this.authorities = authorities;
		this.homeworks = homeworks;
	}
	public SystemUserBean() {
		super();
	}
	
	
}
