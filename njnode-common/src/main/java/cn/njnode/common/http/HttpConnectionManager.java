package cn.njnode.common.http;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;

public class HttpConnectionManager {
	
	private static HttpClient CLIENT = null;
	private static final int TIMEOUT = 5 * 1000;
	private static final int MAX_HTTP_CONNECTION = 200;
	private static final int MAX_CONNECTION_PER_HOST = 50;

	static {
		MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
		HttpConnectionManagerParams httpConnectionManagerParams = new HttpConnectionManagerParams();
		httpConnectionManagerParams.setMaxTotalConnections(MAX_HTTP_CONNECTION);
		httpConnectionManagerParams.setDefaultMaxConnectionsPerHost(MAX_CONNECTION_PER_HOST);
		httpConnectionManagerParams.setSoTimeout(TIMEOUT);
		httpConnectionManagerParams.setConnectionTimeout(TIMEOUT);
		connectionManager.setParams(httpConnectionManagerParams);
		CLIENT = new HttpClient(connectionManager);
		CLIENT.getParams().setContentCharset("UTF-8");
	}

	private HttpConnectionManager() {
	}

	public static HttpClient getHttpClient() {
		return CLIENT;
	}
}
