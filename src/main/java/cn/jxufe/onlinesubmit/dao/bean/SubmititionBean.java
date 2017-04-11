/**
 * 
 */
package cn.jxufe.onlinesubmit.dao.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 提交记录实体
 * @author Frank
 *
 */
@Entity
@Table(name="SUBMITITION")
public class SubmititionBean {

	private Integer recordId;
	private HomeworkBean submissionForWork;
	private String uploader;
	private String filename;
	private Date uploadDate;
	private Integer status;
	/**
	 * @return the recordId
	 */
	@Id
	@Column(name = "RECORDID", unique = true, nullable = false)
	public Integer getRecordId() {
		return recordId;
	}
	/**
	 * @param recordId the recordId to set
	 */
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}
	/**
	 * @return the submissionForWork
	 */
	@ManyToOne
	@JoinColumn(name = "WORKID")
	public HomeworkBean getSubmissionForWork() {
		return submissionForWork;
	}
	/**
	 * @param submissionForWork the submissionForWork to set
	 */
	public void setSubmissionForWork(HomeworkBean submissionForWork) {
		this.submissionForWork = submissionForWork;
	}
	/**
	 * @return the uploader
	 */
	@Column(name = "UPLOADER", nullable = false, length = 15, columnDefinition = "CHAR")
	public String getUploader() {
		return uploader;
	}
	/**
	 * @param uploader the uploader to set
	 */
	public void setUploader(String uploader) {
		this.uploader = uploader;
	}
	/**
	 * @return the filename
	 */
	@Column(name = "FILENAME", nullable = false, length = 32)
	public String getFilename() {
		return filename;
	}
	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}
	/**
	 * @return the uploadDate
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "UPLOADDATE", nullable = false, length = 8)
	public Date getUploadDate() {
		return uploadDate;
	}
	/**
	 * @param uploadDate the uploadDate to set
	 */
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	/**
	 * @return the status
	 */
	@Column(name = "STATUS", nullable = false)
	public Integer getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	public SubmititionBean(Integer recordId, HomeworkBean submissionForWork, String uploader, String filename,
			Date uploadDate, Integer status) {
		super();
		this.recordId = recordId;
		this.submissionForWork = submissionForWork;
		this.uploader = uploader;
		this.filename = filename;
		this.uploadDate = uploadDate;
		this.status = status;
	}
	public SubmititionBean() {
		super();
	}
	
}
