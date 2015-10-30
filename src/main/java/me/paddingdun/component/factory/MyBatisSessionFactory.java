/**
 * 
 */
package me.paddingdun.component.factory;

import java.io.IOException;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NestedIOException;

/**
 * 自定义mybatisSessionFactory 捕获xml解析sql异常;
 * 
 * @author paddingdun
 *
 * 2015年10月30日
 */
public class MyBatisSessionFactory extends SqlSessionFactoryBean {

	private final static Logger logger = LoggerFactory.getLogger(MyBatisSessionFactory.class);

	@Override
	protected SqlSessionFactory buildSqlSessionFactory() throws IOException {
		try {
			return super.buildSqlSessionFactory();
		} catch (NestedIOException e) {
			/**
			 * 输出xml解析错误
			 */
			logger.error("NestedIOException: \r\n" + e.getMessage());
			throw e;
		}
	}
}
