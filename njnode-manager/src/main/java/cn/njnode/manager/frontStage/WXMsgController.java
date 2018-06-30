package cn.njnode.manager.frontStage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("WXMsg")
public class WXMsgController {
//	private static Logger log = Logger.getLogger(WXMsgController.class);
	
//	private static final String token = "wangZi";
//	
//	@Autowired
//	AppService appService;s
//	
//	@RequestMapping(value = "answerWXServer", method = { GET,POST })
//	public void answerWXServer(HttpServletRequest request, HttpServletResponse response){
//		try {
//			if(HttpUtil.isGet(request)){
//                String signature = request.getParameter("signature");
//                String timestamp = request.getParameter("timestamp");
//                String nonce = request.getParameter("nonce");
//                String echostr = request.getParameter("echostr");
//                
//                ArrayList<String> array = new ArrayList<String>();
//                array.add(signature);
//                array.add(timestamp);
//                array.add(nonce);
//                
//                //排序
//                String sortString = WeiXinUtil.sort(token, timestamp, nonce);
//                //加密
//                String mytoken = WeiXinUtil.SHA1(sortString);
//                if (mytoken != null && mytoken != "" && mytoken.equals(signature)) {
//                    response.getWriter().write(echostr);//如果检验成功输出echostr，微信服务器接收到此输出，才会确认检验完成。
//                } else {
//                	log.error("WXMsgController answerWXServer error");
//                }
//                return;
//			}
//		} catch (Exception e) {
//			log.error("WXMsgController answerWXServer error", e);
//		}
//	}
//	
//	/**
//	 * 
//	 * 功能实现描述：获取openId和sessionKey
//	 * 
//	 * @param app
//	 * @param response
//	 * @author: joe 
//	 * @date: Created on 2018年4月15日 下午2:58:09
//	 * @return
//	 */
//	@RequestMapping(value="getOpenIdAndSessionKey", method={POST})
//	public void getOpenIdAndSessionKey(App app, String wxCode, HttpServletResponse response){
//		try {
//			Result<App> result = appService.queryAppById(app.getId());
//			if(!Assert.isEmpty(result)){
//				JSONObject extJsonObj = JSON.parseObject(result.getResultObj().getExt());
//				JSONObject weiXin = (JSONObject) extJsonObj.get("weiXin");
//				String wxAppId = (String) weiXin.get("wxAppId");
//				String wxAppSecret = (String) weiXin.get("wxAppSecret");
//				
//				String openIdAndSessionKey = WeiXinUtil.getOpenIdAndSessionKey(wxAppId, wxAppSecret, wxCode);
//				String token = WeiXinUtil.getToken(app.getId(), wxAppId, wxAppSecret);
//				JSONObject jso = new JSONObject();
//				jso.put("openIdAndSessionKey", openIdAndSessionKey);
//				jso.put("token", token);
//						
//				ResponseWrite.Write(response, JSON.toJSONString(jso));
//			}
//			
//		} catch (Exception e) {
//			log.error("WXMsgController getMsg error", e);
//		}
//	}
//	
//	
//	@RequestMapping(value="getAccessToken", method={POST})
//	public void getAccessToken(App app, String wxCode, HttpServletResponse response){
//		try {
//			Result<App> result = appService.queryAppById(app.getId());
//			if(!Assert.isEmpty(result)){
//				JSONObject extJsonObj = JSON.parseObject(result.getResultObj().getExt());
//				JSONObject weiXin = (JSONObject) extJsonObj.get("weiXin");
//				String wxAppId = (String) weiXin.get("wxAppId");
//				String wxAppSecret = (String) weiXin.get("wxAppSecret");
//				
//				String token = WeiXinUtil.getToken(app.getId(), wxAppId, wxAppSecret);
//				
//				ResponseWrite.Write(response, JSON.toJSONString(token));
//			}
//			
//		} catch (Exception e) {
//			log.error("WXMsgController getMsg error", e);
//		}
//	}
	
}
