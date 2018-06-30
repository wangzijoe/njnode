package cn.njnode;

import java.lang.reflect.ParameterizedType;

public class Base<T> {

	@SuppressWarnings("unchecked")
	public String buildPath(String... o) {
		StringBuffer sb = new StringBuffer();
		Class<T> entity = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		sb.append(entity.getAnnotation(SpaceName.class).value().toString())
		.append(entity.getAnnotation(javax.ws.rs.Path.class).value())
		.append("/");
		int length = o.length;
		for (int i = 0; i < length; i++) {
			if (i == length - 1) {
				sb.append(o[i]);
			} else {
				sb.append(o[i]).append("/");
			}
		}
		return sb.toString();
	}
}
