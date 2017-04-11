/**
 * 
 */
package cn.jxufe.onlinesubmit.dao.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 作业实体
 * @author Frank
 *
 */
@Entity
@Table(name="HOMEWORK")
public class HomeworkBean {

	private Integer workid; // 作业ID
	private SystemUserBean holdUser; // 作业所属用户
	private String content; // 作业内容
	private Date startdate; //作业开始日期
	private Date deadline; // 作业截止日期
	private Integer status; //作业状态
	private Set<SubmititionBean> workSubmissions = new HashSet<SubmititionBean>(0); // 作业的提交记录
	
	@Id
	@Column(name="WORKID", unique = true, nullable = false)
	/**
	 * @return the workid
	 */
	public Integer getWorkid() {
		return workid;
	}
	/**
	 * @param workid the workid to set
	 */
	public void setWorkid(Integer workid) {
		this.workid = workid;
	}
	
	@ManyToOne
	@JoinColumn(name = "USERNAME")
	/**
	 * @return the holdUser
	 */
	public SystemUserBean getHoldUser() {
		return holdUser;
	}
	/**
	 * @param holdUser the holdUser to set
	 */
	public void setHoldUser(SystemUserBean holdUser) {
		this.holdUser = holdUser;
	}
	
	@Column(name = "CONTENT", nullable = false, length = 400)
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * @return the startdate
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "STARTDATE", nullable = false, length = 8)
	public Date getStartdate() {
		return startdate;
	}
	/**
	 * @param startdate the startdate to set
	 */
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	/**
	 * @return the deadline
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "DEADLINE", nullable = false, length = 8)
	public Date getDeadline() {
		return deadline;
	}
	/**
	 * @param deadline the deadline to set
	 */
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	/**
	 * @return the status
	 */
	@Column(name = "STATUS")
	public Integer getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * @return the workSubmissions
	 */
	@OneToMany(mappedBy = "submissionForWork")
	public Set<SubmititionBean> getWorkSubmissions() {
		return workSubmissions;
	}
	/**
	 * @param workSubmissions the workSubmissions to set
	 */
	public void setWorkSubmissions(Set<SubmititionBean> workSubmissions) {
		this.workSubmissions = workSubmissions;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HomeworkBean [workid=" + workid + ", holdUser=" + holdUser + ", content=" + content + ", startdate="
				+ startdate + ", deadline=" + deadline + ", status=" + status + ", workSubmissions=" + workSubmissions
				+ "]";
	}
	public HomeworkBean(Integer workid, SystemUserBean holdUser, String content, Date startdate, Date deadline,
			Integer status, Set<SubmititionBean> workSubmissions) {
		super();
		this.workid = workid;
		this.holdUser = holdUser;
		this.content = content;
		this.startdate = startdate;
		this.deadline = deadline;
		this.status = status;
		this.workSubmissions = workSubmissions;
	}
	public HomeworkBean() {
		super();
	}
}
