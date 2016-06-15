/**
 * 
 */
package me.paddingdun.component.log.log4j;

import java.io.Serializable;
import java.util.Date;

/**
 * @author paddingdun
 *
 * 2015年11月3日
 */
public interface ILog extends Serializable {

	void setCreateTime(Date date);
}
