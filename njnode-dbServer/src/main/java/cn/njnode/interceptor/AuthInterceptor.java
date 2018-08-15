package cn.njnode.interceptor;

import java.util.List;
import java.util.Map;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.log4j.Logger;

public class AuthInterceptor extends AbstractPhaseInterceptor<Message> {

    private final Logger log = Logger.getLogger(getClass());

    public AuthInterceptor() {
        super(Phase.PRE_INVOKE);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        log.info("AuthInterceptor Message=="+message);
        Map<String,List<String>> headers = (Map<String, List<String>>) message.get(Message.PROTOCOL_HEADERS);

        List<String> account = headers.get("AgentAccount");
        List<String> key = headers.get("AgentKey");
        if(account == null || key == null){
            throw new Fault(new IllegalArgumentException("未填写认证信息"));
        }else if(!account.get(0).equals("njnode") || !key.get(0).equals("6597dmin")){
            throw new Fault(new IllegalArgumentException("认证信息填写错误，请联系接口服务商！"));
        }
    }
}
