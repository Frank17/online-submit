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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 权限实体
 * @author Frank
 *
 */
@Entity
@Table(name="AUTHORITY")
public class AuthorityBean {

	private Integer authorityId;
	private String authorityName;
	private Integer value;
	private Set<SystemUserBean> holdUsers = new HashSet<SystemUserBean>(0);
	
	@Id
	@Column(name = "AUTHORITYID", unique = true, nullable = false)
	/**
	 * @return the authorityId
	 */
	public Integer getAuthorityId() {
		return authorityId;
	}
	/**
	 * @param authorityId the authorityId to set
	 */
	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}
	
	@Column(name="AUTHORITYNAME", nullable = false, length = 32)
	/**
	 * @return the authorityName
	 */
	public String getAuthorityName() {
		return authorityName;
	}
	/**
	 * @param authorityName the authorityName to set
	 */
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	
	@Column(name = "VALUE", nullable = false)
	/**
	 * @return the value
	 */
	public Integer getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(Integer value) {
		this.value = value;
	}
	
	@ManyToMany(mappedBy="authorities", fetch = FetchType.EAGER)
	/**
	 * @return the holdUsers
	 */
	public Set<SystemUserBean> getHoldUsers() {
		return holdUsers;
	}
	/**
	 * @param holdUsers the holdUsers to set
	 */
	public void setHoldUsers(Set<SystemUserBean> holdUsers) {
		this.holdUsers = holdUsers;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AuthorityBean [authorityId=" + authorityId + ", authorityName=" + authorityName + ", value=" + value
				+ ", holdUsers=" + holdUsers + "]";
	}
	public AuthorityBean(Integer authorityId, String authorityName, Integer value, Set<SystemUserBean> holdUsers) {
		super();
		this.authorityId = authorityId;
		this.authorityName = authorityName;
		this.value = value;
		this.holdUsers = holdUsers;
	}
	public AuthorityBean() {
		super();
	}
	
}
