package cn.njnode;

import java.io.Serializable;

public interface HandlerConstants extends Serializable {
	
	String S_OK = "1";

	String S_FAIL = "0";
	
	String SUCCESS = "{resultCode:1}";
	
	String ERROR = "{resultCode:0}";

	public static interface balePack {
		String SUCCUSS_MSG = "操作成功！！";
		String FILE_NOT_FOUND = "文件找不到！！";
		String BALE_PACK_FAIL = "打包失败！！";
	}
}
