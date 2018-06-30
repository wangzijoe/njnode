package cn.njnode.common.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigUtils {

	private static final Logger log = LoggerFactory.getLogger(ConfigUtils.class);
	private static Properties props;
	
	synchronized static private void loadProperties(Class<?> clazz, String fileName) {
		
		log.info("开始加载"+fileName+"文件内容.......");
		props = new Properties();
		InputStream in = null;
		try {
			in = clazz.getClassLoader().getResourceAsStream(fileName);
			props.load(in);
		} catch (FileNotFoundException e) {
			log.error(fileName+"文件未找到");
		} catch (IOException e) {
			log.error("出现IOException");
		} finally {
			try {
				if (null != in) {
					in.close();
				}
			} catch (IOException e) {
				log.error(fileName+"文件流关闭出现异常");
			}
		}
		log.info("加载"+fileName+"文件内容完成...........");
		log.info(fileName+"文件内容：" + props);
	}

	public static String getProperty(String key, Class<?> clazz, String fileName) {
		loadProperties(clazz, fileName);
		if (null == props) {
			return null;
		}
		return props.getProperty(key);
	}

}
