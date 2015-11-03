package me.paddingdun.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import me.paddingdun.component.log.log4j.ILogConstant;
import me.paddingdun.component.log.log4j.Log;

@Entity
@Table(name="tb_sys_log")
public class SysLog implements Log {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long logId;
	
	private Date createTime;
	
	private String logMessage;
	
	private Integer status = ILogConstant.LOG_STATUS_SUCCESS;

	@Id
	@Column(name="log_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getLogId() {
		return logId;
	}

	public void setLogId(Long logId) {
		this.logId = logId;
	}

	@Column(name="create_time")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name="log_message")
	public String getLogMessage() {
		return logMessage;
	}

	public void setLogMessage(String logMessage) {
		this.logMessage = logMessage;
	}

	@Column
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}

