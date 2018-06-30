package cn.njnode.manager.listener;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
/**
 * 
 * 文件名：PropertyListenter.java
 *
 * 创建人：joe 
 *
 * 创建时间：2018年4月7日 下午4:17:42
 *
 * 功能描述：读取指定properties文件，将其变为web全局变量
 */
public class PropertyListenter implements ServletContextListener {

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void contextInitialized(ServletContextEvent sce) {
		/**
		 * 读取properties文件
		 * 
		 */
		final Logger logger = Logger.getLogger(PropertyListenter.class);

		Properties properties = new Properties();

		InputStream in = null;
		try {
			// 通过类加载器进行获取properties文件流
			in = PropertyListenter.class.getClassLoader().getResourceAsStream("config/config.properties");
			properties.load(in);

		} catch (FileNotFoundException e) {
			logger.error("未找到properties文件");
		} catch (IOException e) {
			logger.error("发生IOException异常");
		} finally {
			try {
				if (null != in) {
					in.close();
				}
			} catch (IOException e) {
				logger.error("properties文件流关闭出现异常");
			}
		}

		/**
		 * 将properties文件转存到map
		 */
		Map<String, String> pros = new HashMap<String, String>((Map) properties);

		/**
		 * 将Map通过ServletContext存储到全局作用域中
		 */
		ServletContext sct = sce.getServletContext();

		for (Entry<String, String> elem: pros.entrySet()) {
			sct.setAttribute(elem.getKey(), elem.getValue());
		}
		

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

}
