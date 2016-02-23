/**
 * 
 */
package me.paddingdun.ext.spring;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import me.paddingdun.util.DateHelper;

/**
 * 该类用于spring mvc form提交映射为对象时单独处理包含 Timestamp的属性对象;
 * @author paddingdun
 *
 * 2016年2月23日
 */
@Component("timestampConverter")
public class TimestampConverter implements Converter<String, Timestamp> {

	@Override
	public Timestamp convert(String timeStr) {
		Timestamp t = null;
    	if(StringUtils.isNotBlank(timeStr)){
    		Date d = DateHelper.parseDate(timeStr.trim());
    		if(d != null){
    			t = new Timestamp(d.getTime());
    		}
    	}
        return t;
	}

}
