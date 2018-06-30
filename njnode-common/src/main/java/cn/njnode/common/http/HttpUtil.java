package cn.njnode.common.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;

import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;

import cn.njnode.HandlerConstants;
import cn.njnode.HandlerResult;

public class HttpUtil {

	private static final String HTTP_GET = "GET";

	public static boolean isGet(HttpServletRequest request) {
		return HTTP_GET.equals(request.getMethod().toUpperCase());
	}

	public static <R> HandlerResult<R> get(String url, Class<R> returnType) throws Exception {
		String result = null;
		HttpMethod method = null;

		try {
			method = new GetMethod(url);
			result = sendData(method);

		} catch (Exception e) {
			HandlerResult<R> r = HandlerResult.getHandlerResult();
			r.setResultCode(HandlerConstants.S_FAIL);
			r.setErrorMessage("网络异常！");
			return r;
		} finally {
			// 释放连接
			if (null != method)
				method.releaseConnection();
		}

		return zhuanHuan(result, returnType);

	}

	public static String get(String url) throws Exception {
		HttpMethod method = null;
		try {
			method = new GetMethod(url);
			return sendData(method);
		} catch (Exception e) {
			return "";
		} finally {
			// 释放连接
			if (null != method)
				method.releaseConnection();
		}

	}

	/*
	 * 发送请求获取响应字符串
	 */
	private static String sendData(HttpMethod method) throws Exception {

		int statusCode = HttpConnectionManager.getHttpClient().executeMethod(method);
		// 打印服务器返回的状态
		if (statusCode != HttpStatus.SC_OK) {
			throw new Exception();
		}
		// 打印返回的信息
		BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream()));
		StringBuffer stringBuffer = new StringBuffer();
		String str = "";
		while ((str = reader.readLine()) != null) {
			stringBuffer.append(str);
		}
		return new String(stringBuffer.toString().getBytes(), "UTf-8");
	}

	public static <R> HandlerResult<List<R>> getArray(String url, Class<R> returnType) throws Exception {
		String result = null;
		HttpMethod method = null;
		try {
			method = new GetMethod(url);
			result = sendData(method);

		} catch (Exception e) {
			HandlerResult<List<R>> r = HandlerResult.getHandlerResult();
			r.setResultCode(HandlerConstants.S_FAIL);
			r.setErrorMessage("网络异常！");
			return r;
		} finally {
			// 释放连接
			if (null != method)
				method.releaseConnection();
		}
		return convertToArray(result, returnType);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static <T> HandlerResult<T> zhuanHuan(String json, Class<T> returnType) throws IllegalAccessException {
		HandlerResult result = JSON.parseObject(json, HandlerResult.class);

		if (returnType == String.class) {
			return result;
		}
		if (null != result.getResultObj()) {
			T r = JSON.parseObject(result.getResultObj().toString(), returnType);
			result.setResultObj(r);
		}

		return result;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static <T> HandlerResult<List<T>> convertToArray(String json, Class<T> returnType)
			throws IllegalAccessException {
		HandlerResult result = JSON.parseObject(json, HandlerResult.class);
		List list = (List) result.getResultObj();
		List<T> objectList = new ArrayList<T>();
		if (null != list) {
			for (Object o : list) {
				if (returnType == String.class) {
					objectList.add((T) o);
				} else {
					objectList.add(JSON.parseObject(o.toString(), returnType));
				}

			}
		}
		result.setResultObj(objectList);
		return (HandlerResult<List<T>>) result;
	}

	public static <T, R> HandlerResult<R> post(String url, T t, Class<R> returnType) throws Exception {
		PostMethod method = null;
		String result = null;
		try {
			// 使用POST方法
			method = new PostMethod(url);
			RequestEntity entity = new StringRequestEntity(JSON.toJSONString(t), MediaType.APPLICATION_JSON, "UTF-8");
			method.setRequestEntity(entity);
			result = sendData(method);
		} catch (Exception e) {
			HandlerResult<R> r = HandlerResult.getHandlerResult();
			r.setResultCode(HandlerConstants.S_FAIL);
			r.setErrorMessage("网络异常！");
			return r;
		} finally {
			// 释放连接
			if (null != method)
				method.releaseConnection();
		}
		return zhuanHuan(result, returnType);
	}

	public <T> String post(String url, T t) throws Exception {
		PostMethod method = null;
		try {
			// 使用POST方法
			method = new PostMethod(url);
			RequestEntity entity = new StringRequestEntity(JSON.toJSONString(t), MediaType.APPLICATION_JSON, "UTF-8");
			method.setRequestEntity(entity);
			return sendData(method);
		} catch (Exception e) {
			return "";
		} finally {
			// 释放连接
			if (null != method)
				method.releaseConnection();
		}

	}

	public static <T, R> HandlerResult<List<R>> postArray(String url, T t, Class<R> returnType) throws Exception {
		PostMethod method = null;
		String result = null;
		try {
			// 使用POST方法
			method = new PostMethod(url);
			if(!StringUtils.isEmpty(t)){
				RequestEntity entity = new StringRequestEntity(JSON.toJSONString(t), MediaType.APPLICATION_JSON, "UTF-8");
				method.setRequestEntity(entity);
			}
			result = sendData(method);
		} catch (Exception e) {
			HandlerResult<List<R>> r = HandlerResult.getHandlerResult();
			r.setResultCode(HandlerConstants.S_FAIL);
			r.setErrorMessage("网络异常！");
			return r;
		} finally {
			// 释放连接
			if (null != method)
				method.releaseConnection();
		}
		return convertToArray(result, returnType);
	}

}
