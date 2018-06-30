package cn.njnode;

import java.io.Serializable;

import com.github.pagehelper.PageInfo;


public class HandlerResult<T> implements Serializable {

	private static final long serialVersionUID = 5173155050808912603L;
	
	ResultState resultState;
	
	protected T resultObj;
	
	protected PageInfo<?> pageInfo; 
	
	public HandlerResult(String core, T resultObj, String msg){
		resultState = new ResultState();
		resultState.setResultCode(core);
		if(core == HandlerConstants.S_OK){
			resultState.setSuccessMessage(msg);
		}else{
			resultState.setErrorMessage(msg);
		}
		this.resultObj=resultObj;
	}
	
	private HandlerResult(){
	    this.resultState = new ResultState();
	}
	
	public static <T> HandlerResult<T> getHandlerResult(){
	    return new HandlerResult<T>();
	}

	public PageInfo<?> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<?> pageInfo) {
		this.pageInfo = pageInfo;
	}

	/**
     * 
     * 功能实现描述：获取数据对象
     */
	public T getResultObj() {
		return resultObj;
	}
    /**
     * 功能实现描述：设置数据对象
     */
	public void setResultObj(T resultObj) {
		this.resultObj = resultObj;
	}
	
	/**
	 * 
	 * 功能实现描述
	 */
	public String getResultCode() {
        return this.resultState.resultCode;
    }

	/**
	 * 
	 * 功能实现描述：设置返回编码，0：失败，1：成功
	 */
    public void setResultCode(String resultCode) {
        this.resultState.setResultCode(resultCode);
    }
    
    /**
     * 
     * 功能实现描述：获取错误的返回编码
     */
    public String getErrorCode() {
        return this.resultState.errorCode;
    }
    /**
     *
     * 功能实现描述：设置错误编码
     */
    public void setErrorCode(String errorCode) {
        this.resultState.setErrorCode(errorCode);
    }

    /**
     * 
     * 功能实现描述：获取错误内容
     */
    public String getErrorMessage() {
        return this.resultState.errorCode;
    }

    /**
     * 
     * 功能实现描述：设置错误内容
     */
    public void setErrorMessage(String errorMessage) {
        this.resultState.setErrorMessage(errorMessage);;
    }
    
    /**
     * 
     * 功能实现描述：获取成功的内容
     */
    public String getSuccessMessage() {
        return this.resultState.successMessage;
    }

    /**
     * 
     * 功能实现描述：设置成功的内容
     */
    public void setSuccessMessage(String successMessage) {
        this.resultState.setSuccessMessage(successMessage);
    }
}
