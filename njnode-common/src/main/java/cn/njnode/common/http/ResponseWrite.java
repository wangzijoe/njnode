package cn.njnode.common.http;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ResponseWrite {

	private static Logger log = LogManager.getLogger(ResponseWrite.class);

    public static void write(HttpServletResponse response, String str) {
        try { 
            response.getWriter().write(str);
        } catch (IOException e) {
            log.info(e);
        }
    } 
}
