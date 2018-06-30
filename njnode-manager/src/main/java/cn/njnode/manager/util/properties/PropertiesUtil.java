package cn.njnode.manager.util.properties;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class PropertiesUtil extends PropertyPlaceholderConfigurer {
	private static Map<String, String> propertiesMap;

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
			throws BeansException {
		super.processProperties(beanFactoryToProcess, props);
		propertiesMap = new HashMap<String, String>();
		for (Object key : props.keySet()) {
			String k = key.toString();
			String v = props.getProperty(k);
			propertiesMap.put(k, v);
		}
	}

	public static Map<String, String> getProperties() {
		return propertiesMap;
	}
}
