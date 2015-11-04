/**
 * 
 */
package me.paddingdun.dao.syslog;

import org.springframework.stereotype.Repository;

import me.paddingdun.data.SysLog;


/**
 * 系统日志对应的mybatisdao;
 * @author paddingdun
 *
 * 2015年11月4日
 */
@Repository
public interface ISysLogDao {
	
	void saveSysLog(SysLog log);
}
