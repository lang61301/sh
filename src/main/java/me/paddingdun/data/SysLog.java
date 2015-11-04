package me.paddingdun.data;

import java.util.Date;

import me.paddingdun.component.log.log4j.ILogConstant;
import me.paddingdun.component.log.log4j.Log;

public class SysLog implements Log {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long logId;
	
	private Date createTime;
	
	private String logMessage;
	
	private Integer status = ILogConstant.LOG_STATUS_SUCCESS;

	public Long getLogId() {
		return logId;
	}

	public void setLogId(Long logId) {
		this.logId = logId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getLogMessage() {
		return logMessage;
	}

	public void setLogMessage(String logMessage) {
		this.logMessage = logMessage;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}

