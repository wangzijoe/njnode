package cn.njnode.common.file;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

@Component
public class QiNiu {
	private static final String accessKey = "myAZvf2ROzuXpOPo93db9FUUgKN7JRsUcoDV4tYG";
	private static final String secretKey = "ONXeSyxHbilwgsdWmxSP1-P9vSpPeC-ADD8MsX6H";
	private static final String bucket = "njnode";

	private static String upToken = null;
	private static Auth auth = null;
	
	static{
		auth = Auth.create(accessKey, secretKey);
		upToken = auth.uploadToken(bucket);
	}

	public static String getUpToken() {
		return upToken;
	}

	public static void setUpToken(String upToken) {
		QiNiu.upToken = upToken;
	}
	
	
	//构造一个带指定Zone对象的配置类
	private static Configuration cfg = new Configuration(Zone.zone0());
	//...其他参数参考类注释

	private static UploadManager uploadManager = new UploadManager(cfg);
	//...生成上传凭证，然后准备上传

	public static void uploadFile(String localFilePath, String key){
		try {
		    Response response = uploadManager.put(localFilePath, key, upToken);
		    //解析上传成功的结果
		    DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
		    System.out.println(putRet.key);
		    System.out.println(putRet.hash);
		} catch (QiniuException ex) {
		    Response r = ex.response;
		    System.err.println(r.toString());
		    try {
		        System.err.println(r.bodyString());
		    } catch (QiniuException ex2) {
		        //ignore
		    }
		}
	}

	public QiNiu() {
		super();
	}
	
	
}
