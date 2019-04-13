package com.gpms.interceptor;

import com.gpms.dao.domain.entity.User;
import com.gpms.utils.Constant;
import com.gpms.utils.SpringContextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.text.MessageFormat;
import java.util.Map;

@Component
public class AuthHandshakeInterceptor implements HandshakeInterceptor {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
        HttpSession session = SpringContextUtils.getSession();
        User loginUser = (User) session.getAttribute(Constant.SESSION_USER);

        if(loginUser != null){
            logger.debug(MessageFormat.format("用户{0}请求建立WebSocket连接", loginUser.getName()));
            return true;
        }else{
            logger.error("未登录系统，禁止连接WebSocket");
            return false;
        }

    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {

    }

}
